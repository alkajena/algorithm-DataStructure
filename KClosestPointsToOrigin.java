package HeapOrQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
	class Point {
		int xPoint = 0;
		int yPoint = 0;

		public Point(int xPoint, int yPoint) {
			this.xPoint = xPoint;
			this.yPoint = yPoint;
		}
	}
	
	class CustomComparator implements Comparator<Map.Entry<Integer, Point>>{
		@Override
		public int compare(Map.Entry<Integer, Point> o1, Map.Entry<Integer, Point> o2) {
			int count1 = o1.getKey();
			int count2 = o2.getKey();
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

	public void kClosestPointsToOrigin(int[][] arr, int x, int y, int k) {
		PriorityQueue<Map.Entry<Integer, Point>> pq = new PriorityQueue<>(new CustomComparator());
		Map<Integer, Point> map = new HashMap<>();
		List<Point> list  = new ArrayList<>();
		int count = 0;
		for(int i =0; i <x;i++) {
			Point p = new Point(arr[i][0], arr[i][1]);
			list.add(p);
		}
		for(int i =0; i < list.size();i++) {
			
			map.put((list.get(i).xPoint*list.get(i).xPoint)+(list.get(i).yPoint*list.get(i).yPoint), list.get(i));
		}
		for(Map.Entry<Integer, Point> entry : map.entrySet()) {
			if(pq.size() >= k) {
				pq.poll();
			}
			pq.add(entry);
		}
		while(pq.size() > 0) {
			Point p = pq.peek().getValue();
			
				System.out.println("the X is : "+p.xPoint+" Y is : "+p.yPoint);
			
			pq.poll();
		}
	}
	public static void main(String[] args) {
		int[][] arr= {{3,5},{-2,2},{6,8},{0,3}};
		new KClosestPointsToOrigin().kClosestPointsToOrigin(arr, 4, 2, 2);

	}

}
