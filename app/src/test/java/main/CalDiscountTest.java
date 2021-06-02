package main;

import org.junit.jupiter.api.*;

public class CalDiscountTest {

	@DisplayName("不同年紀的折扣")
	@Nested
	class DifferentAges {
		String dateTime = "2021-05-26 週三 14:30:00";

		@Test
		public void testAgeHasCalDiscount() throws Throwable {
			Identity identity = new Identity(10, false, false);
			CalDiscount CalDiscount = new CalDiscount(identity, dateTime);
			Assertions.assertEquals(0.8, CalDiscount.getDiscount());
		}

		@Test
		public void testAgeHasNoCalDiscount() throws Throwable {
			Identity identity = new Identity(40, false, false);
			CalDiscount CalDiscount = new CalDiscount(identity, dateTime);
			Assertions.assertEquals(1, CalDiscount.getDiscount());
		}

		@Test
		public void testAgeLessThan() throws Throwable {
			Identity identity = new Identity(2, false, true);
			try {
				new CalDiscount(identity, dateTime);
			} catch (Throwable exception) {
				Assertions.assertEquals("Your age is too young.", exception.getMessage());
			}
		}

		@Test
		public void testAgeMoreThan() throws Throwable {
			Identity identity = new Identity(80, true, false);
			try {
				new CalDiscount(identity, dateTime);
			} catch (Throwable exception) {
				Assertions.assertEquals("Your age doesn't meet the requirements.", exception.getMessage());
			}
		}
	}

	@DisplayName("營業與非營業時間")
	@Nested
	class DifferentBusinessHours {
		@Test
		public void testNoBusiness() {
			Identity identity = new Identity(25, false, false);
			try {
				new CalDiscount(identity, "2021-05-26 週三 04:30:00");
			} catch (Throwable exception) {
				Assertions.assertEquals("Business hours: 05:00-22:00", exception.getMessage());
			}
		}

		@Test
		public void testEarlyBirdBusiness() throws Throwable {
			Identity identity = new Identity(25, false, false);
			CalDiscount CalDiscount = new CalDiscount(identity, "2021-05-26 週三 06:30:00");
			Assertions.assertEquals(0.8, CalDiscount.getDiscount());
		}

		@Test
		public void testHaveBusiness() throws Throwable {
			Identity identity = new Identity(25, false, false);
			CalDiscount CalDiscount = new CalDiscount(identity, "2021-05-26 週三 10:30:00");
			Assertions.assertEquals(1, CalDiscount.getDiscount());
		}
	}
}
