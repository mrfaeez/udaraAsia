package udaraAsia.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import udaraAsia.Main;

public class GuessDetailController {
	
	@FXML
	private TextField passengerName;

	@FXML
	private TextField passportNo;
	
	@FXML
	private RadioButton male;
	
	@FXML
	private RadioButton female;
	
	@FXML ToggleGroup genderToggle;
	
	public String getGender(){
		RadioButton selectedRadioButton = (RadioButton) genderToggle.getSelectedToggle();
		return selectedRadioButton.getText();
	}
	
	@FXML
	public void handlebtnOk (ActionEvent e) throws IOException {
		
		Main.addGuestDetails(passengerName.getText(), passportNo.getText(), getGender());
	}
	
	@FXML
	public void handlebtnCancel (ActionEvent e) throws Exception {
		Main.home();
	}
	
	@FXML
	private void handleBackToSeat(ActionEvent e) throws Exception {
		Main.cancelSeat();
	}
}
