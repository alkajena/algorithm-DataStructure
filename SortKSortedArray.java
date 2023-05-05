package HeapOrQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//take min heap
public class SortKSortedArray {

	public void sortKSortedArray(int[] arr, int k){
		List<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i <arr.length;i++) {
			pq.add(arr[i]);
			if(pq.size() > k) {
				list.add(pq.peek());
				pq.poll();
			}
		}
		
		while(!pq.isEmpty()) {
			list.add(pq.peek());
			pq.poll();
		}
		for(Integer i : list) {
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		int[] arr = {6,5,3,2,8,10,9};
		new SortKSortedArray().sortKSortedArray(arr, 3);

	}

}
