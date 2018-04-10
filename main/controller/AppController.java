package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.fxml.Initializable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import model.Cart;
import model.CurrentUser;
import model.User;
import model.Product;
import javafx.fxml.*;

public class AppController implements Initializable, MyController {

	public Stage stage;
	private static AppController myInstance = null;
	public static final int REGISTRATION = 1;
	public static final int HOME = 2;
	public static final int LOGIN = 3;
	public static final int SIGNEDOUT = 4;
	public static final int SIGNINAGAIN = 5;
	public static final int CONFIRMATION = 6;
	public static final int VIEWCART = 7;
	public static final int SIGNEDIN = 8;
	private Pane rootPane = null;
	public int state = 0;

	File images[];

	@FXML
	public Pagination products;

	@FXML
	public AnchorPane launch;

	private AppController() {

	}

	@FXML
	public void display() {
		Timeline fiveS = new Timeline(new KeyFrame(Duration.seconds(10), event -> {
			int pos = (products.getCurrentPageIndex() + 1) % products.getPageCount();
			products.setCurrentPageIndex(pos);
		}));
		fiveS.setCycleCount(Timeline.INDEFINITE);
		fiveS.play();

	}

	public VBox createPage(int index) {
		Product product = new Product(index);
		ImageView imageView = new ImageView();
		Label name = new Label();
		Label cost = new Label();
		File file = new File(product.getImagePath());
		System.out.println("Index = " + index);
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			imageView.setImage(image);
			imageView.setFitWidth(400);
			imageView.setPreserveRatio(true);
			imageView.setSmooth(true);
			imageView.setCache(true);
		} catch (Exception e) {
			System.out.println("Error: Exception found: " + e.getMessage());
		}

		try {
			name.setText(product.getName());
			name.setWrapText(true);
			cost.setText("$" + product.getCost());
			cost.setWrapText(true);

		} catch (Exception e) {
			System.out.println("Error: Exception found: " + e.getMessage());
		}

		VBox box = new VBox();
		box.getChildren().add(imageView);
		box.getChildren().add(name);
		box.getChildren().add(cost);
		return box;

	}

	public void changeView(int viewType, Object arg) throws Exception {
		MyController controller = null;
		URL fxmlFile = null;
		switch (viewType) {
		case REGISTRATION:
			fxmlFile = this.getClass().getResource("/RegistrationView.fxml");
			controller = new RegistrationController((User) arg, null);
			break;
		case HOME:
			fxmlFile = this.getClass().getResource("/LaunchScreen.fxml");
			controller = getInstance();
			break;
		case LOGIN:
			fxmlFile = this.getClass().getResource("/LoggedinView.fxml");
			controller = new LoginController((CurrentUser) arg);
			break;
		case SIGNEDOUT:
			fxmlFile = this.getClass().getResource("/ProductsView.fxml");
			controller = new LoginController((CurrentUser) arg);
			break;
		case SIGNINAGAIN:
			fxmlFile = this.getClass().getResource("/SigninAgain.fxml");
			controller = new LoginController((CurrentUser) arg);
			break;
		case CONFIRMATION:
			fxmlFile = this.getClass().getResource("/confirmPurchase.fxml");
			controller = new ConfirmationController();
			break;
		case VIEWCART:
			fxmlFile = this.getClass().getResource("/CartView.fxml");
			controller = new CartController((Cart) arg);
			break;
		case SIGNEDIN:
			fxmlFile = this.getClass().getResource("/LaunchScreen.fxml");
			controller = getInstance((User) arg);
			break;

		}

		FXMLLoader loader = new FXMLLoader(fxmlFile);
		loader.setController(controller);
		Parent viewNode = loader.load();
		Scene scene = new Scene(viewNode, 1024, 768);
		stage.setScene(scene);

		// rootPane.setTop(null);
		// Stage stage = (Stage) launch.getScene().getWindow();
		// stage.hide();

	}

	@FXML
	public void signUp(ActionEvent event) throws Exception {
		changeView(REGISTRATION, null);
	}

	@FXML
	public void closeMe(ActionEvent event) throws Exception {
		Platform.exit();
	}

	@FXML
	public void signIn(ActionEvent event) throws Exception {
		changeView(LOGIN, null);
	}

	@FXML
	public void signOut(ActionEvent event) throws Exception {
		changeView(SIGNEDOUT, null);
	}

	@FXML
	public void viewCart(ActionEvent event) throws Exception {
		changeView(VIEWCART, null);
	}

	public static AppController getInstance() {
		if (myInstance == null)
			myInstance = new AppController();
		return myInstance;
	}

	public static AppController getInstance(User user) {
		if (myInstance == null)
			myInstance = new AppController();
		// do something with user
		return myInstance;
	}

	public void setRootPane(BorderPane root) {
		this.rootPane = root;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		products.setPageFactory((Integer index) -> createPage(index));

	}

}
