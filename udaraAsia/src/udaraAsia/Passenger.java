package udaraAsia;

public abstract class Passenger {
	
	private String passportNo;
	private String name;
	private char gender;
	private String flightId;
	private int baggageSize;
	protected double passengerPrice;
	
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public int getBaggageSize() {
		return baggageSize;
	}
	public void setBaggageSize(int baggageSize) {
		this.baggageSize = baggageSize;
	}
	public double getPassengerPrice() {
		return passengerPrice;
	}
	public abstract void setPassengerPrice();
	
}
