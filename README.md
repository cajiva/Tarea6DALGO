# Tarea6DALGO

## Parte 1
**NOTA:** Se asume que las matrices de entrada no manejan pesos negativos.

**Tiempos de Ejecuci√≥n:**
1. **Distancias5:** <br />
	BellmanFord (milliseconds): 3 <br />
	Dijkstra (milliseconds): 2 <br />
	FloydWarshall (milliseconds): 0 <br />
2. **Distancias100:** <br />
	BellmanFord (milliseconds): 112 <br />
	Dijkstra (milliseconds): 93 <br />
	FloydWarshall (milliseconds): 19 <br />
3. **Distancias1000:** <br />
	BellmanFord (milliseconds): 9099 <br />
	Dijkstra (milliseconds): 5436 <br />
	FloydWarshall (milliseconds): 2105 <br />
	
## Parte 2
Para este punto se utiliza el ejemplo del enunciado pasado a un **.txt**. 
Si se desea crear otro ejemplo a probar se debe agregar el **.txt** en la carpeta **data** 
y hacer referencia a este en File del main en la clase **GrafoBFS**.

## Parte 3

Para encontrar si un grafo descrito por los **.txt** en la carpeta data 
tiene un ciclo y ver cual es el primero en formarse se debe correr la clase
**CicloDigrafoDFS** el cual utiliza **DFS** para encontrar si el grafo pasado de input
tiene al menos un ciclo y adem·s imprime este primer ciclo. <br />
Para escoger el **.txt** que se desea analizar se debe cambiar la referencia a File
que se tiene en el main de esta clase. 

	

	
