package weeklyContest.WC_53;

public class MaxAreaIsland {

	public static void main(String[] args) {

		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

		// int[][] grid = { { 1, 1 }, { 1, 0 } };

		/*
		 * int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1,
		 * 1 }, { 0, 0, 0, 1, 1 } };
		 */
		MAI_Solution sol = new MAI_Solution();
		System.out.println(sol.maxAreaOfIsland(grid));
	}

}

class MAI_Solution {

	public int maxAreaOfIsland(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				visited[i][j] = false;
			}

		int max_area = 0;

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				if (!visited[i][j] && grid[i][j] == 1) {
					int area = visit_node(grid, visited, i, j, 0, rows, cols);
					if (max_area < area)
						max_area = area;
				}
			}
		return max_area;
	}

	private int visit_node(int[][] grid, boolean[][] visited, int i, int j, int area, int rows, int cols) {
		if (grid[i][j] == 0)
			return area;
		else {
			area++;
			visited[i][j] = true;
			if ((i - 1) >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
				area = visit_node(grid, visited, i - 1, j, area, rows, cols);
			}
			if ((j - 1) >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
				area = visit_node(grid, visited, i, j - 1, area, rows, cols);
			}
			if ((i + 1) < rows && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
				area = visit_node(grid, visited, i + 1, j, area, rows, cols);
			}
			if ((j + 1) < cols && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
				area = visit_node(grid, visited, i, j + 1, area, rows, cols);
			}
			return area;
		}
	}
}