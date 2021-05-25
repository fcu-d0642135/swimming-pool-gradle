package main;

import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

		String chargeOption = ChargeOption.select();

		switch (chargeOption) {
			case "1":
				System.out.println(Chinese.chargesBasic);
				int age = QueryAge.query();
				boolean memberAuth = QueryMember.query();
				/*
				System.out.println("Are you a group? (Y/N)");

				format = false;
				while(!format) {
					String stGroup = input.nextLine();
					
					if (stGroup.equalsIgnoreCase("Y")) {
						group = true;
						format = true;
					} else if (stGroup.equalsIgnoreCase("N")){
						group = false;
						format = true;
					} else {
						System.out.println("Please enter Y or N.");
					}	
				}
										
				Identity identity = new Identity(week, member, age, hour, group);
				Discount discount = new Discount(identity);
				
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
