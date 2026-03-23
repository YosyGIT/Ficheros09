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
            System.out.println("Introduce la ruta donde deseas crear el primer archivo: ");
            entrada = sc.nextLine();
            if (!entrada.isEmpty()){
                throw new FileNotFoundException("::ERROR:: Hubo un problema con la ruta marcada.");
            }
            File r1 = new File(entrada);

            System.out.println("Introduce la ruta donde deseas crear el primer archivo:");
            entrada = sc.nextLine();
            if (!entrada.isEmpty()){
                throw new FileNotFoundException("::ERROR:: Hubo un problema con la ruta marcada.");
            }
            File r2 = new File(entrada);
            try (PrintWriter f1 = new PrintWriter(r1);PrintWriter f2 = new PrintWriter(r2)){

            }
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
