package txtclass;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CompararTotal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nameFile1, nameFile2;

        try{
            System.out.print("Introduce el nombre del primer archivo \n->");
            nameFile1 = sc.nextLine();
            if (nameFile1.isEmpty()) throw new FileNotFoundException("::ERROR:: No puede quedar la ruta vacía.");

            File file1 = new File(nameFile1);
            if (!file1.exists()) throw new FileNotFoundException("::ERROR:: El archivo no existe");

            System.out.print("Introduce el nombre del segundo archivo \n->");
            nameFile2 = sc.nextLine();
            if (nameFile2.isEmpty()) throw new FileNotFoundException("::ERROR:: No puede quedar la ruta vacía.");

            File file2 = new File(nameFile2);
            if (!file2.exists()) throw new FileNotFoundException("::ERROR:: El archivo no existe");

            System.out.println(Utiles.equalsFiles(file1, file2)?"Los archivos son iguales":"Los archivos NO son iguales");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
