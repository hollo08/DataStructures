package weeklyContest.WC_18A;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentTreeSum {

	public static void main(String[] args) {
		MostFrequentTreeSum mfts = new MostFrequentTreeSum();
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(-3);
		root.left = left;
		root.right = right;
		int[] res = mfts.findFrequentTreeSum(root);
		System.out.println(res.length);
	}

	public int[] findFrequentTreeSum(TreeNode root) {
		if(root == null)
			return new int[0];
		Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		getChildSum(root,frequency);
		int max = Integer.MIN_VALUE;
		for(int key : frequency.keySet()){
			if(max < frequency.get(key))
				max = frequency.get(key);
		}

		int arr_size = 0;
		for(int key : frequency.keySet()){
			if(max == frequency.get(key))
				arr_size++;
		}
		int[] ret_list = new int[arr_size];
		int index = 0;
		for(int key : frequency.keySet()){
			if(max == frequency.get(key))
				ret_list[index++] = key;
		}
		return ret_list;
	}

	public int getChildSum(TreeNode node, Map<Integer, Integer> frequency) {
		int total_sum;
		if (node.left == null && node.right == null) {
			total_sum = node.val;
		} else if (node.left == null && node.right != null) {
			int right_child_sum = getChildSum(node.right, frequency);
			total_sum = right_child_sum + node.val;
		} else if (node.left != null && node.right == null) {
			int left_child_sum = getChildSum(node.left, frequency);
			total_sum = left_child_sum + node.val;
		} else {
			int right_child_sum = getChildSum(node.right, frequency);
			int left_child_sum = getChildSum(node.left, frequency);
			total_sum = right_child_sum + left_child_sum + node.val;
		}
		if (!frequency.containsKey(total_sum))
			frequency.put(total_sum, 0);
		frequency.put(total_sum, frequency.get(total_sum) + 1);
		return total_sum;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
