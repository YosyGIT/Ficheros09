package txtclass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class ContarPalabrasVeces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String f;

        try{
            System.out.print("Introduce el nombre del fichero \n->");
            f = sc.nextLine();
            if (f.isEmpty()) throw new  FileNotFoundException("::ERROR:: El fichero no puede estar vacío.");

            File file = new File(f);
            if (!file.exists()) throw new  FileNotFoundException("::ERROR:: El fichero no existe.");


            System.out.println("\n" + Utiles.contarN(file));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
