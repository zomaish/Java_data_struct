package bst;

import bst.BinarySearchTree.Node;

class AddGreaterValuesToNodes {

	//Given a BST (Binary Search Tree) , Each node value should replace with sum of 
	//the node which are greater-than the given node. 
	static void addGreaterValue(Node node, int[] sum) {
		if (node == null) return;

		addGreaterValue(node.right, sum);
	
		sum[0] = sum[0] + node.data; 
		node.data = sum[0];

		addGreaterValue(node.left, sum);
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree mbt = new BinarySearchTree();
		
		mbt.add(50);
		mbt.add(70);
		mbt.add(30);
		mbt.add(20);
		mbt.add(40);
		mbt.add(60);
		mbt.add(80);

		int [] sum = {0};
		addGreaterValue(mbt.root, sum);
		
		mbt.inorderTraversal(mbt.root);
//		System.out.println(mbt.minDepth(mbt.root));
	}
}
