package stackAndQueues;

import java.util.Stack;

public class TowerOfHanoi {

	public static void main(String[] args) {
		TowerOfHanoi obj = new TowerOfHanoi();
		Stack<Integer> source = new Stack<Integer>();
		int no_of_plates = 28;
		while (no_of_plates > 0)
			source.push(no_of_plates--);
		Stack<Integer> temp = new Stack<Integer>();
		Stack<Integer> destination = new Stack<Integer>();
		obj.implementTOH(source, temp, destination, source.size());
	}

	public void implementTOH(Stack<Integer> source, Stack<Integer> temp, Stack<Integer> destination,
			int number_of_plates) {
		if (number_of_plates > 2) {
			implementTOH(source, destination, temp, number_of_plates - 1);
			destination.push(source.pop());
			implementTOH(temp, source, destination, number_of_plates - 1);
		} else {
			temp.push(source.pop());
			destination.push(source.pop());
			destination.push(temp.pop());
		}
	}
}
