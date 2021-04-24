package parte1;

import java.util.ArrayList;

import parte2.Queue;

public class BellmanFord {
	
	int[] costos; //arreglo de costos desde la raiz al vertice i.
	boolean[] enQueue;
	Queue<Integer> q; 
	
	// lista de adj. y r como nodo raiz.
	public BellmanFord(ArrayList<Integer>[] adj,ArrayList<Integer>[] pesos, int r) {
		
		costos = new int[adj.length];
		enQueue = new boolean[adj.length];
		q = new Queue<Integer>();
		
		for (int i = 0; i < adj.length; i++) {
			costos[i] = Integer.MAX_VALUE; 
		}
		costos[r] = 0; // el costo de la raiz a la raiz es cero
		q.enqueue(r);
		enQueue[r] = true; //raiz esta en la cola
		while(!q.isEmpty())
		{
			int v = q.dequeue();
			enQueue[v] = false;
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
			if(!enQueue[d]) //si no esta el vertice d ya en la cola
			{
				q.enqueue(d);
				enQueue[d] = true;
			}
		}
	}
	
	public int[] retornarCostosMin()
	{
		return costos;
	}
}
