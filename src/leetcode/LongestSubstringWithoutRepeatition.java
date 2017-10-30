package leetcode;

public class LongestSubstringWithoutRepeatition {

	public static void main(String[] args) {
		LSWR("abcdddefeghi");
	}

	static void LSWR(String word) {
		boolean[] charArr = new boolean[256];
		int start = 0, end = 0, result = 0;
		char[] wordArr = word.toCharArray();
		for (int i = 0; i < wordArr.length; i++) {
			if (charArr[wordArr[i]]) {
				for (int j = start; j < i; j++)
					if (wordArr[j] == wordArr[i]) {
						start = j + 1;
					}
			} else {
				charArr[wordArr[i]] = true;
				end = i;
			}
			result = Math.max(result, end - start + 1);
		}
		System.out.println(result);
	}

}
