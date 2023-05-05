package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextSmallerElementLeft {
public static Stack<Integer> st= new Stack<>();
	
	public void nextSmallerElement(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < arr.length ;i++) {
			if(st.size() == 0) {
				list.add(-1);
			}
			else {
				if(st.size() > 0 && (Integer)st.peek() < arr[i]) {
					list.add((Integer)st.peek());
				}
				else if (st.size() > 0 && (Integer)st.peek() > arr[i]) {
					while(st.size() > 0 && (Integer)st.peek() >= arr[i]) {
						st.pop();
					}
					if(st.size() == 0) {
						list.add(-1);
						
					}else if((Integer)st.peek() < arr[i]) {
						list.add((Integer)st.peek());
					}
				}
				
			}
			st.push(arr[i]);
		}
		for(int x : list) {
			System.out.println("number is : "+x);
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,1,3,1,6,5,8,10,2};
		new NextSmallerElementLeft().nextSmallerElement(arr);
	}

}
