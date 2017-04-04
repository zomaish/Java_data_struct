package bst;

//http://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
class Node {
	Node left;
	Node right;
	Node random;
	int d;
	
	Node(int data) {
		d = data;
		left = null;
		right = null;
		random = null;
	}
}

class CloneBSTWithRandom {

	static Node cloneLeftAndRight(Node n) {
		if(n == null) return null;
		
		System.out.println("cloning " + n.d);
		Node left = n.left;
		n.left = new Node(n.d);
		n.left.left = left;
		
		if (left != null)
			left.left = cloneLeftAndRight(left);
		
		n.left.right = cloneLeftAndRight(n.right);
		return n.left;
	}
	
	static void restoreTreeLeftNode(Node treeNode, Node cloneNode) {
	    if (treeNode == null)
	        return;
	    
	    if (cloneNode.left != null) {
	        Node cloneLeft = cloneNode.left.left;
	        treeNode.left = treeNode.left.left;
	        cloneNode.left = cloneLeft;
	    }
	    else
	        treeNode.left = null;
	 
	    restoreTreeLeftNode(treeNode.left, cloneNode.left);
	    restoreTreeLeftNode(treeNode.right, cloneNode.right);
	}
	
	
	static Node cloneNode(Node n) {
		if (n==null) return null;
		
		Node t = new Node(n.d);
		t.left = cloneNode(n.left);
		t.right = cloneNode(n.right);
		
		return t;
	}
	
	static void printInorder(Node n) {
		if(n == null) return;
		
		printInorder(n.left);
		System.out.print(n.d + " - ");
		printInorder(n.right);
	}
	
	public static void main(String[] args) {
		Node tree = new Node(10);
	    Node n2 = new Node(6);
	    Node n3 = new Node(12);
	    Node n4 = new Node(5);
	    Node n5 = new Node(8);
	    Node n6 = new Node(11);
	    Node n7 = new Node(13);
	    Node n8 = new Node(7);
	    Node n9 = new Node(9);
	    tree.left = n2;
	    tree.right = n3;
	    tree.random = n2;
	    n2.left = n4;
	    n2.right = n5;
	    n2.random = n8;
	    n3.left = n6;
	    n3.right = n7;
	    n3.random = n5;
	    n4.random = n9;
	    n5.left = n8;
	    n5.right = n9;
	    n5.random = tree;
	    n6.random = n9;
	    n9.random = n8;
	    
	    
	    
//	    printInorder(tree);
	    
	    Node clone = cloneLeftAndRight(tree);
	    
	    restoreTreeLeftNode(tree, clone);
//	    
	    printInorder(clone);
	}
}
