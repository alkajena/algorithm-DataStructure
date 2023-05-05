package TreeDS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DiagonalTraversal {

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
	
	public void diaogonalReversal(Node root) {
		
		List<Node> list = new ArrayList<>();
		Deque<Node> qu = new LinkedList<>();
		if(root == null)
			return;
		Node temp = root;
		while(temp != null) {
			list.add(temp);
			if(temp.left != null) {
				qu.add(temp.left);
			}
			if(temp.right != null) {
				temp = temp.right;
			}
			else{
				if(!qu.isEmpty()) {
					temp = qu.peek();
					qu.remove();
				}
				else {
					temp = null;
				}
			}
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
