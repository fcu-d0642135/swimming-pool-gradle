package main;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws Throwable {

		String chargeOption = ChargeOption.select();

		switch (chargeOption) {
			case "1":
				System.out.println(Chinese.chargesBasic);
				int age = QueryAge.query();
				boolean memberAuth = QueryMember.query();
				boolean groupAuth = QueryGroup.query();

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss"); // 設定日期格式
				String dateTime = sdf.format(new Date()); // new Date() 為獲取當前系統時間

				Identity identity = new Identity(age, memberAuth, groupAuth);
				Discount discount = new Discount(identity, dateTime);
				System.out.println(discount.getDiscount());

				/*
				System.out.println("Please pay: $" + discount.getTotal());
				*/

				break;
			
			case "2":
				System.out.println(Chinese.chargesCompetitionPool);
				/*
				switch (choice) {
					case "1":
						System.out.println(Chinese.rentSingleWaterway);
						hour = input.nextInt();

						competitionpool = new CompetitionPool(hour);
						
						System.out.println("Please pay: $" + competitionpool.getTotal());
						break;
						
					case "2":
						System.out.println(Chinese.numberOfTraining);
						int coach = input.nextInt();
						int student = input.nextInt();
						
						while (coach < 1) {
							System.out.println(Chinese.needCoach);
							coach = input.nextInt();
						}
						
						while ((coach + student) < 10) {
							System.out.println(Chinese.minPeople);
							System.out.println(Chinese.numberOfTraining);
							coach = input.nextInt();
							student = input.nextInt();
						}
						
						CompetitionPoolPeriod periodList = new CompetitionPoolPeriod();
						System.out.println(periodList.getAllKeyValue());
						System.out.println("Please enter A-E");
						char period = input.next().charAt(0);
						
						competitionpool = new CompetitionPool(coach, student, period);
						
						System.out.printf("Your period is %s, and please pay: $ %d",
								periodList.getPeriodValue(period), competitionpool.getTotal());
						break;
						
					default:
						System.out.println("The number is invalid");
				}
				*/
				break;

			default:
				System.out.println("No plan.");
				break;
		}
	}
}
