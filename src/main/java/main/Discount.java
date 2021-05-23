package main;

public class Discount {
	private static int general = 200;
	private static int weekend = 250;
	private int money;
	private float discount = 1;
	
	public Discount(Identity identity) {
		
		if (identity.getWeek() >= 1 && identity.getWeek() <= 5) {
			money = general;
		} else if (identity.getWeek() == 6 || identity.getWeek() == 7) {
			money = weekend;
		}

		if (identity.isMember()) {
			discount = (float) 0.5;
		} else if (identity.isGroup()) {
			discount = (float) 0.7;
		} else if (identity.getAge() < 12 || identity.getAge() >= 60) {
			discount = (float) 0.8;
		} else if (identity.getHour() >= 5 && identity.getHour() < 7) {
			discount = (float) 0.8;
		} else {
			discount = 1;
		}
		
		System.out.println("Money: " +  money);
		System.out.println("Discount: " + discount);
	}

	public float getDiscount() {
		return discount;
	}
	
	public int getMoney() {
		return money;
	}
	
	public float getTotal() {
		return discount * money;
	}
}
