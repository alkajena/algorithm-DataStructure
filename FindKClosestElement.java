package sorting;

public class FindKClosestElement {
	
	public void findKClosestElements(int[] arr, int k, int x, int l, int h) {
		
		int index = findCrossOverPoint(arr,l,h,x);
		int left = index-1;
		int right = index+1;
		int count = 1;
		
		while(count <= k && left > l && right < h) {
			if(Math.abs(x - arr[left]) < Math.abs(arr[right] - x)) {
				System.out.println("the element is : "+arr[left]);
				left--;
			}
			else {
				System.out.println("the element is : "+arr[right]);
				right++;
			}
			count++;
		}
		
		while(count <= k && left > l) {
			System.out.println("the element is : "+arr[left]);
			left--;
			count++;
		}
		
		while(count <= k && right < h) {
			System.out.println("the element is : "+arr[right]);
			right++;
			count++;
		}
		
	}

	private int findCrossOverPoint(int[] arr, int l, int h, int x) {
		
		if(l < h) {
			int mid = l+(h-l)/2;
			
			if(arr[mid] == x) {
				return mid;
			}
			
			if(x > arr[mid]) {
				return findCrossOverPoint(arr, mid+1, h, x);
			}
			else {
				return findCrossOverPoint(arr, l, mid-1, x);
			}
		}
		return -1;
		
	}

	public static void main(String[] args) {
		FindKClosestElement close = new FindKClosestElement();
		 int arr[] = {12, 16, 22, 30, 35, 39, 42,
                 45, 48, 50, 53, 55, 56
                };
    int n = arr.length;
    int x = 35, k = 4;
    close.findKClosestElements(arr, k, x, 0, n-1);
	}

}
