package sorting;

public class InsertionSort {

	public void insertionSort(int[] arr, int n) {
		
		for(int j = 1; j <n ;j++) {
			int i = j-1;
			int key = arr[j];
			
			while(i >= 0 && arr[i] > key) {
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
			
		}
	}
	

	public static void main(String[] args) {
		 int[] arr = { 10, 7, 8, 9, 1, 5 };
	     int n = arr.length;
	     new InsertionSort().insertionSort(arr, n);
	     for (int i = 0; i < n; i++)
	            System.out.print(arr[i] + " ");
	  
	        System.out.println();


	}

}
