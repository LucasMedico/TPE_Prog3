

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class ServicioBFS {

	private Grafo<String> grafo;

	public ServicioBFS(Grafo<String> grafo) {
		this.grafo = grafo;
	}
	
    /*
    Complejidad: O(v + a) donde "V" es el numero de vertices en el grafo y "A" es el numero total de arcos en el grafo.
    */
	public List<Integer> bfs() {
		//Para marcar cada nodo ya visitado
		List<Integer> visitados = new ArrayList<>();
		Queue<Integer> filaVisitados = new LinkedList<Integer>();
        //Obtiene los vertices que tiene el grafo
		List<Vertice<String>> vertices = this.grafo.getVertices();
		
		filaVisitados = bfsVisitar(vertices, filaVisitados);
		
		for (Integer i : filaVisitados) {
			visitados.add(i);
		}

		return visitados;
	}
	
    /*
    Complejidad: O(v) donde "V" es el numero de vertices en el grafo.
    Recibe una lista de vertices y una cola de visitados, y realiza el recorrido BFS
    a partir de los vertices proporcionados. Para cada vertice en la lista,
    si su identificador no esta en la cola de visitados, se agrega a la cola.
    Luego, se agregan los identificadores de los vertices adyacentes no visitados a la cola.
    El metodo devuelve la cola de visitados actualizada.
    */
	private Queue<Integer> bfsVisitar(List<Vertice<String>> vertices, Queue<Integer> visitados){
		
		for (Vertice<String> v : vertices) {
			//agrega al vertice actual en caso de no estar en visitados
			if(!visitados.contains(v.getId())) {
				visitados.offer(v.getId());
			}
			for (Integer adyacente : v.getAdyacentes()) {
				if(!visitados.contains(adyacente)) {
					visitados.offer(grafo.obtenerVertice(adyacente).getId());
				}
			}
		}	
		return visitados;
	}
	
}