package udaraAsia.view;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import udaraAsia.Business;
import udaraAsia.Economy;
import udaraAsia.Flight;
import udaraAsia.Main;
import udaraAsia.Passenger;

public class bookingDetailController {
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField gender;
	
	@FXML
	private TextField passport;
	
	@FXML
	private TextField origin;
	
	@FXML
	private TextField destination;
	
	@FXML
	private TextField date;
	
	@FXML
	private TextField time;
	
	@FXML
	private TextField flightId;
	
	@FXML
	private TextField seat;
	
	@FXML
	private TextField meal;

	@FXML
	private TextField classFlight;
	
	@FXML
	private TextField baggage;
	
	@FXML
	private TextField totalPrice;
	
	public void setForm(Passenger passenger, Flight flight) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		name.setText(passenger.getName());
		gender.setText(Character.toString(passenger.getGender()));
		passport.setText(passenger.getPassportNo());
		origin.setText(flight.getOrigin());
		destination.setText(flight.getDestination());
		date.setText(dateFormat.format(flight.getDate().getTime()));
		time.setText(timeFormat.format(flight.getDate().getTime()));
		flightId.setText(flight.getFlightId());
		if(passenger instanceof Business)
		{
			classFlight.setText("Business");
			seat.setText(((Business)passenger).getBusiSeat());
			
		}
		else if(passenger instanceof Economy)
		{
			classFlight.setText("Economy");
			seat.setText(((Economy)passenger).getEcoSeat());
		}
		meal.setText("Provided");
		baggage.setText(Integer.toString(passenger.getBaggageSize()) + "kg");
		
		totalPrice.setText("RM " + Double.toString(passenger.getPassengerPrice() + flight.getFlightPrice()));
	}
	
	@FXML
	public void handlebtnOk (ActionEvent e) throws Exception {
		Main.success();
	}
	
	@FXML
	public void handlebtnCancel (ActionEvent e) throws Exception {
		Main.home();
	}
	
	@FXML
	public void handlebtnBackToGuessDetails (ActionEvent e) throws Exception {
		Main.showGuestDetail();
	}
}
