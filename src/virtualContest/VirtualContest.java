package virtualContest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class VirtualContest {

	public static void main(String[] args) {
		VirtualContest vc = new VirtualContest();
		int[] nums1 = { 2, 4 }, nums2 = { 6, 4, 8, 3, 7, 5, 9, 0 };
		/*
		 * int[][] ip = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, { 4, 5, 6, 7, 8, 9,
		 * 0, 1, 2, 3 }, { 7, 8, 9, 0, 1, 2, 3, 4, 5, 6 } };
		 */
		Integer[] ip = { 1, 2, 3, 4, 5, 6 };
		char[] letters = { 'c', 'f', 'g' };
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int n = 4;
		int k = 2;
		TreeNode root = vc.createTree();
		int sol = vc.findClosestLeaf(root, 2);
		System.out.println();
	}

	public int findClosestLeaf(TreeNode root, int k) {
		Integer[] ret = distanceToLeaf(root, k);
		return ret[3];
	}

	public TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node3.left = node4;
		node4.left = node5;
		return root;
	}

	// Return value contains min distance to leaf, min distance to target node,
	// best value for target node, best node for target node
	public Integer[] distanceToLeaf(TreeNode node, int k) {
		return null;
	}

	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> adjacencyMatrix = new HashMap<Integer, Map<Integer, Integer>>();
		for (int[] time : times) {
			if (!adjacencyMatrix.containsKey(time[0])) {
				adjacencyMatrix.put(time[0], new HashMap<Integer, Integer>());
			}
			adjacencyMatrix.get(time[0]).put(time[1], time[2]);
		}
		Map<Integer, Integer> min_distance = new HashMap<Integer, Integer>();
		Stack<Integer> to_be_visited = new Stack<Integer>();
		to_be_visited.push(K);
		min_distance.put(K, 0);
		while (!to_be_visited.isEmpty()) {
			int node = to_be_visited.pop();
			Map<Integer, Integer> neighbours = adjacencyMatrix.get(node);
			if (neighbours != null && neighbours.size() != 0) {
				for (Integer key : neighbours.keySet()) {
					if (!min_distance.containsKey(key)
							|| min_distance.get(key) > neighbours.get(key) + min_distance.get(node)) {
						min_distance.put(key, neighbours.get(key) + min_distance.get(node));
						to_be_visited.push(key);
					}
				}
			}
		}
		if (min_distance.size() < N)
			return -1;
		else {
			int max = Integer.MIN_VALUE;
			for (Integer key : min_distance.keySet())
				if (min_distance.get(key) > max)
					max = min_distance.get(key);
			return max;
		}
	}

	public char nextGreatestLetter(char[] letters, char target) {
		char sol = Character.MAX_VALUE;
		char min = Character.MAX_VALUE;
		for (char letter : letters) {
			if (letter < min)
				min = letter;
			if (letter > target && letter < sol)
				sol = letter;
		}
		return sol == Character.MAX_VALUE ? min : sol;
	}

	public int[] nextGreaterElement2(int[] nums2) {
		int[] dp = new int[nums2.length];
		Stack<Integer> stc = new Stack<Integer>();
		for (int i = 0; i < nums2.length; i++) {
			while (!stc.isEmpty() && nums2[stc.peek()] < nums2[i])
				dp[stc.pop()] = i;
			if (i != nums2.length - 1 && nums2[i] < nums2[i + 1]) {
				dp[i] = i + 1;
			} else {
				Stack<Integer> temp = new Stack<Integer>();
				while (!stc.isEmpty() && nums2[stc.peek()] < nums2[i])
					temp.push(stc.pop());
				stc.push(i);
				while (!temp.isEmpty())
					stc.push(temp.pop());
			}
		}
		for (int i = 0; i < nums2.length; i++) {
			while (!stc.isEmpty() && nums2[stc.peek()] < nums2[i]) {
				dp[stc.pop()] = i;
			}
		}
		while (!stc.isEmpty()) {
			dp[stc.pop()] = -1;
		}
		for (int i = 0; i < dp.length; i++)
			dp[i] = dp[i] == -1 ? -1 : nums2[dp[i]];
		return dp;
	}

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) {
			int[] empty_array = {};
			return empty_array;
		}
		int[] solution = new int[nums1.length];
		int[] dp = new int[nums2.length];
		dp[nums2.length - 1] = -1;
		for (int i = nums2.length - 2; i >= 0; i--) {
			int temp = i + 1;
			while (temp != -1) {
				if (nums2[temp] > nums2[i]) {
					dp[i] = temp;
					break;
				} else {
					temp = dp[temp];
				}
			}
			if (temp == -1)
				dp[i] = temp;
		}
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < nums2.length; i++) {
			map.put(nums2[i], i);
		}
		for (int i = 0; i < nums1.length; i++) {
			solution[i] = dp[map.get(nums1[i])] == -1 ? -1 : nums2[dp[map.get(nums1[i])]];
		}
		return solution;
	}

	public String[] findRelativeRanks(int[] nums) {
		String[] sol = new String[nums.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int index = map.get(nums[i]);
			switch (nums.length - i) {
			case 1:
				sol[index] = "Gold Medal";
				break;
			case 2:
				sol[index] = "Silver Medal";
				break;
			case 3:
				sol[index] = "Bronze Medal";
				break;
			default:
				sol[index] = Integer.toString(nums.length - i);
				break;
			}
		}
		return sol;
	}

	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			int[] sol = {};
			return sol;
		} else {
			int index = 1;
			int[] sol = new int[matrix.length * matrix[0].length];
			sol[0] = matrix[0][0];
			boolean clockwise = false;
			int rows = matrix.length, cols = matrix[0].length, start_i = 0, start_j = 1;
			if (start_j == cols) {
				start_i = 1;
				start_j = 0;
			}
			while (index < rows * cols) {
				int i = start_i, j = start_j;
				while (i < rows && j < cols && i >= 0 && j >= 0) {
					sol[index++] = matrix[i][j];
					if (clockwise) {
						i--;
						j++;
					} else {
						i++;
						j--;
					}
				}
				if (clockwise) {
					if (j != cols) {
						start_i = 0;
						start_j = j < cols ? j : cols - 1;
					} else {
						start_i = i + 2;
						start_j = cols - 1;
					}
				} else {
					if (i != rows) {
						start_j = 0;
						start_i = i < rows ? i : rows - 1;
					} else {
						start_j = j + 2;
						start_i = rows - 1;
					}
				}
				clockwise = !clockwise;
			}
			sol[rows * cols - 1] = matrix[rows - 1][cols - 1];
			return sol;
		}
	}
}

class TreeNode {
	Integer val;
	TreeNode left;
	TreeNode right;

	TreeNode(Integer x) {
		val = x;
	}

	@Override
	public String toString() {
		return val.toString();
	}
}