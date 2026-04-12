package movimientosbinario;
import java.io.Serializable;
public class Movimiento implements Serializable {
    private String nombre;
    private double cantidad;
    private int nMovimiento;

    public  Movimiento(String nombre, double cantidad) throws MovimientoFormatException {
        if (nombre.isEmpty()) throw new MovimientoFormatException("::ERROR:: El nombre no puede ser un campo vacío.");
        if (cantidad == 0) throw new MovimientoFormatException("::ERROR:: No se puede realizar un movimiento de 0€");
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Movimiento(int numero){
        this.nMovimiento = numero;
    }

    public Movimiento(String nombre) throws MovimientoFormatException {
        if (nombre.isEmpty()) throw new MovimientoFormatException("::ERROR:: El nombre no puede ser un campo vacio.");
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getnMovimiento() {
        return nMovimiento;
    }

    public void setnMovimiento(int nMovimiento) {
        this.nMovimiento = nMovimiento;
    }

    @Override
    public String toString() {
        return "MOVIMIENTO [" + nMovimiento + "] | NOMBRE [" + nombre + "] | CANTIDAD [" + cantidad + "]";
    }
}
