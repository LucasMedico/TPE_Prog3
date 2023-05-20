import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 Matriz de adyacencia:
 	Ventaja:
	 	Se puede determinar en un tiempo fijo y constante si un enlace (arco) pertenece o no al grafo.
	 	Es fácil determinar si existe o no un arco, sólo se debe posicionar en la matriz.
	Desventaja:
		Se requiere un almacenamiento |v|*|v|. Es decir O(n2)n cuadrado
		Solo al leer o examinar la matriz puede llevar un tiempo de O(n2).
		Si el grafo tiene gran cantidad de nodos y poca conectividad (pocos arcos), se desperdicia memoria. Solución  representación mediante una representación de Lista de adyacentes.

  Lista de adyacencia:
	Ventaja:
		Se utiliza bastante cuando el número de enlaces es mucho menor que O(n2).
		La lista de adyacencia requiere un espacio proporcional a la suma del número de vértices más el número de enlaces (arcos). Hace buen uso de la memoria.
	Desventaja:
		Puede llevar un tiempo O(n) determinar si existe un arco del vértice i al vértice j.

public class GrafoDirigidoDeprecated<T> implements Grafo<T> {
	
    private Map<Integer, List<Arco<T>>> adyacencia;

    public GrafoDirigidoDeprecated() {
        adyacencia = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!adyacencia.containsKey(verticeId)) {
            adyacencia.put(verticeId, new LinkedList<>());
        } else {
        	System.out.print("El vértice: "+verticeId+ " ya existe.");
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (adyacencia.containsKey(verticeId)) {
            adyacencia.remove(verticeId);
            // Eliminar todos los arcos que apuntan al vértice eliminado
            for (List<Arco<T>> listaArcos : adyacencia.values()) {
                listaArcos.removeIf(arco -> arco.getDestino() == verticeId);
            }
        } else {
        	System.out.print("El vértice: "+verticeId+ " no existe.");
        }
    }

    public void agregarArco(int origen, int destino, T dato) {
        if (adyacencia.containsKey(origen) && adyacencia.containsKey(destino)) {
            List<Arco<T>> listaArcos = adyacencia.get(origen);
            listaArcos.add(new Arco<>(origen, destino, dato));
        } else {
        	System.out.print("Los vértices no existen.");
        }
    }

    public void imprimirGrafo() {
    	//Recorro todos los valores de adyacencia mi estructura de almacenamiento
        for (Map.Entry<Integer, List<Arco<T>>> entry : adyacencia.entrySet()) {
        	//obtengo la key del mapa
            int origen = entry.getKey();
            //Obtengo el valor del mapa que en este caso es una lista
            List<Arco<T>> listaArcos = entry.getValue();
            System.out.print("Vértice " + origen + " está conectado con: ");
            for (Arco<T> arco : listaArcos) {
                System.out.print(arco.getDestino() + " ");
            }
            System.out.println();
        }
    }
    
}
*/