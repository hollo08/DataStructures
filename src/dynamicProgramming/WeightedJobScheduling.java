package dynamicProgramming;

public class WeightedJobScheduling {

	public static void main(String[] args) {
		WeightedJobScheduling weightedJobScheduling = new WeightedJobScheduling();
		int[] start = { 1, 2, 4, 6, 5, 7 };
		int[] end = { 3, 5, 6, 7, 8, 9 };
		int[] values = { 5, 6, 5, 4, 11, 7 };
		System.out.println(weightedJobScheduling.dp_weightedJobScheduling(start, end, values));
	}

	public int dp_weightedJobScheduling(int[] start, int[] end, int[] values) {
		int[][] dp = new int[end.length][end[end.length - 1] + 1];
		for (int j = 0; j < dp[0].length; j++) {
			if(j >= end[0])
				dp[0][j] = values[0];
		}
		for (int i = 1; i < end.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if(j >= end[i]){
					dp[i][j] = Math.max(dp[i-1][j], values[i] + dp[i][start[i]]);
				} else
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[end.length - 1][end[end.length - 1]];
	}
}
