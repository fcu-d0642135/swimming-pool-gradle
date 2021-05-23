package main;

public class Identity {
	private int week;
	private boolean member;
	private int age;
	private String inTime;
	private int hour;
	private boolean group;
	
	public Identity(int week, boolean member, int age, int hour, boolean group) {
		this.week = week;
		this.member = member;
		this.age = age;
		this.hour = hour;
		this.group = group;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}	
	
	public String getIn_time() {
		return inTime;
	}

	public void setIn_time(String inTime) {
		this.inTime = inTime;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public boolean isGroup() {
		return group;
	}

	public void setGroup(boolean group) {
		this.group = group;
	}
}
