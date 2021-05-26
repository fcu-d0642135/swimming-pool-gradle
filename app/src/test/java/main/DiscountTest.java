package main;

import org.junit.jupiter.api.*;

public class DiscountTest {

	@DisplayName("不同年紀的折扣")
	@Nested
	class DifferentAges {
		String dateTime = "2021-05-26 週三 14:30:00";

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

	@DisplayName("營業與非營業時間")
	@Nested
	class DifferentBusinessHours {
		@Test
		public void testNoBusiness() {
			Identity identity = new Identity(25, false, false);
			Discount discount = new Discount(identity, "2021-05-26 週三 04:30:00");
			Assertions.assertEquals(0, discount.getDiscount());
		}

		@Test
		public void testEarlyBirdBusiness() {
			Identity identity = new Identity(25, false, false);
			Discount discount = new Discount(identity, "2021-05-26 週三 06:30:00");
			Assertions.assertEquals(0.8, discount.getDiscount());
		}

		@Test
		public void testHaveBusiness() {
			Identity identity = new Identity(25, false, false);
			Discount discount = new Discount(identity, "2021-05-26 週三 10:30:00");
			Assertions.assertEquals(1, discount.getDiscount());
		}
	}
}
