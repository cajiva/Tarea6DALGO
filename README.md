# Tarea6DALGO

## Parte 1
**NOTA:** Se asume que las matrices de entrada no manejan pesos negativos.

La matriz que se va a probar se decide en el main donde se crea un File con 
referencia al archivo .txt de esta que se encuentra en la carpeta **data**.<br />

Las salidas generadas al correr el main son las matrices de costos minimos
generadas por cada algoritmo y sus tiempos de ejecución. <br />

**Tiempos de EjecuciÃ³n:**
1. **Distancias5:** <br />
	BellmanFord (milliseconds): 3 <br />
	Dijkstra (milliseconds): 2 <br />
	FloydWarshall (milliseconds): 0 <br />
2. **Distancias100:** <br />
	BellmanFord (milliseconds): 112 <br />
	Dijkstra (milliseconds): 93 <br />
	FloydWarshall (milliseconds): 19 <br />
3. **Distancias1000:** <br />
	BellmanFord (milliseconds): 2497 <br />
	Dijkstra (milliseconds): 2166 <br />
	FloydWarshall (milliseconds): 2556 <br />
	**NOTA:** Recurde usar distances1000_202110.txt.	
	
## Parte 2

**Entradas:**<br />
Para este punto se utiliza el ejemplo del enunciado pasado a un **.txt**. 
Si se desea crear otro ejemplo a probar se debe agregar el **.txt** en la carpeta **data** 
y hacer referencia a este en File del main en la clase **GrafoBFS**. <br />

**Salidas:** <br />
Se imprime el número de componentes encontrados en el grafo formado por la matriz de 
entrada y además se imprimen los vertices que componen cada componente. Estos están
espaciados de acuerdo con el componente en el que se encuentran.

## Parte 3

Para encontrar si un grafo descrito por los **.txt** en la carpeta data 
tiene un ciclo y ver cual es el primero en formarse se debe correr la clase
**CicloDigrafoDFS** el cual utiliza **DFS** para encontrar si el grafo pasado de input
tiene al menos un ciclo y además imprime este primer ciclo. <br />
Para escoger el **.txt** que se desea analizar se debe cambiar la referencia a File
que se tiene en el main de esta clase.<br />
Se creó un ejemplo pequeño para probar cuando 
no hay ciclos si se forma correctamente el orden topológico. (**sinCiclos.txt**)

**NOTA:** Los .txt que se crearon para probar las funciones se encuentran en
la capeta data. <br />
Son dos .txt: <br />
Grafo Ejm Parte 3 Tarea 6 Dalgo.txt <br />
sinCiclos.txt

	

	
