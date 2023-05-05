package TreeDS;
//code is same for levelorder and inorder traversal
public class TreeFromInOrderAndPreOrder {

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
	
	public Node treeFromInOrderAndPreOrder(int[] in, int[] pre, int inStart, int inEnd) {
		
		if(inStart > inEnd) {
			return null;
		}
		
		if(inStart == inEnd) {
			return new Node(in[inStart]);
		}
		int index = 0;
		Node root = null;
		boolean found = false;
		for(int i =0; i < pre.length; i++) {
			int data = pre[i];
			for(int j = inStart ; j < inEnd; j++) {
				if(data == in[j]) {
					root = new Node(data);
					index = j;
					found = true;
				}
				if(found) {
					break;
				}
			}
			if(found) {
				break;
			}
		}
		root.left = treeFromInOrderAndPreOrder(in, pre, inStart, index-1);
		root.right = treeFromInOrderAndPreOrder(in, pre, index+1, inEnd);
		
		return root;
		
	}
	
	public static void main(String[] args) {
		int[] in= {4, 2, 5, 1, 6, 3, 7};
		int[] pre = {1, 2, 4, 5, 3, 6, 7};
		TreeFromInOrderAndPreOrder tr = new TreeFromInOrderAndPreOrder();
		Node root = tr.treeFromInOrderAndPreOrder(in, pre, 0, in.length-1);
		System.out.println(root.data);
	}

}
