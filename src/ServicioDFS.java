import java.util.ArrayList;
import java.util.List;

public class ServicioDFS {

	private Grafo<String> grafo;

	public ServicioDFS(Grafo<String> grafo) {
		this.grafo = grafo;
	}
	
    /*
    Complejidad: O(v + a) donde "V" es el numero de vertices en el grafo y "A" es el numero total de arcos en el grafo.
	Recorre todos los vertices en el grafo y para cada vertice si no ha sido agregado aun a la lista de visitados, invoca al metodo dfsVisitar() para agregarlo a la lista junto con sus adyacentes. 
	El metodo devuelve la lista de vertices visitados.     
    */	
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
	
    /*
    Complejidad: O(v + a) donde "V" es el numero de vertices en el grafo y "A" es el numero total de arcos en el grafo.
    recibe un vertice y una lista de visitados, y realiza el recorrido DFS a partir del vertice proporcionado. 
    Si el identificador del vertice no esta en la lista de visitados, se agrega a la lista. Luego, para cada identificador de vertice adyacente no visitado,
    se obtiene el vertice correspondiente utilizando el metodo obtenerVertice() del grafo y se invoca recursivamente al metodo dfsVisitar() desde el vertice adyacente.
    El metodo devuelve la lista de visitados actualizada.
    */	
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