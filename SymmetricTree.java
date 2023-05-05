package TreeDS;

import TreeDS.BinaryTreeISPerfectOrNot.Node;

public class SymmetricTree {

	static class Node{
		
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public boolean isSymmetric(Node root) {
		Node root1 = root;
		return symmetricTree(root, root1);
	}
	public boolean symmetricTree(Node root1, Node root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		return root1.data == root2.data && symmetricTree(root1.left, root2.right) && symmetricTree(root1.right, root2.left);
	}
	public static void main(String[] args) {
		  Node root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(2);
	        root.left.left = new Node(3);
	        root.left.right = new Node(4);
	        root.right.left = new Node(4);
	        root.right.right = new Node(3);
	    SymmetricTree st = new SymmetricTree();
	    if(st.isSymmetric(root)){
	    	System.out.println("Symmetric tree");
	    }
	}
}
