package bst;

//http://www.geeksforgeeks.org/floor-and-ceil-from-a-bst/
	
import bst.BinarySearchTree.Node;
class Ceil {

	
	static int findCeil(Node n, int input) {
		if (n == null) return -1;
		
		if (n.data == input) return n.data;
		
		if (n.data < input) {
			return findCeil(n.right, input);
		}
		
		int ceil = findCeil(n.left, input);		
		return (ceil >= input) ? ceil : n.data;
	}
	
	static int floor(Node n, int input) {
		if (n == null) return -1;
		if (n.data == input) return n.data;
		
		if (n.data > input)
			return floor(n.left, input);
		
		
		int flr = floor(n.right, input);
		return flr<=input && flr > -1 ? flr : n.data;
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
        for (int i = 0; i < 16; i++) {
            System.out.println(i + " " + floor(tree.root, i));
        }
    }
}
