package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementRight {

	public static Stack<Integer> st = new Stack<>();
	@SuppressWarnings("unchecked")
	public void nextGreaterElement(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for(int i = arr.length-1; i >= 0 ;i--) {
			if(st.size() == 0) {
				list.add(-1);
			}
			else {
				if(st.size() > 0 && (Integer)st.peek() > arr[i]) {
					list.add((Integer)st.peek());
				}
				else if(st.size() > 0 && (Integer)st.peek() < arr[i]) {
					while(st.size() > 0 && (Integer)st.peek() <= arr[i]) {
						st.pop();
					}
					if(st.size() == 0) {
						list.add(-1);
					}
					else if((Integer)st.peek() > arr[i]) {
						list.add((Integer)st.peek());
					}
				}
			}
			st.push(arr[i]);
		}
		Collections.reverse(list);
		for(Integer i : list) {
			System.out.println("number is : "+i);
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,1,3,1,6,5,8,10,2};
		new NextGreaterElementRight().nextGreaterElement(arr);

	}

}
