package string;

public class NearestPalindrome {

	public static void main(String[] args) {
		String n = "123432156";
		char[] stringArray = n.toCharArray();
		int len = stringArray.length;
		boolean isPalindrome=true;
		for (int i = 0; i < len / 2; i++) {
			if (stringArray[i] != stringArray[len - i - 1]) {
				isPalindrome = false;
				stringArray[len - i - 1] = stringArray[i];
			}
		}
		Integer palinNum = new Integer(new String(stringArray));
		if(isPalindrome){
			if(len%2!=0)
				palinNum += (int)Math.pow(10, len/2);
			else
				palinNum = palinNum + 11*(int)Math.pow(10, (len-1)/2);
		}
		System.out.println(palinNum);
	}
}