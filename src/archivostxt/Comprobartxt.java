package archivostxt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class Comprobartxt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = "", linea = "";

        try{
            System.out.print("Introduce la ruta absoluta del archivo \n->");
            entrada = sc.nextLine();
            if (entrada.isEmpty()) throw new FileNotFoundException("::ERROR:: La ruta esta vacía.");

            File f1 = new File(entrada);
            if (!f1.exists()) throw new FileNotFoundException("::ERROR:: El fichero no existe.");

            try (Scanner f = new Scanner(f1)){
                System.out.println("Introduce el texto que deseas comprobar: ");
                entrada = sc.nextLine();
                linea = f.nextLine();

                while (!linea.equals(entrada)){
                    linea = f.nextLine();
                }
                System.out.println("El texto introducido es igual.");

            }catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e){
                System.out.println("No hay coincidencias en ninguna fila del documento.");
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
