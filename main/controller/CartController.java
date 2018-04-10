package controller;

import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.input.MouseEvent;
import model.Cart;
import model.CurrentUser;
import controller.AppController;

public class CartController implements Initializable, MyController {

	private Cart cart;
	private Button buy;

	public CartController(Cart cart) {
		this.cart = cart;
	}

	@FXML
	public void back(MouseEvent event) throws Exception {
		AppController.getInstance().changeView(AppController.HOME, null);
	}

	@FXML
	public void purchase(ActionEvent event) throws Exception {
		AppController.getInstance().changeView(AppController.CONFIRMATION, null); // this needs to go to confirm page.
	}

	@FXML
	public void remove(ActionEvent event) throws Exception {
		// removeFromCart(PRODUCT);
		// reset cart view to show one less item.
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
