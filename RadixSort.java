package sorting;

import java.util.Arrays;

public class RadixSort {
	
	public void radixSort(int[] arr, int n) {
		
		int max = getMax(arr);
		
		for(int i = 1; max/i > 0 ;i*=10) {
			
			countingSort(arr, n, i);
		}
	}

	private void countingSort(int[] arr, int n, int exp) {
		
		int[] count = new int[10];
		Arrays.fill(count, 0);
		int[] output = new int[n];
		
		for(int i = 0; i < n; i++) {
			count[(arr[i]/exp)%10]++;
		}
		
		for(int i = 1; i < 10; i++) {
			count[i]+=count[i-1];
		}
		
		for(int i =n-1 ;i >=0 ;i--) {
			output[count[(arr[i]/exp)%10]-1] = arr[i];
			count[(arr[i]/exp)%10]--;
		}
		for(int i =0;i <n ; i ++) {
			arr[i] = output[i];			
		}
	}

	private int getMax(int[] arr) {
		int max = 0;
		for(int i=0 ; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;
        new RadixSort().radixSort(arr, n);
        for(int i =0;i<n ;i++) {
			System.out.println("the no is :  "+arr[i]);
		}
	}

}
