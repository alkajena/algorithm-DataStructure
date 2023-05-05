package TreeDS;

import TreeDS.DiagonalTraversal.Node;

public class FoldableTree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public boolean foldableTree(Node root) {
		if(root == null)
			return true;
		return isFoldableUtil(root.left, root.right);
		
	}

	private boolean isFoldableUtil(Node left, Node right) {
		if(left == null && right == null)
			return true;
		if(left == null || right == null)
			return false;
		return isFoldableUtil(left.left, right.right) && isFoldableUtil(left.right, right.left);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.left.right = new Node(5);
        FoldableTree ft = new FoldableTree();
        if(ft.foldableTree(root)) {
        	System.out.println("Foldable tree");
        }

	}

}
