package TreeDS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Insert a node where you find empty space in level order tarversal 
public class InsertionToBT {
	
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
	//inorder
	public void traversal(Node node) {
		if(node == null) {
			return;
		}
	
		traversal(node.left);
		System.out.println("node.data : "+node.data);
		traversal(node.right);
		
	}

	public static void main(String[] args) {
		
		InsertionToBT in = new InsertionToBT();
		Node root =  in.insert(null, 1);
		root = in.insert(root, 2);
		root = in.insert(root, 3);
		root = in.insert(root, 4);
		root = in.insert(root, 5);
		root = in.insert(root, 6);
		root = in.insert(root, 7);
		
		in.traversal(root);

	}

}
