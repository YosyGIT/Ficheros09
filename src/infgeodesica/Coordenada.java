package infgeodesica;
import java.io.Serializable;
public class Coordenada implements Comparable<Coordenada> {
    private String nombre;
    private double x;
    private double y;

    public Coordenada(String nombre, double x, double y) throws CoordenadaFormatException {
        if (nombre.isEmpty()) throw new CoordenadaFormatException("::ERROR:: Nombre de coordenada nulo");
        if (x < 0) throw new CoordenadaFormatException("::ERROR:: X negativo");
        if (y < 0) throw new CoordenadaFormatException("::ERROR:: Y negativo");
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    public Coordenada(String nombre){
        this.nombre = nombre;
        this.x = 0.0;
        this.y = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void modificarCoordenada(double x, double y, int opc) throws CoordenadaFormatException{
        if (nombre.isEmpty() && opc == 1 &&x == 0 && y == 0){
            throw new  CoordenadaFormatException("::ERROR:: Campos vacios.");
        }
        if (opc == 1){
            setX(x);
        }else if (opc == 2){
            setY(y);
        } else if (opc == 3) {
            setX(x);
            setY(y);
        }
    }
    @Override
    public String toString() {
        return this.nombre + ","  + this.x + "," + this.y;
    }

    @Override
    public int compareTo(Coordenada o) {
        return this.nombre.compareTo(o.getNombre());
    }
}
