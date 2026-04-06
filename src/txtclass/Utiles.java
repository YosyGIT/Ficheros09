package txtclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Utiles {

    public static boolean equalsFiles(File f1, File f2) throws FileNotFoundException {
        try (Scanner sc1 = new Scanner(f1) ; Scanner sc2 = new Scanner(f2)) {
            while (sc1.hasNextLine() && sc2.hasNextLine()) {
                String line1 = sc1.nextLine();
                String line2 = sc2.nextLine();
                if (!line1.equals(line2)) return false;
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("::ERROR:: Ha ocurrido un error al intentar comparar los archivos tipo de error:\n" +
                    e.getMessage());
        }

        return true;
    }
}
