package model;

import java.net.URL;
import java.util.ResourceBundle;

import controller.MyController;
import javafx.fxml.Initializable;

public class CurrentUser implements MyController, Initializable {
	
	private String userName;
	private String passWord;
	
	public CurrentUser(String userName, String passWord) {
		this.userName = new String(userName);
		this.passWord = new String(passWord);
	}
	public CurrentUser() {
		this("","");
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String userName() {
		return userName;
	}
	public String passWord() {
		return passWord;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

