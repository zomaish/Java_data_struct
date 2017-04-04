package LinkedList;

import LinkedList.LinkedList;
import LinkedList.LinkedList.Node;

public class SortLLWithZerosToTwos {

	
	static void sort(Node head) {
		int[] count = {0, 0, 0};
		Node curr = head;
		
		while(curr != null) {
			++count[curr.data];
			curr = curr.next;
		}
		
		int i=0;
		curr = head;
		
		while(curr != null) {
			
			if (count[i] == 0)
				++i;
			else {
				curr.data = i;
				--count[i];
				curr = curr.next;
			}
		}
	}

	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		ll.pushBack(0);
		ll.pushBack(1);
		ll.pushBack(0);
		ll.pushBack(2);
		ll.pushBack(1);
   		ll.pushBack(1);
   		ll.pushBack(2);
   		ll.pushBack(1);
   		ll.pushBack(2);
   		
//   		ll.printLL();
   		
   		sort(ll.head);
   				
		ll.printLL();
   		
	}
}
