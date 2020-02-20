package udaraAsia.view;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import udaraAsia.Flight;
import udaraAsia.Main;

public class DetailsControl {
	
	@FXML
	private TextField dateTime;
	
	@FXML
	private TextField origin;
	
	@FXML
	private TextField destination;

	@FXML
	private TextField price;
	
	
	public void setGUI(Flight flight) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		dateTime.setText(sdf.format(flight.getDate().getTime()));
		
		origin.setText(flight.getOrigin());
		
		destination.setText(flight.getDestination());
		
		price.setText("RM " + Double.toString(flight.getFlightPrice()));
	}
	
	@FXML
	private void handleNext(ActionEvent e) throws IOException, ParseException {
		Main.showBaggageSize();
	}
	
	@FXML
	private void handleBackToFlightDetails(ActionEvent e) throws Exception {
		Main.home();
	}


}
