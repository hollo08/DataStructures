package weeklyContest.WC_66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

	public static void main(String[] args) {
		EmployeeFreeTime eft = new EmployeeFreeTime();
		// [[[1,2],[5,6]],[[1,3]],[[4,10]]]
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(5, 6);
		Interval i3 = new Interval(1, 3);
		Interval i4 = new Interval(4, 10);
		List<Interval> e1 = new ArrayList<Interval>();
		e1.add(i1);
		e1.add(i2);
		List<Interval> e2 = new ArrayList<Interval>();
		e2.add(i3);
		e2.add(i4);
		List<List<Interval>> intervals = new ArrayList<List<Interval>>();
		intervals.add(e1);
		intervals.add(e2);
		List<Interval> freeTime = eft.employeeFreeTime(intervals);
		System.out.println(freeTime.size());
	}

	public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
		PriorityQueue<Interval> employees = new PriorityQueue<Interval>(new IntervalSort());
		for (int i = 0; i < avails.size(); i++) {
			List<Interval> avail = avails.get(i);
			for (Interval interval : avail)
				employees.add(interval);
		}
		List<Interval> ans = new ArrayList<Interval>();
		int prev = employees.poll().end;
		while (!employees.isEmpty()) {
			Interval present = employees.poll();
			if(present.start>prev)
				ans.add(new Interval(prev, present.start));
			prev = Math.max(prev, present.end);
		}
		return ans;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return start + " - " + end;
	}

}

class IntervalSort implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
	}
}