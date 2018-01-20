package weeklyContest.WC_67;

public class LargestPlusSign {

	public static void main(String[] args) {
		LargestPlusSign lps = new LargestPlusSign();
		int N = 5;
		int[][] mines = { { 4, 2 } };
		lps.orderOfLargestPlusSign(N, mines);
	}

	public int orderOfLargestPlusSign(int N, int[][] mines) {
		int count = 0;
		if (N == 0)
			return count;
		int[][] grid = new int[N][N];
		int[][] left = new int[N][N];
		int[][] right = new int[N][N];
		int[][] top = new int[N][N];
		int[][] buttom = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				grid[i][j] = 1;
		if (mines != null && mines.length != 0) {
			for (int i = 0; i < mines.length; i++)
				grid[mines[i][0]][mines[i][1]] = 0;
		}

		for (int j = 1; j < N; j++) {
			for (int i = 0; i < N; i++) {
				left[i][j] = grid[i][j] == 0 || grid[i][j - 1] == 0 ? 0 : left[i][j - 1] + 1;
			}
		}

		for (int j = N - 2; j >= 0; j--) {
			for (int i = 0; i < N; i++) {
				right[i][j] = grid[i][j] == 0 || grid[i][j + 1] == 0 ? 0 : right[i][j + 1] + 1;
			}
		}

		for (int j = 1; j < N; j++) {
			for (int i = 0; i < N; i++) {
				left[i][j] = grid[i][j] == 0 || grid[i][j - 1] == 0 ? 0 : left[i][j - 1] + 1;
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				top[i][j] = grid[i][j] == 0 || grid[i - 1][j] == 0 ? 0 : top[i - 1][j] + 1;
			}
		}

		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				buttom[i][j] = grid[i][j] == 0 || grid[i + 1][j] == 0 ? 0 : buttom[i + 1][j] + 1;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 1)
					count = Math.max(count,
							1 + Math.min(Math.min(left[i][j], right[i][j]), Math.min(top[i][j], buttom[i][j])));
			}
		}

		return count;
	}

}
