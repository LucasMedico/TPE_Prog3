import java.util.List;

import TPE.Vertice;

public interface Grafo<T> {
    void agregarVertice(int verticeId);
    void borrarVertice(int verticeId);
    List<Vertice<T>> getVertices();
    Vertice<T> obtenerVertice(int verticeId);
}
