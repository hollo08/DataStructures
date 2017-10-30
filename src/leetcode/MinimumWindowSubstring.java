package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MWS("cabwefgewcwaefcf", "cae");
	}

	static void MWS(String source, String target) {
		Map<Character, Integer> needToFind = new HashMap<Character, Integer>();
		int begin = -1, end = -1, count = 0, min = Integer.MAX_VALUE;
		for (char c : target.toCharArray()) {
			if (needToFind.containsKey(c))
				needToFind.put(c, needToFind.get(c) + 1);
			else
				needToFind.put(c, 1);
		}

		Map<Character, Integer> hasFound = new HashMap<Character, Integer>();
		char[] charArr = source.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			char c = charArr[i];
			if (needToFind.containsKey(c)) {
				if (begin == -1)
					begin = i;
				if (hasFound.containsKey(c)) {
					hasFound.put(c, hasFound.get(c) + 1);
					if (needToFind.get(c) >= hasFound.get(c)) {
						count++;
					}
				} else {
					hasFound.put(c, 1);
					count++;
				}
				while (hasFound.get(charArr[begin]) > needToFind.get(charArr[begin])) {
					hasFound.put(charArr[begin], hasFound.get(charArr[begin]) - 1);
					for (int j = begin + 1; j <= end; j++) {
						if (needToFind.containsKey(charArr[j])) {
							begin = j;
							break;
						}
					}
				}
				if (count == target.length()) {
					end = i;
					if (min > (end - begin + 1))
						min = end - begin + 1;
				}
			}
		}
		System.out.println(begin + " - " + end);
	}

}