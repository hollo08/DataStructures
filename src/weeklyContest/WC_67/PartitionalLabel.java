package weeklyContest.WC_67;

import java.util.*;

public class PartitionalLabel {

	public static void main(String[] args) {
		PartitionalLabel pl = new PartitionalLabel();
		pl.partitionLabels("ababcbacadefegdehijhklij");
	}

	public List<Integer> partitionLabels(String S) {
		Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		int len = S.length();
		char[] char_arr = S.toCharArray();
		for (int i = 0; i < len; i++) {
			char c = char_arr[i];
			if (!map.containsKey(c)) {
				map.put(c, new ArrayList<Integer>());
				map.get(c).add(i);
				map.get(c).add(i);
			}
			map.get(c).set(1, i);
		}
		List<List<Integer>> values = new ArrayList<List<Integer>>(map.values());
		Collections.sort(values, new ListComparator());
		int list_len = values.size();
		for (int i = 0; i < list_len - 1; i++) {
			if (values.get(i).get(1) > values.get(i + 1).get(0)) {
				values.get(i).set(1, Math.max(values.get(i + 1).get(1), values.get(i).get(1)));
				values.remove(i + 1);
				i--;
				list_len--;
			}
		}
		List<Integer> ans = new ArrayList<Integer>();
		for (List<Integer> partition : values)
			ans.add(partition.get(1) - partition.get(0) + 1);
		return ans;
	}
}

class ListComparator implements Comparator<List<Integer>> {

	@Override
	public int compare(List<Integer> arg0, List<Integer> arg1) {
		return arg0.get(0) == arg1.get(0) ? arg0.get(1) - arg1.get(1) : arg0.get(0) - arg1.get(0);
	}

}