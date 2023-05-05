package dynamicProgrammin;

import java.util.ArrayList;
import java.util.List;

public class LongestSubsequenceWithDiff1 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 3, 2};
		longestSubsequenceLength(arr, arr.length);

	}

	private static void longestSubsequence(int[] arr, int length) {
		List<List<Integer>> res = new ArrayList<>();
		for(int i = 0; i<length ; i++) {
			int x = i;
			List<Integer> list = new ArrayList<>();
			for(int j = i+1; j<length;j++) {
				if(arr[x] == arr[j]+1 || arr[x] == arr[j]-1) {
					list.add(arr[x]);
					x = j;
				}
				if(j == arr.length-1) {
					list.add(arr[x]);
				}
			}
			res.add(list);
		}
		for(List<Integer> list : res) {
			for(Integer i : list) {
				System.out.print(" "+i);
			}
			System.out.println();
			
			
		}//int[] arr = {1, 2, 3, 4, 5, 3, 2};
	}
	
	private static void longestSubsequenceLength(int[] arr, int length) {
		int[] dp = new int[length];
		for(int i =0;i <length;i++) {
			dp[i] = 1;
		}
		
		for(int i =1;i <length;i++) {
			for(int j =0;j <i;j++) {
				if(arr[i] == arr[j]+1 || arr[i] == arr[j]-1) {
					dp[i] = Math.max(dp[i], 1+dp[j]);
				}
			}
		}
		for(Integer i : dp) {
			
			System.out.println(i);
			
			
		}
	}

}
