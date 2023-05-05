package TreeDS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
			
import TreeDS.LevelOrderReverseTraversal.Node;

public class TraversalWithoutRecursion {
	
	class Node{
		int data;
		Node left;
		Node right;
		boolean iscovered;
		
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
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
		TraversalWithoutRecursion in = new TraversalWithoutRecursion();
		Node root =  in.insertion(null, 7);
		root = in.insertion(root, 2);
		root = in.insertion(root, 5);
		root = in.insertion(root, 1);
		root = in.insertion(root, 3);
		root = in.insertion(root, 6);
		
		in.inOrder(root);

	}
	
	public void inOrder(Node root) {
		if(root == null)
			return;
		Stack<Node> st = new Stack<>();
		Node temp = root;
		st.push(temp);
		while (temp != null || !st.isEmpty()) {
			
			while(temp != null) {
				temp = temp.left;
				st.push(temp);
			}
			
			int temp1 = st.peek().data;
			st.pop();
			System.out.println(temp.data);
			temp = temp.right;
			
		}
	}
	
	public void postOrder(Node root) {
		if(root == null)
			return;
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		st1.push(root);
		while (!st1.isEmpty()) {
			Node temp = st1.pop();
			st2.push(temp);
			if(temp.left != null) {
				st1.push(temp.left);
			}
			if(temp.right != null) {
				st1.push(temp.right);
			}
		}
		
		while(!st2.isEmpty()) {
			System.out.println(st2.peek().data);
			st2.pop();
		}
	}
	
	public void preOrder(Node root) {
		if(root == null)
			return;
		Stack<Node> st1 = new Stack<>();
		st1.push(root);
		while (!st1.isEmpty()) {
			Node temp = st1.pop();
			System.out.println(temp.data);
			if(temp.right != null) {
				st1.push(temp.right);
			}
			if(temp.left != null) {
				st1.push(temp.left);
			}
		}
	}

}
