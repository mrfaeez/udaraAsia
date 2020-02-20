package udaraAsia;

public class Economy extends Passenger {
	private String ecoSeat;
	private String meal;
	
	public void setEcoSeat(String ecoSeat) {
		this.ecoSeat = ecoSeat;
	}
	public String getEcoSeat() {
		return ecoSeat;
	}
	
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	@Override
	public void setPassengerPrice() {
		this.passengerPrice += 100;
		
		if (super.getBaggageSize() == 20) 
			this.passengerPrice += 50;
		
		else if(super.getBaggageSize() == 40)
			this.passengerPrice += 100;
		
		else if(super.getBaggageSize() == 60)
			this.passengerPrice += 150;
		
		else
			this.passengerPrice += 0;
	}
	
}
