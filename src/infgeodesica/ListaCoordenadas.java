package infgeodesica;
import java.util.ArrayList;
public class ListaCoordenadas {
    private ArrayList<Coordenada> listaCoord;

    public ListaCoordenadas(){
        this.listaCoord = new ArrayList<>();
    }

    public boolean addCoordenada(Coordenada coord){
        if (!listaCoord.contains(coord)){
            this.listaCoord.add(coord);
            return true;
        }
        return false;
    }
}
