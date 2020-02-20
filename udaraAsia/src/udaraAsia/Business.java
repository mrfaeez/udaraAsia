package udaraAsia;

public class Business extends Passenger {
	
	private String busiSeat;
	
	public String getBusiSeat() {
		return busiSeat;
	}
	public void setBusiSeat(String busiSeat) {
		this.busiSeat = busiSeat;
	}
	
	@Override
	public void setPassengerPrice() {
		
		if (super.getBaggageSize() == 20) 
			this.passengerPrice += 150;
		
		else if(super.getBaggageSize() == 40)
			this.passengerPrice += 200;
		
		else if(super.getBaggageSize() == 60)
			this.passengerPrice += 250;
		
		else
			this.passengerPrice += 100;
	}
	
	

}
