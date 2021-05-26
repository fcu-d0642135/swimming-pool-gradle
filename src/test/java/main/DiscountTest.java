package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {

	static String dateTime;

	@BeforeEach
	public void catchCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		dateTime = sdf.format(new Date());
	}

	@Test
	public void testAgeHasDiscout() {
		Identity identity = new Identity(10, false, false);
		Discount discount = new Discount(identity, dateTime);
		
		float expected = (float) 0.8;
		float result = discount.getDiscount();
		assertEquals(expected, result);
	}
	
	@Test	
	public void testAgeHasNoDiscout() {
		Identity identity = new Identity(40, false, false);
		Discount discount = new Discount(identity, dateTime);
		
		float expected = (float) 0.8;
		float result = discount.getDiscount();
		assertEquals(expected, result);
	}
	
	@Test
	public void testAgeLessThan() {
		Identity identity = new Identity(2, false, true);
		Discount discount = new Discount(identity, dateTime);
		
		float expected = (float) (0);
		float result = discount.getDiscount();
		assertEquals(expected, result);
	}
	
	@Test
	public void testAgeMoreThan() {
		Identity identity = new Identity(80, true, false);
		Discount discount = new Discount(identity, dateTime);
		
		float expected = (float) (0);
		float result = discount.getDiscount();
		assertEquals(expected, result);
	}
}
