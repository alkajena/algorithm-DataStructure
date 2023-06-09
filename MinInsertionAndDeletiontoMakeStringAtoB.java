package dynamicProgrammin;

public class MinInsertionAndDeletiontoMakeStringAtoB {

	public void minInsertionAndDeletiontoMakeStringAtoB(String a, String b) {
		
		int m = a.length();
		int n = b.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i =0;i <= m ;i++) {
			for(int j =0;j<=n;j++) {
				if(i ==0 || j==0) {
					dp[i][j] = 0;
				}
				else if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int insertion = b.length() - dp[m][n];
		int deletion = a.length() - dp[m][n];
		System.out.println("insertion count is : "+insertion+" Deletion count is : "+deletion);
	}
	public static void main(String[] args) {
		String a = "heapoyt";
		String b = "pea";
		
		new MinInsertionAndDeletiontoMakeStringAtoB().minInsertionAndDeletiontoMakeStringAtoB(a, b);

	}

}
