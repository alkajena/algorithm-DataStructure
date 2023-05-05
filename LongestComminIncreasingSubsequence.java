package dynamicProgrammin;

public class LongestComminIncreasingSubsequence {

	public static void main(String[] args) {
		int arr1[] = {10, 11, 3, 4, 9, 1, 10, 34, 1};
        int arr2[] = {10, 11,5, 3, 8, 9, 10, 2, 1, 34};
 
        int n = arr1.length;
        int m = arr2.length;
 
    System.out.println("Length of LCIS is " +
                       LCIS(arr1, n, arr2, m));

	}

	private static String LCIS(int[] arr1, int n, int[] arr2, int m) {
		
		int[] table = new int[m];
		
		for(int i =0;i < m;i++) {
			table[i] = 0;
		}
		
		for(int i =0;i <n;i++) {
			
			int current = 0;
			for(int j =0;j <m;j++) {
				
				if(arr1[i] ==arr2[j]) {
					if(current+1 > table[j]) {
						table[j] = current+1;
					}
				}
				
				if(arr1[i] > arr2[j]) {
					if(table[j] > current) {
						current = table[j];
					}
				}
			}
		}
		
		int max = 0;
		for(int i =0 ; i <table.length; i++ ) {
			//System.out.println(i);
			/*if(table[i] != 0) {
				System.out.println(arr2[i]);
			}*/
			if(max < table[i]) {
				System.out.println(arr2[i]);
				max = table[i];
			}
		}
		return Integer.toString(max);
	}

}
