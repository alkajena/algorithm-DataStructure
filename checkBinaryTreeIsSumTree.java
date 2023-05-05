package TreeDS;

public class checkBinaryTreeIsSumTree {
	
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
	
	public int sum(Node node) {
		if(node == null)
			return 0;
		return sum(node.left)+node.data+sum(node.right);
	}
	
	public int isSumTree(Node root) {
		
		if(root == null || (root.left == null && root.right == null)) {
			return 1;
		}
			
		int left = sum(root.left);
		int right = sum(root.right);
		
		if((left+right == root.data) && isSumTree(root.left) == 1 && isSumTree(root.right) == 1) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		
		Node root=new Node(26);
        root.left=new Node(10);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(6);
        root.right.right=new Node(3);
        checkBinaryTreeIsSumTree ct = new checkBinaryTreeIsSumTree();
        int i = ct.isSumTree(root);
        if(i == 1) {
        	System.out.println("sumtree");
        }
        else {
        	System.out.println("No sumtree");
        }
	}
}
