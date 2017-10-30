package stackAndQueues;

public class ThreeStackInArray {

	int[] stack_index = new int[] { -100, -1, -1, -1 };
	int present_index = 0;
	Stack[] buffer = new Stack[100];

	public static void main(String[] args) {
		ThreeStackInArray stack = new ThreeStackInArray();
		stack.push(11, 1);
		stack.push(21, 2);
		stack.push(31, 3);
		stack.push(12, 1);
		stack.push(13, 1);
		stack.push(22, 2);
		stack.push(23, 2);
		stack.push(32, 3);
		stack.push(33, 3);
		stack.push(24, 2);
		stack.push(14, 1);
		stack.push(34, 3);
		System.out.println(stack.pop(1) + " " + stack.pop(1) + " " + stack.pop(1) + " " + stack.pop(1));
		stack.push(11, 1);
		stack.push(25, 2);
		stack.push(35, 3);
		stack.push(12, 1);
	}

	public void push(int value, int stack_number) {
		Stack stack = new Stack(value, stack_index[stack_number]);
		stack_index[stack_number] = present_index;
		buffer[present_index++] = stack;
	}

	int pop(int stackNum) {
		int value = buffer[stack_index[stackNum]].value;
		int lastIndex = stack_index[stackNum];
		stack_index[stackNum] = buffer[stack_index[stackNum]].previous_index;
		buffer[lastIndex] = null;
		present_index--;
		return value;
		}
}

class Stack {
	int value;
	int previous_index;

	public Stack(int value, int previous_index) {
		this.value = value;
		this.previous_index = previous_index;
	}
}