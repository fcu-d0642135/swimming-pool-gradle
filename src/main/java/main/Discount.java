package main;

public class Discount {
	private float discount = 0;
	
	public Discount(Identity identity, String dateTime) {

		int hour = InputNormalization.extractHour(dateTime);
		int min = InputNormalization.extractMin(dateTime);

		if (hour < 5 || (hour == 22 && min > 0) || hour > 22) {
			System.out.println("Business hours: 05:00-22:00");
		} else if (identity.getAge() < 3 || identity.getAge() > 75) {
			System.out.println("Your age doesn't meet the requirements.");
		} else {
			if (identity.isMember()) {
				discount = (float) 0.5;
			} else if (identity.isGroup()) {
				discount = (float) 0.7;
			} else if (identity.getAge() < 12 || identity.getAge() >= 60) {
				discount = (float) 0.8;
			} else if (hour >= 5 && hour < 7) {
				discount = (float) 0.8;
			} else {
				discount = 1;
			}
		}
	}

	public float getDiscount() {
		return discount;
	}
}
