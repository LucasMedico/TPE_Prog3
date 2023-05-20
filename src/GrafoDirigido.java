import java.util.ArrayList;
import java.util.List;

import TPE.Vertice;


public class GrafoDirigido<T> implements Grafo<T> {
	
	 private List<Vertice<T>> vertices;

	    public GrafoDirigido() {
	        vertices = new ArrayList<>();
	    }

	    @Override
	    public void agregarVertice(int verticeId) {
	        if (!existeVertice(verticeId)) {
	            vertices.add(new Vertice<>(verticeId));
	        } else {
	        	System.out.println("El vértice ya existe");
	        }
	    }

	    @Override
	    public void borrarVertice(int verticeId) {
	        if (existeVertice(verticeId)) {
	            Vertice<T> vertice = obtenerVertice(verticeId);
	            vertices.remove(vertice);
	            // Eliminar todos los arcos que apuntan al vértice eliminado
	            for (Vertice<T> v : vertices) {
	                v.eliminarArco(verticeId);
	            }
	        } else {
	        	System.out.println("El vértice no existe");
	        }
	    }

	    public void agregarArco(int origen, int destino, T dato) {
	        if (existeVertice(origen) && existeVertice(destino)) {
	            Vertice<T> verticeOrigen = obtenerVertice(origen);
	            verticeOrigen.agregarArco(destino, dato);
	        } else {
	        	System.out.println("Los vértices no existen");
	        }
	    }

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

	    private boolean existeVertice(int verticeId) {
	        for (Vertice<T> vertice : vertices) {
	            if (vertice.getId() == verticeId) {
	                return true;
	            }
	        }
	        return false;
	    }

	    private Vertice<T> obtenerVertice(int verticeId) {
	        for (Vertice<T> vertice : vertices) {
	            if (vertice.getId() == verticeId) {
	                return vertice;
	            }
	        }
	        return null;
	    }
	    
	    public List<Vertice<T>> getVertices(){
	    	return this.vertices;
	    }
}
