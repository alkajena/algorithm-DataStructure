package sorting;

public class FindUnsortedSubArray {
	
	public void findUnsortedSubArray(int[] arr, int size) {
		int s =0; int e =0;int max =0; int min =0;
		for(int i = 0; i < size-1; i++) {
			if(arr[i] > arr[i+1]) {
				s=i;
				break;
			}
		}
		for(int i = size-1 ; i >0 ; i--) {
			if(arr[i] < arr[i-1]) {
				e = i;
				break;
			}
		}
		
		for(int i = s+1 ; i <= e; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		for(int i =0; i <s;i++) {
			if(arr[i] > min) {
				s=i;
				break;
			}
		}
		
		for(int i =size-1; i > e+1;i--) {
			if(arr[i] < max) {
				e=i;
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
