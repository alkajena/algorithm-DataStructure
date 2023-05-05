package sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
//Acyclic directed graph
public class TopologicalSort {
	List<List<Integer>> adj = new ArrayList<>();
		int v;
	
		
		public TopologicalSort(int v) {
			this.v = v;	
			for(int i=0; i<v; i++) {
				adj.add(new ArrayList<Integer>());
			}
		}
	
	public void addEdge(int u, int v) {
		adj.get(u).add(v);
	}
	public void sortUtil(TopologicalSort g) {
		Stack<Integer> s = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		for(int i=0; i < g.v;i++) {
			if(!visited.contains(i)) {
				sort(i, visited, s);
			}
		}
		System.out.println("stack size is : "+s.size());
	}

	private void sort(int i, Set<Integer> visited, Stack<Integer> s) {
		visited.add(i);
		for(int j=0; j < adj.get(i).size();j++) {
			if(!visited.contains(i)) {
				sort(j, visited, s);
			}
		}
		s.push(new Integer(i));
	}

	public static void main(String[] args) {
		TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.sortUtil(g);

	}

}
