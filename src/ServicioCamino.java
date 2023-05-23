import java.util.ArrayList;
import java.util.List;

public class ServicioCamino {
	private Grafo<String> grafo;
    private int origen;
    private int destino;
    private int limite;
    private List<List<Integer>> caminos;

    public ServicioCamino(Grafo<String> grafo, int origen, int destino, int limite) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.limite = limite;
        this.caminos = new ArrayList<>();
    }

    public List<List<Integer>> caminos() {
        List<Integer> caminoActual = new ArrayList<>();
        caminoActual.add(origen);
        backtracking(origen, caminoActual, 0);
        return caminos;
    }

    private void backtracking(int vertice, List<Integer> caminoActual, int arcosRecorridos) {
    	//si el vertice es el final y no supero los limites establecidos agrega a la lista de caminos el camino actual
        if (vertice == destino && arcosRecorridos <= limite) {
            caminos.add(new ArrayList<>(caminoActual));
            return;
        }
        //si los arcos recorridos superan al limite establecido no agrego ese camino al camino final
        if (arcosRecorridos >= limite) {
            return;
        }
        //se obtienen los adyacentes del vertice, 
        //se recorren todos y si el camino no contiene al adyacente agrego el adyacente al camino (para que no pase mas de una vez por vertice)
        //se hace un llamado recursivo con el vertice adyacente
        //se remueve el ultimo vertice agregado para que busque por otros vertices
        List<Integer> adyacentes = grafo.obtenerVertice(vertice).getAdyacentes();
        for (Integer adyacente : adyacentes) {
            if (!caminoActual.contains(adyacente)) {
                caminoActual.add(adyacente);
                backtracking(adyacente, caminoActual, arcosRecorridos + 1);
                caminoActual.remove(caminoActual.size() - 1);
            }
        }
    }
}