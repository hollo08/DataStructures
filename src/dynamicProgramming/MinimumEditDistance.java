package dynamicProgramming;

public class MinimumEditDistance {

	public static void main(String[] args) {
		MinimumEditDistance med = new MinimumEditDistance();
		System.out.println(med.dp_minimumEditDistance("azced", "abcdef"));
	}

	public int dp_minimumEditDistance(String word1, String word2) {
		int[][] dp = new int[word1.length()][word2.length()];
		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				if (i == 0 && j == 0) {
					if (word1.charAt(i) == word2.charAt(j))
						dp[i][j] = 0;
					else
						dp[i][j] = 1;
				} else if (i == 0) {
					dp[i][j] = word1.charAt(i) == word2.charAt(j) ? dp[i][j - 1] : dp[i][j - 1] + 1;
				} else if (j == 0) {
					dp[i][j] = word1.charAt(i) == word2.charAt(j) ? dp[i - 1][j] : dp[i - 1][j] + 1;
				} else {
					int temp = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]);
					dp[i][j] = word1.charAt(i) == word2.charAt(j) ? temp : temp + 1;
				}
			}
		}
		return dp[word1.length() - 1][word2.length() - 1];
	}
}