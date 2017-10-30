package weeklyContest.WC_53;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StickerToSpell {

	public static void main(String[] args) {
		STS_Solution sol = new STS_Solution();
		String[] stickers = { "these", "guess", "about", "garden", "him" };
		String target = "atomher";
		System.out.println(sol.minStickers(stickers, target));
	}
}

class STS_Solution {
	public int minStickers(String[] stickers, String target) {
		if (target == null || target.length() == 0)
			return 0;
		if (!isPossible(stickers, target))
			return -1;
		Map<Character, Integer> targetDict = wordToMap(target.toCharArray());
		List<Map<Character, Integer>> stickersDict = new ArrayList<Map<Character, Integer>>();
		for (String sticker : stickers)
			stickersDict.add(wordToMap(sticker.toCharArray()));

		int remainigChars = getRemainingChars(targetDict);
		int no_of_stickers = 0;
		while (remainigChars > 0) {
			no_of_stickers++;
			int max = -1, max_index = -1;
			for (int i = 0; i < stickersDict.size(); i++) {
				Map<Character, Integer> stickerDict = stickersDict.get(i);
				int temp = getMaxReduce(stickerDict, targetDict);
				if (max < temp) {
					max = temp;
					max_index = i;
				}
			}
			targetDict = removeChars(stickersDict.get(max_index), targetDict);
			remainigChars = getRemainingChars(targetDict);
		}
		return no_of_stickers;
	}

	private Map<Character, Integer> removeChars(Map<Character, Integer> stickerDict,
			Map<Character, Integer> targetDict) {
		for (Character c : targetDict.keySet()) {
			if (stickerDict.containsKey(c)) {
				if (stickerDict.get(c) >= targetDict.get(c))
					targetDict.put(c, 0);
				else
					targetDict.put(c, targetDict.get(c) - stickerDict.get(c));
			}
		}
		return targetDict;
	}

	private int getMaxReduce(Map<Character, Integer> stickerDict, Map<Character, Integer> targetDict) {
		int no_of_chars_reduced = 0;
		for (Character c : targetDict.keySet()) {
			if (stickerDict.containsKey(c)) {
				if (stickerDict.get(c) >= targetDict.get(c))
					no_of_chars_reduced += targetDict.get(c);
				else
					no_of_chars_reduced += stickerDict.get(c);
			}
		}
		return no_of_chars_reduced;
	}

	private int getRemainingChars(Map<Character, Integer> targetDict) {
		int remainigChars = 0;
		for (Character c : targetDict.keySet())
			remainigChars += targetDict.get(c);
		return remainigChars;
	}

	private Map<Character, Integer> wordToMap(char[] word) {
		if (word == null || word.length == 0)
			return null;
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		for (char c : word)
			if (dict.containsKey(c))
				dict.put(c, dict.get(c) + 1);
			else
				dict.put(c, 1);
		return dict;
	}

	private boolean isPossible(String[] stickers, String target) {
		Set<Character> targetSet = new HashSet<Character>();
		for (char c : target.toCharArray()) {
			targetSet.add(c);
		}

		Set<Character> stickerSet = new HashSet<Character>();
		StringBuffer stickersStringBuffer = new StringBuffer();
		for (String sticker : stickers)
			stickersStringBuffer.append(sticker);
		for (char c : stickersStringBuffer.toString().toCharArray()) {
			stickerSet.add(c);
		}

		for (char c : targetSet)
			if (!stickerSet.contains(c))
				return false;

		return true;
	}
}
