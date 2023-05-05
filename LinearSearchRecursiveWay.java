package searching;


public class LinearSearchRecursiveWay {
	
	public int LinearSearch(Integer arr[], int size, int key ) {
		
		if(size == -1) {
			return 0;
		}
		else if (arr[size-1] == key) {
			return size-1;
		}
		else {
			return LinearSearch(arr, size-1, key);
		}
	}

	public static void main(String[] args) {
		Integer arr[] = {4,89,67,54,30};
		LinearSearchRecursiveWay obj = new LinearSearchRecursiveWay();
		int index = obj.LinearSearch(arr, 5, 67);
		System.out.println("index is : "+index);
	}

}

//Time complexity :- O(N)
//space complexity :- O(N)(due to recursion)
