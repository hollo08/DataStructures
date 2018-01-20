package weeklyContest.WC_63;

public class CostClimbingStairs {

	public static void main(String[] args) {
		CostClimbingStairs ccs = new CostClimbingStairs();
		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		int res = ccs.minCostClimbingStairs(cost);
		System.out.println(res);
	}

	public int minCostClimbingStairs(int[] cost) {
		if (cost.length == 0)
			return 0;
		else if (cost.length == 1)
			return cost[0];
		else {
			int[] dp = new int[cost.length];
			dp[cost.length - 1] = cost[cost.length - 1];
			dp[cost.length - 2] = cost[cost.length - 2];
			for (int i = cost.length - 3; i >= 0; i--) {
				dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
			}
			return Math.min(dp[0], dp[1]);
		}
	}
}
