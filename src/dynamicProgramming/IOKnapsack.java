package dynamicProgramming;

public class IOKnapsack {

	public static void main(String[] args) {
		int[] weights = {1, 3, 4, 5};
		int[] values = {1, 4, 5, 7};
		IOKnapsack ioknapsack = new IOKnapsack();
		System.out.println(ioknapsack.dp_IOKnapsack(weights, values, 7));
	}

	public int dp_IOKnapsack(int[] weights, int[] values, int total_weight) {
		if ((weights.length != values.length) || total_weight <= 0)
			return 0;

		int[][] dp = new int[weights.length][total_weight + 1];

		for (int i = 0; i < weights.length; i++)
			dp[i][0] = 0;

		for (int i = 0; i < weights.length; i++)
			for (int j = 1; j <= total_weight; j++) {
				if (i == 0) {
					dp[i][j] = weights[i] <= j ? values[i] : 0;
				} else {
					dp[i][j] = j - weights[i] < 0 ? dp[i - 1][j] : Math.max(dp[i - 1][j], values[i] + dp[i - 1][j - weights[i]]);
				}
			}
		return dp[weights.length - 1][total_weight];
	}

}
