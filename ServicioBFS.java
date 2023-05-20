

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class ServicioBFS {

	private Grafo<String> grafo;

	public ServicioBFS(Grafo<String> grafo) {
		this.grafo = grafo;
	}
	
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