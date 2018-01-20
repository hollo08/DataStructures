package weeklyContest.WC_66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BoldWordsInString {

	public static void main(String[] args) {
		BoldWordsInString bwis = new BoldWordsInString();
		String[] keywords = { "abc","123" };
		String S = "abcxyz123";
		String res = bwis.boldWords(keywords, S);
		System.out.println(res);
	}

	public String boldWords(String[] words, String S) {
		List<int[]> range = new ArrayList<int[]>();
		for (String word : words) {
			int offset = 0, start_index;
			do {
				start_index = S.indexOf(word, offset);
				int end_index = start_index + word.length();
				offset = end_index;
				if (start_index != -1) {
					int[] bold_word_index = { start_index, end_index };
					range.add(bold_word_index);
				}
			} while (start_index != -1);
		}
		Collections.sort(range, new ListComparator());
		int len = range.size();
		for (int i = 0; i < len - 1; i++) {
			if (range.get(i + 1)[0] <= range.get(i)[1] + 1) {
				range.get(i)[1] = Math.max(range.get(i + 1)[1], range.get(i)[1]);
				range.remove(i + 1);
				i--;
				len--;
			}
		}
		StringBuffer bold = new StringBuffer(S);
		for (int index = 0; index < range.size(); index++) {
			int[] interval = range.get(index);
			int offset = index * 7;
			bold.insert(interval[0] + offset, "<b>");
			bold.insert(interval[1] + offset + 3, "</b>");
		}
		return bold.toString();
	}
}

class ListComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		return o1[0] - o2[0];
	}
}