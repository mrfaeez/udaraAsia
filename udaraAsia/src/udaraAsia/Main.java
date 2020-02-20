package udaraAsia;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import udaraAsia.view.DetailsControl;
import udaraAsia.view.SeatController;
import udaraAsia.view.bookingDetailController;

public class Main extends Application {
	private static Stage primaryStage;
	private static AnchorPane anchorPane;
	private static TitledPane titlePane;
	private static VBox vbox;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
	
	public Aeroplane[] plane = new Aeroplane[15];
	public static ArrayList<Passenger> passenger = new ArrayList<Passenger>();
	public static ArrayList<Flight> flight = new ArrayList<Flight>();
	public static int countPassenger = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initiliaze();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Udara Asia");
		showMainView();
		
	}
	
	public void initiliaze() {
		for (int x = 0 ; x < plane.length ; x++) {
			plane[x] = new Aeroplane();
			plane[x].setAeroId("A0" + x);
			plane[x].setBusiCapacity(6);
			plane[x].setEcoCapacitiy(48);
		}
		int z = 0;
		for(int w = 0 ; w < 10 ; w++) {
			for (int x = 0 ; x < 12 ; x++) {
				Calendar date1 = new GregorianCalendar(2019,4,5,8,00,00);
				date1.add(date1.DAY_OF_MONTH, w);
				Calendar date2 = new GregorianCalendar(2019,4,5,20,00,00);
				date2.add(date2.DAY_OF_MONTH, w);
				
				
				flight.add(new Flight());
				flight.get(w*12+x).setFlightId("F0" + (w*12+x));
				flight.get(w*12+x).setAeroId(plane[(x)/2].getAeroId());
				if(x%2 == 0)
					flight.get(w*12+x).setDate(date1);
				else
					flight.get(w*12+x).setDate(date2);
			}
			
			String country[] = {"Kuala Lumpur", "Jakarta", "Bangkok", "Hanoi"};
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
			
			for(int x = 0 ; x < country.length ; x++) {
				for(int y = 0 ; y < country.length ; y++) {
					if(x != y && x < y) {
						flight.get(z).setOrigin(country[x]);
						flight.get(z).setDestination(country[y]);
						flight.get(z).setFlightPrice(Math.random()*100 +100);
						z++;
						flight.get(z).setOrigin(country[y]);
						flight.get(z).setDestination(country[x]);
						flight.get(z).setFlightPrice(Math.random()*100 + 100);
						z++;
					}
				}
			}
			
		}
		
	}

	public static void showMainView() throws Exception{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/flight details.fxml"));
		anchorPane = loader.load();
		Scene scene = new Scene(anchorPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void getMainViewData(String origin, String destination, Date date, String flightClass) throws IOException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy MMM dd");
		String dateNoTime = formatter.format(date);
		
		int flightIdx = searchFlight(origin, destination, dateNoTime, flightClass);//arrayList string will change to flight object
		showFlight(flightIdx, flight, flightClass);
		
	}
	
	public static int searchFlight(String origin, String destination, String dateNoTime, String flightClass){
		int flightIdx = -1;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy MMM dd");
		
		ArrayList<Flight> flightId = new ArrayList<Flight>();
		/*
		for(int x = 0 ; x < flight.size() ; x++) {
			String date = formatter.format(flight.get(x).getDate().getTime());
			if(date.equals(dateNoTime) && (origin.equals(flightId.get(x).getOrigin())) && (destination.equals(flightId.get(x).getDestination())))
				flightIdx = x;
		}*/
		
		for (int x = 0 ; x < flight.size() ; x++) {
			String date = formatter.format(flight.get(x).getDate().getTime());
			if(date.equals(dateNoTime))
				flightId.add(flight.get(x));
		}
		
		ArrayList<Flight> flightId1 = new ArrayList<Flight>();		
		for(int x = 0 ; x <flightId.size() ; x++) {
			if((origin.equals(flightId.get(x).getOrigin())))
				flightId1.add(flightId.get(x));
		}
		
		ArrayList<Flight> flightId2 = new ArrayList<Flight>();
		for(int x = 0 ; x < flightId1.size(); x++) {
			if((destination.equals(flightId1.get(x).getDestination())))
				flightId2.add(flightId1.get(x));
		}

		for(int x = 0 ; x < flight.size() ; x++)
			if(flight.get(x).getFlightId().equals(flightId2.get(0).getFlightId()))
				flightIdx = x;
		
		return flightIdx;
	}
	
	public static int searchFlight(String flightId) {
		int flightIdx = -1;
		
		for(int x = 0 ; x < flight.size() ; x++) {
			if(flight.get(x).getFlightId().equals(flightId))
				flightIdx = x;
		}
		
		return flightIdx;
	}
	
	public static void showFlight(int flightIdx, ArrayList<Flight> flight, String flightClass) throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Details.fxml"));
		titlePane = loader.load();
		DetailsControl controller = loader.getController();
		Flight flight1 = flight.get(flightIdx);
		controller.setGUI(flight1);
		Scene scene = new Scene(titlePane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		if (flightClass.equals("Economy Class"))
			passenger.add(new Economy());
		
		else if(flightClass.equals("Business Class"))
			passenger.add(new Business());
		
		passenger.get(countPassenger).setFlightId(flight1.getFlightId());
	}
	
	public static void showBaggageSize() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/LuggageSize.fxml"));
		titlePane = loader.load();
		Scene scene = new Scene(titlePane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void addBaggageSize(int size) throws IOException {
		passenger.get(countPassenger).setBaggageSize(size);
		showSeat(searchFlight(passenger.get(countPassenger).getFlightId()));
	}
	
	public static void showSeat(int flightIdx) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Seat.fxml"));
		vbox = loader.load();
		SeatController controller = loader.getController();
		controller.filterRadioBtn(flight.get(flightIdx).getEcoSeat());
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void addSeat(String seat) throws IOException {
		

		if(passenger.get(countPassenger) instanceof Business)
		{
			((Business)passenger.get(countPassenger)).setBusiSeat(seat);
			((Business)passenger.get(countPassenger)).setPassengerPrice();;
			flight.get(searchFlight(passenger.get(countPassenger).getFlightId())).setBusiSeat(seat);
			
		}
		else if(passenger.get(countPassenger) instanceof Economy)
		{
			((Economy)passenger.get(countPassenger)).setPassengerPrice();
			((Economy)passenger.get(countPassenger)).setEcoSeat(seat);
			flight.get(searchFlight(passenger.get(countPassenger).getFlightId())).setEcoSeat(seat);
		}
		
		showGuestDetail();
	}
	
	public static void cancelSeat() throws IOException {
		
		if(passenger.get(countPassenger) instanceof Business)
		{
			flight.get(searchFlight(passenger.get(countPassenger).getFlightId())).getBusiSeat().remove(((Business) passenger.get(countPassenger)).getBusiSeat());
			
		}
		else if(passenger.get(countPassenger) instanceof Economy)
		{
			flight.get(searchFlight(passenger.get(countPassenger).getFlightId())).getEcoSeat().remove(((Economy) passenger.get(countPassenger)).getEcoSeat());
		}
		
		showSeat(searchFlight(passenger.get(countPassenger).getFlightId()));

	}
	
	public static void showGuestDetail() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/GuessDetail.fxml"));
		vbox = loader.load();
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void addGuestDetails(String passengerName, String passportNo, String passengerGender) throws IOException {
		passenger.get(countPassenger).setName(passengerName);
		passenger.get(countPassenger).setPassportNo(passportNo);
		passenger.get(countPassenger).setGender(passengerGender.charAt(0));
			
		showBookingDetail();
	}
	
	public static void showBookingDetail() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/bookingDetail.fxml"));
		vbox = loader.load();
		bookingDetailController controller = loader.getController();
		int flightIdx = searchFlight(passenger.get(countPassenger).getFlightId());
		controller.setForm(passenger.get(countPassenger), flight.get(flightIdx));
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void home() throws Exception {
		showMainView();
	}
	
	public static void success() throws Exception {
		countPassenger++;
		showMainView();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Udara Asia");
		alert.setHeaderText("Message");
		alert.setContentText("Your booking is successful!");

		alert.showAndWait();
		printData();
	}
	
	public static void printData() {
		System.out.println("Flight Data");
		for(int x = 0 ; x < flight.size() ; x++)
			System.out.println(flight.get(x).getDate().getTime() + " FROM " + flight.get(x).getOrigin() + " TO " + flight.get(x).getDestination() + " FLIGHT ID " + flight.get(x).getFlightId());
		
		System.out.println("Passenger Data");
		for (int x = 0 ; x < passenger.size(); x++)
			System.out.println(passenger.get(x).getName() + "\n" + passenger.get(x).getPassportNo() + "\n" + passenger.get(x).getGender() + "\n" + passenger.get(x).getFlightId() + "\n" + passenger.get(x).getBaggageSize() + "\n" + passenger.get(x).getClass() + "\n");
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	

	

}
