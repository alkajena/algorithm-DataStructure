package TreeDS;

import java.util.Deque;
import java.util.LinkedList;

import TreeDS.DeletionFromBT.Node;

public class InsertionToBST {
	
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public Node insertion(Node root, int data) {
		Deque<Node> dq = new LinkedList<>();
		dq.add(root);
		if(root == null) {
			return new Node(data);
		}
		Node temp = root;
		Node prev = null;
		while(temp != null) {
			if(data > temp.data) {
				prev = temp;
				temp = temp.right;
			}
			else if(data < temp.data){
				prev = temp;
				temp = temp.left;
			}
	    }
		if(data >prev.data) {
			prev.right = new Node(data);
		}
		else {
			prev.left = new Node(data);
		}
		return root;
		
	}

	public void inorderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		inorderTraversal(root.left);
		System.out.println("root.data : "+root.data);
		inorderTraversal(root.right);
	}

	
	public static void main(String[] args) {
		InsertionToBST in = new InsertionToBST();
		Node root =  in.insertion(null, 7);
		root = in.insertion(root, 2);
		root = in.insertion(root, 5);
		root = in.insertion(root, 1);
		root = in.insertion(root, 3);
		root = in.insertion(root, 6);
		
		in.inorderTraversal(root);
	}

}
