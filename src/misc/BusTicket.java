package misc;

import java.util.Arrays;
import java.util.Collections;

public class BusTicket {
	private int minCost(int[] days, int [] costs ) {
		int n = days[days.length -1];
		
		// create a table of boolean contains all days from day 1 to day n (including not travel day)
		// put a true if it is travel day
		boolean [] travelDay = new boolean[n+1];
		for (int i = 0; i < days.length; i++) {
			int day = days[i];
			travelDay[day] = true;
		}
		
		int[] dp = new int[n+1];
		
		for(int i = 1; i < dp.length; i++) {
			if(!travelDay[i]) {
				dp[i] = dp[i-1];
				continue;
			}
			int one = dp[i-1]+costs[0];
			int seven = dp[Math.max(i-7, 0)]+costs[1];
			int thirty = dp[Math.max(i-30, 0)]+costs[2];
			
			System.out.println("cost: "+one + " "+seven+ " "+ thirty);
			dp[i] = Collections.min(Arrays.asList(one,seven, thirty));
		}
		
		return dp[n];
	}
	public static void main (String arg[]) {
		BusTicket bus = new BusTicket();
		int [] days = new int[]{ 1, 3, 4, 5 };
		int [] costs = new int[]{2, 7, 15};
		int cost = bus.minCost(days, costs);
		
		System.out.println("min cost: "+cost);
	}
}
