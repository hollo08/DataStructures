package google;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		StringBuffer input = new StringBuffer("210413");
		int max = Character.getNumericValue(input.charAt(input.length() - 1));
		int i = input.length() - 2;
		for (; i >= 0; i--) {
			int currentChar = Character.getNumericValue(input.charAt(i));
			if (max <= currentChar) {
				max = currentChar;
			} else
				break;
		}
		if (i < 0)
			System.out.println("Next permutation number doesn't exist");
		else {
			int pos2 = getPosition2(input, i);
			System.out.println(exchangeChars(input, i, pos2).toString());
		}
	}

	static public StringBuffer exchangeChars(StringBuffer number, int pos1, int pos2) {
		StringBuffer sb = new StringBuffer(number);
		char temp = sb.charAt(pos1);
		sb.setCharAt(pos1, sb.charAt(pos2));
		sb.setCharAt(pos2, temp);
		StringBuffer tempBuffer = new StringBuffer();
		// tempBuffer.append(sb.charAt(pos1));
		for (int i = pos1 + 1; i < number.length(); i++)
			tempBuffer.append(sb.charAt(i));
		char[] charArr = tempBuffer.toString().toCharArray();
		Arrays.sort(charArr);
		// String sorted = String.valueOf(charArr);
		if (charArr != null && charArr.length != 0) {
			// sb.setCharAt(pos1, charArr[0]);
			for (int i = 0; i < charArr.length;) {
				sb.setCharAt(pos1 + 1 + i, charArr[i]);
				i++;
			}
		}
		return sb;
	}

	static int getPosition2(StringBuffer number, int pos1) {
		char temp = number.charAt(pos1);
		StringBuffer tempBuffer = new StringBuffer();
		for (int i = pos1 + 1; i < number.length(); i++)
			tempBuffer.append(number.charAt(i));
		char[] charArr = tempBuffer.toString().toCharArray();
		Arrays.sort(charArr);
		for (int i = 0; i < charArr.length; i++) {
			char c = charArr[i];
			if (c > temp) {
				return number.indexOf(Character.toString(c));
			}
		}
		return -1;
	}
}
