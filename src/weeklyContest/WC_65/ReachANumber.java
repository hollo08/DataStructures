package weeklyContest.WC_65;

public class ReachANumber {

	public static void main(String[] args) {
		ReachANumber ran = new ReachANumber();
		int res = ran.reachNumber(4);
		System.out.println(res);
	}

	public int reachNumber(int target) {
		if (target == 0)
			return 0;
		if (target < 0)
			target = 0 - target;
		int odd_reach_number = 1;
		int even_reach_number = 0;
		int change_count = 1;
		int count = 1;
		boolean target_even = target % 2 == 0;
		boolean increase_even = false;
		int running_counter = 1;
		while (true) {
			if ((target_even && even_reach_number >= target) || (!target_even && odd_reach_number >= target))
				break;
			count++;
			running_counter = running_counter + count;
			change_count++;
			if (increase_even) {
				if (change_count == 1) {
					even_reach_number = even_reach_number + running_counter;
					running_counter = count;
				} else
					even_reach_number = even_reach_number + count;
			} else {
				if (change_count == 1) {
					odd_reach_number = odd_reach_number + running_counter;
					running_counter = count;
				} else
					odd_reach_number = odd_reach_number + count;
			}
			if (change_count == 2) {
				increase_even = !increase_even;
				change_count = 0;
			}
		}
		return count;
	}
}
