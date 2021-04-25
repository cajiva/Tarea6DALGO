package parte1;

import java.util.ArrayList;

public class FloydWarshall {

	int[][] costos;

	public FloydWarshall(ArrayList<Integer>[] adj,ArrayList<Integer>[] pesos)
	{
		int nV = adj.length;
		costos = new int[nV][nV];

		//inicializar todos los costos en aprox inf.
		for (int i = 0; i < nV; i++) {
			for (int j = 0; j < nV; j++) {
				if(i == j)
				{
					costos[i][j] = 0;
				}
				else
					costos[i][j] = Integer.MAX_VALUE;
			}
		}

		//se usa lista de adj y lista de pesos para inicializar tabla
		for (int i = 0; i < nV; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				int w = adj[i].get(j);
				costos[i][w] = pesos[i].get(j);
			}
		}
		
		//se asume que no hay costos negativos, por ende, no se busca ciclo neg.
		for (int i = 0; i < nV; i++) {
			//con 0 hasta i como vertices intermedios
			for (int s = 0; s < nV ; s++) {
				if(costos[s][i] == Integer.MAX_VALUE || i == s) continue;
				for (int d = 0; d < nV; d++) {
					if(costos[i][d] == Integer.MAX_VALUE) continue;
					if(costos[s][d] > costos[s][i] + costos[i][d])
					{
						//si es mejor pasar por i
						costos[s][d] = costos[s][i] + costos[i][d];
					}
				}
			}	
		}
	}
	
	public int[][] retornarCostosMin()
	{
		return costos;
	}
}
