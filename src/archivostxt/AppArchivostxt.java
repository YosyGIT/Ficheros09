package archivostxt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.classfile.FieldBuilder;
import java.util.*;
public class AppArchivostxt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = "";

        File arch = new File("C:\\Users\\alumno\\Documents\\jdk-25.0.1\\ficheros\\volcado.txt");

        try (PrintWriter fich = new PrintWriter(arch)){

            do {
                System.out.print("Introduce una linea de texto \n->");
                fich.println(entrada = sc.nextLine());
            } while (!entrada.isEmpty());

        } catch (FileNotFoundException e) {
            System.out.println("::ERROR:: EL FICHERO NO SE CREO CORRECTAMENTE \n" + e.getMessage());
        }

    }
}
