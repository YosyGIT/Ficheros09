package spanishtxt;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void generadorLista(File f) throws FileNotFoundException {
        String linea, palabra, definicion;
        String[] separador;

        try (Scanner file = new Scanner(f)){
            while (file.hasNextLine()){
                linea = file.nextLine();
                separador = linea.split("\t", 2);
                palabra = separador[0].trim();
                definicion = separador[1].trim();
                if (!palabra.isEmpty() && !definicion.isEmpty()){
                    addPalabra(new PalabraDic(palabra, definicion));
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("::ERROR:: Ha ocurrido un error al crear la lista de palabras.");
        }
    }
}
