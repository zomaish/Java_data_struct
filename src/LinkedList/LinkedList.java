package LinkedList;

public class LinkedList {

	public class Node {
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;
		}
		
		public int getData() {
			return data;
		}
		
		public Node getNext() {
			return next;
		}
	}
	
	public Node head;
	
	public LinkedList() {
		Node head = null;
	}
	
	public void add(int n) {
	  head = doAdd(head, n);
	}
	
	
	public void sortedInsert(Node newNode) {
		if (head == null || head.data > newNode.data) {
			newNode.next = head;
			head = newNode;
		} else {
			Node current = head;
			while(current != null && current.next != null && 
					current.next.data < newNode.data 
					) {
				current = current.next;
			}
			
			newNode.next = current.next;
			current.next = newNode;
		}
	}
	
	public void pushBack(int d) {
		if (head == null) {
			head = new Node(d);
		} else {
			Node newNode = new Node(d);
			newNode.next = head;
			head = newNode;
		}
	}

	private Node doAdd(Node node, int n) {
		if (node == null) return new Node(n);
		node.next = doAdd(node.next, n);
		return node;
	}
	
	public void printLL() {
		Node curr = head;
		
		while(curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
	}
	
	
	public static void main(String args[]) {
		
		LinkedList ll = new LinkedList();
		ll.add(5);
		ll.add(10);
		ll.add(7);
		ll.add(3);
		ll.add(1);
		ll.add(9);
		
	}
}

