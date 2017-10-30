package dynamicProgramming;

import java.util.Arrays;

public class CoinChangingAlgorithm {

	public static void main(String[] args) {
		CoinChangingAlgorithm coinChangingAlgorithm = new CoinChangingAlgorithm();
		int[] numbers = { 7, 2, 3, 6 };
		System.out.println(coinChangingAlgorithm.dp_coinChangingAlgorithm(numbers, 13));
	}

	public float dp_coinChangingAlgorithm(int[] numbers, int total) {
		Arrays.sort(numbers);
		float[][] dp = new float[numbers.length][total + 1];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j <= total; j++) {
				if (j == 0)
					dp[i][j] = 0;
				else
					dp[i][j] = Float.POSITIVE_INFINITY;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (i == 0) {
					if (j - numbers[i] >= 0 && Float.isFinite(dp[i][j - numbers[i]]))
						dp[i][j] = dp[i][j - numbers[i]] + 1;
					else
						dp[i][j] = Float.POSITIVE_INFINITY;
				} else {
					if (j - numbers[i] >= 0) {
						dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - numbers[i]]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		return dp[numbers.length - 1][total];
	}
}
