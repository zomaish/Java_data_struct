package bst;

import bst.Node;
public class SortedArrayToBst {

	
	static Node sortedArrayToBST(int[] arr, int l, int r) {
		
		if (l>r) return null;
		
		int m = (l+r)/2;
		
		Node root = new Node(arr[m]);
		root.left = sortedArrayToBST(arr, l, m-1);
		root.right = sortedArrayToBST(arr, m+1, r);
		return root;
	}
	
	public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        Node root = sortedArrayToBST(arr, 0, n - 1);
        
        System.out.println(root);
       
    }
}
