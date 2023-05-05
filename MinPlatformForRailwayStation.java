package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MinPlatformForRailwayStation {
	
	public int arrivalTime;
	public int deptTime;
	
	public MinPlatformForRailwayStation() {}
	
	public MinPlatformForRailwayStation(int arr, int dept) {
		
		this.arrivalTime = arr;
		this.deptTime = dept;
	}

    public class ArrivalTimeComparator implements Comparator<MinPlatformForRailwayStation>{
		
		@Override
		public int compare(MinPlatformForRailwayStation o1, MinPlatformForRailwayStation o2) {
			
			return o1.arrivalTime - o2.arrivalTime;
		}
		
	}
	public static void main(String[] args) {
		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
        List<MinPlatformForRailwayStation> list = new ArrayList<>();
		for(int i = 0; i<arr.length; i++) {
			list.add(new MinPlatformForRailwayStation(arr[i], dep[i]));
		}
        int res = new MinPlatformForRailwayStation().countPlatforms(list);
        System.out.println(res);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private  int countPlatforms(List<MinPlatformForRailwayStation> list) {
		
		Collections.sort(list, new ArrivalTimeComparator());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(list.get(0).deptTime);
		int count = 1;
		for(int i =0; i < list.size(); i++) {
			
			if(list.get(i).arrivalTime < queue.peek()) {
				count++;
			}
			else {
				queue.poll();
			}
			queue.add(list.get(i).deptTime);
		}
		
		return count;
	}

}
