package TreeDS;

import TreeDS.BinaryTreeISPerfectOrNot.Node;

public class InorderSuccessorForAllNodes {
	Node next = null;
	static class Node{
		int data;
		Node left;
		Node right;
		Node next;
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
			next = null;
		}
	}
	
	public void inorderSuccessorForAllNodes(Node root) {
		
		if(root == null)
			return;
		inorderSuccessorForAllNodes(root.right);
		
		root.next = next;
		next = root;
		
		inorderSuccessorForAllNodes(root.left);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
