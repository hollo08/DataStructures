package weeklyContest.WC_18A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardRow {

	public static void main(String[] args) {
		KeyboardRow kr = new KeyboardRow();
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		String[] same_row_words = kr.findWords(words);
		System.out.println(same_row_words.length);
	}

	public String[] findWords(String[] words) {
		Map<Character, Integer> char_row = new HashMap<Character, Integer>();
		char_row.put('Q', 1);
		char_row.put('W', 1);
		char_row.put('E', 1);
		char_row.put('R', 1);
		char_row.put('T', 1);
		char_row.put('Y', 1);
		char_row.put('U', 1);
		char_row.put('I', 1);
		char_row.put('O', 1);
		char_row.put('P', 1);
		char_row.put('A', 2);
		char_row.put('S', 2);
		char_row.put('D', 2);
		char_row.put('F', 2);
		char_row.put('G', 2);
		char_row.put('H', 2);
		char_row.put('J', 2);
		char_row.put('K', 2);
		char_row.put('L', 2);
		char_row.put('Z', 3);
		char_row.put('X', 3);
		char_row.put('C', 3);
		char_row.put('V', 3);
		char_row.put('B', 3);
		char_row.put('N', 3);
		char_row.put('M', 3);
		List<String> same_row_words = new ArrayList<String>();
		for (String word : words) {
			char[] word_chars = word.toUpperCase().toCharArray();
			int row = char_row.get(word_chars[0]);
			boolean same_row_word = true;
			for (int i = 1; i < word_chars.length; i++) {
				if(char_row.get(word_chars[i]) != row){
					same_row_word = false;
					break;
				}
			}
			if(same_row_word)
				same_row_words.add(word);
		}
		return same_row_words.toArray(new String[same_row_words.size()]);
	}
}
