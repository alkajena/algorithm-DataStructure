package stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StockSpanProblem {

	@SuppressWarnings("unchecked")
	public void stockSpan(int[] arr) {
		Stack<Map<Integer, Integer>> st = new Stack();
		List<Integer> list = new ArrayList<>();
		for(int i =0; i <arr.length; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			if(st.size() == 0) {
				list.add(-1);
			}
			else if(st.size() > 0 && ((Map<Integer, Integer>)st.peek()).entrySet().iterator().next().getValue() > arr[i]) {
				list.add(((Map<Integer, Integer>)st.peek()).entrySet().iterator().next().getKey());
			}
			else if(st.size() > 0 && ((Map<Integer, Integer>)st.peek()).entrySet().iterator().next().getValue() < arr[i]) {
				while(st.size() > 0 && ((Map<Integer, Integer>)st.peek()).entrySet().iterator().next().getValue() < arr[i]) {
					st.pop();
				}
				if(st.size() == 0) {
					list.add(-1);
				}
				else if(((Map<Integer, Integer>)st.peek()).entrySet().iterator().next().getValue() > arr[i]) {
					list.add(((Map<Integer, Integer>)st.peek()).entrySet().iterator().next().getKey());
				}
			}
			map.put(i, arr[i]);
			st.push(map);
		}
		
		for(int i = 0; i <list.size();i++) {
			System.out.println(i-list.get(i));
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {100, 80, 60, 70, 60, 75, 85};
		new StockSpanProblem().stockSpan(arr);
		
		
	}

}
