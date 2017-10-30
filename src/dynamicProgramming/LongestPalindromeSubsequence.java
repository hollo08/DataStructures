package dynamicProgramming;

public class LongestPalindromeSubsequence {

	public static void main(String[] args) {
		LongestPalindromeSubsequence lps = new LongestPalindromeSubsequence();
		System.out.println(lps.dp_LongestPalindromeSubsequence("agbdba"));
	}

	public int dp_LongestPalindromeSubsequence(String word) {
		int[][] dp = new int[word.length()][word.length()];
		for (int j = 0; j < word.length(); j++) {
			for (int i = 0; i < word.length() - j; i++) {
				if (j == 0) {
					dp[i][i + j] = 1;
				} else {
					int max = Math.max(Math.max(dp[i + 1][i + j], dp[i + 1][i + j - 1]), dp[i][i + j - 1]);
					if (word.charAt(i) == word.charAt(i + j)) {
						dp[i][i + j] = max + 2;
					} else {
						dp[i][i + j] = max;
					}
				}
			}
		}
		return dp[0][word.length() - 1];
	}
}
