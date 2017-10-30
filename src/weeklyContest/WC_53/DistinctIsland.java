package weeklyContest.WC_53;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.IntegerSyntax;

public class DistinctIsland {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 } };
		DI_Solution sol = new DI_Solution();
		System.out.println(sol.numDistinctIslands(grid));
	}

}

class DI_Solution {
	public int numDistinctIslands(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				visited[i][j] = false;
			}
		}

		Set<List<List<Integer>>> set = new HashSet<List<List<Integer>>>();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					List<List<Integer>> newIsland = new ArrayList<List<Integer>>();
					set.add(DFS(grid, visited, i, j, rows, cols, i, j, newIsland));
				}
			}
		}
		return set.size();
	}

	private List<List<Integer>> DFS(int[][] grid, boolean[][] visited, int i0, int j0, int rows, int cols, int i, int j,
			List<List<Integer>> islandShape) {
		if (i >= 0 && i < rows && j >= 0 && j < cols && !visited[i][j]) {
			List<Integer> coord = new ArrayList<Integer>();
			visited[i][j] = true;
			coord.add(i - i0);
			coord.add(j - j0);
			islandShape.add(coord);
			if ((i - 1) >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
				islandShape = DFS(grid, visited, i0, j0, rows, cols, i - 1, j, islandShape);
			}
			if ((j - 1) >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
				islandShape = DFS(grid, visited, i0, j0, rows, cols, i, j - 1, islandShape);
			}
			if ((i + 1) < rows && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
				islandShape = DFS(grid, visited, i0, j0, rows, cols, i + 1, j, islandShape);
			}
			if ((j + 1) < cols && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
				islandShape = DFS(grid, visited, i0, j0, rows, cols, i, j + 1, islandShape);
			}
		}
		return islandShape;
	}
}