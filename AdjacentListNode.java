package greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AdjacentListNode {
	
	public int vertex;
	public int weight;
	
	public AdjacentListNode() {};
	
	public AdjacentListNode(int v, int w) {
		this.vertex = v;
		this.weight = w;
	}
	

	public int getVertex() {
		return vertex;
	}
	public int getWeight() {
		return weight;
	}
	public static void main(String[] args) {
		int v = 9;
		int src = 0 ;
		List<List<AdjacentListNode>> graph = new ArrayList<>();
		for(int i =0; i < v; i++) {
			graph.add(new ArrayList<>());
		}
		
			graph.get(0).add(new AdjacentListNode(1,4));
			graph.get(0).add(new AdjacentListNode(7, 8));
			graph.get(1).add(new AdjacentListNode(2, 8));
	        graph.get(1).add(new AdjacentListNode(7, 11));
	        graph.get(1).add(new AdjacentListNode(0, 7));
	        graph.get(2).add(new AdjacentListNode(1, 8));
	        graph.get(2).add(new AdjacentListNode(3, 7));
	        graph.get(2).add(new AdjacentListNode(8, 2));
	        graph.get(2).add(new AdjacentListNode(5, 4));
	        graph.get(3).add(new AdjacentListNode(2, 7));
	        graph.get(3).add(new AdjacentListNode(4, 9));
	        graph.get(3).add(new AdjacentListNode(5, 14));
	        graph.get(4).add(new AdjacentListNode(3, 9));
	        graph.get(4).add(new AdjacentListNode(5, 10));
	        graph.get(5).add(new AdjacentListNode(4, 10));
	        graph.get(5).add(new AdjacentListNode(6, 2));
	        graph.get(6).add(new AdjacentListNode(5, 2));
	        graph.get(6).add(new AdjacentListNode(7, 1));
	        graph.get(6).add(new AdjacentListNode(8, 6));
	        graph.get(7).add(new AdjacentListNode(0, 8));
	        graph.get(7).add(new AdjacentListNode(1, 11));
	        graph.get(7).add(new AdjacentListNode(6, 1));
	        graph.get(7).add(new AdjacentListNode(8, 7));
	        graph.get(8).add(new AdjacentListNode(2, 2));
	        graph.get(8).add(new AdjacentListNode(6, 6));
	        graph.get(8).add(new AdjacentListNode(7, 1));
	        
	        findAdjacentListNode(src, v, graph);

	}

	private static void findAdjacentListNode(int src, int v, List<List<AdjacentListNode>> graph) {
		
		int[] dist = new int[v];
		
		for(int i =0; i <v;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		PriorityQueue<AdjacentListNode> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		
		queue.add(new AdjacentListNode(src, 0));
		
		while(queue.size() > 0) {
			AdjacentListNode curr = queue.poll();
			for(AdjacentListNode n : graph.get(curr.getVertex())) {
				if((n.getWeight()+dist[curr.getVertex()]) < dist[n.getVertex()]) {
					dist[n.getVertex()] = n.getWeight()+dist[curr.getVertex()];
					queue.add(new AdjacentListNode(n.getVertex(), dist[n.getVertex()]));
				}
			}
			
		}
		for(int i : dist) {
			System.out.println("vertex is : "+i);
		}
	}

}
