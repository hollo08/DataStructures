package mycodeschool;

public class LinkedList {
	Integer element;
	LinkedList next = null;
	
	public LinkedList(Integer element){
		this.element = element;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.element.toString();
	}
}
