
public class Arco<T> {
	private int verticeOrigen;
	private int verticeDestino;
	private T dato;

	public Arco(int origen, int destino, T dato) {
        this.verticeOrigen = origen;
        this.verticeDestino = destino;
        this.dato = dato;
    }

    public int getOrigen() {
        return verticeOrigen;
    }

    public int getDestino() {
        return verticeDestino;
    }

    public T getDato() {
        return dato;
    }
}
