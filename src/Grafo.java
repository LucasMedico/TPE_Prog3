import java.util.List;

public interface Grafo<T> {
	//Agrega Vertice
    void agregarVertice(int verticeId);
    
    //Borra Vertice
    void borrarVertice(int verticeId);
    
    //Obtiene la lista de Vertices
    List<Vertice<T>> getVertices();
    
    //Obtiene un vertice
    Vertice<T> obtenerVertice(int verticeId);
}
