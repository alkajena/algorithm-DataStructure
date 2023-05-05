package greedyAlgorithm;

public class ShortestPathInGraph {

	public static void main(String[] args) {
		  int graph[][]
		            = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
		                            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
		                            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
		                            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
		                            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
		                            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
		                            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
		                            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
		                            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        ShortestPathInGraph t = new ShortestPathInGraph();
		 
		        // Function call
        t.dijkstra(graph, 0);
        
	}

	private void dijkstra(int[][] graph, int src) {
		
		int V = 9;
		int[] dist = new int[V];
		boolean[] vertex = new boolean[V];
		
		for(int i =0; i < V;i++) {
			dist[i] = Integer.MAX_VALUE;
			vertex[i]=false;
		}
		dist[src] = 0;
		for(int i =0 ; i < V;i++) {
			
			int u = minIndex(dist, vertex);
			
			vertex[u] = true;
			
			for(int v =0; v< V;v++) {
				if(!vertex[v] && graph[u][v] != 0 && dist[u]+graph[u][v] < dist[v]) {
					dist[v] = dist[u]+graph[u][v];
				}
			}
		}
		
		for(int i =0; i < V; i++) {
			System.out.println(i + " \t\t " + dist[i]);
		}
	}

	private int minIndex(int[] dist, boolean[] vertex) {
		int v =9;
		int min = Integer.MAX_VALUE; int minIndex = -1;
		for(int i =0;i <v; i++) {
			if(vertex[i] == false && dist[i] < min) {
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	

}
