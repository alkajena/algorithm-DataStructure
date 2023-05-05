package sorting;

public class SortKSortedArray {
	
	public void sortKSortedArray(int[] arr, int l, int h, int k) {
		
		if(l < h) {
			
			int partition = findPartition(arr, l, h, k);
			sortKSortedArray(arr, l, partition-1, k);
			sortKSortedArray(arr, partition+1, h, k);
		}
		
	}

	private int findPartition(int[] arr, int l, int h, int k) {
		int mid = l+(h-l)/2;
		int i = Math.max(l, mid-k);
		int j = i;
		int end = Math.min(mid+k, h);
		swap(arr, mid, end);
		while(j < end) {
			if(arr[j] < arr[end]) {
				swap(arr, j, i++);
			}
			j=j+1;
		}
		swap(arr, end , i);
		return i;
	}
	

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {6, 5, 3, 2, 8, 10, 9};
		new SortKSortedArray().sortKSortedArray(arr, 0, 6, 3);
		System.out.println("Array after K sort\n");
       for(int i : arr) {
    	   System.out.println(i);
       }
		

	}
//time complexity NLog(N) and space complexity :- LOGN
}
