package weeklyContest.WC_18A;

import java.util.ArrayList;
import java.util.List;

public class FindMaximizedCapital {

	public static void main(String[] args) {
		FindMaximizedCapital fmc = new FindMaximizedCapital();
		int[] profits = { 1, 2, 3 };
		int[] capital = { 11, 12, 13 };
		int res = fmc.findMaximizedCapital(11, 11, profits, capital);
		System.out.println(res);
	}

	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		List<Integer> profits = new ArrayList<Integer>();
		List<Integer> capital = new ArrayList<Integer>();
		for (int p : Profits)
			profits.add(p);
		for (int c : Capital)
			capital.add(c);
		while (k > 0 && capital.size() > 0) {
			int max_capital = Integer.MIN_VALUE;
			int next_i = -1;
			for (int i = 0; i < capital.size(); i++) {
				int c = capital.get(i);
				if (c <= W && max_capital < profits.get(i)) {
					next_i = i;
				}
			}
			if (next_i == -1)
				break;
			W = W + profits.get(next_i);
			capital.remove(next_i);
			profits.remove(next_i);
			k--;
		}
		return W;
	}
}
