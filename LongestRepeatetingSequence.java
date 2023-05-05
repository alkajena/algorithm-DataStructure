package dynamicProgrammin;

public class LongestRepeatetingSequence {

	public void longestRepeatetingSequence(String a, int m) {
		
		String b = a;
		int n = m;
		int[][] dp = new int [m+1][n+1];
		for(int i =0; i <=m ;i++) {
			for(int j =0;j <=n;j++) {
				if(i==0 || j ==0) {
					dp[i][j] = 0;
				}
				else if(a.charAt(i-1) == b.charAt(j-1) && i != j){
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println("the length of longest repeateting sequence : "+dp[m][n]);
		
	}
	public static void main(String[] args) {
		String a = "AAXDFBCBDGCD";
		new LongestRepeatetingSequence().longestRepeatetingSequence(a, a.length());

	}

}
