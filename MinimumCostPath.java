package dynamicProgrammin;

public class MinimumCostPath {

	public static void main(String[] args) {
		

	}
	
	public static void findMincostPath(int[][] arr, int m, int n) {
		
		int[][] dp = new int[m+1][n+1];
		
		dp[0][0] = arr[0][0];
		for(int i = 1; i <= m; i++) {
			dp[0][i] = arr[0][i] + arr[0][i-1];
		}
		
		for(int i = 1; i <= n; i++) {
			dp[i][0] = arr[i][0] + arr[i-1][0];
		}
		
		for(int i = 1 ;i <=m;i++) {
			for(int j = 1;j<=n;j++) {
				dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+arr[i][j];
			}
		}
			
	}

	private static int min(int i, int j, int k) {
		if(i < j && i < k) {
			return i;
		}
		else if(j < k) {
			return j;
		}
		else {
			return k;
		}
	}

}
