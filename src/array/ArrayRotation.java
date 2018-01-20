package array;

public class ArrayRotation {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		ArrayRotation arrayRotation = new ArrayRotation();
		arrayRotation.rotateArray(arr, 0);
		System.out.println();
	}

	public void rotateArray(int[][] arr, int level) {
		if (arr.length / 2 >= level) {
			int[] buffer = new int[arr[level].length - level * 2 - 1];
			int[] tempBuffer = new int[buffer.length];
			int direction = 1;
			int offset = level + 1;
			for (; direction <= 4; ++direction) {
				for (int j = 0; j < tempBuffer.length; j++) {
					if (direction == 1) {
						tempBuffer[j] = arr[offset + j][arr.length - 1 - level];
					} else if (direction == 2) {
						tempBuffer[j] = arr[arr.length - 1 - level][arr.length - 1 - offset - j];
					} else if (direction == 3) {
						tempBuffer[j] = arr[arr.length - 1 - offset - j][level];
					} else {
						tempBuffer[j] = arr[level][offset + j];
					}
				}

				if (direction == 1) {
					for (int i = 0; i < tempBuffer.length; i++)
						buffer[i] = arr[level][offset + i];
					arr[level][arr.length - offset] = arr[level][level];
				}

				for (int j = 0; j < tempBuffer.length; j++) {
					if (direction == 1) {
						arr[offset + j][arr.length - 1 - level] = buffer[j];
					} else if (direction == 2) {
						arr[arr.length - 1 - level][arr.length - 1 - offset - j] = buffer[j];
					} else if (direction == 3) {
						arr[arr.length - 1 - offset - j][level] = buffer[j];
					} else {
						arr[level][offset + j] = buffer[j];
					}
				}

				for (int i = 0; i < tempBuffer.length; i++) {
					buffer[i] = tempBuffer[i];
				}
			}
			rotateArray(arr, ++level);
		}
	}
}
