package model;

import java.net.URL;
import java.util.ResourceBundle;

import controller.MyController;
import javafx.fxml.Initializable;

public class User implements MyController, Initializable {

	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private String eMail;
	private String phoneNumber;
	private String userName;
	private String passWord;
	
	public User(String firstName, String lastName, String gender, String address, 
			String eMail, String phoneNumber, String userName, String passWord) {
		this.firstName = new String(firstName);
		this.lastName = new String(lastName);
		this.gender = new String(gender);
		this.address = new String(address);
		this.eMail = new String(eMail);
		this.phoneNumber = new String(phoneNumber);
		this.userName = new String(userName);
		this.passWord = new String(passWord);
		
	}
	public User() {
		this("", "", "", "", "", "", "", "");
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String firstName() {
		return firstName;
	}
	public String lastName() {
		return lastName;
	}
	public String gender() {
		return gender;
	}
	public String eMail() {
		return eMail;
	}
	public String phoneNumber() {
		return phoneNumber;
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
