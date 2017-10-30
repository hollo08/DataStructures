package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BalancedString {

	public static void main(String[] args) {
		char[] str = "()(())".toCharArray();
		Deque<Character> stack = new ArrayDeque<Character>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		for (int i = 0; i < str.length;) {
			while (i < str.length && str[i] != ')')
				stack.push(str[i++]);
			int counter = 0;
			while (i < str.length && str[i] == ')') {
				if (stack.isEmpty()) {
					for (Integer val : map.values())
						if (max < val)
							max = val;
					map = new HashMap<Integer, Integer>();
				} else {
					counter += 2;
					if (map.containsKey(stack.size())) {
						counter += map.get(stack.size());
						map.remove(stack.size());
					}
					stack.pop();
				}
				if (map.containsKey(stack.size()))
					map.put(stack.size(), map.get(stack.size()) + counter);
				else
					map.put(stack.size(), counter);
				i++;
			}
		}
		System.out.println(map);
		for (Integer i : map.values())
			if (max < i)
				max = i;
		System.out.println(max);
	}

}
