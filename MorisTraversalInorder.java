package TreeDS;

import java.util.Deque;
import java.util.LinkedList;

import TreeDS.LevelOrderTraversalInSpiralForm.Node;

public class MorisTraversalInorder {

	class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public void morisTraversal(Node root) {
		
		if(root == null)
			return;
		Node current = root;
		while(current != null) {
		if(current.left == null) {
			System.out.println(current.data);
			current = current.right;
		}
		else {
			Node pre = current.left;
			while(pre.right != null && pre.right != current) {
				pre = pre.right;
			}
			if(pre.right == null) {
				pre.right = current;
				current = current.left;
			}
			else {
				pre.right = null;
				System.out.println(current.data);
				current = current.right;
			}
		}
		}
	}
	
	public void morisTraversalPreOrder(Node root) {
		if(root == null)
			return;
		Node current = root;
		while(current != null) {
			if(current.left == null) {
				System.out.println(current.data);
				current = current.right;
			}
			else {
				Node pre = current.left;
				while(pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if(pre.right == current) {
					pre.right = null;
					current = current.right;
				}
				else {
					System.out.println(current.data);
					pre.right = current;
					current = current.left;
				}
			}
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
	public static void main(String[] args) {
		MorisTraversalInorder in = new MorisTraversalInorder();
		Node root =  in.insertion(null, 7);
		root = in.insertion(root, 2);
		root = in.insertion(root, 5);
		root = in.insertion(root, 1);
		root = in.insertion(root, 3);
		root = in.insertion(root, 6);
		
		in.morisTraversal(root);

	}

}
