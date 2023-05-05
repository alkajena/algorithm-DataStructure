package sorting;

public class QuickSort {
	
	public void quickSort(int[] arr, int l, int h) {
		if(l < h) {
			int par = partition(arr, l, h);
			quickSort(arr, l, par-1);
			quickSort(arr, par+1, h);
		}
	}
	
	private int partition(int[] arr, int l, int h) {
		
		int pivot = arr[h];
		int i = l-1;
		for(int j = l;j <= h; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr, i+1, h);
		return i+1;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		 int[] arr = { 10, 7, 8, 9, 1, 5 };
	     int n = arr.length;
	     new QuickSort().quickSort(arr, 0, n-1);
	     for (int i = 0; i < n; i++)
	            System.out.print(arr[i] + " ");
	  
	        System.out.println();

	}

}
