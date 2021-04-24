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

		File grafo = new File ("./data/distances5.txt");
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
		
		int[][] matriz = new int[adj.length][adj.length]; // matriz costos minimos
		
		for (int i = 0; i < adj.length; i++) {
			BellmanFord bf = new BellmanFord(adj, pesos, i);
			int[] costosMin = bf.retornarCostosMin();
			matriz[i] = costosMin; // le agrego la fila a la matriz
		}
		
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				System.out.printf("%5d",matriz[i][j]);
			}
			System.out.println();
		}	
	}
}
