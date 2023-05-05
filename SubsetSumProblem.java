package dynamicProgrammin;

public class SubsetSumProblem {

	public static void main(String[] args) {
		int[] arr =  {2,3,5,8,7};
		int n = arr.length;
		int sum = 10;
		System.out.println(subsetSum(arr, n, sum));
	}
	  static void isSubsetSum(int set[], int n, int sum)
	    {
	        // The value of subset[i][j] will be
	        // true if there is a subset of
	        // set[0..j-1] with sum equal to i
	        boolean subset[][] = new boolean[sum + 1][n + 1];
	  
	        // If sum is 0, then answer is true
	        for (int i = 0; i <= n; i++)
	            subset[0][i] = true;
	  
	        // If sum is not 0 and set is empty,
	        // then answer is false
	        for (int i = 1; i <= sum; i++)
	            subset[i][0] = false;
	  
	        // Fill the subset table in bottom
	        // up manner
	        for (int i = 1; i <= sum; i++) {
	            for (int j = 1; j <= n; j++) {
	                subset[i][j] = subset[i][j - 1];
	                if (i >= set[j - 1])
	                    subset[i][j]
	                        = subset[i][j]
	                          || subset[i - set[j - 1]][j - 1];
	            }
	        }
	  
	        /* // uncomment this code to print table
	        for (int i = 0; i <= sum; i++)
	        {
	        for (int j = 0; j <= n; j++)
	            System.out.println (subset[i][j]);
	        } */
	  
	        System.out.println("the value is : "+subset[sum][n]);
	    }
	  
	 static boolean subsetSum(int[] arr, int n, int sum) {
		 
		boolean[][] dp = new boolean[n+1][sum+1];
		
		for(int i = 0;i <= sum; i++) {
			dp[0][i] = false;
		}
		
		for(int i = 0; i<= n;i++) {
			dp[i][0] = true;
		}
		
		for(int i =1; i <= n; i++) {
			for(int j = 1; j<=sum; j++) {
				if(arr[i-1] <= j) {
					dp[i][j] = (dp[i-1][j] || dp[i-1][j-arr[i-1]]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
		//boolean a ;
	//	System.out.println("boolean value : "+a);
		return dp[n][sum];
		
		
	}
}
