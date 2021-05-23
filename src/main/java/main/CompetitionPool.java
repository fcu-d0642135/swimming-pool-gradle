package main;

public class CompetitionPool {
	private int waterwayCost = 3000;
	private int adult = 120;
	private int student = 70;
	private char period;
	private int total;
	
	public CompetitionPool(int hour) {
		RentSingleWaterway(hour);
	}
	
	public CompetitionPool(int numOfAdult, int numOfStudent, char period) {
		TeamTraining(numOfAdult, numOfStudent);
		this.setPeriod(period);
	}
	
	public void RentSingleWaterway(int hour) {
		this.setTotal(waterwayCost * hour);
	}
	
	public void TeamTraining(int numOfAdult, int numOfStudent) {
		this.setTotal(adult * numOfAdult + student * numOfStudent);
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public char getPeriod() {
		return period;
	}

	public void setPeriod(char period) {
		this.period = period;
	}
	
}
