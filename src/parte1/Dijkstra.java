package parte1;

import java.util.ArrayList;

public class Dijkstra {
	
	int[] costos; //arreglo de costos desde la raiz al vertice i.
	boolean[] enQueue;
	IndexMinPQ<Integer> q;
	
	// lista de adj. y r como nodo raiz.
	public Dijkstra(ArrayList<Integer>[] adj,ArrayList<Integer>[] pesos, int r) {
		
		costos = new int[adj.length];
		q = new IndexMinPQ<>(adj.length);
		
		for (int i = 0; i < adj.length; i++) {
			costos[i] = Integer.MAX_VALUE; 
		}
		costos[r] = 0; // el costo de la raiz a la raiz es cero
		
		q.insert(r, costos[r]);
		while(!q.isEmpty())
		{
			int v = q.delMin();
			//relajo todos los vertices adjacentes a v.
			for (int a = 0; a < adj[v].size(); a++) { 
				int d = adj[v].get(a); //vertice adj
				int w = pesos[v].get(a); //peso o costo de eje desde v hasta d.
				relax(v,d,w);
			}	
		}	
	}
	
	public void relax(int s, int d, int w) {
		if(costos[d] > costos[s] + w) // si es mejor pasar por s para llegar a d.
		{
			costos[d] = costos[s] + w;
			if(q.contains(d)) //si ya esta en la cola
			{
				q.decreaseKey(d, costos[d]);
			}
			else
				q.insert(d, costos[d]);
		}
	}
	
	public int[] retornarCostosMin()
	{
		return costos;
	}

}
