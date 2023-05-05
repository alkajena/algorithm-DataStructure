package HeapOrQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

	class CustomComparator implements Comparator<Map.Entry<Integer, Integer>>{
		@Override
		public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
			int count1 = o1.getValue();
			int count2 = o2.getValue();
			if(count1 < count2) {
				return 1;
			}
			else if(count1 > count2) {
				return -1;
			}
			else{
				return 0;
			}
			
		}
}
	
	public void frequencySort(int[] arr) {
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new CustomComparator());
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for(int i =0; i <arr.length;i++) {
			if(map.get(arr[i]) == null) {
				count = 0;
			}
			map.put(arr[i], count+=1);
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.add(entry);
		}
		while(pq.size() > 0) {
			int fr = pq.peek().getValue();
			for(int i =0; i <fr;i++) {
				System.out.println("the number is : "+pq.peek().getKey());
			}
			pq.poll();
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,1,1,3,2,2,4};
		new FrequencySort().frequencySort(arr);
	}

}
