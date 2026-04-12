package infgeodesica;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class ListaCoordenadas {
    private TreeSet<Coordenada> listaCoord;

    public ListaCoordenadas(){
        this.listaCoord = new TreeSet<>();
    }

    public Coordenada encontrarCoordenada(String nombre){
        Coordenada aux = new Coordenada(nombre);
        Coordenada newCoord = listaCoord.ceiling(aux);
        if(newCoord.getNombre().equals(nombre)){
            return newCoord;
        }
        return null;
    }

    public boolean addCoordenada(String nombre, double x, double y) throws CoordenadaFormatException {
        Coordenada newCoord = encontrarCoordenada(nombre);
        if (newCoord != null) throw new CoordenadaFormatException("::ERROR:: Coordenada ya existente");
        newCoord = new Coordenada(nombre, x, y);
        return listaCoord.add(newCoord);
    }

    public void modificarCoordenada(String nombre, double x, double y, int opc) throws CoordenadaFormatException {
        Coordenada aux = new Coordenada(nombre);
        Coordenada coord = listaCoord.ceiling(aux);
        if (coord == null) throw new CoordenadaFormatException("::ERROR:: NO se encontro la coordenada.");
        coord.modificarCoordenada(x , y, opc);
    }

    public boolean delCoordenada(String nombre) throws CoordenadaFormatException {
        Coordenada aux = encontrarCoordenada(nombre);
        if (aux == null) throw new CoordenadaFormatException("::ERROR:: Coordenada no existente");
        return listaCoord.remove(aux);
    }

    public StringBuilder listarCoordenadas(){
        StringBuilder texto = new StringBuilder();
        for (Coordenada aux : listaCoord){
            texto.append(aux.toString());
        }
        return texto;
    }

    public boolean guardarCoordenadas(File f) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(f)) {
            for (Coordenada aux : listaCoord) {
                pw.println(aux.toString());
            }
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    public boolean cargarCoordenadas(File f) throws CoordenadaFormatException, FileNotFoundException {
        try (Scanner sc = new Scanner(f)) {
            String linea;
            String[] data;
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                data = linea.split(",");
                listaCoord.add(new Coordenada(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2])));
            }
        }catch (CoordenadaFormatException | NumberFormatException e) {
            return false;
        }
        return true;
    }
}
