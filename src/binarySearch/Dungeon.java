package binarySearch;

public class Dungeon {

	public static void main(String[] args) {
		int[][] dungeon = { { 0, 0, 0 }, { 1, 1, -1 } };
		Dungeon d = new Dungeon();
		System.out.println(d.calculateMinimumHP(dungeon));
	}

	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null)
			return 1;
		int[][] health = new int[dungeon.length][dungeon[0].length];
		for (int i = dungeon.length - 1; i >= 0; i--) {
			for (int j = dungeon[i].length - 1; j >= 0; j--) {
				if ((i == dungeon.length - 1) && (j == dungeon[i].length - 1)) {
					health[i][j] = dungeon[i][j] <= 0 ? 1 - dungeon[i][j] : 1;
				} else if ((i == dungeon.length - 1) && (j != dungeon[i].length - 1)) {
					health[i][j] = health[i][j + 1] - dungeon[i][j];
					if (health[i][j] <= 0)
						health[i][j] = 1;
				} else if ((i != dungeon.length - 1) && (j == dungeon[i].length - 1)) {
					health[i][j] = health[i + 1][j] - dungeon[i][j];
					if (health[i][j] <= 0)
						health[i][j] = 1;
				} else {
					health[i][j] = Math.min(health[i + 1][j], health[i][j + 1]) - dungeon[i][j];
					if (health[i][j] <= 0)
						health[i][j] = 1;
				}
			}
		}
		return health[0][0];
	}
}
