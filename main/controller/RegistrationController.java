package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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
	private PasswordField input_password;
	@FXML
	private Button submit;

	private CurrentUser currentuser;

	public RegistrationController(User user, CurrentUser currentuser) {
		this.user = user;
		this.currentuser = currentuser;
	}

	public RegistrationController() {
		
	}
	@FXML
	void submitUser(ActionEvent event) throws Exception {
		User user = new User();
		CurrentUser currentuser = new CurrentUser();
		user.setFirstName(input_first_name.getText());
		user.setLastName(input_last_name.getText());
		user.setGender(radioMale.getText());
		user.setGender(radioFemale.getText());
		user.setAddress(input_address.getText());
		user.seteMail(input_email.getText());
		user.setPhoneNumber(input_phone.getText());
		user.setUserName(input_username.getText());
		user.setPassWord(input_password.getText());
		AppController.getInstance().changeView(AppController.SIGNINAGAIN, currentuser);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
