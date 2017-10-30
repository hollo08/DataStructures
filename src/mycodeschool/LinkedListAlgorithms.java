package mycodeschool;

public class LinkedListAlgorithms {

	public static void main(String[] args) {
		LinkedListAlgorithms ll = new LinkedListAlgorithms();
		int[] number_srray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		LinkedList head = ll.createLinkedList(number_srray);
		System.out.println("Linked list");
		ll.printLinkedList(head);
		System.out.println("Reversing the list");
		head = ll.reverseLinkedList(head);
		ll.printLinkedList(head);
		System.out.println("Printing in reverse order");
		ll.printReverseLinkedList(head);
		System.out.println();
		System.out.println("Reversing the Linked List in Recurssion");
		head = ll.reverserLinkedListRecursively(null, head);
		System.out.println("Prining the reverse list");
		ll.printLinkedList(head);
	}
	
	public void insertSort(LinkedList head) {
		if(head != null && head.next != null){
			LinkedList temp = head;
			while(temp.next!=null){
				while(temp.element<temp.next.element){
					temp = temp.next;
				}
				LinkedList bp = head;
				LinkedList fp = bp.next;
				while(fp.element<temp.next.element){
					fp = fp.next;
					bp = bp.next;
				}
				LinkedList temp_next = temp.next;
				temp.next = temp_next.next;
				temp_next.next = bp.next;
				bp.next = temp_next;
			}
		}
	}

	public LinkedList reverseLinkedList(LinkedList head) {
		if (head == null)
			return null;
		else {
			LinkedList reverse_pointer = null;
			LinkedList node = head;
			while (node != null) {
				LinkedList temp = node.next;
				node.next = reverse_pointer;
				reverse_pointer = node;
				node = temp;
			}
			return reverse_pointer;
		}
	}

	public LinkedList createLinkedList(int[] number_array) {
		if (number_array.length == 0)
			return null;
		else {
			LinkedList head = new LinkedList(number_array[0]);
			LinkedList previous = head;
			for (int i = 1; i < number_array.length; i++) {
				LinkedList temp = new LinkedList(number_array[i]);
				previous.next = temp;
				previous = temp;
			}
			return head;
		}
	}

	public LinkedList reverserLinkedListRecursively(LinkedList prev, LinkedList node) {
		LinkedList temp = node.next;
		node.next = prev;
		prev = node;
		if (temp == null) {
			return node;
		} else {
			return reverserLinkedListRecursively(prev, temp);
		}

	}

	public void printLinkedList(LinkedList head) {
		LinkedList temp = head;
		while (temp != null) {
			System.out.print(temp.element + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void printReverseLinkedList(LinkedList node) {
		if (node != null) {
			printReverseLinkedList(node.next);
			System.out.print(node.element + " ");
		}
	}
}