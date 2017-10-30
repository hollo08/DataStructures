package linkedIn;

public class BinarySearchRotated {

	public static void main(String[] args) {
		BinarySearchRotated bsr = new BinarySearchRotated();
		int[] rotated_array = { 8, 9, 0, 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(bsr.bsr(0, rotated_array.length - 1, 9, rotated_array));
	}

	boolean bsr(int s, int e, int p, int[] array) {
		if (s > e)
			return false;
		int m = s + (e - s) / 2;
		if (array[m] == p)
			return true;
		else {
			if (array[m] < p) {
				if (array[e] < p)
					return bsr(s, m - 1, p, array);
				else
					return bsr(m + 1, e, p, array);
			} else {
				if (array[s] < p)
					return bsr(s, m - 1, p, array);
				else
					return bsr(m + 1, e, p, array);
			}
		}
	}
}
