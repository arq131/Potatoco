package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import java.net.URL;
import java.util.ResourceBundle;
import controller.AppController;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.Cart;
import model.CurrentUser;
import model.Product;
import controller.AppController;

public class CartController implements Initializable, MyController {

	private Cart cart;
	private Button buy;
	
	@FXML
	private Label total;
	
	@FXML
	private GridPane items;
	
	@FXML
	private ScrollPane scroll;

	public CartController(Cart cart) {
		this.cart = cart;
	}
	
	public void populateItems() {
		int i = 0;
		for (Product product : cart.getProducts()) {
			ImageView imageView = new ImageView();
			File file = new File(product.getImagePath());
			try {
				BufferedImage bufferedImage = ImageIO.read(file);
				Image image = SwingFXUtils.toFXImage(bufferedImage, null);
				imageView.setImage(image);
				imageView.setFitWidth(50);
				imageView.setFitHeight(50);
				imageView.setPreserveRatio(true);
				imageView.setSmooth(true);
				imageView.setCache(true);
			} catch (Exception e) {
				System.out.println("Error: Exception found: " + e.getMessage());
			}
			
			Label item = new Label();
			item.setAlignment(Pos.CENTER);
			item.setText(product.getName());
			
			Label cost = new Label();
			cost.setAlignment(Pos.CENTER);
			cost.setText(String.format("$%.2f", product.getCost()));
			
			Button remove = new Button();
			remove.setText("REMOVE");
			remove.setAlignment(Pos.CENTER);
			remove.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					cart.removeFromCart(product);
					populateItems();
				}
			});
			
			items.add(item, 0, i);
			items.add(imageView, 1, i);
			items.add(cost, 2, i);
			items.add(remove, 3, i);
			i++;
		}
		total.setText("Total Cost: " + String.format("$%.2f", cart.getCost()));
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
	
	@FXML
	public void home(ActionEvent event) throws Exception {
		AppController.getInstance().changeView(AppController.HOME, null);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		populateItems();

	}

}
