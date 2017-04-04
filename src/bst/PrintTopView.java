package bst;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class TreeNode {
	int data;
	int hd;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int d) {
		data = d;
		hd = 0;
		left = null;
		right = null;
	}
}


class PrintTopView {

	
	static void printTopView(TreeNode node) {
		
		ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
		Map<Integer, Integer> myView = new TreeMap<Integer, Integer>();
		int hd = 0;
		
		TreeNode curr = node;
		node.hd = hd;
		
		while (!q.isEmpty()) {
			
			if(curr.left != null) {
				curr.left.hd = curr.hd - 1;
				q.add(curr.left);
			}
			
			if (curr.right != null) {
				curr.right.hd = curr.hd + 1;
				q.add(curr.right);
			}
			

			System.out.println(",.,.,. " + curr.hd + " " + curr.data);
			
			if (myView.get(curr.hd) == null) {
				myView.put(curr.hd, curr.data);
			}
				 
			curr = q.remove();
		}
		
		for(Integer n: myView.values()) {
			System.out.print(n + " ");
		}
	}
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
       
        System.out.println("Following are nodes in top view of Binary Tree");
        printTopView(root);
	} 
	
	
}
