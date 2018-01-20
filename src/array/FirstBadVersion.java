package array;

public class FirstBadVersion {

	public static void main(String[] args) {
		FirstBadVersion firstBadVersion = new FirstBadVersion();
		System.out.println(firstBadVersion.firstBadVersion(100));
	}

	public int firstBadVersion(int n) {
		int start = 1;
		int end = n;
		while (start <= end) {
			if (isBadVersion(start))
				return start;
			else {
				int m = start + (end - start) / 2;
				if (isBadVersion(m))
					end = m;
				else
					start = m + 1;
			}
		}
		return 0;
	}

	public boolean isBadVersion(int n) {
		if (n >= 0)
			return true;
		return false;
	}
}