

import java.util.ArrayList;
import java.util.List;

public class ServicioDFS {

	private Grafo<String> grafo;

	public ServicioDFS(Grafo<String> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> dfsForest() {
		//Para marcar cada nodo ya visitado
		List<Integer> visitados = new ArrayList<>();
        //Obtiene los vertices que tiene el grafo
		List<Vertice<String>> vertices = this.grafo.getVertices();
		/*Por cada vertice, si no fue agregado aun, invoca dfsVisitar para ir agregandolo
		a el junto a sus adyacentes.*/
		for (Vertice<String> v : vertices) {
			if(!visitados.contains(v.getId())) {
				visitados = dfsVisitar(v, visitados);
			}
		}

		return visitados;
	}
	
	private List<Integer> dfsVisitar(Vertice<String> v, List<Integer> visitados){
		//agrega al vertice actual en caso de no estar en lista de visitados
		if(!visitados.contains(v.getId())) {
			visitados.add(v.getId());
		}
		/*por cada id de adyacentes, obteniendo el vertice que corresponde al id y vuelve
		a invocar metodo desde adyacente. */
		for (Integer adyacente : v.getAdyacentes()) {
			if(!visitados.contains(adyacente)) {
				visitados = dfsVisitar(grafo.obtenerVertice(adyacente), visitados);
			}
		}
		
		return visitados;
	}

}