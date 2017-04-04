package bst;


import bst.BinarySearchTree.Node;

class SerializeDeserialize {

	
	static void serializeUtil(Node n, StringBuilder str) {
		if (n != null) {
			str.append(n.data).append(", ");
			serializeUtil(n.left, str);
			serializeUtil(n.right, str);
		} else {
			str.append(n).append(", ");
		}
	}
	
	static String serialize(Node n) {
		StringBuilder str = new StringBuilder();
		str.append("[");
		
		serializeUtil(n, str);
		
		str.append("]");
		return str.toString();
	}

	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		
		System.out.println(serialize(root));
	}
}
