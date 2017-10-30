package linkedIn;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
	}

	String minimumWindowSubstring(char[] s, char[] t) {
		boolean[] found = new boolean[t.length];
		int index = 0;
		while(!allTrue(found)){
			if(hasChar(s[index],t)){
				
			}
		}
		return "";
	}
	
	boolean hasChar(char ch, char[] t){
		for(char c : t)
			if(c == ch)
				return true;
		return false;
	}
	
	boolean allTrue(boolean[] found){
		for(boolean b : found)
			if(!b)
				return false;
		return true;
	}
}
