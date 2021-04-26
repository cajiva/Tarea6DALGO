package parte3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CicloDigrafoDFS {
	
	boolean[] enDfs; // marca los vertices usados en un dfs, en caso de que a partir de un hijo y sus hijos se vuelva a llegar al padre formando un ciclo.
	boolean[] marcados; // marcados[v] = true si ya se hizo dfs sobre v.
	Stack<Integer> pilaCiclo; // pila que guarda los vertices recorridos en el ciclo, null si no se forma ningun ciclo.
	int[] padre; // padre[v] = vertice de donde acaba de llegar a v.
	
	public CicloDigrafoDFS(ArrayList<Integer>[] adj) {
		
		enDfs = new boolean[adj.length];
		marcados = new boolean[adj.length];
		padre = new int[adj.length];
		
		for (int i = 0; i < adj.length; i++) {
			if(!marcados[i] && pilaCiclo == null) // si el vertice no se ha recorrido y todavia no se ha registrado ciclo.
				dfs(i,adj);
		}	
	}
	
	public void dfs(int v,ArrayList<Integer>[] adj ) {
		marcados[v] = true;
		enDfs[v] = true;
		
		for (int i = 0; i < adj[v].size(); i++) {
			
			int hijo = adj[v].get(i);
					
			if(pilaCiclo != null) //si ya hay un ciclo interrumpe el dfs 
				return;
			
			else if(!marcados[hijo]) { // se ecuentra vertice no marcado/recorrido, se registra su padre y se llama dfs sobre el.
				padre[hijo] = v;
				dfs(hijo, adj);
			}
			
			else if(enDfs[hijo]) { // si el hijo ya se habia tocado en el ciclo padre dfs, es decir se llego a un mismo vertice a traves de hijos, hay ciclo
				pilaCiclo = new Stack<Integer>();
				for (int j = v; j != hijo; j = padre[j]) { // recorre hacia atras, es decir pasando de padre en padre
					pilaCiclo.push(j);
				}
				pilaCiclo.push(hijo);
				pilaCiclo.push(v); 		
			}	
		}
		enDfs[v] = false; //termina el dfs de v entonces saca a v de la pila ya que no esta siendo usado en el dfs.
	}
	
	public boolean tieneCiclo()
	{
		return pilaCiclo != null;
	}
	
	public Iterable<Integer> ciclo()
	{
		return pilaCiclo;
	}
		
	public static void main(String[] args) throws FileNotFoundException {
		File grafo = new File ("./data/distances100.txt");
		Scanner scanner = new Scanner(grafo);

		ArrayList<Integer>[] adj = null; // lista con tamaño = # vertices con arreglos que llevan
		//los vertices a los que el vertice en la pos. se conecta.
		int pos = 0;
		boolean inic = false; // arreglos inicializados?
		while(scanner.hasNextLine())
		{
			String s[]= scanner.nextLine().split("\\s+");
			if(!inic)
			{
				adj = new ArrayList[s.length];
				for (int i = 0; i < adj.length; i++) {
					adj[i] = new ArrayList<>();
				}
				inic = true; // arreglos inicializados
			}
			for(int i = 0 ;i < s.length;i++){
				if(Integer.parseInt(s[i]) != -1 && pos!=i)//si hay conexion y no es con el mismo vertice
				{
					adj[pos].add(i); // agrega posicion/vertice que esta conectado al de la pos.
				}
			}
			pos++; // paso de line y paso de vertice.

		}	
		scanner.close();
		
		CicloDigrafoDFS ciclo = new CicloDigrafoDFS(adj);
		if(ciclo.tieneCiclo()) {
			System.out.println("Tiene ciclo");
			System.out.println();
		}
		else
			System.out.println("No tiene ciclo");
			
		if(ciclo.tieneCiclo())
		{
			System.out.println("Ciclo: ");
			for (int vertice : ciclo.ciclo()) {
				System.out.println(vertice + " ");
			}
		}
	}
}
