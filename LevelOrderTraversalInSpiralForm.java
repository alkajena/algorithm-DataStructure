package TreeDS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import TreeDS.InsertionToBST.Node;

public class LevelOrderTraversalInSpiralForm {
	
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
	
	public void levelOrderTraversalInSpiralForm(Node root) {
		
		Stack<Node> st = new Stack<>();
		st.push(root);
		System.out.println(root.data);
		int count = 1;
		while(!st.isEmpty()) {
			int size = st.size();
			for(int i =0; i < size; i++) {
				if(count % 2 != 0) {
					Node temp = st.pop();
					if(temp.left != null) {
						st.push(temp.left);
						System.out.println(temp.left.data);
					}
					if(temp.right != null) {
						st.push(temp.right);
						System.out.println(temp.right.data);
					}	
				}
				else{
					Node temp = st.pop();
					if(temp.right != null) {
						st.push(temp.right);
						System.out.println(temp.right.data);
					}
					if(temp.left != null) {
						st.push(temp.left);
						System.out.println(temp.left.data);
					}
				}
			}
			count +=1;
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
		LevelOrderTraversalInSpiralForm in = new LevelOrderTraversalInSpiralForm();
		Node root =  in.insertion(null, 7);
		root = in.insertion(root, 2);
		root = in.insertion(root, 5);
		root = in.insertion(root, 1);
		root = in.insertion(root, 3);
		root = in.insertion(root, 6);
		
		in.levelOrderTraversalInSpiralForm(root);

	}

}
