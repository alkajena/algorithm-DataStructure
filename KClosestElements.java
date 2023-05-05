package HeapOrQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class KClosestElements {
	
	class customComparator implements Comparator<Map<Integer, Integer>>{
		@SuppressWarnings("unchecked")
		public int compare(Map<Integer, Integer> a , Map<Integer, Integer> b) {
			Map.Entry<Integer, Integer> entryA = a.entrySet().iterator().next();
			Map.Entry<Integer, Integer> entryB =  b.entrySet().iterator().next();
		
			if(entryA.getKey() < entryB.getKey()) {
				return 1;
			}
			else if (entryA.getKey() > entryB.getKey()) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
	public void findKClosestElements(int[] arr, int x, int k) {
		PriorityQueue<Map<Integer, Integer>> pq = new PriorityQueue<>(new customComparator());
		for(int i = 0;i <arr.length; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			if(x!=arr[i]) {
				map.put(Math.abs(arr[i] - x), arr[i]);
				pq.add(map);
			}
			if(pq.size() > k) {
				pq.poll();
			}
		}
		
		while(pq.size() > 0) {
			System.out.println("the number is : "+pq.peek().entrySet().iterator().next().getValue());
			pq.poll();
		}
	}

	public static void main(String[] args) {
		int[] arr = {5,6,7,8,9};
		new KClosestElements().findKClosestElements(arr, 7, 2);
	}

}
