package LinkedList;

class LinkedListLoop {

	static class Node {
		int data;
		Node next;
		
		public Node(Integer d) {
			data = d;
			next = null;
		}
	}
	
	Node head;
	
	public LinkedListLoop() {
		head = null;
	}
	
	public Node add(Node node, Integer data) {
		if (node == null) return new Node(data);
		node.next = add(node.next, data);
		return node;
	}
	
	public Boolean detectLoop(Node node) {
		Node slow = node;
		Node fast = node;
		
		while (fast != null &&
				slow != null &&
				fast.next != null
			) {

			slow = slow.next;
			fast = fast.next.next;
			
			if (fast == slow) {
				removeLoop(slow, node);
				return true;
			}
		} 
		
		return false;
	}
	
	private void removeLoop(Node loop, Node node) {
		Node ptr = loop;
		Node h = node;
		
		while(true) {
			while(ptr.next != h && ptr.next != loop) {
				ptr = ptr.next;
			}
			
			if(ptr.next == h) {
				break;
			}
			
			h = h.next;
		}

		ptr.next = null;
	}
	
	public void printLL(Node node) {
		
		while(node.next != null) {
			System.out.println(node.data);
			
			node = node.next;
		}
		
		System.out.println(node.data);	
	}
	
	public static void main(String[] args) {
		LinkedListLoop list = new LinkedListLoop();
		list.head = list.add(list.head, 5);
		list.head = list.add(list.head, 4);
		list.head = list.add(list.head, 3);
		list.head = list.add(list.head, 2);
		list.head = list.add(list.head, 1);
		list.head = list.add(list.head, 0);

//		list.head.next.next.next.next = list.head.next.next.next;
		
        System.out.println(list.detectLoop(list.head));
	}
}
