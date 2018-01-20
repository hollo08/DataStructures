package weeklyContest.WC_20;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement {

	public static void main(String[] args) {
		BeautifulArrangement ba = new BeautifulArrangement();
		int res = ba.countArrangement(4);
		System.out.println(res);
	}

	public int countArrangement(int N) {
		List<Integer> nums = new ArrayList<Integer>();
		int n = 1;
		while (n <= N)
			nums.add(n++);
		return getArrangement(nums, 0, 0);
	}

	public int getArrangement(List<Integer> available_numbers, int index, int count) {
		if (available_numbers == null || available_numbers.size() == 0)
			return count + 1;
		else {
			for (int i = 0; i < available_numbers.size(); i++) {
				int num = available_numbers.get(i);
				if ((index + 1) % num == 0 || num % (index + 1) == 0) {
					List<Integer> local = new ArrayList<>(available_numbers);
					local.remove(i);
					count = getArrangement(local, index + 1, count);
				}
			}
			return count;
		}
	}
}
