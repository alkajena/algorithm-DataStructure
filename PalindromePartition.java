package dynamicProgrammin;

public class PalindromePartition {

	public int palindromePartition(String s, int i , int j) {
		 if(i>=j || isPalindrome(s, i, j) ) {
			 return 0;
		 }
		 int min = Integer.MAX_VALUE;
		 for(int k = i; k <= j-1;k++) {
			 int temp = palindromePartition(s, i, k)+
					 palindromePartition(s, k+1, j)+1;
			 if(temp < min) {
				 min = temp;
			 }
		 }
		 return min;
	}
	private boolean isPalindrome(String s, int i, int j) {
		while(i <= j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			}
			else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "ababbbabbababa";
		System.out.println("the partition count is : "+new PalindromePartition().palindromePartition(s, 0, s.length()-1));

	}

}
