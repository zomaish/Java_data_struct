package LinkedList;


class LinkedListStrCmp {
	
	static class Node {
		char data;
		Node next;
		
		Node(char d) {
			data = d;
			next = null;
		}
	}
	
	Node head;
	LinkedListStrCmp() {
		head = null;
	}
	
	Node add(Node node, char d) {
		if (node == null) return new Node(d);
		
		node.next = add(node.next, d);
		return node;
	}
	
	Boolean cmp(Node node1, Node node2) {
		
		while(node1.next != null && node2.next != null) {
			if (node1.data != node2.data) return false;
			
			node1 = node1.next;
			node2 = node2.next;
		}
		
		if (node1.data != node2.data) return false;
		
		node1 = node1.next;
		node2 = node2.next;
		
		if (node1 == null && node2 == null) return true;
		
		return false;
	}

}




//list1 = g->e->e->k->s->a
//list2 = g->e->e->k->s->b