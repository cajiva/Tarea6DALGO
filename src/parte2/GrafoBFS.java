package parte2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GrafoBFS {

	boolean[] marcado;
	int[] id;
	int[] size;
	int cont;
	//se le debe pasar el grafo
	public GrafoBFS(ArrayList<Integer>[] lista) {
		marcado = new boolean[lista.length];
		id = new int[lista.length];
		size = new int[lista.length];
		for (int v = 0; v < lista.length; v++) {
			if (!marcado[v]) {
				bfs(lista, v);
				cont++;
			}
		}
	}

	private void bfs(ArrayList<Integer>[] lista, int s) {
		Queue<Integer> q = new Queue<Integer>();
		marcado[s] = true; 
		id[s] = cont; // le asigno componente
		size[cont]++; // aumento numero de vertices con id cont
		q.enqueue(s);

		while (!q.isEmpty()) {
			int v = q.dequeue();
			for (int i = 0; i < lista[v].size(); i++) //por los adj a v.
			{
				int w = lista[v].get(i);//vertice adj
				if (!marcado[w]) {
					marcado[w] = true;
					id[w] = cont;
					size[cont]++;
					q.enqueue(w);
				}
			}
		}
	}

	public int darCont()
	{
		return cont;
	}


	public static void main(String[] args) throws FileNotFoundException {

		File grafo = new File ("./data/Grafo Ejm Parte 2 Tarea 6 Dalgo.txt");
		Scanner scanner = new Scanner(grafo);

		ArrayList<Integer>[] adj = null; // lista con tamaño == # vertices con arreglos que llevan
		//los vertices a los que el vertice en la pos. se conecta.
		int pos = 0;
		boolean inic = false; // arreglo inicializado?
		while(scanner.hasNextLine())
		{
			String s[]= scanner.nextLine().split(" ");
			if(!inic)
			{
				adj = new ArrayList[s.length];
				for (int i = 0; i < adj.length; i++) {
					adj[i] = new ArrayList<>();
				}
				inic = true; // arreglo inicializado
			}
			for(int i =0 ;i < s.length;i++){
				if(Integer.parseInt(s[i]) == 1)
				{
					adj[pos].add(i); // agrega posicion/vertice que esta conectado al de la pos.
				}
			}
			pos++; // paso de line y paso de vertice.

		}

		GrafoBFS graph = new GrafoBFS(adj);

		int n = graph.darCont(); // numero de componentes conectados
		System.out.println("# Componentes: "+n);

		Queue<Integer>[] components = (Queue<Integer>[]) new Queue[n]; //arr de colas con los comp.

		for (int i = 0; i < n; i++) {
			components[i] = new Queue<Integer>();
		}
		for (int v = 0; v < adj.length; v++) {
			components[graph.id[v]].enqueue(v);
		}

		// print results
		for (int i = 0; i < n; i++) {
			for (int v : components[i]) {
				System.out.println(v + " ");
			}
			System.out.println();;
		}
	}
}
