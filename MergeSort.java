package sorting;

public class MergeSort {
	
	public void mergeSort(int[] arr, int l, int h) {
		if(l < h) {
		int mid = l+(h-l)/2;
		
		mergeSort(arr, l, mid);
		mergeSort(arr, mid+1, h);
		
		merge(arr,l,mid,h);
		}
	}

	private void merge(int[] arr, int l, int mid, int h) {
		
		int n1 = mid-l+1;
		int n2 = h-mid;
		
		int le[] = new int[n1];
		int r[] = new int[n2];
		
	 for(int i = 0;i <n1;i++) {
		 le[i] = arr[l+i];
	 }
	 
	 for(int i = 0;i <n2;i++) {
		 r[i] = arr[mid+1+i];
	 }
	 
	 int i =0; int j=0; int k =l;
	 while(i < n1 && j <n2) {
		 if(le[i] <= r[j]) {
			 arr[k] = le[i];
			 i++;
		 }
		 else {
			 arr[k] = r[j];
			 j++;
		 }
		 k++;
	 }
	while(i < n1) {
		arr[k] = le[i];
		 i++;
		 k++;
	}
	
	while(j < n2) {
		 arr[k] = r[j];
		 j++;
		 k++;
	}
		
	}

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		new MergeSort().mergeSort(arr, 0, arr.length-1);
		int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
	}

}
