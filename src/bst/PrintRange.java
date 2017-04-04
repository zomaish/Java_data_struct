package bst;

import bst.BinarySearchTree.Node;
class PrintRange {

	
	
	
	static void print(int l, int r) {
		
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(8);
        tree.root.left = new Node(4);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(14);
        
        
        print(6, 12);
    }
}
