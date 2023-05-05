package TreeDS;

import java.util.Deque;
import java.util.LinkedList;

public class CheckTwoNodesAreCousin {

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
	
	public void checkTwoNodesAreCousin(Node root, Node a , Node b) {
		
		Deque<Node> dq = new LinkedList<>();
		dq.add(root);
		int la = 0;
		int lb= 0;
		boolean sameLevel = false;
		while(!dq.isEmpty()) {
			la = 0;
			lb = 0;
			sameLevel = false;
			int size = dq.size();
			for(int i =0; i < size;i++) {
				Node temp = dq.remove();
				if(temp.left != null) {
					dq.add(temp.left);
					if(temp.left.data == a.data) {
						la++;
					}
					if(temp.left.data == b.data) {
						lb++;
					}
				}
				if(temp.right != null) {
					dq.add(temp.right);
					if(temp.right.data == a.data) {
						la++;
					}
					if(temp.right.data == b.data) {
						lb++;
					}
				}
				if(la != 0 && lb != 0 && la == lb) {
					System.out.println("same level");
					sameLevel =true;
					break;
				}
			}
			if(sameLevel) {
				break;
			}
			
		}
		
		if(sameLevel && !isSibling(root, a, b)) {
			System.out.println("cousins");
		}
	}
	
	public boolean isSibling(Node root, Node a, Node b) {
		if(root == null)
			return false;
		return ((root.left == a && root.right == b) ||
				(root.right == a && root.left == b) ||
				isSibling(root.left, a, b) || isSibling(root.right, a, b));
	}
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
 
        Node Node1, Node2;
        Node1 = root.left.left;
        Node2 = root.right.right;
        
        CheckTwoNodesAreCousin ck = new CheckTwoNodesAreCousin();
        ck.checkTwoNodesAreCousin(root, Node1, Node2);

	}

}
