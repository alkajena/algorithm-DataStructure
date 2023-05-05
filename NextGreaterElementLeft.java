package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementLeft {

	public Stack<Integer> stack = new Stack<>();
	
	public void nextGreaterElementLeft(int[] arr) {
		List<Integer> list = new ArrayList<>();
		
		for(int i =0; i < arr.length; i++) {
			
			if(stack.size() == 0) {
				list.add(-1);
			}
			else {
				if(stack.size() > 0 && (Integer)stack.peek() > arr[i]) {
					list.add((Integer)stack.peek());
				}
				else if(stack.size() > 0 && (Integer)stack.peek() < arr[i]) {
					while(stack.size() > 0 && (Integer)stack.peek() <= arr[i]) {
						stack.pop();
					}
					if(stack.size() == 0) {
						list.add(-1);
					}
					else if ((Integer)stack.peek() > arr[i]) {
						list.add((Integer)stack.peek());
					}
				}
			}
			stack.push(arr[i]);
		}
		for(Integer i : list) {
			System.out.println("number is : "+i);
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,1,3,1,6,5,8,10,2};
		new NextGreaterElementLeft().nextGreaterElementLeft(arr);
	}

}
