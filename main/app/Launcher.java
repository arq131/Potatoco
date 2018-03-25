package app;

import javafx.application.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;
import java.net.URL;
import controller.AppController;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Launcher extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AppController appControl = AppController.getInstance();
		URL res = this.getClass().getResource("/LaunchScreen.fxml");
		FXMLLoader loader = new FXMLLoader(res);
		loader.setController(appControl);
		Parent root = loader.load();
		appControl.setRootPane((BorderPane)root);
		
		Scene scene = new Scene(root, 1024, 768);
		primaryStage.setTitle("Welcome to Potaco");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
