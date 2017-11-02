package treesDataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TreeAlgorithms {

	public static void main(String[] args) {
		TreeAlgorithms treeAlgorithms = new TreeAlgorithms();
		ConstructTree constructTree = new ConstructTree();
		TreeNode root = constructTree.constructTree();
		/*
		 * Root to leaf Sum in Binary Tree
		 */
		// System.out.println(treeAlgorithms.rootToLeafSum(root, 45));// Correct
		// Implementation

		/*
		 * Is Binary Tree a Binary Search Tre
		 */
		// System.out.println(treeAlgorithms.isBinaryTree(root,
		// Integer.MIN_VALUE, Integer.MAX_VALUE));//Correct Implementations

		/*
		 * Reverse Level Order Traversal
		 */
		// treeAlgorithms.reverseLevelOrder(root);

		/*
		 * Level by level printing of Binary Tree
		 */

		// treeAlgorithms.levelByLevelPrinting(root);

		/*
		 * Spiral Order printing of Binary Tree
		 */

		// treeAlgorithms.spiralOrderPrinting(root);

		/*
		 * Lowest Common Ancestor
		 */

		// System.out.println(treeAlgorithms.commonAncestor(root, 3, 19).val);

		/*
		 * Largest BST in Binary Tree
		 */
		// System.out.println(treeAlgorithms.largestBSTInBinaryTree(root)[1]);

		/*
		 * Prints the left view of the tree
		 */
		// List<Integer> rightView = new ArrayList<Integer>();
		// treeAlgorithms.leftView(root, 1, 0, rightView);
		// System.out.println(rightView);

		/*
		 * Delete a node
		 */
		/*
		 * treeAlgorithms.deleteNode(root, 10); treeAlgorithms.deleteNode(root,
		 * 15); treeAlgorithms.deleteNode(root, 19);
		 * treeAlgorithms.deleteNode(root, 21); treeAlgorithms.deleteNode(root,
		 * 3); treeAlgorithms.deleteNode(root, 7);
		 * treeAlgorithms.deleteNode(root, 1); treeAlgorithms.deleteNode(root,
		 * 5); treeAlgorithms.deleteNode(root, 13);
		 * treeAlgorithms.deleteNode(root, 12);
		 */

		/*
		 * Most Frequent Subtree Sum
		 */
		/*
		 * int[] frequentSum = treeAlgorithms.findFrequentTreeSum(root); for
		 * (int i : frequentSum) { System.out.println(i); }
		 */

		/*
		 * House Robber III
		 */
		// System.out.println(treeAlgorithms.rob(root));

		/*
		 * AVLTree avl_root = treeAlgorithms.AVLTree(new
		 * ArrayList<Integer>(Arrays.asList(10, 5, 15, -10, -20, 20, 30, -30)));
		 */

		/*
		 * Redundant Connection II
		 */

		int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };

		int[] redundentEdge = treeAlgorithms.findRedundantDirectedConnection(edges);
		System.out.println(redundentEdge[0] + " " + redundentEdge[1]);

		/*
		 * Cycle Detection
		 */

		// Map<Integer, List<Integer>> cycleIndex =
		// treeAlgorithms.getEdgeMap(edges);
		// System.out.println(cycleIndex);

	}

	public int[] findRedundantDirectedConnection(int[][] edges) {
		if (edges == null)
			return new int[0];
		Map<Integer, List<Integer>> childParentMap = new HashMap<Integer, List<Integer>>();
		Integer twoParentChild = null;

		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			int child = edge[1];
			if (childParentMap.containsKey(child)) {
				twoParentChild = child;
				childParentMap.get(child).add(edge[0]);
			} else {
				List<Integer> childIndex = new ArrayList<Integer>();
				childIndex.add(edge[0]);
				childParentMap.put(child, childIndex);
			}
		}

		Map<Integer, List<Integer>> edgeMap = getEdgeMap(edges);
		if (twoParentChild == null) {
			int count = 0;
			int currentChild = edges[edges.length - 1][0];
			boolean foundLoop = false;
			while (count < edges.length) {
				List<Integer> parents = edgeMap.get(currentChild);
				if (parents == null || parents.size() == 0) {
					break;
				} else if (parents.size() == 2) {
					foundLoop = true;
					break;
				} else if (parents.size() == 1) {
					currentChild = parents.get(0);
					if (currentChild == edges[edges.length - 1][1]) {
						foundLoop = true;
						break;
					}
				}
				count++;
			}
			if (foundLoop)
				return edges[edges.length - 1];
			else
				return edges[edges.length - 2];
		} else {
			int parent1 = childParentMap.get(twoParentChild).get(0);
			int parent2 = childParentMap.get(twoParentChild).get(1);
			int count = 0;
			boolean foundLoop = false;
			int currentChild = parent1;
			while (count < edges.length) {
				List<Integer> parents = edgeMap.get(currentChild);
				if (parents == null || parents.size() == 0) {
					break;
				} else if (parents.size() == 2) {
					foundLoop = true;
					break;
				} else if (parents.size() == 1) {
					currentChild = parents.get(0);
					if (currentChild == edges[edges.length - 1][1]) {
						foundLoop = true;
						break;
					}
				}
				count++;
			}
			if (!foundLoop) {
				return new int[] { parent2, twoParentChild };
			} else {
				return new int[] { parent1, twoParentChild };
			}
		}
	}

	public Map<Integer, List<Integer>> getEdgeMap(int[][] edges) {
		Map<Integer, List<Integer>> edgesMap = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			if (!edgesMap.containsKey(edge[1]))
				edgesMap.put(edge[1], new ArrayList<Integer>());
			edgesMap.get(edge[1]).add(edge[0]);
		}
		return edgesMap;
	}

	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		int[] maxRobValue = robHouse(root);
		return Math.max(maxRobValue[0], maxRobValue[1]);
	}

	public int[] robHouse(TreeNode node) {
		int[] returnValue;
		if (node.left == null && node.right == null) {
			returnValue = new int[] { 0, node.val };
			return returnValue;
		} else if (node.left == null && node.right != null) {
			int[] rightChildMaxValues = robHouse(node.right);
			returnValue = new int[] { Math.max(rightChildMaxValues[0], rightChildMaxValues[1]),
					node.val + rightChildMaxValues[0] };
			return returnValue;
		} else if (node.left != null && node.right == null) {
			int[] leftChildMaxValues = robHouse(node.left);
			returnValue = new int[] { Math.max(leftChildMaxValues[0], leftChildMaxValues[1]),
					node.val + leftChildMaxValues[0] };
			return returnValue;
		} else {
			int[] leftChildMaxValues = robHouse(node.left);
			int[] rightChildMaxValues = robHouse(node.right);
			returnValue = new int[] {
					Math.max(leftChildMaxValues[0], leftChildMaxValues[1])
							+ Math.max(rightChildMaxValues[0], rightChildMaxValues[1]),
					node.val + leftChildMaxValues[0] + rightChildMaxValues[0] };
			return returnValue;
		}
	}

	public int[] findFrequentTreeSum(TreeNode root) {
		List<Integer> frequentSum = new ArrayList<Integer>();
		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		findTreeSum(root, sumMap, 0);
		int max = Integer.MIN_VALUE;
		for (int key : sumMap.keySet()) {
			if (max < sumMap.get(key))
				max = sumMap.get(key);
		}
		for (int key : sumMap.keySet()) {
			if (sumMap.get(key) == max) {
				frequentSum.add(key);
			}
		}
		int[] returnValues = new int[frequentSum.size()];
		int index = 0;
		for (Integer val : frequentSum) {
			returnValues[index++] = val;
		}
		return returnValues;
	}

	public int findTreeSum(TreeNode node, Map<Integer, Integer> sumMap, int sum) {
		Integer leftSum = null;
		Integer rightSum = null;
		if (node.left != null)
			leftSum = findTreeSum(node.left, sumMap, sum);
		if (node.right != null)
			rightSum = findTreeSum(node.right, sumMap, sum);
		int presentSum = leftSum == null ? (rightSum == null ? node.val : node.val + rightSum)
				: (rightSum == null ? node.val + leftSum : node.val + leftSum + rightSum);

		if (sumMap.containsKey(presentSum)) {
			sumMap.put(presentSum, sumMap.get(presentSum) + 1);
		} else {
			sumMap.put(presentSum, 1);
		}

		return presentSum;
	}

	public int leftView(TreeNode node, int level, int printed_depth, List<Integer> rightView) {
		if (node == null)
			return printed_depth;
		if (level > printed_depth) {
			rightView.add(node.val);
			printed_depth++;
		}
		printed_depth = leftView(node.right, level + 1, printed_depth, rightView);
		printed_depth = leftView(node.left, level + 1, printed_depth, rightView);
		return printed_depth;
	}

	public boolean rootToLeafSum(TreeNode node, int value) {
		if (node.left == null && node.right == null)
			if (node.val == value)
				return true;
			else
				return false;
		else {
			if (node.left != null && node.right != null)
				return (rootToLeafSum(node.left, value - node.val) || rootToLeafSum(node.right, value - node.val));
			else if (node.left != null && node.right == null)
				return rootToLeafSum(node.left, value - node.val);
			else
				return rootToLeafSum(node.right, value - node.val);
		}
	}

	public boolean isBinaryTree(TreeNode node, int lower, int upper) {
		if (node != null) {
			if (lower <= node.val && node.val <= upper) {
				return (isBinaryTree(node.left, lower, node.val) && isBinaryTree(node.right, node.val, upper));
			} else
				return false;
		} else
			return true;
	}

	public void reverseLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.remove();
			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
			stack.push(current);
		}
		while (!stack.isEmpty())
			System.out.println(stack.pop().val);
	}

	public void levelByLevelPrinting(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int levelCounter = 1, currentCounter;
		queue.add(root);
		while (!queue.isEmpty()) {
			currentCounter = levelCounter;
			levelCounter = 0;
			while (currentCounter > 0) {
				TreeNode current = queue.remove();
				if (current.left != null) {
					queue.add(current.left);
					levelCounter++;
				}
				if (current.right != null) {
					queue.add(current.right);
					levelCounter++;
				}
				System.out.print(current.val + ", ");
				currentCounter--;
			}
			System.out.println();
		}
	}

	public void spiralOrderPrinting(TreeNode root) {
		// Technique 1: Two Stacks
		Stack<TreeNode> r2l = new Stack<TreeNode>();
		Stack<TreeNode> l2r = new Stack<TreeNode>();
		r2l.push(root);
		while (!r2l.isEmpty() || !l2r.isEmpty()) {
			if (!r2l.isEmpty()) {
				while (!r2l.isEmpty()) {
					TreeNode current = r2l.pop();
					if (current.left != null)
						l2r.push(current.left);
					if (current.right != null)
						l2r.push(current.right);
					System.out.println(current.val);
				}
			} else {
				while (!l2r.isEmpty()) {
					TreeNode current = l2r.pop();
					if (current.right != null)
						r2l.push(current.right);
					if (current.left != null)
						r2l.push(current.left);
					System.out.println(current.val);
				}
			}
		}
	}

	public TreeNode commonAncestor(TreeNode node, int node1, int node2) {
		if (node == null)
			return null;
		else {
			if (node.val == node1 || node.val == node2)
				return node;
			else {
				TreeNode left = null, right = null;
				if (node.left != null && node.right == null) {
					left = commonAncestor(node.left, node1, node2);
					return left;
				} else if (node.right != null && node.left == null) {
					right = commonAncestor(node.right, node1, node2);
					return right;
				} else {
					right = commonAncestor(node.right, node1, node2);
					left = commonAncestor(node.left, node1, node2);
					if (left != null && right != null)
						return node;
					else if (left != null && right == null)
						return left;
					else if (left == null && right != null)
						return right;
					else
						return null;
				}

			}
		}
	}

	public void deleteNode(TreeNode root, int value) {
		if (root != null) {
			TreeNode parent = null;
			TreeNode node = root;
			boolean found = false;
			while (node != null) {
				if (node.val == value) {
					found = true;
					break;
				} else if (node.val > value) {
					parent = node;
					node = node.left;
				} else {
					parent = node;
					node = node.right;
				}
			}
			if (!found)
				return;
			TreeNode[] temp = getSucessor(node);
			TreeNode sucessor = temp[1];
			TreeNode sucessorParent = temp[0];
			if (sucessor == null) {
				if (parent == null) {
					parent = node;
					root = node.left;
				} else if (parent.val < node.val) {
					parent.right = node.left;
				} else {
					parent.left = null;
				}
				node = null;
			} else {
				int temp2 = node.val;
				node.val = sucessor.val;
				sucessor.val = temp2;
				if (sucessorParent == node) {
					sucessorParent.right = sucessor.right;
				} else {
					sucessorParent.left = sucessor.right;
				}
				sucessor = null;
			}
		}
	}

	public TreeNode[] getSucessor(TreeNode node) {
		TreeNode[] returnObj;
		if (node == null) {
			returnObj = new TreeNode[] { null, null };
			return returnObj;
		} else if (node.right == null) {
			returnObj = new TreeNode[] { null, null };
			return returnObj;
		}
		TreeNode sucessorParent = node;
		TreeNode sucessor = node.right;
		while (sucessor.left != null) {
			sucessorParent = sucessor;
			sucessor = sucessor.left;
		}
		returnObj = new TreeNode[] { sucessorParent, sucessor };
		return returnObj;
	}

	public Object[] largestBSTInBinaryTree(TreeNode node) {
		if (node.left == null && node.right == null)
			return new Object[] { true, 1, node.val, node.val };
		else {
			Object[] left_child_status = null;
			Object[] right_child_status = null;
			Integer left_best = null, left_small = null, left_big = null, right_best = null, right_small = null,
					right_big = null;
			if (node.left != null) {
				left_child_status = largestBSTInBinaryTree(node.left);
				left_best = (int) left_child_status[1];
				left_small = (int) left_child_status[2];
				left_big = (int) left_child_status[3];
			}
			if (node.right != null) {
				right_child_status = largestBSTInBinaryTree(node.right);
				right_best = (int) right_child_status[1];
				right_small = (int) right_child_status[2];
				right_big = (int) right_child_status[3];
			}
			if (left_child_status == null) {
				if (node.val < (int) right_small)
					return new Object[] { true, right_best + 1, node.val, right_big };
				else
					return new Object[] { false, right_best, right_small, right_big };
			} else if (right_child_status == null) {
				if (node.val > (int) left_small)
					return new Object[] { true, left_best + 1, left_small, node.val };
				else
					return new Object[] { false, left_best, left_small, left_big };
			}
			if ((boolean) left_child_status[0] == false && (boolean) right_child_status[0] == false) {
				return left_best > right_best ? new Object[] { false, left_best, left_small, left_big }
						: new Object[] { false, right_best, right_small, right_big };
			} else if ((boolean) left_child_status[0] == false && (boolean) right_child_status[0] == true) {
				return new Object[] { false, right_best, right_small, right_big };
			} else if ((boolean) left_child_status[0] == true && (boolean) right_child_status[0] == false) {
				return new Object[] { false, left_best, left_small, left_big };
			} else {
				if (node.val >= left_big && node.val < right_big)
					return new Object[] { true, left_best + 1 + right_best, left_small, right_big };
				return left_best > right_best ? new Object[] { false, left_best, left_small, left_big }
						: new Object[] { false, right_best, right_small, right_big };
			}
		}
	}

	public AVLTree AVLTree(List<Integer> elements) {
		AVLTree root = null;
		for (int number : elements)
			root = insertToAVLTree(root, number);
		return balancedAVLTree(root);
	}

	public AVLTree insertToAVLTree(AVLTree root, int element) {
		if (root != null) {
			AVLTree temp1 = null, newNode = new AVLTree(element), temp2 = root;
			while (temp2 != null) {
				temp1 = temp2;
				if (temp1.data >= newNode.data) {
					temp2.left_height++;
					temp2 = temp1.left;
				} else {
					temp2.right_height++;
					temp2 = temp1.right;
				}
				;
			}
			if (temp1.data >= newNode.data)
				temp1.left = newNode;
			else
				temp1.right = newNode;
		} else
			root = new AVLTree(element);
		return root;
	}

	public AVLTree balancedAVLTree(AVLTree root) {
		AVLTree unBalancedNode = getUnbalancedNode(root);
		while (unBalancedNode != null) {
			AVLTree parent_node = getParentNode(root, unBalancedNode);
			switch (determineCase(unBalancedNode)) {
			case 0:
				rightRotate(unBalancedNode, parent_node);
				break;
			case 1:
				leftRotate(unBalancedNode.left, unBalancedNode);
				rightRotate(unBalancedNode, parent_node);
				break;
			case 2:
				rightRotate(unBalancedNode.right, unBalancedNode);
				leftRotate(unBalancedNode, parent_node);
				break;
			case 3:
				leftRotate(unBalancedNode, parent_node);
				break;
			}
			unBalancedNode = getUnbalancedNode(root);
		}
		return root;
	}

	public void rightRotate(AVLTree unBalancedNode, AVLTree parent_node) {
		AVLTree temp = unBalancedNode;
		parent_node.left = unBalancedNode.left;
		unBalancedNode.left = unBalancedNode.left.right;
		parent_node.left.right = temp;
	}

	public void leftRotate(AVLTree unBalancedNode, AVLTree parent_node) {
		AVLTree temp = unBalancedNode;
		parent_node.right = unBalancedNode.right;
		unBalancedNode.right = unBalancedNode.right.left;
		parent_node.right.left = temp;
	}

	public AVLTree getParentNode(AVLTree root, AVLTree childNode) {
		AVLTree temp1 = null, temp2 = root;
		while (temp2 != childNode) {
			temp1 = temp2;
			temp2 = temp2.data > childNode.data ? temp2.left : temp2.right;
		}
		return temp1;
	}

	public int determineCase(AVLTree unbalancedNode) {
		if (unbalancedNode.left_height > unbalancedNode.right_height) {
			if (unbalancedNode.left.left_height > unbalancedNode.left.right_height)
				return 0;
			return 1;
		} else {
			if (unbalancedNode.right.left_height > unbalancedNode.right.right_height)
				return 2;
			return 3;
		}
	}

	public AVLTree getUnbalancedNode(AVLTree node) {
		if (node != null) {
			if (Math.abs(node.left_height - node.right_height) > 1)
				return node;
			else {
				AVLTree left = getUnbalancedNode(node.left);
				if (left == null)
					return left;
				else {
					return getUnbalancedNode(node.right);
				}
			}
		} else
			return null;
	}
}

/*
 * TreeNode Structure
 * 
 * 10 / \ 5 15 / / \ 1 13 19 \ / \ 3 12 21
 */

class ConstructTree {
	public TreeNode constructTree() {
		TreeNode root = new TreeNode(10);

		root.left = new TreeNode(5);
		root.right = new TreeNode(15);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(19);

		root.left.left.right = new TreeNode(3);
		root.right.left.left = new TreeNode(12);
		root.right.right.right = new TreeNode(21);

		return root;
	}
}

class TreeNode {
	Integer val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
		this.right = null;
		this.left = null;
	}

	@Override
	public String toString() {
		return val.toString();
	}
}

class AVLTree {
	public int data;
	public AVLTree right;
	public AVLTree left;
	public int left_height;
	public int right_height;

	public AVLTree(int data) {
		this.data = data;
		this.right = null;
		this.left = null;
		this.left_height = 0;
		this.right_height = 0;
	}
}