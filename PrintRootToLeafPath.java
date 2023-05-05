package TreeDS;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import TreeDS.BinaryTreeISPerfectOrNot.Node;

public class PrintRootToLeafPath {

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
	
	public void printRootToLeafPath(Node root) {
		Map<Node, Node> map = new HashMap<>();
		Stack<Node> st = new Stack<>();
		st.push(root);
		map.put(root, null);
		while(!st.isEmpty()) {
			Node temp = st.pop();
			if(temp.left == null && temp.right == null)
				printRootToLeaf(map, temp);
			if(temp.right != null) {
				st.push(temp.right);
				map.put(temp.right, temp);
			}
			if(temp.left != null) {
				st.push(temp.left);
				map.put(temp.left, temp);
			}
		}
	}
	private void printRootToLeaf(Map<Node, Node> map, Node temp) {
		Stack<Node> st = new Stack<>();
		while(temp != null) {
			st.push(temp);
			temp = map.get(temp);
		}
		while(!st.isEmpty()) {
			System.out.println(st.peek());
			st.pop();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
