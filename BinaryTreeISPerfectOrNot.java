package TreeDS;

public class BinaryTreeISPerfectOrNot {
	
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
	public int depth(Node root) {
		int d = 0;
		if(root == null)
			return 0;
		while(root != null) {
			d++;
			root = root.left;
		}
		return d;
	}
	public boolean binaryTreeISPerfectOrNot(Node root) {
		int d = depth(root);
		int level = 0;
		return perfectTree(root, d, level);
	}

	private boolean perfectTree(Node root, int d, int level) {
		
		if(root == null)
			return true;
		if(root.left == null && root.right == null)
			return d == level+1;
		if(root.left == null || root.right == null)
			return false;
		return perfectTree(root.left, d, level+1) && perfectTree(root.right, d, level+1);
	}
	public static void main(String[] args) {
		Node root = new Node(10);
	    root.left = new Node(20);
	    root.right = new Node(30);
	 
	    root.left.left = new Node(40);
	    root.left.right = new Node(50);
	    root.right.left = new Node(60);
	    root.right.right = new Node(70);
	    
	    BinaryTreeISPerfectOrNot bt = new BinaryTreeISPerfectOrNot();
	    if(bt.binaryTreeISPerfectOrNot(root)) {
	    	System.out.println("Perfect tree");
	    }
	 

	}

}
