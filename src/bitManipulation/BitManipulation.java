package bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class BitManipulation {

	public static void main(String[] args) {
		System.out.println(largestPowerof2(33));
		for(String str : subset("abcde"))
			System.out.println(str);
	}

	static List<String> subset(String elements) {
		List<String> subsets = new ArrayList<String>();
		for (int i = 0; i < Math.pow(2, elements.length()); i++) {
			StringBuffer subset = new StringBuffer();
			for (int j = 0; j < elements.length(); j++) {
				if ((i & (int) Math.pow(2, j)) != 0)
					subset.append(new Character( elements.charAt(j)));
			}
			subsets.add(subset.toString());
		}
		return subsets;
	}

	static int largestPowerof2(int num){
		int x=-10, y=-11;
		
		int f = (x ^ y);
		System.out.println(f);
		double shift = Math.log(num)/Math.log(2);
		System.out.println(shift);
		int temp = num;
		int counter = 0;
		while(counter<shift){
			temp |=(temp>>(int)Math.pow(2, counter));
			counter++;
		}
		return (temp+1)/2;
	}
}
