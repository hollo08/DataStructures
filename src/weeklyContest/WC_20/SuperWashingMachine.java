package weeklyContest.WC_20;

public class SuperWashingMachine {

	public static void main(String[] args) {
		SuperWashingMachine swm = new SuperWashingMachine();
		int[] machines = { 1, 0, 5 };
		int res = swm.findMinMoves(machines);
		System.out.println(res);
	}

	public int findMinMoves(int[] machine) {
		int len = machine.length;
		int[] left = new int[len];
		int[] right = new int[len];
		int count = 0;
		for (int i = 0; i < len; i++) {
			int cloths = machine[i];
			left[i] = count;
			count += cloths;
		}

		for (int i = len - 2; i >= 0; i--) {
			right[i] = right[i + 1] + machine[i + 1];
		}
		if (count % len != 0)
			return -1;
		else {
			int moves = 0;
			int avg = count / len;
			for (int i = 0; i < len; i++) {
				int left_cloths = i * avg - left[i];
				int right_cloths = (len - i - 1) * avg - right[i];
				if (left_cloths > 0 && right_cloths > 0)
					moves = Math.max(moves, Math.abs(left_cloths) + Math.abs(right_cloths));
				else
					moves = Math.max(moves, Math.max(Math.abs(left_cloths), Math.abs(right_cloths)));
			}
			return moves;
		}
	}
}
