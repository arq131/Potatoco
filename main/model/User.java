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
	private String email;
	private String phoneNumber;
	private String username;
	private String password;
	private Cart cart;
	
	public User(String username, String password, String gender, String address,
			String email, String phoneNumber, String firstName, String lastName) {
		this.firstName = new String(firstName);
		this.lastName = new String(lastName);
		this.gender = new String(gender);
		this.address = new String(address);
		this.email = new String(email);
		this.phoneNumber = new String(phoneNumber);
		this.username = new String(username);
		this.password = new String(password);
		this.cart = new Cart();
		
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	
	public String getPassWord() {
		return password;
	}
	public void setPassWord(String passWord) {
		this.password = passWord;
	}
	
	public Cart getCart() {
		return this.cart;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
}
