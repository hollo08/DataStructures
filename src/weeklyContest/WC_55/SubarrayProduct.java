package weeklyContest.WC_55;

public class SubarrayProduct {
	public static void main(String[] args) {
		SubarrayProduct sap = new SubarrayProduct();
		int[] nums = { 10,5,2,6};
		int sol = sap.numSubarrayProductLessThanK(nums, 100);
		System.out.println(sol);
	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int prod = 1;
		int sol = 0;
		Integer start_index = 0;
		Integer running_index = 0;
		for (int num : nums) {
			if (prod * num < k) {
				running_index++;
				sol = sol + (running_index - start_index);
				prod *= num;
			} else {
				while (start_index != running_index && prod * num >= k) {
					prod /= nums[start_index++];
				}
				if (prod * num < k) {
					running_index++;
					sol = sol + (running_index - start_index);
					prod *= num;
				}
			}
		}
		return sol;
	}
}