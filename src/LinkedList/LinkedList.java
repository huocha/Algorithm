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
		while(current!=null) {
			if(count == position) { return current.data; }
			else { count++; current = current.next; }
		}
		return 0;
	}
	public static void main(String arg[]) {
		LinkedList list = new LinkedList();
		
		list.push(1);
		list.push(14);
		list.push(12);
		list.push(9);
		list.push(2);
		list.push(3);
		
		System.out.println(""+list.getNth(3));
		System.out.println(list.head.data);
	}
}

