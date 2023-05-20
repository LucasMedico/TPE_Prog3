
public class Main {

	public static void main(String[] args) {
        GrafoDirigido<String> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarArco(0, 1, "Arco 0-1");
        grafo.agregarArco(0, 2, "Arco 0-2");
        grafo.agregarArco(1, 2, "Arco 1-2");
        grafo.agregarArco(2, 3, "Arco 2-3");
        grafo.imprimirGrafo();

        grafo.borrarVertice(1);
        System.out.println("Grafo después de borrar el vértice 1:");
        grafo.imprimirGrafo();

	}

}
