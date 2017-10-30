package prefixAndSufix;

public class PatternMatchingKNPAlgorithm {

	public static void main(String[] args) {
		PatternMatchingKNPAlgorithm patternMatching = new PatternMatchingKNPAlgorithm();
		String text = "abcxabcdabxabcdabcdabcy";
		String pattern = "abcdabcy";
		int[] prefixArray = (new PrefixArray()).getPrefixArray(pattern.toCharArray());
		System.out.println(patternMatching.isPatternMatching(text.toCharArray(), pattern.toCharArray(), prefixArray));
	}

	boolean isPatternMatching(char[] text, char[] pattern, int[] prefixArray) {
		boolean matched = false;
		int i = 0, j = 0;
		while (true) {
			while (i < text.length && j < pattern.length && text[i] == pattern[j]) {
				i++;
				j++;
			}
			if (j == pattern.length) {
				matched = true;
				break;
			} else if (i == text.length) {
				matched = false;
				break;
			}
			if (j != 0)
				j = prefixArray[j - 1];
			else
				i++;
		}
		return matched;
	}

}
