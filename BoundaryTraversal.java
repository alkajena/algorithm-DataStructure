package TreeDS;

public class BoundaryTraversal {

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
	
	public void boundaryTraversal(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root	.data);
		boundaryLeftTraversal(root.left);
		leafTraversal(root.left);
		leafTraversal(root.right);
		boundaryRightTraversal(root.right);
		
	}
	private void boundaryRightTraversal(Node right) {
		if(right == null)
			return;
		if(right.right != null) {
			boundaryRightTraversal(right.right);
			System.out.println(right.data);
			
		}
		else if(right.left != null) {
			boundaryRightTraversal(right.left);
			System.out.println(right.data);
		}
	}
	private void leafTraversal(Node node) {
		if(node == null) {
			return;
		}
		leafTraversal(node.left);
		if(node.left == null && node.right == null) {
			System.out.println(node.data);
		}
		leafTraversal(node.right);
		
	}
	private void boundaryLeftTraversal(Node left) {
		
		if(left == null)
			return;
		if(left.left != null) {
			System.out.println(left.data);
			boundaryLeftTraversal(left.left);
		}
		else if(left.right != null) {
			System.out.println(left.data);
			boundaryLeftTraversal(left.right);
		}
		
	}
	public static void main(String[] args) {
		BoundaryTraversal bt = new BoundaryTraversal();
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right.right = new Node(25);
		bt.boundaryTraversal(root);

	}

}
