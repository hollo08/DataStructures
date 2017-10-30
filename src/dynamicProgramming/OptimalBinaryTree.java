package dynamicProgramming;

public class OptimalBinaryTree {

	public static void main(String[] args) {
		OptimalBinaryTree optimalBinaryTree = new OptimalBinaryTree();
		int[] f = { 4, 2, 6, 3 };
		System.out.println(optimalBinaryTree.dp_optimalBinaryTree(f));
	}

	public int dp_optimalBinaryTree(int[] f) {
		int[][] dp = new int[f.length][f.length];
		for (int j = 0; j < f.length; j++) {
			for (int i = 0; i < f.length - j; i++) {
				if (j == 0)
					dp[i][i + j] = f[i];
				else if (j == 1) {
					dp[i][i + j] = f[i] + f[i + j] + Math.min(f[i], f[i + j]);
				} else {
					int min_cost = 0;
					for (int k = 0; k <= j; k++)
						min_cost += f[i + k];
					int min = Integer.MAX_VALUE;
					for (int k = 0; k <= j; k++) {
						if (k == 0)
							min = dp[i + k + 1][i + j];
						else if (k == j) {
							min = Math.min(min, dp[i][i + k - 1]);
						} else {
							min = Math.min(min, dp[i + k + 1][i + j] + dp[i][i + k - 1]);
						}
					}
					dp[i][i+j] = min_cost + min;
				}
			}
		}
		return dp[0][f.length - 1];
	}
}