package array;

public class KEmptySlots {

	public static void main(String[] args) {
		KEmptySlots kEmptySlots = new KEmptySlots();
		int[] flowers = { 6, 5, 8, 9, 7, 1, 10, 2, 3, 4 };
		System.out.println(kEmptySlots.kEmptySlots(flowers, 2));
	}

	public int kEmptySlots(int[] flowers, int k) {
		int[] bloom = new int[flowers.length];
		for (int i = 0; i < flowers.length; i++) {
			bloom[flowers[i] - 1] = i + 1;
		}
		int left = 0;
		int right = k + 1; // Slot of size k
		int res = Integer.MAX_VALUE;
		for (int i = 0; right < bloom.length; i++) {
			if (bloom[i] < bloom[left] || bloom[i] <= bloom[right]) {
				if (i == right) {
					res = Math.min(res, Math.max(bloom[left], bloom[right]));
				}
				left = i;
				right = k + 1 + i;
			}
		}
		return (res == Integer.MAX_VALUE) ? -1 : res;
	}
}