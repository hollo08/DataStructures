package dynamicProgramming;

import java.util.Arrays;

public class SubsetSumProblem {

	public static void main(String[] args) {
		SubsetSumProblem subsetSumProblem = new SubsetSumProblem();
		int[] numbers = { 2, 3, 7, 8, 10 };
		System.out.println(subsetSumProblem.dp_subsetSum(numbers, 11));
	}

	public boolean dp_subsetSum(int[] numbers, int total) {
		Arrays.sort(numbers);
		boolean[][] dp = new boolean[numbers.length][total + 1];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j <= total; j++) {
				if (j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					if (j == numbers[i])
						dp[i][j] = true;
					else
						dp[i][j] = false;
				} else {
					if (j - numbers[i] >= 0)
						dp[i][j] = dp[i - 1][j] || dp[i - 1][j - numbers[i]];
					else
						dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[numbers.length - 1][total];
	}

}
