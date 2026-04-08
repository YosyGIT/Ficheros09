package spanishtxt;
import java.util.ArrayList;
public class ListaPalabrasDic {
    private ArrayList<PalabraDic> palabras;

    public ListaPalabrasDic() {
        this.palabras = new ArrayList<>();
    }

    public void addPalabra(PalabraDic palabra) {
        this.palabras.add(palabra);
    }

    public ArrayList<PalabraDic> getPalabras() {
        return palabras;
    }
}
