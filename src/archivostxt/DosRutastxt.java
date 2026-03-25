package archivostxt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class DosRutastxt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = "";
        int opc = -1;

        try {
            System.out.println("Introduce la ruta del archivo con texto: ");
            entrada = sc.nextLine();
            if (entrada.isEmpty()) throw new FileNotFoundException("::ERROR:: Ruta de origen vacía.");
            File r1 = new File(entrada);
            if (!r1.exists()) throw new FileNotFoundException("::ERROR:: El archivo de origen no existe.");

            System.out.println("Introduce la ruta donde deseas escribir el texto: ");
            entrada = sc.nextLine();
            if (entrada.isEmpty()) throw new FileNotFoundException("::ERROR:: Ruta de destino vacía.");
            while (opc > 2 || opc < 1) {
                System.out.println("\nLa ruta contiene texto, deseas escribir en este archivo?");
                System.out.println("1) SI");
                System.out.println("2) NO");
                opc = Integer.parseInt(sc.nextLine());
                if (opc > 2 || opc < 1) throw new NumberFormatException("\n::ERROR:: La opción no es valida.");
            }
            File r2 = new File(entrada);
            if (!r2.exists()) throw new FileNotFoundException("::ERROR:: El archivo de destino no existe.");

            try (PrintWriter f1 = new PrintWriter(r1) ; PrintWriter f2 = new PrintWriter(r2)){

            }
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
