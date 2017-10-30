package leetcode;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		System.out.println(LCSS("zabcdhf", "pabcdkh"));
	}

	static int LCSS(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int d[][] = new int[m][n];
		int max = -1;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					if (s1.charAt(i) == s2.charAt(j)) {
						d[i][j] = 1;
						max = 1;
					} else
						d[i][j] = 0;
				} else if (s1.charAt(i) == s2.charAt(j)) {
					d[i][j] = d[i - 1][j - 1] + 1;
					max = Math.max(max, d[i][j]);
				} else
					d[i][j] = 0;
			}
		return max;
	}
}