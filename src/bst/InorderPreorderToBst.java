package bst;
import bst.Node;

//http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
//postOrder is the same with preIdx--;

public class InorderPreorderToBst {

	static int preIdx = 0;
	
	static Node buildTree(char[] in, char[] pre, int l, int r) {
		
		if (l>r) return null;
		
		int idx = search(in, pre[preIdx++]);
		
		Node root = new Node(in[idx]);
		if (l==r) return root;
		
		root.left = buildTree(in, pre, l, idx-1);
		root.right = buildTree(in, pre, idx+1, l);
				
		return root;
		
	}
	
	static int search(char[] arr, char c) {
		for (int i=0; i<arr.length; i++)
			if(arr[i] == c)
				return i;
		
		return -1;
	}
	
	
	
	public static void main(String args[]) {
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node root = buildTree(in, pre, 0, len - 1);
  
    }
}
