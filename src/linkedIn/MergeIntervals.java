package linkedIn;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		List<List<Integer>> intervals = new ArrayList<List<Integer>>();
		List<Integer> t = new ArrayList<Integer>();
		t.add(1);
		t.add(3);
		intervals.add(t);
		t = new ArrayList<Integer>();
		t.add(2);
		t.add(6);
		intervals.add(t);
		t = new ArrayList<Integer>();
		t.add(8);
		t.add(10);
		intervals.add(t);
		t = new ArrayList<Integer>();
		t.add(15);
		t.add(18);
		intervals.add(t);
		for (int i = 1; i < intervals.size(); i++) {
			List<Integer> prev_interval = intervals.get(i - 1);
			List<Integer> present_interval = intervals.get(i);
			if (prev_interval.get(0) > present_interval.get(0)) {
				prev_interval.add(0, present_interval.get(0));
				prev_interval.add(1, present_interval.get(0) > prev_interval.get(0) ? present_interval.get(0)
						: prev_interval.get(0));
				intervals.remove(i--);
			} else if (prev_interval.get(0) < present_interval.get(0)
					&& prev_interval.get(1) > present_interval.get(0)) {
				prev_interval.set(1, present_interval.get(1) > prev_interval.get(1) ? present_interval.get(1)
						: prev_interval.get(1));
				intervals.remove(i--);
			}
		}
		for (List<Integer> i : intervals) {
			for (int j : i)
				System.out.print(j+" ");
			System.out.println();
		}
	}

}
