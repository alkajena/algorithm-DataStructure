package searching;

public class TernarySearch {

	public int ternarysearch(int[] arr , int n, int key, int l, int h) {
		if(l <= h) {
			int mid1 = l+(h-l)/3;
			int mid2 = mid1+(h-l)/3;
			
			if(arr[mid1] == key) {
				return mid1;
			}
			if(arr[mid2] == key) {
				return mid2;
			}
			if(arr[mid1] > key) {
				return ternarysearch(arr, n, key, l, mid1-1);
			}
			if(arr[mid2] < key) {
				return ternarysearch(arr, n, key, mid2+1, h);
			}
			
			return ternarysearch(arr, n, key, mid1+1, mid2-1);
		
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70,80,90};
		System.out.println("the ternary search index is : "+new TernarySearch().ternarysearch(arr, arr.length, 100, 0, arr.length-1));

	}

}
