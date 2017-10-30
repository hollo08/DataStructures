package dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinHeap {

	private List<Element> elements = new ArrayList<Element>();
	private Map<Character, Integer> map = new HashMap<Character, Integer>();

	public MinHeap() {
		this.elements.add(null);
	}

	public Element extractMin() {
		if (elements.size() <= 1)
			return null;
		Element min = elements.get(1);
		elements.set(1, elements.get(elements.size() - 1));
		elements.remove(elements.size() - 1);
		if (elements.size() > 1) {
			Element first = elements.get(1);
			map.remove(min.key);
			map.put(first.key, 1);
			heapify();
		}
		return min;
	}

	private void heapify() {
		int index = 1;
		while (index <= (elements.size() - 1) / 2) {
			int child1Index = index * 2;
			int child2Index = index * 2 + 1;
			if (child2Index < elements.size()) {
				if (elements.get(child2Index).compareTo(elements.get(child1Index)) > 0) {
					Element temp = elements.get(index);
					elements.set(index, elements.get(child1Index));
					elements.set(child1Index, temp);
					map.put(elements.get(index).key, index);
					map.put(elements.get(child1Index).key, child1Index);
					index = child1Index;
				} else if (elements.get(child1Index).compareTo(elements.get(child2Index)) > 0) {
					Element temp = elements.get(index);
					elements.set(index, elements.get(child2Index));
					elements.set(child2Index, temp);
					map.put(elements.get(index).key, index);
					map.put(elements.get(child2Index).key, child2Index);
					index = child2Index;
				} else
					break;
			} else if (elements.get(index).compareTo(elements.get(child1Index)) > 0) {
				Element temp = elements.get(index);
				elements.set(index, elements.get(child1Index));
				elements.set(child1Index, temp);
				map.put(elements.get(index).key, index);
				map.put(elements.get(child1Index).key, child1Index);
				index = child1Index;
			} else
				break;
		}
	}

	public Integer contains(Character key) {
		return map.containsKey(key) ? map.get(key) : null;
	}

	public void decrease(Character key, Integer value) {
		Integer index = contains(key);
		if (index != null) {
			Element e = elements.get(index);
			e.number = value;
			heapifyBottomUp(index);
		}
	}

	private void heapifyBottomUp(int childIndex) {
		int parentIndex = childIndex / 2;
		while (parentIndex > 0) {
			Element childElement = elements.get(childIndex);
			Element parentElement = elements.get(parentIndex);
			if (parentElement.number < childElement.number)
				break;
			else {
				Element temp = elements.get(childIndex);
				elements.set(childIndex, elements.get(parentIndex));
				elements.set(parentIndex, temp);
				map.put(elements.get(childIndex).key, childIndex);
				map.put(elements.get(parentIndex).key, parentIndex);
				childIndex = parentIndex;
				parentIndex = childIndex / 2;
			}
		}
	}

	public void add(Character key, Integer number) {
		if (contains(key) == null) {
			Element newElement = new Element(key, number);
			elements.add(newElement);
			map.put(key, elements.size() - 1);
			heapifyBottomUp(elements.size() - 1);
		}
	}

}
