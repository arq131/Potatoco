package controller;

import java.net.URL;
import java.util.ResourceBundle;

import Products.Cart;
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

public class CartController implements Initializable, MyController{
	
	private Cart cart;
	
	public CartController(Cart cart) {
		this.cart = cart;
	}
	
	@FXML
	public void purchase(ActionEvent event) throws Exception{
		AppController.getInstance().changeView(AppController.HOME, null);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
