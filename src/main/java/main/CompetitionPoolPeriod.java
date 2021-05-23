package main;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class CompetitionPoolPeriod {

	Map<Character, String> period = new TreeMap<>();
	
	public CompetitionPoolPeriod() {
				
		period.put('A', "8:00-10:00");
		period.put('B', "10:30-12:30");
		period.put('C', "14:00-16:00");
		period.put('D', "16:30-18:30");
		period.put('E', "19:00-21:00");
		
	}
	
	public Set<Entry<Character, String>> getAllKeyValue() {
		return this.period.entrySet();
	}
	
	public String getPeriodValue(char no){
		return this.period.get(no);
	}
	
	
}
