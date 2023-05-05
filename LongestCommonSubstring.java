package dynamicProgrammin;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s1 = "Alka is a good girl";
		String s2 = "is a good boy";
		printLCSubstring(s1, s2);

	}

	private static void printLCSubstring(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		int row=0;
		int col=0;
		int[][] dp = new int[m+1][n+1];
		int len =0;
		for(int i = 0; i <= m ; i++) {
			for(int j = 0; j <= n ;j++) {
				if( i ==0 || j ==0) {
					dp[i][j] = 0;
				}
				else if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
					if(len < dp[i][j]) {
						len = dp[i][j];
						row=i;
						col=j;
					}
				
				}
				else {
					dp[i][j] = 0;
				}
			}
		}
		
		int index = dp[m][n];
		int i =row;
		int j =col;
		String res = "";
		while(i > 0 && j > 0) {
			res += s1.charAt(i-1);
			i--;
			j--;
		}
		System.out.println("LCS is : "+new StringBuilder(res).reverse());
		
	}

}
