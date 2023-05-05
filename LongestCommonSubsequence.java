package dynamicProgrammin;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		//String s1 = "AGGTAB";
		//String s2 = "GGTGAYB";
		
		String s1 = "ALKA";
		String s2 = "AKLA";
		printLCS(s1, s2, s1.length(), s2.length());

	}

	private static void printLCS(String s1, String s2, int m, int n) {
		
		int dp[][] = new int[m+1][n+1];
		
		for(int i =0 ;i <=m ;i++) {
			for(int j =0;j <=n; j++) {
				if(i == 0|| j==0) {
					dp[i][j] = 0;
				}
				else if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		int len = dp[m][n];
		
		int i = m;int j =n;
		String str = "";
		while(i > 0 && j >0) {
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				str += s1.charAt(i-1);
				i--;
				j--;
			}else if(dp[i-1][j] > dp[i][j-1]) {
				i--;
			}
			else {
				j--;
			}
		}
		
		System.out.println("LCS is : "+str);
		
	}

}
