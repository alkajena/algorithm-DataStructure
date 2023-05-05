package TreeDS;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import TreeDS.BinaryTreeISPerfectOrNot.Node;

public class SubtreeWithGivenSumInBT {
	
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
	
	public boolean subtreeWithGivenSumInBT(Node root, int tsum) {
		Stack<Node> st = new Stack<>();
		st.push(root);
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		while(!st.isEmpty()) {
			Node temp = st.pop();
			if(map.containsKey(sum-tsum))
				return true;
			map.put(sum+temp.data, 1);
			if(temp.right != null) {
				st.push(temp.right);
			}
			if(temp.left != null) {
				st.push(temp.left);
			}
			
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
