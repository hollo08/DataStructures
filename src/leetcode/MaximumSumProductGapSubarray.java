package leetcode;

public class MaximumSumProductGapSubarray {

	public static void main(String[] args) {
		System.out.println(MPSA(new int[] { 4, 8, 17, 20, 7, 4, 8, 3 }));
	}

	static int MSSA(int[] numberArray) {
		int maxToNow = 0, max = 0;
		for (int i : numberArray) {
			maxToNow = maxToNow + i;
			if (maxToNow < 0)
				maxToNow = 0;
			if (max < maxToNow)
				max = maxToNow;
		}
		return max;
	}

	static int MPSA(int[] numberArray) {
		int result = 0;
		int[] max = new int[numberArray.length];
		int[] min = new int[numberArray.length];
		max[0] = min[0] = numberArray[0];
		for (int i = 1; i < numberArray.length; i++) {
			if (numberArray[i] > 0) {
				max[i] = Math.max(numberArray[i], max[i - 1] * numberArray[i]);
				min[i] = Math.min(numberArray[i], min[i - 1] * numberArray[i]);
			} else {
				max[i] = Math.max(numberArray[i], min[i - 1] * numberArray[i]);
				min[i] = Math.min(numberArray[i], max[i - 1] * numberArray[i]);
			}
			result = Math.max(result, max[i]);
		}
		return result;
	}

	static int MaximumGap(int[] number) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i : number) {
			if (min > i)
				min = i;
			if (max < i)
				max = i;
		}
		double interval = (double) number.length / (max - min);
		Bucket[] bucketArr = new Bucket[number.length + 1];
		for (int i = 0; i < bucketArr.length; i++)
			bucketArr[i] = new Bucket();
		for (int num : number) {
			int index = (int) ((num - min) * interval);
			if (bucketArr[index].low == -1)
				bucketArr[index].low = bucketArr[index].high = num;
			else {
				bucketArr[index].low = Math.min(bucketArr[index].low, num);
				bucketArr[index].high = Math.max(bucketArr[index].high, num);
			}
		}
		int previous_high = bucketArr[0].high;
		int result = -1;
		for (int i = 1; i < bucketArr.length; i++) {
			if (bucketArr[i].low != -1) {
				result = Math.max(result, bucketArr[i].low - previous_high);
				previous_high = bucketArr[i].high;
			}
		}
		return result;
	}
}

class Bucket {
	int low, high;

	public Bucket() {
		low = high = -1;
	}
}