package dynamicProgrammin;

public class KnapSackRecursion {

	public int knapSack(int[] wt, int[] val, int W, int n) {
		
		if(n==0 || W==0) {
			return 0;
		}
		if(wt[n-1] <= W) {
			return Math.max(val[n-1]+knapSack(wt, val, W-wt[n-1], n-1), knapSack(wt, val, W, n-1));
		}
		else {
			return knapSack(wt, val, W, n-1);
		}
	}
	public static void main(String[] args) {
		
		int wt[] = {1,3,4,5};
		int val[] = {1,4,5,7};
		int W = 7;
		System.out.println("the max profit is : "+new KnapSackRecursion().knapSack(wt, val, W, wt.length-1));

	}

}
