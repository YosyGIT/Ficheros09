package movimientosbinario;
import java.io.*;
import java.util.TreeSet;
public class ListaMovimeintos {
    private TreeSet<Movimiento> lista;

    public ListaMovimeintos(){
        this.lista = new TreeSet<>();
    }

    public boolean addMovimiento (String nombre, double cantidad) throws MovimientoFormatException {
        Movimiento aux = lista.last();
        Movimiento nuevo = new Movimiento(nombre, cantidad);

        if (!lista.isEmpty()){
            lista.add(nuevo);
            nuevo.setnMovimiento(aux.getnMovimiento() + 1);
            return true;
        }else {
            lista.add(nuevo);
            nuevo.setnMovimiento(1);
            return true;
        }
    }

    public Movimiento buscarMovimiento (int numero){
        Movimiento aux = new Movimiento(numero);
        Movimiento buscado = lista.ceiling(aux);
        if (buscado.getnMovimiento() == numero){
            return buscado;
        }
        return null;
    }

    public Movimiento buscarMovimiento (String nombre) throws MovimientoFormatException {
        Movimiento aux = new Movimiento(nombre);
        Movimiento buscado = lista.ceiling(aux);
        if (buscado.getNombre().equals(nombre)){
            return buscado;
        }
        return null;
    }

    public StringBuilder consultarPorNumero (int numero){
        StringBuilder texto = new StringBuilder();
        Movimiento consultado = buscarMovimiento(numero);
        return texto.append(consultado.toString());
    }

    public StringBuilder consultarPorNombre (String nombre) throws MovimientoFormatException {
        StringBuilder texto = new StringBuilder();
        Movimiento consultado = buscarMovimiento(nombre);
        return texto.append(consultado.toString());
    }

    public boolean guardarDatos (File f) throws IOException {
        if (!f.exists()) throw new IOException("Fichero no encontrado");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))){
            out.writeObject(lista);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean cargarDatos (File f) throws IOException {
        if (!f.exists()) throw new IOException("Fichero no encontrado");

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))){
            lista = (TreeSet<Movimiento>) in.readObject();
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
