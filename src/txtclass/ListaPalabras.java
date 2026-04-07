package txtclass;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
public class ListaPalabras {
    private TreeSet<Palabra> palabra;

    public ListaPalabras() {
        palabra = new TreeSet<>(new ComparatorPalabraVeces());
    }

    public void crearLista(TreeMap<String, Integer> palabras) {
        for (Map.Entry<String, Integer> p : palabras.entrySet()) {
            palabra.add(new Palabra(p.getKey(), p.getValue()));
        }
    }

    public TreeSet<Palabra> getLista() {
        return palabra;
    }
}
