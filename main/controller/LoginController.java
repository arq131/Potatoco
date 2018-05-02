package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import controller.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.CurrentUser;
import model.User;
import controller.AppController;

public class LoginController implements Initializable, MyController {
	private User user;
	@FXML
	private TextField userName;
	@FXML
	private PasswordField userPassword;
	@FXML
	private Button signin;
	@FXML
	private Label lblStatus;
	
	private UserInfo userInfo;
	
	private class UserInfo {
		private HashMap<String, User> hash = new HashMap<String, User>();

		public UserInfo(File file) {
			read(file);
		}

		private void read(File file) {
			try {
				String input;
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				while ((input = br.readLine()) != null) {
					String[] inputs = input.split(",");
					User newUser = new User(inputs[0], inputs[1], inputs[2], inputs[3],
							 inputs[4], inputs[5], inputs[6], inputs[7]);
					hash.put(inputs[0], newUser);
				}
				br.close();
				fr.close();
			} catch (Exception e) {
				System.out.println("Unable to read file. Exception: " + e.getMessage());
			}
		}

		protected User get(String key) {
			return hash.get(key);
		}
		
		protected boolean isExist(String user) {
			return hash.containsKey(user);
		}
		
	}
	
	public LoginController() {
		this.userInfo = new UserInfo(new File("users.csv"));
	}

	public LoginController(User user) {
		this.user = user;
		this.userInfo = new UserInfo(new File("users.csv"));
	}
	
	@FXML
	public void login(ActionEvent event) throws Exception {
		System.out.println("Text: '" +userName.getText()+"'");
		if (!userName.getText().equals("")) {
			if (userInfo.isExist(userName.getText())) {
				user = userInfo.get(userName.getText());
			} else {
				lblStatus.setText("User does not exist. Please register.");
				return;
			}
		} else {
			lblStatus.setText("Please enter username/password");
			return;
		}
		
		if(userPassword.getText().equals(user.getPassWord())) {
			AppController.getInstance().changeView(AppController.SIGNEDIN, user);
		}
		else {
			lblStatus.setText("Login Failed");
		}
	}
	
	@FXML
	public void cancel(ActionEvent event) throws Exception{
		AppController.getInstance().changeView(AppController.HOME, user);
	}
	
	@FXML
	public void register(ActionEvent event) throws Exception {
		AppController.getInstance().changeView(AppController.REGISTRATION, user);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
