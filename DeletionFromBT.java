package TreeDS;

import java.util.Deque;
import java.util.LinkedList;

import TreeDS.InsertionToBT.Node;


public class DeletionFromBT {
	
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
	
	public Node deletion(Node root, int data) {
		Deque<Node> dq = new LinkedList<>();
		dq.add(root);
		Node temp = root;
		if(root == null) {
			return null;
		}
		Node prev = null;
		while(temp.right != null) {
			prev = temp;
			temp = temp.right;
		}
		while(!dq.isEmpty()) {
			Node temp1 = dq.remove();
			if(temp1.left != null && temp1.left.data == data) {
				Node left = temp1.left.left;
				Node right = temp1.left.right;
				temp1.left = new Node(temp.data);
				temp1.left.left = left;
				temp1.left.right = right;
				prev.right = null;
				break;
			}
			else if(temp1.left != null) {
				dq.add(temp1.left);
			}
			if(temp1.right != null && temp1.right.data == data) {
				Node left = temp1.right.left;
				Node right = temp1.right.right;
				temp1.right = new Node(temp.data);
				temp1.right.left = left;
				temp1.right.right = right;
				prev.right = null;
				break;
			}
			else if(temp1.right != null) {
				dq.add(temp1.right);
			}
		}
		return root;
	}
	
public Node insert(Node root, int data) {
		
		if(root == null) {
			return new Node(data);
		}
		else {
			Deque<Node> st = new LinkedList<>();
			st.add(root);
			while(!st.isEmpty()) {
				Node temp = st.remove();
				Node left = temp.left;
				Node right = temp.right;
				if(left != null) {
					st.add(left);
				}
				else {
					temp.left = new Node(data);
					break;
				}
				if(right != null) {
					st.add(right);
				}
				else {
					temp.right = new Node(data);
					break;
				}
			}
			
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
		DeletionFromBT in = new DeletionFromBT();
		Node root =  in.insert(null, 1);
		root = in.insert(root, 2);
		root = in.insert(root, 3);
		root = in.insert(root, 4);
		root = in.insert(root, 5);
		root = in.insert(root, 6);
		root = in.insert(root, 7);
		
		//in.inorderTraversal(root);
		
		root = in.deletion(root, 4);
		
		in.inorderTraversal(root);

	}

}
