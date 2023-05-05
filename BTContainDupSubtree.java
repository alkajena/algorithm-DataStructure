package TreeDS;

import java.util.HashSet;

import TreeDS.BinaryTreeISPerfectOrNot.Node;

public class BTContainDupSubtree {
	
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
	
	public String BTHaveSubtree(Node root, HashSet<String> set) {
		String s ="";
		
		if(root == null) {
			s=s+"#";
		}
		String l = BTHaveSubtree(root.left, set);
		if(l.equals(s))
			return s;
		String r = BTHaveSubtree(root.right, set);
		if(r.equals(s))
			return s;
		
		s = s+root.data+"%"+l+"%"+r;
		
		if(set.contains(s)) {
			return "";
		}
		set.add(s);
		return s;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
