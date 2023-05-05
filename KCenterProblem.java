package greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class KCenterProblem {

	public static void main(String[] args) {
		 int n = 4;
		    int[][] weights = new int[][]{ { 0, 4, 8, 5 }, 
		                                   { 4, 0, 10, 7 }, 
		                                   { 8, 10, 0, 9 }, 
		                                   { 5, 7, 9, 0 } };
		    int k = 2;
		  
		    // Function Call
		    selectKcities(n, weights, k);

	}

	private static void selectKcities(int n, int[][] weights, int k) {
		
		List<Integer> dist = new ArrayList<>();
		List<Integer> centers = new ArrayList<>();
		
		int max = 0;
		for(int i = 0; i < k;i++) {
			for(int j =0; j<n;j++) {
				dist.add(j, weights[max][j]);
			}
			max = findMaxIndex(dist, n);
			centers.add(max);
		}
		
		for(Integer i : centers) {
			System.out.println("center is : "+i);
		}
		
	}

	private static int findMaxIndex(List<Integer> dist, int n) {
		int index = 0;
		for(int i =0; i < n;i++) {
			if(dist.get(i) > dist.get(index)) {
				index = i;
			}
		}
		return index;
	}

}
