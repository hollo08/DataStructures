package weeklyContest.WC_20;

public class DetectCapital {

	public static void main(String[] args) {
		DetectCapital dc = new DetectCapital();
		boolean res = dc.detectCapitalUse("U");
		System.out.println(res);
	}

	public boolean detectCapitalUse(String word) {
		char[] word_char = word.toCharArray();
		int len = word_char.length;
		if(len == 1)
			return true;
		int type = 0;
		type = word_char[0] >= 65 && word_char[0] <= 90 ? 1 : 0;
		switch (type) {
		case 1:
			if (len == 2)
				return true;
			type = word_char[1] >= 65 && word_char[1] <= 90 ? 1 : 0;
			for (int i = 2; i < len; i++) {
				if ((type == 0 && word_char[i] >= 65 && word_char[i] <= 90)
						|| (type == 1 && word_char[i] >= 97 && word_char[i] <= 122))
					return false;
			}
			break;
		case 0:
			for (int i = 1; i < len; i++) {
				if (word_char[i] >= 65 && word_char[i] <= 90)
					return false;
			}
			break;
		}
		return true;
	}
}
