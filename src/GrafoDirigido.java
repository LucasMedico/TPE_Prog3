import java.util.ArrayList;
import java.util.List;

//ULTIMO CAMBIO IMPORTANTE: Revisar si asi funciona todo bien getVertices().

public class GrafoDirigido<T> implements Grafo<T> {
	
	 private List<Vertice<T>> vertices;

	    public GrafoDirigido() {
	        vertices = new ArrayList<>();
	    }
	    
	    /*
	    Complejidad: O(n), donde "N" es el numero de vertices en el grafo.
	    Esto se debe al metodo de verificacion de existencia de vertices utilizando existeVertice(), que tiene una complejidad de O(n) en el peor caso.
	    Utilizar el metodo Add en la lista tiene complejidad O(1)
	    */
	    @Override
	    public void agregarVertice(int verticeId) {
	        if (!existeVertice(verticeId)) {
	            vertices.add(new Vertice<>(verticeId));
	        } else {
	        	System.out.println("El vértice ya existe");
	        }
	    }

	    /*
	    Complejidad: O(n * a), donde "N" es el numero de vertices en el grafo y "A" el numero promedio de arcos.
	    Esto se debe a los metodos de verificacion de existencia de vertices utilizando existeVertice() y obtenerVertice(), ambas con una complejidad de O(n).
	    */
	    @Override
	    public void borrarVertice(int verticeId) {
	        if (existeVertice(verticeId)) {
	            Vertice<T> vertice = obtenerVertice(verticeId);
	            vertices.remove(vertice);
	            // Eliminar todos los arcos que apuntan al vertice eliminado
	            for (Vertice<T> v : vertices) {
	                v.eliminarArco(verticeId);
	            }
	        } else {
	        	System.out.println("El vértice no existe");
	        }
	    }

	    /*
	    Complejidad: O(n), donde "N" es el numero de vertices en el grafo.
	    Esto se debe a los metodos de verificacion de existencia de vertices utilizando existeVertice() y obtenerVertice(), ambas con una complejidad de O(n).
	    */
	    public void agregarArco(int origen, int destino, T dato) {
	        if (existeVertice(origen) && existeVertice(destino)) {
	            Vertice<T> verticeOrigen = obtenerVertice(origen);
	            verticeOrigen.agregarArco(destino, dato);
	        } else {
	        	System.out.println("Los vértices no existen");
	        }
	    }

	    /*
	    Complejidad: O(v + a), donde "V" es el numero de vertices y "A" es el numero total de arcos en el grafo, 
	    Esto se debe a recorrer toda la lista de vertices y por cada uno recorrer los arcos para imprimir el grafo.
	    */
	    public void imprimirGrafo() {
	        for (Vertice<T> vertice : vertices) {
	            System.out.print("Vértice " + vertice.getId() + " está conectado con: ");
	            List<Arco<T>> arcos = vertice.getArcos();
	            for (Arco<T> arco : arcos) {
	                System.out.print(arco.getDestino() + " ");
	            }
	            System.out.println();
	        }
	    }

	    
	    /*
	    Complejidad: O(n) donde "N" es el numero de vertices en la lista de Vertices, 
	    Esto se debe a recorrer toda la lista y comparar cada Id con verticeId para verificar si existe un en especifico.
	    */
	    private boolean existeVertice(int verticeId) {
	        for (Vertice<T> vertice : vertices) {
	            if (vertice.getId() == verticeId) {
	                return true;
	            }
	        }
	        return false;
	    }

	    /*
	    Complejidad: O(n) donde "N" es el numero de vertices en la lista de Vertices, 
	    Esto se a debe recorrer toda la lista y comparar cada Id con verticeId para retornar un vertice especifico.
	    */
	    @Override
	    public Vertice<T> obtenerVertice(int verticeId) {
	        for (Vertice<T> vertice : vertices) {
	            if (vertice.getId() == verticeId) {
	                return vertice;
	            }
	        }
	        return null;
	    }
	
	    /*
	    Complejidad: O(1) solo retorna una variable, en este caso la lista de vertices.
	    */
	    @Override
	    public List<Vertice<T>> getVertices(){
	    	return new ArrayList<Vertice<T>>(this.vertices);
	    }
}
