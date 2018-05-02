package controller;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.fxml.Initializable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private User user;
	public ProductsInfo productsInfo;
	private boolean isLoggedIn = false;
	private FXMLLoader loader;
	
	ArrayList<File> images;

	@FXML
	public Pagination products;

	@FXML
	public AnchorPane launch;
	
	@FXML
	private Label welcome;
	
	@FXML
	private Hyperlink signin;
	
	@FXML
	private Button register;
	
	@FXML
	private Button logout;

	private AppController() {

	}
	
	/**
	 * Class to handle reading products from csv file
	 * @author Lamak
	 *
	 */
	private class ProductsInfo {
		private LinkedHashMap<String, Product> hash = new LinkedHashMap<String, Product>();

		public ProductsInfo(File file) {
			read(file);
		}

		private void read(File file) {
			try {
				String input;
				BufferedReader br = new BufferedReader(new FileReader(file));
				br.readLine(); // Skip first line of csv
				while ((input = br.readLine()) != null) {
					String[] inputs = input.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					for (int i = 0; i < 6; i++) {
						if (inputs[i].equals("")) {
							inputs[i] = "-1";
						}
					}
					Product product = new Product(Integer.parseInt(inputs[0]), inputs[1], Double.parseDouble(inputs[2].replaceAll("[$]", "")), inputs[3], inputs[4], inputs[5]);
					hash.put(inputs[0], product);
				}
				br.close();
			} catch (Exception e) {
				System.out.println("Unable to read file. Exception: " + e.getMessage());
			}
		}
		
		/* Get a product by key (id of product) */
		protected Product get(String key) {
			return hash.get(key);
		}
		
		/* Get a product by the index of the product */
		protected Product getByIndex(int index) {
			return hash.get((hash.keySet().toArray())[index]);
		}
		
		/* Check if a certain product id exists */
		protected boolean isExist(String productName) {
			return hash.containsKey(productName);
		}
		
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
		Product product = productsInfo.getByIndex(index);
		ImageView imageView = new ImageView();
		Label name = new Label();
		Label cost = new Label();
		File file = new File(product.getImagePath());
		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			imageView.setImage(image);
			imageView.setFitWidth(400);
			imageView.setFitHeight(400);
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
			controller = new RegistrationController((User) arg);
			break;
		case HOME:
			fxmlFile = this.getClass().getResource("/LaunchScreen.fxml");
			controller = getInstance();
			break;
		case LOGIN:
			fxmlFile = this.getClass().getResource("/LoggedinView.fxml");
			controller = new LoginController((User) arg);
			break;
		case SIGNEDOUT:
			signin.setVisible(true);
			register.setVisible(true);
			welcome.setVisible(false);
			logout.setVisible(false);
			isLoggedIn = false;
			//controller = new LoginController();
			break;
		case SIGNINAGAIN:
			fxmlFile = this.getClass().getResource("/SigninAgain.fxml");
			controller = new LoginController((User) arg);
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
			this.user = (User) arg;
			isLoggedIn = true;
			fxmlFile = this.getClass().getResource("/LaunchScreen.fxml");
			controller = getInstance(user);
			break;

		}
		if (fxmlFile != null) {
			loader = new FXMLLoader(fxmlFile);
			loader.setController(controller);
			Parent viewNode = loader.load();
			Scene scene = new Scene(viewNode, 1024, 768);
			stage.setScene(scene);
		}

		if (isLoggedIn) {
			signin.setVisible(false);
			register.setVisible(false);
			
			logout.setVisible(true);
			welcome.setText("Welcome, " + user.getFirstName());
			welcome.setVisible(true);
			
		}
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
		System.out.println("Signing out...");
		this.user = null;
		changeView(SIGNEDOUT, null);
	}

	@FXML
	public void viewCart(ActionEvent event) throws Exception {
		Cart cart = null;
		if (user != null) {
			cart = user.getCart();
			changeView(VIEWCART, cart);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Sorry!");
			alert.setHeaderText("Unable to view cart.");
			alert.setContentText("Please login/register before viewing your cart!");
			alert.showAndWait();
		}
		
	}

	public static AppController getInstance() {
		if (myInstance == null)
			myInstance = new AppController();
		return myInstance;
	}

	public AppController getInstance(User user) {
		if (myInstance == null)
			myInstance = new AppController();
		this.user = user;
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
		productsInfo = new ProductsInfo(new File("products.csv"));
		images = new ArrayList<File>();
		for (Product product : productsInfo.hash.values()) {
			images.add(new File(product.getImagePath()));
		}
		products.setPageFactory((Integer index) -> createPage(index));

	}

}
