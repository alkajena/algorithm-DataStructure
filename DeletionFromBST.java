package TreeDS;

import java.util.Deque;
import java.util.LinkedList;

import TreeDS.InsertionToBST.Node;

public class DeletionFromBST {
	
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public Node deletion(Node root, int data) {
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
			else {
				if(data > prev.data) {
					prev.right = null;
				}
				else {
					prev.left = null;
				}
				break;
			}
		}
		return root;
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
	public static void main(String[] args) {
		DeletionFromBST in = new DeletionFromBST();
		Node root =  in.insertion(null, 7);
		root = in.insertion(root, 2);
		root = in.insertion(root, 5);
		root = in.insertion(root, 1);
		root = in.insertion(root, 3);
		root = in.insertion(root, 6);
		
		//in.inorderTraversal(root);
		//in.deletion(root, 5);
		//in.inorderTraversal(root);
		in.levelOrderTraversal(root);

	}

	private void inorderTraversal(Node root) {
		if(root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.println("the node is : "+root.data);
		inorderTraversal(root.right);
		
	}
	
	private void preTraversal(Node root) {
		if(root == null) {
			return;
		}
		System.out.println("the node is : "+root.data);
		inorderTraversal(root.left);
		inorderTraversal(root.right);
		
	}
	
	private void postTraversal(Node root) {
		if(root == null) {
			return;
		}
		inorderTraversal(root.left);
		inorderTraversal(root.right);
		System.out.println("the node is : "+root.data);
	}
	
	private void levelOrderTraversal(Node root) {
		Deque<Node> dq = new LinkedList<>();
		dq.add(root);
		while(!dq.isEmpty()) {
			Node temp = dq.remove();
			System.out.println("the node is : "+temp.data);
			if(temp.left != null) {
				dq.add(temp.left);
			}
			if(temp.right != null) {
				dq.add(temp.right);
			}
		}
	}

}
