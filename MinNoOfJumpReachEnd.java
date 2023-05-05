package dynamicProgrammin;

import java.util.ArrayList;
import java.util.List;

public class MinNoOfJumpReachEnd {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9, 7, 8 ,9 ,10, 11, 234, 654 };
		int count = findMinJump(arr);
	}

	private static int findMinJump(int[] arr) {
		List<Integer> indexList = new ArrayList<>();
		indexList.add(0);
		if(arr[0] == 0 || arr[0] == -1) {
			return -1;
		}
		int i =0; 
		while(i < arr.length){
			int j = i+arr[i];
			int max = 0;
			int maxIndex = 0;
			if(j >= arr.length -1) {
				break;
			}
			else {
				for(int k = Math.min(j, arr.length -1) ; k > i ;k--) {
					if(arr[k] > max) {
						max = arr[k];
						maxIndex = k;
					}
				}
				indexList.add(maxIndex);
			}
			i = maxIndex;
		}
		for(Integer m :indexList) {
			System.out.println("index is  : "+m);
		}
		return indexList.size();
	}

}
