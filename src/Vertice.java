import java.util.ArrayList;
import java.util.List;

public class Vertice<T> {
	
	private int id;
    private List<Arco<T>> arcos;

    public Vertice(int id) {
        this.id = id;
        this.arcos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Arco<T>> getArcos() {
        return arcos;
    }

    public void agregarArco(int destino, T dato) {
        arcos.add(new Arco<>(this.id, destino, dato));
    }

    public void eliminarArco(int destino) {
        arcos.removeIf(arco -> arco.getDestino() == destino);
    }
    
    public List<Integer> getAdyacentes(){
    	List<Integer> adyacentes = new ArrayList<Integer>();
    	for (Arco<T> a : arcos) {
    		adyacentes.add(a.getDestino());
    	}
    	return adyacentes;
    }
}
