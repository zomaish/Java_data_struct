package bst;

import bst.BinarySearchTree.Node;

class Counter {
	int c;
	
	Counter() {
		c = 0;
	}
}
class KthSmallest {
	
	/**
	 * Uses Morris traversal
	 * O(h + k) Worst case is O(n)
	 */
	static int findKthSmallestOneSpace(Node root, int k) {
		Node curr = root;
		int count = 0;
		
		while(curr != null) {
			
			if (curr.left == null) {
				if (++count == k)
					return curr.data;
				
				curr = curr.right;
			} else {
				Node pre = curr.left;
				
				while(pre.right != null && pre.right != curr) 
					pre = pre.right;
				
				if (pre.right != curr) {
					pre.right = curr;
					curr = curr.left;
				} else {
					if (++count == k)
						return curr.data;
					else {
						curr = curr.right;
					}
						
				}
			}
		}
		
		return Integer.MIN_VALUE;
	}
	
	
	static void findKthSmallestExtraSpace(Node n, int k, Counter c) {
		if (n == null || c.c > k) return;
		
		findKthSmallestExtraSpace(n.left, k, c);
		if (++c.c == k) {
			System.out.println(n.data);
			return;
		}
		findKthSmallestExtraSpace(n.right, k, c);
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree mbt = new BinarySearchTree();
		mbt.add(50);
		mbt.add(30);
		mbt.add(20);
		mbt.add(40);
		mbt.add(70);
		mbt.add(60);
		mbt.add(80);
	
//		System.out.print(findKthSmallestOneSpace(mbt.root, 6));
		
		Counter c = new Counter();
		
		findKthSmallestExtraSpace(mbt.root, 3, c);
	}
	
	
}
