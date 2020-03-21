package controller;

import java.util.*; 
/**
 * 
 * @author Sheran, Dhananjay
 * @since 03-12-2020
 * @Description: This class is used to represent the connection between the different diagrams 
 * and to check whether the diagrams follow the predefined rules. 
 */
class Graph { 
	private int V;
	private ArrayList<LinkedList<Integer>> adj;
	
	Graph(Integer v){ 
		V = v; 
		adj = new ArrayList<LinkedList<Integer>>();
		for (int i=0; i<v; ++i) {
			adj.add(new LinkedList<Integer>()); 
		}			
	} 

	void addEdge(int v,int w){ 
		adj.get(v).add(w); 
	} 
	
	public boolean checkConnection(int s){ 
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();		 
		visited[s]=true; 
		queue.add(s); 

		while (queue.size() != 0) { 			
			s = queue.poll(); 			
			Iterator<Integer> i = adj.get(s).listIterator(); 
			while (i.hasNext()) 
			{ 
				int n = i.next(); 
				if (!visited[n]) 
				{ 
					visited[n] = true; 
					queue.add(n); 
				} 
			} 
		} 		
		
		for(boolean flag: visited) {
			if (!flag) {
				return false;
			}
		}
		
		return true;
	} 
	
}
