package TreeDS;

import java.util.Deque;
import java.util.LinkedList;

import TreeDS.DeletionFromBST.Node;

public class MaximumDepthOrHeight {
	
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
	
	public int maximumDepthOrHeight(Node root) {
		Deque<Node> dq = new LinkedList<>();
		dq.add(root);
		int height = 0; 
		while(!dq.isEmpty()) {
			int size = dq.size();
			for(int i = 0 ;i <size; i++) {
			Node temp = dq.remove();
			if(temp.left != null) {
				dq.add(temp.left);
			}
			if(temp.right != null) {
				dq.add(temp.right);
			}
		}
			height+=1;
	}
		return height;
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
		MaximumDepthOrHeight in = new MaximumDepthOrHeight();
		Node root =  in.insertion(null, 7);
		root = in.insertion(root, 2);
		root = in.insertion(root, 5);
		root = in.insertion(root, 1);
		root = in.insertion(root, 3);
		root = in.insertion(root, 6);
		
		//in.inorderTraversal(root);
		//in.deletion(root, 5);
		//in.inorderTraversal(root);
		System.out.print("the max height/depth is : "+new MaximumDepthOrHeight().maximumDepthOrHeight(root));

	}

}
