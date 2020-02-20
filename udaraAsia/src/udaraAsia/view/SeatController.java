package udaraAsia.view;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import udaraAsia.Main;

public class SeatController {
	ArrayList<RadioButton> allButton = new ArrayList<RadioButton>();
	
	@FXML RadioButton a1;
	@FXML RadioButton a2;
	@FXML RadioButton a3;
	@FXML RadioButton a4;
	@FXML RadioButton a5;
	@FXML RadioButton a6;
	@FXML RadioButton a7;
	@FXML RadioButton a8;
	
	@FXML RadioButton b1;
	@FXML RadioButton b2;
	@FXML RadioButton b3;
	@FXML RadioButton b4;
	@FXML RadioButton b5;
	@FXML RadioButton b6;
	@FXML RadioButton b7;
	@FXML RadioButton b8;
	
	@FXML RadioButton c1;
	@FXML RadioButton c2;
	@FXML RadioButton c3;
	@FXML RadioButton c4;
	@FXML RadioButton c5;
	@FXML RadioButton c6;
	@FXML RadioButton c7;
	@FXML RadioButton c8;
	
	@FXML RadioButton d1;
	@FXML RadioButton d2;
	@FXML RadioButton d3;
	@FXML RadioButton d4;
	@FXML RadioButton d5;
	@FXML RadioButton d6;
	@FXML RadioButton d7;
	@FXML RadioButton d8;
	
	@FXML RadioButton e1;
	@FXML RadioButton e2;
	@FXML RadioButton e3;
	@FXML RadioButton e4;
	@FXML RadioButton e5;
	@FXML RadioButton e6;
	@FXML RadioButton e7;
	@FXML RadioButton e8;
	
	@FXML RadioButton f1;
	@FXML RadioButton f2;
	@FXML RadioButton f3;
	@FXML RadioButton f4;
	@FXML RadioButton f5;
	@FXML RadioButton f6;
	@FXML RadioButton f7;
	@FXML RadioButton f8;
	
	@FXML ToggleGroup seatToggle;

	public void filterRadioBtn(ArrayList<String> seat) {
		allButton.add(a1);
		allButton.add(a2);
		allButton.add(a3);
		allButton.add(a4);
		allButton.add(a5);
		allButton.add(a6);
		allButton.add(a7);
		allButton.add(a8);
		allButton.add(b1);
		allButton.add(b2);
		allButton.add(b3);
		allButton.add(b4);
		allButton.add(b5);
		allButton.add(b6);
		allButton.add(b7);
		allButton.add(b8);
		allButton.add(c1);
		allButton.add(c2);
		allButton.add(c3);
		allButton.add(c4);
		allButton.add(c5);
		allButton.add(c6);
		allButton.add(c7);
		allButton.add(c8);
		allButton.add(d1);
		allButton.add(d2);
		allButton.add(d3);
		allButton.add(d4);
		allButton.add(d5);
		allButton.add(d6);
		allButton.add(d7);
		allButton.add(d8);
		allButton.add(e1);
		allButton.add(e2);
		allButton.add(e3);
		allButton.add(e4);
		allButton.add(e5);
		allButton.add(e6);
		allButton.add(e7);
		allButton.add(e8);
		allButton.add(f1);
		allButton.add(f2);
		allButton.add(f3);
		allButton.add(f4);
		allButton.add(f5);
		allButton.add(f6);
		allButton.add(f7);
		allButton.add(f8);
		
		disableRadioBtn(seat);
	}
	
	public void disableRadioBtn(ArrayList<String> seat) {
		for(int x = 0 ; x < seat.size() ; x++) {
			for(int y = 0 ; y < allButton.size() ; y++) {
				if(seat.get(x).equals(allButton.get(y).getText())) {
					allButton.get(y).setDisable(true);
				}
			}
		}
	}
	
	public String getSeat(){
		RadioButton selectedRadioButton = (RadioButton) seatToggle.getSelectedToggle();
		return selectedRadioButton.getText();
	}
	
	@FXML
	public void handlebtnOk (ActionEvent e) throws IOException {
		Main.addSeat(getSeat());
	}
	
	@FXML
	public void handlebtnCancel (ActionEvent e) throws Exception {
		Main.home();
	}
	
	@FXML
	private void handleBackToLuggage(ActionEvent e) throws Exception {
		Main.showBaggageSize();
	}
	
	
	
}
