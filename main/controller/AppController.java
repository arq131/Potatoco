package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.CurrentUser;
import model.User;
import javafx.fxml.*;

public class AppController implements Initializable {
	
	private static AppController myInstance = null;
	public static final int REGISTRATION = 1;
	public static final int HOME = 2;
	public static final int LOGIN = 3;
	public static final int SIGNEDOUT = 4;
	public static final int SIGNINAGAIN = 5;
	private BorderPane rootPane = null;
	public int state = 0;
	
	
	private AppController() {
		
	}
	
	public void changeView(int viewType, Object arg) throws Exception{
			MyController controller = null;
			URL fxmlFile = null;
			switch(viewType) {
				case REGISTRATION:
					fxmlFile = this.getClass().getResource("/RegistrationView.fxml");
					controller = new RegistrationController((User)arg, null);
					break;
				case HOME:
					fxmlFile = this.getClass().getResource("/LaunchScreen.fxml");
					controller = new RegistrationController((User)arg, null);
					break;
				case LOGIN:
					fxmlFile = this.getClass().getResource("/LoggedinView.fxml");
					controller = new LoginController((CurrentUser)arg);
					break;	
				case SIGNEDOUT:
					fxmlFile = this.getClass().getResource("/signedoutView.fxml");
					controller = new LoginController((CurrentUser)arg);
					break;
				case SIGNINAGAIN:
					fxmlFile = this.getClass().getResource("/SigninAgain.fxml");
					controller = new LoginController((CurrentUser)arg);
					break;
			
			}
			FXMLLoader loader = new FXMLLoader(fxmlFile);
			loader.setController(controller);
			Parent viewNode = loader.load();
			rootPane.setCenter(viewNode);
			rootPane.setTop(null);
		
	}
	@FXML
	void signUp(ActionEvent event) throws Exception {
		changeView(REGISTRATION,null);
	}
	@FXML
	void closeMe(ActionEvent event) throws Exception{
		Platform.exit();
	}
	@FXML 
	void signIn(ActionEvent event) throws Exception{
		changeView(LOGIN,null);
	}
	@FXML
	void signOut(ActionEvent event) throws Exception{
		changeView(SIGNEDOUT,null);
	}
	public static AppController getInstance() {
		if(myInstance == null)
			myInstance = new AppController();
		return myInstance;
	}
	public BorderPane getRootPane() {
		return rootPane;
	}
	
	public void setRootPane(BorderPane root) {
		this.rootPane = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
