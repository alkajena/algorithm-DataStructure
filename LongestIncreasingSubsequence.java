																																																																															package dynamicProgrammin;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr =  {50, 3, 10, 7, 40, 80};
		printLIS(arr);

	}

	private static void printLIS(int[] arr) {
		
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i= 0; i <arr.length ;i++) {
			
			int x =i;
			List<Integer> licList = new ArrayList<>();
			for(int j =i+1 ;j < arr.length ;j++) {
				if(arr[x] < arr[j] && j ==  arr.length -1) {
					licList.add(arr[x]);
					licList.add(arr[j]);
					x = j;
				}
				else if (arr[x] < arr[j]) {
					licList.add(arr[x]);
					x = j;
				}
			}
			list.add(licList);
		}
		for(List<Integer> list1 : list) {
			System.out.println("list is : ");
			for(int i : list1) {
				System.out.print(" "+i);
			}
		}
	}

}
