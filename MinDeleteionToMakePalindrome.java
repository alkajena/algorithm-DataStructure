package dynamicProgrammin;

//The same code will be applicable for minimum insertion required to make a string palindrome 
//and minimum deletion required to make a string palindrome
public class MinDeleteionToMakePalindrome {

	public int minDeletionToMakePalindrome(String str) {
		StringBuilder rev = new StringBuilder(str);
		rev.reverse();
		String revStr = rev.toString();
		int m = str.length();
		int n = revStr.length();
		int[][] dp = new int [m+1][n+1];
		for(int i =0; i <=m;i++) {
			for(int j =0;j <=n;j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else if(str.charAt(i-1) == revStr.charAt(j-1)){
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int diff = str.length() - dp[m][n];
		return diff;
		
	}
	public static void main(String[] args) {
		String str = "abgcefba";
		System.out.println("the count is : "+new MinDeleteionToMakePalindrome().minDeletionToMakePalindrome(str));
	}

}
