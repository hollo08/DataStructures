package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRangesMain {
	public static void main(String[] args) {
		SummaryRanges summaryRanges = new SummaryRanges();
		summaryRanges.addNum(6);
		summaryRanges.addNum(6);
		summaryRanges.addNum(0);
		summaryRanges.addNum(4);
		summaryRanges.addNum(8);
		summaryRanges.addNum(7);
		summaryRanges.addNum(6);
		summaryRanges.addNum(4);
		summaryRanges.addNum(7);
		summaryRanges.addNum(5);
		System.out.println(summaryRanges.getIntervals().size());
	}
}

class SummaryRanges {

	List<Interval> intervals;
	int index = -1;

	public SummaryRanges() {
		intervals = new ArrayList<Interval>();
	}

	public void addNum(int val) {
		int index = getIndex(val);
		if (index == -1)
			return;
		Interval interval = new Interval();
		interval.start = val;
		interval.end = val;
		// intervals.add(index, interval);
		if (index > 0 && intervals.get(index - 1).end >= interval.start - 1) {
			interval.start = intervals.get(index - 1).start;
			intervals.remove(index - 1);
			index--;
		}
		if (index <= intervals.size() - 1 && intervals.get(index).start <= interval.end + 1) {
			interval.end = intervals.get(index).end;
			intervals.remove(index);
		}
		intervals.add(index, interval);
	}

	public List<Interval> getIntervals() {
		return this.intervals;
	}

	private int getIndex(int interval) {
		int s = 0;
		int e = intervals.size() - 1;
		int m = 0;
		while (s <= e) {
			m = s + (e - s) / 2;
			Interval temp = intervals.get(m);
			if (temp.start > interval)
				e = m - 1;
			else if (temp.end < interval)
				s = m + 1;
			else if (temp.start <= interval && temp.end >= interval)
				return -1;
			else
				return m;
		}
		if (e == -1)
			return 0;
		return s;
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
		return "[" + start + " - " + end + "]";
	}
}