package infgeodesica;
import java.io.Serializable;
public class Coordenada implements Serializable {
    private String nombre;
    private double x;
    private double y;

    public Coordenada(String nombre, double x, double y){
        if (nombre.isEmpty());
        this.x = x;
        this.y = y;
    }
}
