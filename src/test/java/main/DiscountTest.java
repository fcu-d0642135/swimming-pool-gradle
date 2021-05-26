package main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiscountTest {

	static String dateTime;

	@BeforeEach
	public void catchCurrentTime() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
//		dateTime = sdf.format(new Date());
		dateTime = "2021-05-26 週三 14:30:00";
	}

	@Test
	public void testAgeHasDiscount() {
		Identity identity = new Identity(10, false, false);
		Discount discount = new Discount(identity, dateTime);
		System.out.println(discount.getDiscount());
		Assertions.assertEquals(0.8, discount.getDiscount());
	}
	
	@Test	
	public void testAgeHasNoDiscount() {
		Identity identity = new Identity(40, false, false);
		Discount discount = new Discount(identity, dateTime);
		Assertions.assertEquals(1, discount.getDiscount());
	}
	
	@Test
	public void testAgeLessThan() {
		Identity identity = new Identity(2, false, true);
		Discount discount = new Discount(identity, dateTime);
		Assertions.assertEquals(0, discount.getDiscount());
	}
	
	@Test
	public void testAgeMoreThan() {
		Identity identity = new Identity(80, true, false);
		Discount discount = new Discount(identity, dateTime);
		Assertions.assertEquals(0, discount.getDiscount());
	}
}
