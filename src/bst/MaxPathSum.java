package bst;

import bst.BinarySearchTree.Node;

class Res {
	int val;
	
	Res() {
		val = 0;
	}
}

public class MaxPathSum {

	
	
	static int findMaxSum(Node node) {
		Res res = new Res();
		
		findMaxUtil(node, res);
		
		return res.val;
	}
	
	static int findMaxUtil(Node node, Res res) {
		
		if (node == null) return 0;
		
		int l = findMaxUtil(node.left, res);
		int r = findMaxUtil(node.right, res);
		
		int childrenMax = Math.max(Math.max(l, r) + node.data, node.data);
		int topMax = Math.max(childrenMax + node.data, node.data);
		
		res.val = Math.max(res.val, topMax);
		
		return childrenMax;
	}
	
	
	
	public static void main(String[] args) {
			BinarySearchTree tree = new BinarySearchTree();
	        tree.root = new Node(10);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(10);
	        tree.root.left.left = new Node(20);
	        tree.root.left.right = new Node(1);
	        tree.root.right.right = new Node(-25);
	        tree.root.right.right.left = new Node(3);
	        tree.root.right.right.right = new Node(4);
	        System.out.println("maximum path sum is : " +
	                            findMaxSum(tree.root));
	}
}
