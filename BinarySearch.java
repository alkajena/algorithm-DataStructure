package searching;

public class BinarySearch {
	
	public static int binarySearchIterative(int[] arr, int l, int h, int key) {
		while(l <= h) {
			int mid = l+(h-l)/2;
			
			if(arr[mid] == key) {
				return mid;
			}else if(key > arr[mid]) {
				l=mid+1;
			}
			else if(key < arr[mid]) {
				h=mid-1;
			}
		}
		return -1;
	}
	/*Time complexity :- O(logn)
	 * space complexity :- 1*/
	public int binarySearchRecursive(int[] arr, int l, int h, int key) {
		
		if(l <= h) {
			int mid = l+(h-l)/2;
			
			if(arr[mid] == key) {
				return mid;
			}else if(key > arr[mid]) {
				binarySearchRecursive(arr,mid+1,h,key);
			}
			else if(key < arr[mid]) {
				binarySearchRecursive(arr,l,mid-1,key);
			}
		}
		return -1;
	}
	/*Time complexity :- O(logn)
	 * space complexity :- O(logn)*/
	public static void main(String[] args) {
		int[] arr = {9,10,23,34,65,83};
		System.out.println("Index from method binarySearchIterative is : "+binarySearchIterative(arr,0,arr.length-1,34));
		System.out.println("Index from method binarySearchRecursive is : "+binarySearchIterative(arr,0,arr.length-1,10));
	}

	//Here mid = l+(h-l)/2 instead of l+h/2 because it may return negative number for higher positive value like (2^31-1)the n it will throw
	//arrayoutofboundexception
	
	
}
