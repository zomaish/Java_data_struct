package LinkedList;

class LinkedListAdd {
	
	static class Node {
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	private Node head;
	
	LinkedListAdd() {
		head = null;
	}
	
	Node add(Node node, int d) {
		if (node == null) return new Node(d);
		
		node.next = add(node.next, d);
		return node;
	}
	
	
	
	Node sum(Node node1, Node node2) {
		Node rem = new Node(0);
		sumRec(node1, node2, rem);
		
		if (rem.data > 0) {
			rem.next = node1;
			node1 = rem;
		}
		
		return node1;
	}
	
	Node sumRec(Node node1, Node node2, Node rem) {
		
		if (node1 == null) return node1;
		
		node1.next = sumRec(node1.next, node2.next, rem);
		
		int sum = node1.data + node2.data + rem.data;
		
		node1.data = sum%10;
		rem.data = sum >= 10 ? 1 : 0;
		
		return node1;
	}
	
	Node getList() {
		return head;
	}
	
	static void printLL(Node node) {
		
		while(node.next != null) {
			System.out.println(node.data);
			
			node = node.next;
		}
		
		System.out.println(node.data);	
	}
	

	public static void main(String[] args) {
		LinkedListAdd ll1 = new LinkedListAdd();
		ll1.head = ll1.add(ll1.head, 5);
		ll1.head = ll1.add(ll1.head, 6);
		ll1.head = ll1.add(ll1.head, 3);

		LinkedListAdd ll2 = new LinkedListAdd();
		ll2.head = ll2.add(ll2.head, 8);
		ll2.head = ll2.add(ll2.head, 4);
		ll2.head = ll2.add(ll2.head, 2);
		
		Node res = ll1.sum(ll1.head, ll2.head);
		printLL(res);
	}

}
