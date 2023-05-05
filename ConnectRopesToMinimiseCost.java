package HeapOrQueue;

import java.util.PriorityQueue;

public class ConnectRopesToMinimiseCost {

	public void connectRopesToMinimiseCost(int[] arr) {
		int cost = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i =0;i <arr.length;i++) {
			pq.add(arr[i]);
		}
		int a = 0;
		while(pq.size() >= 2) {
			cost+=pq.peek();
			a = pq.peek();
			pq.poll();
			cost+=pq.peek();
			pq.add(a+pq.peek());
			pq.poll();
			
		}
		
		System.out.println("The cost is : "+cost);
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		new ConnectRopesToMinimiseCost().connectRopesToMinimiseCost(arr);
	}

}
