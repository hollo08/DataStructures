package linkedIn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		Permutations p = new Permutations();
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		List<List<Integer>> solutions = p.printPermutations(a);
		for (List<Integer> i : solutions) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	List<List<Integer>> printPermutations(List<Integer> a) {
		if (a.size() == 2) {
			List<Integer> t1 = new ArrayList<Integer>();
			t1.add(a.get(0));
			t1.add(a.get(1));
			List<Integer> t2 = new ArrayList<Integer>();
			t2.add(a.get(1));
			t2.add(a.get(0));
			List<List<Integer>> p = new ArrayList<List<Integer>>();
			p.add(t1);
			if(a.get(0)==a.get(1)){
				return p;
			}
			p.add(t2);
			return p;
		} else {
			List<List<Integer>> p = new ArrayList<List<Integer>>();
			Integer prev = null;
			for (int i = 0; i < a.size(); i++) {
				if(prev!=null && prev == a.get(i))
					continue;
				prev = a.get(i);
				List<Integer> a1 = new ArrayList<>(a.subList(0, i));
				List<Integer> a2 = new ArrayList<>(a.subList(i + 1, a.size()));
				a1.addAll(a2);
				List<List<Integer>> temp = printPermutations(a1);
				for (List<Integer> t : temp) {
					t.add(0, a.get(i));
					p.add(t);
				}
			}
			return p;
		}
	}
}
