package searching;

public class InterpolationSearch {
	public int interpolationSearch(int[] arr, int n, int l, int h, int key) {
		if(l <= h) {
			int pos = l+(((h-l)/(arr[h]-arr[l]))*(key - arr[l]));
			if(arr[pos] == key) {
				return pos;
			}
			if(arr[pos] < key) {
				return interpolationSearch(arr, n, pos+1, h, key);
			}
			if(arr[pos] > key){
				return interpolationSearch(arr, n, l, pos-1, key);
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {32, 45, 56, 87, 99, 100};
		System.out.println("InterpolationSearch index is : "+new InterpolationSearch().interpolationSearch(arr, arr.length, 0, arr.length-1, 87));
	}

}
