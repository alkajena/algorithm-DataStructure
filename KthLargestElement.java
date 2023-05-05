package HeapOrQueue;

import java.util.PriorityQueue;
//for largest take min heap
public class KthLargestElement {

	public int findKthLargestElement(int[] arr, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
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
		System.out.println(new KthLargestElement().findKthLargestElement(arr, 3));

	}

}
