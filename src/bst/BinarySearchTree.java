package bst;

class BinarySearchTree {

	public static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}
	
	
	Node root;
	BinarySearchTree() {
		root = null;
	}
	
	
	void add(int d) {
		root = addRec(root, d); 
	}
	
	Node addRec(Node node, int d) {
		if (node == null) return new Node(d);
		
		if (node.data >= d) node.left = addRec(node.left, d);
		else node.right = addRec(node.right, d);
		
		return node;
	}
	
	int maxDepth(Node node) {
		if (node == null) return 0;
		return 1+Math.max(maxDepth(node.left), maxDepth(node.right));
	}
	
	int minDepth(Node node) {
		if (node == null) return 0;
		
		if(node.left == null && node.right == null)
			return 1;
		
		if (node.left == null)
			return 1+minDepth(node.right);
		
		if (node.right == null)
			return 1+minDepth(node.left);
		
		return 1+Math.min(minDepth(node.left), minDepth(node.right));
	}
	
	static void preorderTraversal(Node node) {
		if (node == null) return;
		System.out.println(node.data);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	static void inorderTraversal(Node node) {
		if (node == null) return;
		inorderTraversal(node.left);
		System.out.println(node.data);
		inorderTraversal(node.right);
	}
	
	static void postorderTraversal(Node node) {
		if (node == null) return;
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.data);
	}
	
	void print(Node node) {
		
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

		inorderTraversal(mbt.root);
//		System.out.println(mbt.minDepth(mbt.root));
	}

}
