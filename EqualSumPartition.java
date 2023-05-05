package dynamicProgrammin;

public class EqualSumPartition {

	public static void main(String[] args) {
		int arr[] = {1,5,11,7};
		int n = arr.length;
		System.out.println(findPartition(arr,n));

	}

	private static boolean findPartition(int[] arr, int n) {
		int sum = 0;
		for(int i =0;i <arr.length;i++) {
			sum+=arr[i];
		}
		if(sum%2 != 0) {
			return false;
		}
		else {
			return new SubsetSumProblem().subsetSum(arr, n, sum);
		}
		
	}

}
