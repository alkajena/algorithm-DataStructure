package dynamicProgrammin;

public class MatrixChainMultiplication {
	
	public int matrixChainMultiplication(int[] arr, int i, int j) {
		if(i >= j) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int k = i;k <=j-1;k++) {
			
			int temp = matrixChainMultiplication(arr, i ,k) +
					matrixChainMultiplication(arr, k+1 ,j) +
					arr[i-1] * arr[k] * arr[j];
			if(temp < min) {
				min = temp;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] arr = {40,20,30,10,30};
		System.out.println("minimum cost is : "+new MatrixChainMultiplication().matrixChainMultiplication(arr, 1, 4));

	}

}
