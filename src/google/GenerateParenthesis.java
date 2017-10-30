package google;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		List<String> parenthesisList = new ArrayList<String>();
		possibleParenthesis(0, 0, 3, new StringBuffer(), parenthesisList);
		for (String str : parenthesisList)
			System.out.println(str);
		System.out.println(parenthesisList.size());
	}

	static void possibleParenthesis(int open, int close, int limit, StringBuffer generatedString,
			List<String> parenthesisList) {
		if (open == limit && close == limit)
			parenthesisList.add(generatedString.toString());
		else if (open == limit && close != limit) {
			for (int i = close; i < limit; i++) {
				close++;
				generatedString.append(")");
			}
			parenthesisList.add(generatedString.toString());
		} else {
			StringBuffer temp = new StringBuffer(generatedString.toString());
			StringBuffer temp2 = new StringBuffer(generatedString.toString());
			if (close < open)
				possibleParenthesis(open, close + 1, limit, temp2.append(")"), parenthesisList);
			possibleParenthesis(open + 1, close, limit, temp.append("("), parenthesisList);
		}
	}

}
