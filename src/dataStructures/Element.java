package dataStructures;

class Element implements Comparable<Element> {
	Integer number;
	Character key;

	public Element() {

	}

	public Element(Character key, Integer number) {
		this.key = key;
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	@Override
	public int compareTo(Element o) {
		Element ele1 = (Element) o;
		return number > ele1.number ? 1 : number == ele1.number ? 0 : -1;
	}

	@Override
	public String toString() {
		return "Key [" + this.key + "] - Number [" + this.number + "]";
	}
}