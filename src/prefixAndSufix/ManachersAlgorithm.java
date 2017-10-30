package prefixAndSufix;

public class ManachersAlgorithm {

	public static void main(String[] args) {
		//String str = "abaxabaxabb";
		String str = "abaxabaxabybaxabyb";
		System.out.println(longestPalindrome(str.toCharArray()));
	}

	static int[] longestPalindrome(char[] input) {
		int len = input.length;
		int[] palinLen = new int[len];
		for (int i = 0; i < len;) {
			palinLen[i] = lenOfPalin(input, i);
			int lower_limit = i - palinLen[i] / 2;
			int upper_limit = i + palinLen[i] / 2;
			int j = 1;
			boolean found_jump = false;
			while (i - j >= lower_limit) {
				if ((i - j) - palinLen[i - j] / 2 == lower_limit) {
					i = i + j;
					found_jump = true;
					break;
				} else if ((i - j) - palinLen[i - j] / 2 > lower_limit) {
					palinLen[i + j] = palinLen[i - j];
				} else if ((i - j) - palinLen[i - j] / 2 < lower_limit) {
					palinLen[i + j] = (upper_limit - (i + j)) * 2 + 1;
				}
				j++;
			}
			if (!found_jump)
				i = upper_limit + 1;
		}
		return palinLen;
	}

	static int lenOfPalin(char[] string, int index) {
		int i = 0;
		int len = 1;
		while (true) {
			i++;
			if ((index + i >= string.length) || (index - i < 0) || (string[index + i] != string[index - i]))
				break;
			len = len + 2;
		}
		return len;
	}

}
