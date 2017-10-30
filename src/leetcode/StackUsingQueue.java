package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pull());
		System.out.println(stack.pull());
		System.out.println(stack.pull());
		System.out.println(stack.pull());
		System.out.println(stack.pull());
		System.out.println(stack.pull());
	}
}

class Stack<T> {
	Queue<T> stack = new LinkedList<T>();

	public Boolean isEmpty() {
		return stack.isEmpty();
	}

	public int size() {
		return stack.size();
	}

	public void push(T element) {
		int size = size();
		stack.add(element);
		while (size > 0) {
			T temp = stack.poll();
			stack.add(temp);
			size--;
		}
	}

	public T pull() {
		if (size() == 0)
			return null;
		else
			return stack.poll();
	}
}