package HeapOrQueue;

import java.util.Collections;
import java.util.PriorityQueue;
//for smallest take max heap
public class KthSmallestElement {

public int findKthSmallestElement(int[] arr, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i =0; i < arr.length;i++) {
			pq.add(arr[i]);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
	public static void main(String[] args) {
		int[] arr = {2,6,1,8,19,14};
		System.out.println(new KthSmallestElement().findKthSmallestElement(arr, 2));

	}

}
