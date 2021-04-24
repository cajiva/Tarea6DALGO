package parte1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import parte2.GrafoBFS;
import parte2.Queue;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {

		File grafo = new File ("./data/distances100.txt");
		Scanner scanner = new Scanner(grafo);

		ArrayList<Integer>[] adj = null; // lista con tamaño = # vertices con arreglos que llevan
		//los vertices a los que el vertice en la pos. se conecta.
		ArrayList<Integer>[] pesos = null; // lista con los pesos/costos de los ejes en mismas pos. de adj.
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

				pesos = new ArrayList[s.length];
				for (int i = 0; i < pesos.length; i++) {
					pesos[i] = new ArrayList<>();
				}

				inic = true; // arreglos inicializados
			}
			for(int i = 0 ;i < s.length;i++){
				if(Integer.parseInt(s[i]) != -1 && pos!=i)//si hay conexion y no es con el mismo vertice
				{
					adj[pos].add(i); // agrega posicion/vertice que esta conectado al de la pos.
					pesos[pos].add(Integer.parseInt(s[i])); // agrega peso del eje recien registrado en adj.
				}
			}
			pos++; // paso de line y paso de vertice.

		}	
		scanner.close();

		int[][] mBF = new int[adj.length][adj.length]; // matriz costos minimos

		long stBF = System.currentTimeMillis();
		for (int i = 0; i < adj.length; i++) {
			BellmanFord bf = new BellmanFord(adj, pesos, i);
			int[] costosMin = bf.retornarCostosMin();
			mBF[i] = costosMin; // le agrego la fila a la matriz
		}
		long etBF = System.currentTimeMillis();
		
		System.out.println("Tiempo ejecucion BellmanFord (milliseconds): "+(etBF-stBF));

//		System.out.println("Matriz Costos Mínimos BellmanFord");
//		for (int i = 0; i < adj.length; i++) {
//			for (int j = 0; j < adj.length; j++) {
//				System.out.printf("%5d",mBF[i][j]);
//			}
//			System.out.println();
//		}	

		int[][] mD = new int[adj.length][adj.length]; // matriz costos minimos

		long stD = System.currentTimeMillis();
		for (int i = 0; i < adj.length; i++) {
			Dijkstra dij = new Dijkstra(adj, pesos, i);
			int[] costosMin = dij.retornarCostosMin();
			mD[i] = costosMin; // le agrego la fila a la matriz
		}
		long etD = System.currentTimeMillis();
		System.out.println("Tiempo ejecucion Dijkstra (milliseconds): "+(etD-stD));

//		System.out.println();
//		System.out.println("Matriz Costos Mínimos Dijkstra");
//		for (int i = 0; i < adj.length; i++) {
//			for (int j = 0; j < adj.length; j++) {
//				System.out.printf("%5d",mD[i][j]);
//			}
//			System.out.println();
//		}	

	}
}
