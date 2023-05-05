package dynamicProgrammin;

import java.util.Arrays;
//print all possible combinations
public class CoinChange {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int sum = 4;
		System.out.println("count is : "+minCoinChange(arr,arr.length,sum));

	}
	
	public static long coinChange(int[] S,int n, int sum)
    {
		int[] table = new int[sum+1];
		
		Arrays.fill(table, 0);
		table[0] = 1;
		for(int i =0; i <n;i++) {
			for(int j = S[i]; j <= sum ;j++) {
				table[j] = table[j]+table[j-S[i]];
			}
		}
		return table[sum];
    }
	//coin change with minimum coin
	public static long minCoinChange(int[] S,int n, int sum)
    {
		int[][] table = new int[n][sum+1];
		for(int i =0 ; i < n;i++) {
			table[i][0] = 0;
		}
		for(int i =1 ; i <= sum;i++) {
			table[0][i] = 1+table[0][i-1];
		}
		for(int i =1; i <n;i++) {
			for(int j=1;j<=sum;j++) {
				if(j >= S[i]) {
					table[i][j] = Math.min(table[i-1][j], 1+table[i][j-S[i]]);
				}
				else {
					table[i][j] = table[i-1][j];
				}
			}
		}
		return table[n-1][sum];
    }

}
