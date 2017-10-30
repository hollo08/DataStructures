package dynamicProgramming;

public class MatrixMultiplication {

	public static void main(String[] args) {
		int[][] matries = { { 2, 3 }, { 3, 6 }, { 6, 4 }, { 4, 5 } };
		MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
		System.out.println(matrixMultiplication.dp_matrixMultiplication(matries));
	}

	public int dp_matrixMultiplication(int[][] matries) {
		if (matries == null)
			return 0;
		else if (matries[0].length == 1) {
			return matries.length;
		} else {
			for (int i = 1; i < matries.length; i++)
				if (matries[i][0] != matries[i - 1][1])
					return -1;
			int[][] dp = new int[matries.length][matries.length];

			for (int j = 0; j < matries.length; j++) {
				for (int i = 0; i < matries.length - j; i++)
					if (j == 0)
						dp[i][i + j] = 0;
					else {
						if (j == 1) {
							dp[i][i + j] = matries[i][0] * matries[i][1] * matries[i + j][1];
						} else {
							int min = Integer.MAX_VALUE;
							for (int k = 0; k < j; k++) {
								int temp = dp[i][i + k] + dp[i+ k + 1][i + j]
										+ matries[i][0] * matries[i+ k][1] * matries[i + j][1];
								min = temp < min ? temp : min;
							}
							dp[i][i + j] = min;
						}
					}
			}
			return dp[0][matries.length - 1];
		}
	}
}
