package controller;

import java.net.URL;
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
import controller.AppController;

public class LoginController implements Initializable, MyController {
	private CurrentUser currentuser;
	@FXML
	private TextField userName;
	@FXML
	private PasswordField userPassword;
	@FXML
	private Button signin;
	@FXML
	private Label lblStatus;
	
	public LoginController() {

	}

	public LoginController(CurrentUser currentuser) {
		this.currentuser = currentuser;
	}
	@FXML
	public void login(ActionEvent event) throws Exception {
		if(userName.getText().equals("user") && userPassword.getText().equals("pass")) {
			AppController.getInstance().changeView(AppController.SIGNEDIN, currentuser);
		}
		else {
			lblStatus.setText("Login Failed");
		}
	}
	@FXML
	public void cancel(ActionEvent event) throws Exception{
		AppController.getInstance().changeView(AppController.HOME, currentuser);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
