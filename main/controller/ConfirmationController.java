package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class ConfirmationController implements Initializable, MyController {

	public ConfirmationController() {
		
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
