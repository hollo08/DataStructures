package dynamicProgramming;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] numbers = { 2, 5, 1, 8, 3};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.dp_longestIncreasingSubsequence(numbers));
	}

	public int dp_longestIncreasingSubsequence(int[] numbers) {
		int max = Integer.MIN_VALUE;
		int[] dp = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			for (int j = i; j >= 0; j--) {
				if (j == i)
					dp[i] = 1;
				else {
					if (numbers[i] > numbers[j])
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		for (int i : dp)
			max = i > max ? i : max;
		return max;
	}
}
