package LinkedList;

/**
 * 
 * @author dnguyen
 * problem: Get the nth element from linkedlist 
 * complexity: O(n)
 */

public class LinkedList {
	Node head;
	int size;
	public LinkedList() {
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public void push(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public int getNth(int index) {
		Node current = head;
		int position = this.size() - index - 1;
		
		int count = 0;
		while (current!=null) {
			if(count == position) { return current.data; }
			else { count++; current = current.next; }
		}
		return 0;
	}
	
	public void remove(int index) {
		int position = this.size() - index - 1;
		Node current = head; 
		if (head == null) { return; }
		
		if (index == 0) { head = current.next; size--; return; }
		
		for(int i = 0; i < position - 1; i++) {
			current = current.next;
		}
		
		current.next = current.next.next;
		size--;
	}
	public static void main(String arg[]) {
		LinkedList list = new LinkedList();
		
		list.push(15);
		list.push(9);
		list.push(17);
		list.push(2);
		list.push(31);
		
		list.remove(1);
		list.remove(3);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.getNth(i));
		}
		
	}
}

