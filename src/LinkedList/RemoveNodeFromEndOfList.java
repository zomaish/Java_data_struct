package LinkedList;

import LinkedList.Node;

public class RemoveNodeFromEndOfList {

	static void remove(Node n, int k) {
		
		if (k<1) return;

		Node fast = n;
		Node slow = n;
		
		for (int i=0; i<k; i++) {
			fast = fast.next;
		}
		
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
	}
	
	
	static void printLL(Node head) {
		
		while(head.next != null) {
			System.out.println(head.data);
			
			head = head.next;
		}
		
		System.out.println(head.data);	
	}
	public static void main(String[] args) {
		Node list = new Node(0);
		list.next = new Node(1);
		list.next.next = new Node(2);
		list.next.next.next = new Node(3);
		list.next.next.next.next = new Node(4);
		list.next.next.next.next.next = new Node(5);
		list.next.next.next.next.next.next = new Node(6);
		
		remove(list, 3);
		printLL(list);
	}
}
