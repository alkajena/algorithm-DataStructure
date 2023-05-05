package TreeDS;

import TreeDS.InsertionToBST.Node;

public class DepthOfBTFromPreorder {

	public int findDepth(String tree, int n) {
		int index = 0;
		return findDepthFromPreOrder(tree, n, index);
	}
	private int findDepthFromPreOrder(String tree, int n, int index) {
		if(index >= n || tree.charAt(index) == 'l') {
			return 0;
		}
		index++;
		int left = findDepthFromPreOrder(tree, n, index);
		index++;
		int right = findDepthFromPreOrder(tree, n, index);
		int depth = Math.max(left, right)+1;
		return depth;
	}
	public static void main(String[] args) {
		DepthOfBTFromPreorder in = new DepthOfBTFromPreorder();
		String tree = "nlnnlll";
        int n = tree.length();
        System.out.println(in.findDepth(tree, n));
	}

}
