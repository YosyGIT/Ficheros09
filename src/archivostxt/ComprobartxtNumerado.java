package archivostxt;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class ComprobartxtNumerado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = "", linea = "";
        int cont = 1;

        try{
            System.out.print("Introduce la ruta para comprobar su texto \n->");
            entrada = sc.nextLine();
            if (entrada.isEmpty()) throw new FileNotFoundException("::ERROR:: La ruta esta vacía.");

            File f1 = new File(entrada);
            if (!f1.exists()) throw new FileNotFoundException("::ERROR:: El archivo no existe.");

            try (Scanner f = new Scanner(f1)){
                System.out.print("Introduce el texto que deseas comprobar \n->");
                entrada = sc.nextLine();

                while (f.hasNextLine()){
                    linea = f.nextLine();
                    if (linea.matches(".*" + entrada + ".*")){
                        System.out.println(cont + linea);
                        cont++;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
