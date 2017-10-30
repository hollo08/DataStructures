package dynamicProgramming;

public class MaxAreaRectangle {
	public static void main(String[] args) {
		int[][] numbers = { { 2, 1, -3, -4, 5 }, { 0, 6, 3, 4, 1 }, { 2, -2, -1, 4, -5 }, { -3, 3, 1, 0, 5 } };
		MaxAreaRectangle maxAreaRectangle = new MaxAreaRectangle();
		maxAreaRectangle.dp_maxAreaRectangle(numbers);
	}

	public int dp_maxAreaRectangle(int[][] numbers) {
		int maxArea = -1, maxLeft = -1, maxRight = -1, maxUp = -1, maxDown = -1;
		KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i; j < numbers.length; j++) {
				int[] row = new int[numbers[i].length];
				if (i == j) {
					row = numbers[i];
				} else {
					for (int k = 0; k < row.length; k++)
						row[k] += numbers[i][k];
				}
				int[] row_best = kadanesAlgorithm.kadane_maxSum(row);
				if (maxArea < row_best[0]) {
					maxArea = row_best[0];
					maxLeft = row_best[1];
					maxRight = row_best[2];
					maxUp = i;
					maxDown = j;
				}
			}
		}
		return 0;
	}
}

/*
 * Calculated the max sum subarray in 1-D matrix
 */
class KadanesAlgorithm {

	public int[] kadane_maxSum(int[] numbers) {
		int max = -1;
		int endIndex = -1;
		int startIndex = -1;
		int runningMax = 0;
		int runningStartIndex = -1;
		for (int j = 0; j < numbers.length; j++) {
			int i = numbers[j];
			if (runningMax + i > 0) {
				if (runningStartIndex == -1)
					runningStartIndex = j;
				runningMax += i;
				if (max < runningMax) {
					startIndex = runningStartIndex;
					max = runningMax;
					endIndex = j;
				}
			} else {
				runningStartIndex = -1;
				runningMax = 0;

			}
		}
		int[] returnArray = { max, startIndex, endIndex };
		return returnArray;
	}
}