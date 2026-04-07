package txtclass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public abstract class Utiles {

    public static boolean equalsFiles(File f1, File f2) throws FileNotFoundException {
        try (Scanner sc1 = new Scanner(f1) ; Scanner sc2 = new Scanner(f2)) {
            while (sc1.hasNextLine() && sc2.hasNextLine()) {
                String line1 = sc1.nextLine();
                String line2 = sc2.nextLine();
                if (!line1.equals(line2)) return false;
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("::ERROR:: Ha ocurrido un error al intentar comparar los archivos, tipo de error:\n" +
                    e.getMessage());
        }

        return true;
    }

    public static String contarP (File f) throws FileNotFoundException {
        String texto = "", palabra, contador;
        int cont = 0;
        HashMap <String, Integer> palabraCont = new HashMap<>();

        try (Scanner file = new Scanner(f)){

            while(file.hasNext()){
                palabra = file.next().toLowerCase();
                if (!palabra.isEmpty() && palabraCont.containsKey(palabra)) cont++;
                palabraCont.put(palabra, cont);
            }
        }catch (FileNotFoundException e){
            throw new FileNotFoundException("::ERROR:: Ocurrio un error al intentar contar las palabras, tipo de error: \n" +
                    e.getMessage());
        }

        for (Map.Entry<String, Integer> pal : palabraCont.entrySet()){
            String s = String.valueOf(pal.getValue()) + " veces";
            texto += pal.getKey() + "," + s + "\n";
        }

        if (texto.isEmpty()) return "El fichero esta vacío o ha ocurrido un error de otro tipo";
        return texto;
    }
}
