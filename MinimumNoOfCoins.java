package greedyAlgorithm;

public class MinimumNoOfCoins {
	
	public void minimumNoOfCoins(int v) {
		
		int[] denomination = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int remaining = 0;
		for(int i = denomination.length - 1; i >= 0 ; i --) {
			if(v >= denomination[i]) {
				remaining = v - denomination[i];
				System.out.println(denomination[i]);
				break;
			}
		}
		if(remaining > 0)
			minimumNoOfCoins(remaining);
	}

	public static void main(String[] args) {
		new MinimumNoOfCoins().minimumNoOfCoins(11);
	}
}
