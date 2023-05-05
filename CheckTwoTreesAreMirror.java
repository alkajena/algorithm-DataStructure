package TreeDS;

public class CheckTwoTreesAreMirror {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left =null;
			right = null;
		}
	}
	
	public boolean checkTwoTreesAreMirror(Node root1, Node root2) {
		if(root1 == null && root2 ==null)
			return true;
		if(root1 == null || root2 ==null)
			return false;
		return root1.data == root2.data && checkTwoTreesAreMirror(root1.left, root2.right) && checkTwoTreesAreMirror(root1.right, root2.left);
	}

	public static void main(String[] args) {
		Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
 
        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);
        
        CheckTwoTreesAreMirror ct = new CheckTwoTreesAreMirror();
        if(ct.checkTwoTreesAreMirror(a, b)) {
        	System.out.println("Mirror tree");
        }

	}

}
