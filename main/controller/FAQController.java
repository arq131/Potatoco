package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FAQController  implements Initializable, MyController {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void cancel(ActionEvent event) throws Exception {
		AppController.getInstance().changeView(AppController.HOME, null);
	}

}
