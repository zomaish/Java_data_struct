package LinkedList;

import LinkedList.Node;

class AddLinkedList {
	
	
	
	static int getSize(Node n) {
		int counter = 0;
		Node curr = n;
		
		while(curr != null) {
			++counter;
			curr = curr.next;
		}
		
		return counter;
	}
	
	static void swap(Node n1, Node n2) {
		Node temp = n1.next;
		n1.data = n2.data;
		n1.next = n2.next;
		
		n2.data = temp.data;
		n2.next = temp.next;
	}
	
	static Node addEqualLength(Node n1, Node n2, Node carry) {
		
		if(n1 == null) {
			return n1;
		}

		n1.next = addEqualLength(n1.next, n2.next, carry);
		
		int sum = n1.data + n2.data + carry.data;
		
		System.out.println(sum + "    +++++    " + carry.data);
		carry.data = sum>=10 ? 1 : 0;
		n1.data = sum%10;
		
		return n1;
	}
	
	static Node addCarry(Node n1, Node t, Node carry) {
		
		if (n1 != t) {
			n1.next = addCarry(n1.next, t, carry);
			
			int sum = n1.data + carry.data;
			carry.data = sum>=10 ? 1 : 0;
			n1.data = sum%10;
			
			return n1;
		}
		
		return n1;
	}
	
	static Node add(Node n1, Node n2) {
		
		Node t = n1;
		Node carry = new Node(0);
		
		int len1 = getSize(n1);
		int len2 = getSize(n2);
		
		int diff = Math.abs(len1-len2);
		
		if (diff ==0) {
			return addEqualLength(n1, n2, carry);
		}
		
		if (len1<len2) {
			swap(n1, n2);
		}

		for(; diff>0; diff--, t = t.next);
		
		
		t = addEqualLength(t, n2, carry);
		
		
		addCarry(n1, t, carry);
		
		if (carry.data > 0) {
			carry.next =  n1;
			
			return carry;
		}
		
		return n1;
	}
	
	
	static void printLL(Node n) {
		
		while(n != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
	}

	public static void main(String[] args) {
		Node n1 = new Node(9);
		n1.next = new Node(9);
		n1.next.next = new Node(9);
		
		
		Node n2 = new Node(1);
		n2.next = new Node(8);
		
		Node result = add(n1, n2);
		
		printLL(result);
	}

}
