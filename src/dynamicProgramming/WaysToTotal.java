package dynamicProgramming;

import java.util.Arrays;

public class WaysToTotal {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3 };
		int total = 5;
		WaysToTotal waysToTotal = new WaysToTotal();
		System.out.println(waysToTotal.dp_waysToTotal(numbers, total));
	}

	public int dp_waysToTotal(int[] numbers, int total) {
		Arrays.sort(numbers);
		int[][] dp = new int[numbers.length][total + 1];
		dp[0][0] = 1;
		for (int i = 1; i < numbers.length; i++)
			dp[i][0] = 1;
		for (int j = 1; j <= total; j++)
			dp[0][j] = (j - numbers[0]) >= 0 ? dp[0][j - numbers[0]] : 0;
		for (int i = 1; i < numbers.length; i++)
			for (int j = 1; j <= total; j++) {
				if (j - numbers[i] >= 0)
					dp[i][j] = dp[i - 1][j] + dp[i][j - numbers[i]];
				else
					dp[i][j] = dp[i - 1][j];
			}
		return dp[numbers.length - 1][total];
	}
}
