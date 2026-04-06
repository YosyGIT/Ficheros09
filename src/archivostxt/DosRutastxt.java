package archivostxt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class DosRutastxt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = "";

        try {
            System.out.println("Introduce la ruta del archivo con texto: ");
            entrada = sc.nextLine();
            if (entrada.isEmpty()) throw new FileNotFoundException("::ERROR:: Ruta de origen vacía.");

            File r1 = new File(entrada);
            if (!r1.exists()) throw new FileNotFoundException("::ERROR:: El archivo de origen no existe.");

            System.out.println("Introduce la ruta donde deseas escribir el texto: ");
            entrada = sc.nextLine();
            if (entrada.isEmpty()) throw new FileNotFoundException("::ERROR:: Ruta de destino vacía.");
            File r2 = new File(entrada);

            try (Scanner f1 = new Scanner(r1) ; PrintWriter f2 = new PrintWriter(r2)){
                while (f1.hasNextLine()){
                    f2.println(f1.nextLine());
                }
            }catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Archivo copiado correctamente");
    }
}
