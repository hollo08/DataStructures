package weeklyContest.WC_63;

public class ContainViruses {

	public static void main(String[] args) {
		ContainViruses cv = new ContainViruses();
		int[][] grid = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		/*
		 * { { 1, 1, 1, 0, 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1, 1, 1, 1, 1 }, { 1,
		 * 1, 1, 0, 0, 0, 0, 0, 0 } };
		 */
		/* { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }; */
		/*
		 * { { 0, 1, 0, 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0,
		 * 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
		 */
		int res = cv.containVirus(grid);
		System.out.println(res);
	}

	public int containVirus(int[][] grid) {
		int walls_needed = 0;
		while (hasVirus(grid)) {
			int[] res = getVirusWithMostAffected(grid);
			walls_needed += res[2];
			removeVirus(res[0], res[1], grid.length, grid[0].length, grid);
			spreadVirus(grid);
		}
		return walls_needed;
	}

	public boolean hasVirus(int[][] grid) {
		for (int[] row : grid)
			for (int col : row)
				if (col == 1)
					return true;
		return false;
	}

	public int[] getVirusWithMostAffected(int[][] grid) {
		int[] res = new int[3];
		int rows = grid.length;
		int cols = grid[0].length;
		int max_effected_cells = Integer.MIN_VALUE;
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (grid[i][j] == 1 && !visited[i][j]) {
					int[] result = graph_DFS(i, j, rows, cols, grid, visited, new boolean[rows][cols], new int[2]);
					if (max_effected_cells < result[0]) {
						max_effected_cells = result[0];
						res[0] = i;
						res[1] = j;
						res[2] = result[1];
					}
				}
		return res;
	}

	public int[] graph_DFS(int i, int j, int rows, int cols, int[][] grid, boolean[][] visited,
			boolean[][] non_virus_cells, int[] res) {
		visited[i][j] = true;
		if (i - 1 >= 0 && grid[i - 1][j] == 0) {
			res[1] = res[1] + 1;
			if (!non_virus_cells[i - 1][j]) {
				non_virus_cells[i - 1][j] = true;
				res[0] = res[0] + 1;
			}
		}
		if (i + 1 < rows && grid[i + 1][j] == 0) {
			res[1] = res[1] + 1;
			if (!non_virus_cells[i + 1][j]) {
				non_virus_cells[i + 1][j] = true;
				res[0] = res[0] + 1;
			}
		}
		if (j - 1 >= 0 && grid[i][j - 1] == 0) {
			res[1] = res[1] + 1;
			if (!non_virus_cells[i][j - 1]) {
				non_virus_cells[i][j - 1] = true;
				res[0] = res[0] + 1;
			}
		}
		if (j + 1 < cols && grid[i][j + 1] == 0) {
			res[1] = res[1] + 1;
			if (!non_virus_cells[i][j + 1]) {
				non_virus_cells[i][j + 1] = true;
				res[0] = res[0] + 1;
			}
		}

		if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == 1) {
			res = graph_DFS(i - 1, j, rows, cols, grid, visited, non_virus_cells, res);
		}
		if (i + 1 < rows && !visited[i + 1][j] && grid[i + 1][j] == 1) {
			res = graph_DFS(i + 1, j, rows, cols, grid, visited, non_virus_cells, res);
		}
		if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == 1) {
			res = graph_DFS(i, j - 1, rows, cols, grid, visited, non_virus_cells, res);
		}
		if (j + 1 < cols && !visited[i][j + 1] && grid[i][j + 1] == 1) {
			res = graph_DFS(i, j + 1, rows, cols, grid, visited, non_virus_cells, res);
		}
		return res;
	}

	public void removeVirus(int i, int j, int rows, int cols, int[][] grid) {
		grid[i][j] = -1;
		if (i - 1 >= 0 && grid[i - 1][j] == 1)
			removeVirus(i - 1, j, rows, cols, grid);
		if (i + 1 < rows && grid[i + 1][j] == 1)
			removeVirus(i + 1, j, rows, cols, grid);
		if (j - 1 >= 0 && grid[i][j - 1] == 1)
			removeVirus(i, j - 1, rows, cols, grid);
		if (j + 1 < cols && grid[i][j + 1] == 1)
			removeVirus(i, j + 1, rows, cols, grid);
	}

	public void spreadVirus(int[][] grid) {
		boolean[][] previous_state = new boolean[grid.length][grid[0].length];
		int rows = grid.length, cols = grid[0].length;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (grid[i][j] == 1)
					previous_state[i][j] = true;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (grid[i][j] == 1 && previous_state[i][j]) {
					if (i - 1 >= 0 && grid[i - 1][j] != -1)
						grid[i - 1][j] = 1;
					if (i + 1 < rows && grid[i + 1][j] != -1)
						grid[i + 1][j] = 1;
					if (j - 1 >= 0 && grid[i][j - 1] != -1)
						grid[i][j - 1] = 1;
					if (j + 1 < cols && grid[i][j + 1] != -1)
						grid[i][j + 1] = 1;
				}
	}
}