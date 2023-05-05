package dynamicProgrammin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintIncreasingSubsequences {

	public static void main(String[] args) {
		int[] arr = {1,2,3, 4};
		printIS(arr);

	}

	private static void printIS(int[] arr) {
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> element = new ArrayList<>();
		int pos = 0;
		dfs(res, element , pos, arr);
		for(List<Integer> list : res) {
			System.out.println("list is : ");
			for(int i : list) {
				System.out.print(" "+i);
			}
		}
		
	}

	private static void dfs(List<List<Integer>> res, List<Integer> element, int pos, int[] arr) {
		
		if(element.size() >= 2) {
			res.add(new ArrayList(element));
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = pos ;i<arr.length ;i++) {
			if((element.size() == 0 || element.get(element.size() - 1) <= arr[i]) && !set.contains(arr[i])){
				element.add(arr[i]);
				dfs(res, element, i+1, arr);
				element.remove(element.size()-1);
				set.add(arr[i]);
			}
		}
		
	}

}
