package udaraAsia;

import java.util.ArrayList;
import java.util.Calendar;

public class Flight {
	private String flightId;
	private String aeroId;
	private ArrayList<String> busiSeat = new ArrayList<String>();
	private ArrayList<String> ecoSeat = new ArrayList<String>();
	private Calendar date;
	private String origin;
	private String destination;
	private double flightPrice;
	
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getAeroId() {
		return aeroId;
	}
	public void setAeroId(String aeroId) {
		this.aeroId = aeroId;
	}
	public ArrayList<String> getBusiSeat() {
		return busiSeat;
	}
	public void setBusiSeat(String busiSeat) {
		this.busiSeat.add(busiSeat);
	}
	public ArrayList<String> getEcoSeat() {
		return ecoSeat;
	}
	public void setEcoSeat(String ecoSeat) {
		this.ecoSeat.add(ecoSeat);
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getFlightPrice() {
		return flightPrice;
	}
	public void setFlightPrice(double flightPrice) {
		this.flightPrice = flightPrice;
	}
	public void removeSeat(String seat) {
		
	}
	

}
