package searching;

public class JumpSearch {
	
	public int jumpSearch(int[] arr, int size, int key) {
		
		
			int step = (int)Math.floor(Math.sqrt(size));
			int prev = 0 ;
			
			while(arr[Math.min(step, size)-1] < key) {
				prev = step;
				step += (int)Math.floor(Math.sqrt(size));
				if(prev >= size) {
					return -1;
				}
			}
			while(arr[prev] < key) {
				prev++;
				
				if(prev >= size) {
					return -1;
				}
			}
			
			if(arr[prev] == key) {
				return prev;
			}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		JumpSearch jump = new JumpSearch();
		System.out.println("The jump search index is : "+jump.jumpSearch(arr, arr.length, 8));

	}
//Time complexity is O(root(N)) and space complexity :- 1
//It is better than linear search but worse than binary search.. but when to search for smallest no or just after smallest no then 
//jump search is better as binary search start searching from middle element and needs logn jumps to reach smallest elements
}
