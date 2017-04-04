package LinkedList;

class LinkedListMerge {

	void sort(Node head) {
		if (head == null) return;
		
		Node a;
		Node b;
		
		split(head, a, b);
		sort(a);
		sort(b);
		
		merge(head, a, b);
	}
	
	void split(Node head, Node a, Node b) {
		Node slow = head;
		Node fast = head;
		
		while (slow.next != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		b = slow;
	}
}
