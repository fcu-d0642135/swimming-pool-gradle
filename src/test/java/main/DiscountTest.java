package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {

	@Test
	public void testAgeHasDiscout() {
		Identity identity = new Identity(10, false, false);
		Discount discount = new Discount(identity);
		
		float expected = (float) (200 * 0.8);
		float result = discount.getTotal();
		assertEquals(expected, result);
	}
	
	@Test	
	public void testAgeHasNoDiscout() {
		Identity identity = new Identity(40, false, false);
		Discount discount = new Discount(identity);
		
		float expected = (float) (250 * 0.8);
		float result = discount.getTotal();
		assertEquals(expected, result);
	}
	
	@Test
	public void testAgeLessThan() {
		Identity identity = new Identity(2, false, true);
		Discount discount = new Discount(identity);
		
		float expected = (float) (0);
		float result = discount.getTotal();
		assertEquals(expected, result);
	}
	
	@Test
	public void testAgeMoreThan() {
		Identity identity = new Identity(80, true, false);
		Discount discount = new Discount(identity);
		
		float expected = (float) (0);
		float result = discount.getTotal();
		assertEquals(expected, result);
	}
}
