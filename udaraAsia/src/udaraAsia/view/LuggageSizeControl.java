package udaraAsia.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import udaraAsia.Main;

public class LuggageSizeControl {

	@FXML
	private void handleBtn20(ActionEvent e) throws IOException {
		Main.addBaggageSize(20);
	}
	
	@FXML
	private void handleBtn40(ActionEvent e) throws IOException {
		Main.addBaggageSize(40);
	}
	
	@FXML
	private void handleBtn60(ActionEvent e) throws IOException {
		Main.addBaggageSize(60);
	}
	
	@FXML
	private void handleBackToHome(ActionEvent e) throws Exception {
		Main.home();
	}
}
