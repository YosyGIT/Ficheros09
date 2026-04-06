package archivostxt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class FileAugusto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nameFile, codif = "";
        char[] stringChar, codifString;
        int contCodif = 0;

        try {
            System.out.print("Introduce el nombre del archivo \n->");
            nameFile = sc.nextLine();
            if (nameFile.isEmpty()) throw new FileNotFoundException("::ERROR:: La ruta del archivo no puede estar vacia");

            File file = new File(nameFile);
            if (!file.exists()) throw new FileNotFoundException("::ERROR:: La ruta del archivo no existe");

            File file2 = new File(file.getParent() , "augusto.txt");

            while (!codif.matches("[0-9]{2,}")) {
                System.out.print("Introduce la clave de codificación: ");
                codif = sc.nextLine();
                if (!codif.matches("[0-9]{2,}")) throw new FileNotFoundException("::ERROR:: La clave debe tener minimo 2 números y estar compuesta por solo números");
            }
            codifString = codif.toCharArray();


            try (Scanner readFile = new Scanner(file); PrintWriter writeFile = new PrintWriter(file2)) {
                while (readFile.hasNextLine()) {
                    stringChar = readFile.nextLine().toCharArray();
                    for (int i = 0; i < stringChar.length; i++) {
                        stringChar[i] += Integer.parseInt(String.valueOf(codifString[contCodif]));
                        if (contCodif == codifString.length - 1) contCodif = 0;
                        contCodif++;
                    }
                    writeFile.println(stringChar);
                }
            }catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
