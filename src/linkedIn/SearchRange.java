package linkedIn;

public class SearchRange {

	public static void main(String[] args) {
		SearchRange sg = new SearchRange();
		int[] array = { 1, 3, 5, 11, 11, 11, 11, 15, 17, 19 };
		int index = sg.binarySearch(0, array.length - 1, array, 11);
		if (index != -1) {
			int start = sg.getStart(0, index, array, 11);
			int end = sg.getEnd(index, array.length - 1, array, 11);
			System.out.println(start+" "+end);
		}
	}

	int binarySearch(int s, int e, int[] array, int p) {
		if (s > e)
			return -1;
		else {
			int m = s + (e - s) / 2;
			if (array[m] == p)
				return m;
			else {
				if (array[m] < p)
					return binarySearch(m + 1, e, array, p);
				else
					return binarySearch(s, m - 1, array, p);
			}
		}
	}

	int getStart(int s, int e, int[] array, int p) {
		if (array[e] != p)
			return e+1;
		int m = s + (e - s) / 2;
		if (array[m] == p)
			return getStart(s, m-1, array, p);
		else
			return getStart(m+1, e, array, p);
	}

	int getEnd(int s, int e, int[] array, int p) {
		if (array[s] != p)
			return s-1;
		int m = s + (e - s) / 2;
		if (array[m] == p)
			return getEnd(m+1, e, array, p);
		else
			return getEnd(s, m-1, array, p);
	}

}
