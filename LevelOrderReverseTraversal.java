package TreeDS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import TreeDS.LevelOrderTraversalInSpiralForm.Node;

public class LevelOrderReverseTraversal {
	
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
	
	public void levelOrderReverseTraversal(Node root) {
		Stack<Node> st = new Stack<>();
		Stack<Node> st1 = new Stack<>();
		st.push(root);
		st1.push(root);
		while(!st.isEmpty()) {
			Node temp = st.pop();
			if(temp.right != null) {
				st.push(temp.right);
				st1.push(temp.right);
			}
			if(temp.left != null) {
				st.push(temp.left);
				st1.push(temp.left);
			}
		}
		
		while(!st1.isEmpty()) {
			System.out.println(st1.peek().data);
			st1.pop();
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
		LevelOrderReverseTraversal in = new LevelOrderReverseTraversal();
		Node root =  in.insertion(null, 7);
		root = in.insertion(root, 2);
		root = in.insertion(root, 5);
		root = in.insertion(root, 1);
		root = in.insertion(root, 3);
		root = in.insertion(root, 6);
		
		in.levelOrderReverseTraversal(root);

	}

}
