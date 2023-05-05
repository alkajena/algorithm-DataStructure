package TreeDS;

import TreeDS.BinaryTreeISPerfectOrNot.Node;

public class DiameterOFTree {

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
	
	public int diameterOFTree(Node root) {
		if(root ==null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		
		int leftDiameter = diameterOFTree(root.left);
		int rightDiameter = diameterOFTree(root.right);
		
		int dia = Math.max(left+right+1, Math.max(leftDiameter, rightDiameter));
		return dia;
	}
	private int height(Node node) {
		if(node == null)
			return 0;
		return 1+Math.max(height(node.left), height(node.right));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
