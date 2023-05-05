package dynamicProgrammin;

public class SequencePatternMatching {

	public void sequencePatternMatching(String a, String b, int m, int n) {
		
		int dp[][] = new int[m+1][n+1];
		for(int i =0; i <=m;i++) {
			for(int j =0;j <=n;j++) {
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
		
		int shortestLen = m < n ? m : n;
		if(dp[m][n] == shortestLen) {
			System.out.println("String a is present in String b");
		}
	}
	public static void main(String[] args) {
		String a = "ABCK";
		String b = "AvfgBgfCd";
		new SequencePatternMatching().sequencePatternMatching(a, b, 4, 8);

	}

}
