package bst;

import bst.Node;

class LLNode {
	int d;
	LLNode next;
	
	public LLNode(int data) {
		d = data;
		next = null;
	}
}


class BstFromSortedLL {

	static LLNode head;
	
	static Node toBst(int n) {
		
		if (n <= 0) return null;
		Node left = toBst(n/2);
		Node root = new Node(head.d);
		
		root.left = left;
		head = head.next;
		
		root.right = toBst(n-n/2-1);
		
		return root;
	}
	
	
	public static void main(String[] args) {
		head = new LLNode(1);
		head.next = new LLNode(2);
		head.next.next = new LLNode(3);
		head.next.next.next = new LLNode(4);
		head.next.next.next.next = new LLNode(5);
		head.next.next.next.next.next = new LLNode(6);
		
		Node res = toBst(6);
		
		System.out.println(res);
	}
	
	
}
