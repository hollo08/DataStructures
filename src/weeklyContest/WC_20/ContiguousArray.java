package weeklyContest.WC_20;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	public static void main(String[] args) {
		ContiguousArray ca = new ContiguousArray();
		int[] nums = { 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1,
				0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0,
				1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1 };
		int res = ca.findMaxLength(nums);
		System.out.println(res);
	}

	public int findMaxLength(int[] nums) {
		Map<Integer, Integer> balance = new HashMap<Integer, Integer>();
		int len = nums.length;
		for (int index = 0; index < len; index++)
			nums[index] = nums[index] == 0 ? -1 : 1;
		int count = 0;
		balance.put(count, -1);
		int max = 0;
		int index = 0;
		while (index < len) {
			count = count + nums[index];
			if (balance.containsKey(count)) {
				max = Math.max(max, index - balance.get(count));
			} else {
				balance.put(count, index);
			}
			index++;
		}
		return max;
	}
}
