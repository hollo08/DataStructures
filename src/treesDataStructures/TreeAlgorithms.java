package treesDataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeAlgorithms {

	public static void main(String[] args) {
		TreeAlgorithms treeAlgorithms = new TreeAlgorithms();
		ConstructTree constructTree = new ConstructTree();
		Tree root = constructTree.constructTree();
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

		// System.out.println(treeAlgorithms.commonAncestor(root, 3, 19).data);

		/*
		 * Largest BST in Binary Tree
		 */
		// System.out.println(treeAlgorithms.largestBSTInBinaryTree(root)[1]);

		/*
		 * Prints the left view of the tree
		 */
		List<Integer> rightView = new ArrayList<Integer>();
        treeAlgorithms.leftView(root, 1, 0, rightView);
        System.out.println(rightView);

		/*
		 * AVLTree avl_root = treeAlgorithms .AVLTree(new
		 * ArrayList<Integer>(Arrays.asList(10, 5, 15, -10, -20, 20, 30, -30)));
		 */

	}

	public int leftView(Tree node, int level, int printed_depth, List<Integer> rightView) {
		if (node == null)
			return printed_depth;
		if (level > printed_depth) {
            rightView.add(node.data);
			printed_depth++;
		}
		printed_depth = leftView(node.right, level+1, printed_depth, rightView);
		printed_depth = leftView(node.left, level+1, printed_depth, rightView);
		return printed_depth;
	}

	public boolean rootToLeafSum(Tree node, int value) {
		if (node.left == null && node.right == null)
			if (node.data == value)
				return true;
			else
				return false;
		else {
			if (node.left != null && node.right != null)
				return (rootToLeafSum(node.left, value - node.data) || rootToLeafSum(node.right, value - node.data));
			else if (node.left != null && node.right == null)
				return rootToLeafSum(node.left, value - node.data);
			else
				return rootToLeafSum(node.right, value - node.data);
		}
	}

	public boolean isBinaryTree(Tree node, int lower, int upper) {
		if (node != null) {
			if (lower <= node.data && node.data <= upper) {
				return (isBinaryTree(node.left, lower, node.data) && isBinaryTree(node.right, node.data, upper));
			} else
				return false;
		} else
			return true;
	}

	public void reverseLevelOrder(Tree root) {
		Queue<Tree> queue = new LinkedList<Tree>();
		Stack<Tree> stack = new Stack<Tree>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Tree current = queue.remove();
			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
			stack.push(current);
		}
		while (!stack.isEmpty())
			System.out.println(stack.pop().data);
	}

	public void levelByLevelPrinting(Tree root) {
		Queue<Tree> queue = new LinkedList<Tree>();
		int levelCounter = 1, currentCounter;
		queue.add(root);
		while (!queue.isEmpty()) {
			currentCounter = levelCounter;
			levelCounter = 0;
			while (currentCounter > 0) {
				Tree current = queue.remove();
				if (current.left != null) {
					queue.add(current.left);
					levelCounter++;
				}
				if (current.right != null) {
					queue.add(current.right);
					levelCounter++;
				}
				System.out.print(current.data + ", ");
				currentCounter--;
			}
			System.out.println();
		}
	}

	public void spiralOrderPrinting(Tree root) {
		// Technique 1: Two Stacks
		Stack<Tree> r2l = new Stack<Tree>();
		Stack<Tree> l2r = new Stack<Tree>();
		r2l.push(root);
		while (!r2l.isEmpty() || !l2r.isEmpty()) {
			if (!r2l.isEmpty()) {
				while (!r2l.isEmpty()) {
					Tree current = r2l.pop();
					if (current.left != null)
						l2r.push(current.left);
					if (current.right != null)
						l2r.push(current.right);
					System.out.println(current.data);
				}
			} else {
				while (!l2r.isEmpty()) {
					Tree current = l2r.pop();
					if (current.right != null)
						r2l.push(current.right);
					if (current.left != null)
						r2l.push(current.left);
					System.out.println(current.data);
				}
			}
		}
	}

	public Tree commonAncestor(Tree node, int node1, int node2) {
		if (node == null)
			return null;
		else {
			if (node.data == node1 || node.data == node2)
				return node;
			else {
				Tree left = null, right = null;
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

	public Object[] largestBSTInBinaryTree(Tree node) {
		if (node.left == null && node.right == null)
			return new Object[] { true, 1, node.data, node.data };
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
				if (node.data < (int) right_small)
					return new Object[] { true, right_best + 1, node.data, right_big };
				else
					return new Object[] { false, right_best, right_small, right_big };
			} else if (right_child_status == null) {
				if (node.data > (int) left_small)
					return new Object[] { true, left_best + 1, left_small, node.data };
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
				if (node.data >= left_big && node.data < right_big)
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
 * Tree Structure
 * 
 * 10 / \ 5 15 / / \ 1 13 19 \ / \ 3 12 21
 */

class ConstructTree {
	public Tree constructTree() {
		Tree root = new Tree(10);

		root.left = new Tree(5);
		root.right = new Tree(15);

		root.left.left = new Tree(1);

		root.right.left = new Tree(13);
		root.right.right = new Tree(19);

		root.left.left.right = new Tree(3);

		root.right.left.left = new Tree(12);
		
		root.right.left.left.right = new Tree(7);
		
		root.right.right.right = new Tree(21);

		return root;
	}
}

class Tree {
	public int data;
	public Tree right;
	public Tree left;

	public Tree(int data) {
		this.data = data;
		this.right = null;
		this.left = null;
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