package dynamicProgrammin;

public class ShortestSupersequence {

	public void shortestsupersequence(String a, String b) {
		
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];
		for(int i = 0;i <=m ;i++) {
			for(int j =0;j <= n;j++) {
				if(i == 0 || j == 0) {
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
		int i = m;
		int j = n;
		String str = "";
		while(i >0 && j >0) {
			if(a.charAt(i-1) == b.charAt(j-1)) {
				str += a.charAt(i-1);
				i--;
				j--;
			}
			else if (dp[i-1][j] > dp[i][j-1]) {
				str += a.charAt(i-1);
				i--;
			}
			else {
				str += b.charAt(j-1);
				j--;
			}
		}
		while(i >0) {
			str += a.charAt(i-1);
			i--;
		}
		while(j>0) {
			str += b.charAt(j-1);
			j--;
		}
		
		System.out.println("the supersequence is : "+new StringBuilder(str).reverse());
	}
	public static void main(String[] args) {
		
		String a = "AGGTAYB";
		String b = "GXTXAB";
		new ShortestSupersequence().shortestsupersequence(a, b);

	}

}
