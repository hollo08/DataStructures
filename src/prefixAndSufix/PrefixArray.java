package prefixAndSufix;

public class PrefixArray {

	public static void main(String[] args) {
		PrefixArray prefixArray = new PrefixArray();
		prefixArray.getPrefixArray("acacabacacabacacac".toCharArray());
	}

	int[] getPrefixArray(char[] string) {
		int len = string.length;
		int[] prefix_array = new int[len];
		int j, i;
		prefix_array[0] = 0;
		j = 0;
		i = 1;
		while (i < len) {
			if (string[j] == string[i]) {
				prefix_array[i] = j + 1;
				i++;
				j++;
			} else {
				if (j != 0)
					j = prefix_array[j - 1];
				else
					prefix_array[i++] = 0;
			}
		}
		return prefix_array;
	}
}