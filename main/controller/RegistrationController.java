package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.*;
import model.CurrentUser;
import model.User;
import javafx.event.ActionEvent;

public class RegistrationController implements Initializable, MyController {
	private User user;
	
	@FXML
	private TextField input_first_name;
	@FXML
	private TextField input_last_name;
	@FXML
	private RadioButton radioMale;
	@FXML
	private RadioButton radioFemale;
	@FXML
	private TextField input_address;
	@FXML
	private TextField input_email;
	@FXML
	private TextField input_phone;
	@FXML
	private TextField input_username;
	@FXML
	private TextField input_password;
	@FXML
	private Button submit;
	@FXML
	private Label lblStatus;
	
	private boolean selected = false;

	public RegistrationController(User user) {
		this.user = user;
	}

	public RegistrationController() {
		
	}
	@FXML
	void submitUser(ActionEvent event) throws Exception {
		User user = new User();

		if(input_first_name.getText().equals("") || input_last_name.getText().equals("")) {
			lblStatus.setText("All fields required");
		}else if (radioMale.getText().equals("") || radioFemale.getText().equals("")){
			lblStatus.setText("All fields required");
		}else if (input_address.getText().equals("") || input_email.getText().equals("")) {
			lblStatus.setText("All fields required");
		}else if (input_phone.getText().equals("") || input_username.getText().equals("")) {
			lblStatus.setText("All fields required");
		}else if (input_password.getText().equals("")) {
			lblStatus.setText("All fields required");
		} else {
			String firstName = input_first_name.getText();
			String lastName = input_last_name.getText();
			String gender = radioMale.isSelected() ? "male" : "female";
			String address = input_address.getText();
			String email = input_email.getText();
			String phoneNumber = input_phone.getText();
			String username = input_username.getText();
			String password = input_password.getText();
			
			File file = new File("users.csv");
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			String data = username + "," + password + "," + gender + "," + address + "," + email + "," + phoneNumber + "," + firstName + "," + lastName;
			
			bw.write(data);
			
			bw.close();
			fw.close();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Success!");
			alert.setHeaderText("Account created.");
			alert.setContentText("Congratulations on creating a new account with us " + firstName + "!");
			alert.showAndWait();
			AppController.getInstance().changeView(AppController.HOME, user);
		}
	}
	
	@FXML
	public void checkGenderMale(ActionEvent event) {
		radioMale.setSelected(true);
		radioFemale.setSelected(false);
	}
	
	@FXML
	public void checkGenderFemale(ActionEvent event) {
		radioMale.setSelected(false);
		radioFemale.setSelected(true);
	}
	
	@FXML
	public void cancel(ActionEvent event) throws Exception {
		AppController.getInstance().changeView(AppController.HOME, user);
	}
	
	@FXML
	public void login(ActionEvent event) throws Exception {
		AppController.getInstance().changeView(AppController.LOGIN, user);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
