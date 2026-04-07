package txtclass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class ContarPalabras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String f1;

        try{
            System.out.print("Introduce el nombre del ficheo \n->");
            f1 = sc.nextLine();
            if (f1.isEmpty()) throw new FileNotFoundException("::ERROR:: La ruta no puede estar vacía.");

            File f = new File(f1);
            if (!f.exists()) throw new FileNotFoundException("::ERROR:: El fichero no existe.");

            System.out.println("\n" + Utiles.contarP(f));
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}
