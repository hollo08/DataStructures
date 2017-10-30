package stackAndQueues;

import java.util.Stack;

public class MaxHistogramArea {

	public static void main(String[] args) {
		MaxHistogramArea obj = new MaxHistogramArea();
		System.out.println(obj.maxArea(new int[] { 3,4,2,4,5}));
	}

	private int maxArea(int[] histogram) {
		int area, max_area, top, i;
		area = 0;
		max_area = 0;
		i = 0;
		top = -1;
		Stack<Integer> histogram_stack = new Stack<Integer>();
		while (i < histogram.length) {
			if (histogram_stack.isEmpty()) {
				histogram_stack.push(i);
			} else {
				if (histogram[histogram_stack.peek()] >= histogram[i]) {
					while (!histogram_stack.isEmpty() && (histogram[histogram_stack.peek()] >= histogram[i])) {
						top = histogram_stack.pop();
						if (histogram_stack.isEmpty())
							area = histogram[top] * i;
						else
							area = histogram[top] * (i - 1 - histogram_stack.peek());
						if (area > max_area)
							max_area = area;
					}
				}
				histogram_stack.push(i);
			}
			i++;
		}
		while (!histogram_stack.isEmpty()) {
			top = histogram_stack.pop();
			if (histogram_stack.isEmpty())
				area = histogram[top] * i;
			else
				area = histogram[top] * (i - 1 - histogram_stack.peek());
			if (area > max_area)
				max_area = area;
		}
		return max_area;
	}

}
