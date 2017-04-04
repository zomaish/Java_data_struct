package LinkedList;

class CloneDoubleLinkedList {

	static class Node {
		int data;
		Node next;
		Node random;
		
		Node(int d) {
			data = d;
			next = null;
			random = null;
		}
	}
	
	static Node clone(Node n) {
		
		Node curr = n, temp;
		
		while(curr != null) {
		  temp = curr.next;
		  
		  curr.next = new Node(curr.data);
		  curr.next.next = temp;
		  curr=temp;
		}
		
		curr = n;
		
		while(curr != null) {
			curr.next.random = curr.random.next;
			curr = curr.next != null ? curr.next.next: curr.next;
		}
		
		Node original = n, copy = n.next;
		
		while(original != null && copy != null) {
			original.next = original.next != null ? original.next.next : original.next;
			copy.next = copy.next != null ? copy.next.next : copy.next;
			
			original = original.next;
			copy = copy.next;
		}
		
		
		return copy;
	}
	
	static void print(Node n) {
		Node curr = n;
		
		while(curr!= null) {
			System.out.print("data: " + curr.data + " random : " + curr.random.data + " -> ");
			curr = curr.next;
		}
		
//		System.out.print(curr.data + " random : " + curr.random.data + " -> ");
	}
	
	
	public static void main(String[] args) {
		
		Node start = new Node(1);
	    start.next = new Node(2);
	    start.next.next = new Node(3);
	    start.next.next.next = new Node(4);
	    start.next.next.next.next = new Node(5);
	    
	    
	 // 1's random points to 3
	    start.random = start.next.next;
	 
	    // 2's random points to 1
	    start.next.random = start;
	 
	    // 3's and 4's random points to 5
	    start.next.next.random = start.next.next.next.next;
	    start.next.next.next.random = start.next.next.next.next;
	 
	    // 5's random points to 2
	    start.next.next.next.next.random =
	                                      start.next;
	    
	    Node cloned = clone(start);
	    
	    print(start);
	}
}
