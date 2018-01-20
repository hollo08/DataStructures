package weeklyContest.WC_66;

import java.util.HashMap;
import java.util.Map;

public class AnagramMatching {

	public static void main(String[] args) {
		AnagramMatching am = new AnagramMatching();
		int[] A = { 12, 28, 46, 32, 50 }, B = { 50, 12, 32, 46, 28 };
		int[] sol = am.anagramMappings(A, B);
		System.out.println(sol.length);
	}

	public int[] anagramMappings(int[] A, int[] B) {
		int len = A.length;
		int[] res = new int[A.length];
		Map<Integer, Integer> index = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++)
			index.put(B[i], i);
		for (int i = 0; i < len; i++)
			res[i] = index.get(A[i]);
		return res;
	}
}
