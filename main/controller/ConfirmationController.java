package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import model.Cart;

public class ConfirmationController implements Initializable, MyController {
	
	@FXML
	private Button purchase;
	
	@FXML
	private Button cart;
	
	@FXML
	private Button home;
	
	private Cart userCart;

	public ConfirmationController(Cart userCart) {
		this.userCart = userCart;
	}
	
	@FXML
	public void returnToCart(ActionEvent event) throws Exception {
		AppController.getInstance().changeView(AppController.VIEWCART, userCart);
	}
	
	@FXML
	public void returnToHome(ActionEvent event) throws Exception {
		AppController.getInstance().changeView(AppController.HOME, null);
	}
	
	@FXML
	public void purchase(ActionEvent event) throws Exception {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Success!");
		alert.setHeaderText("Purchase completed!");
		alert.setContentText("Thank you for shopping with Potatoco!");
		alert.showAndWait();
		AppController.getInstance().changeView(AppController.COMPLETE_PURCHASE, null);
	}
	
	@FXML
	public void back(MouseEvent event) throws Exception {
		AppController.getInstance().changeView(AppController.HOME, null);
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
