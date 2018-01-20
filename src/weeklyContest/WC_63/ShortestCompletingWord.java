package weeklyContest.WC_63;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestCompletingWord {

	public static void main(String[] args) {
		ShortestCompletingWord scw = new ShortestCompletingWord();
		String licensePlate = "1s3 456";
		String[] words = { "looks", "pest", "stew", "show" };
		String res = scw.shortestCompletingWord(licensePlate, words);
		System.out.println(res);
	}

	public String shortestCompletingWord(String licensePlate, String[] words) {
		char[] licensePlateChars = licensePlate.toLowerCase().toCharArray();
		Map<Character, Integer> characters = new HashMap<Character, Integer>();
		int char_len = 0;
		for (char ch : licensePlateChars) {
			if (ch >= 97 && ch <= 122) {
				char_len++;
				if (!characters.containsKey(ch))
					characters.put(ch, 0);
				characters.put(ch, characters.get(ch) + 1);
			}
		}
		List<String> valid_strings = new ArrayList<String>();
		int min_word_len = Integer.MAX_VALUE;
		for (String word : words) {
			if (containsAllCharacters(characters, word, char_len)) {
				valid_strings.add(word);
				if (min_word_len > word.length())
					min_word_len = word.length();
			}
		}
		for (String valid_string : valid_strings)
			if (valid_string.length() == min_word_len)
				return valid_string;
		return null;
	}

	public boolean containsAllCharacters(Map<Character, Integer> temp, String word, int len) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character key : temp.keySet()){
			map.put(key, temp.get(key));
		}
		char[] word_chars = word.toCharArray();
		for (char ch : word_chars) {
			if (map.containsKey(ch) && map.get(ch) != 0) {
				len--;
				map.put(ch, map.get(ch) - 1);
			}
		}
		if (len == 0)
			return true;
		return false;
	}
}
