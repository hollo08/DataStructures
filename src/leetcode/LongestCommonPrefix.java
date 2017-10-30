package leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] arr = {"abcur","abcdbn","abcdvdrhcoi","abcdasdfgh","abcddxfcghjkl"};
		System.out.println(LCP(arr));
	}

	static int LCP(String[] strArray) {
		int min = strArray[0].length();
		for (String str : strArray)
			if (min > str.length())
				min = str.length();
		int i =0;
		for (i = 0; i < min; i++)
			for (int j = 0; j < strArray.length-1; j++) {
				if(strArray[j].charAt(i)!=strArray[j+1].charAt(i))
					return i;
			}
		return i;
	}
}
