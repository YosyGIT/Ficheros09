package archivostxt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class  FileCesar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = "", lineaCifrada = "";
        char[] lineaChar;
        int valor = -1;

        try{
            System.out.print("Introduce la ruta absoluta del archivo que desea codificar \n->");
            entrada = sc.nextLine();
            if (entrada.isEmpty()) throw new FileNotFoundException("::ERROR:: La ruta esta vacia.");

            File f1 = new File(entrada);
            if (!f1.exists()) throw new FileNotFoundException("::ERROR:: El archivo no existe.");

            File f2 = new File(f1.getParent() , "cesar.txt");

            System.out.print("Introduce el valor con el que deseas codificar: ");
            valor = Integer.parseInt(sc.nextLine());

            try (Scanner f = new Scanner(f1); PrintWriter copy = new PrintWriter(f2)){
                while(f.hasNextLine()){
                    lineaChar = f.nextLine().toCharArray();
                    for (int i = 0; i < lineaChar.length; i++){
                        lineaChar[i] += valor;
                    }
                    lineaCifrada = new String(lineaChar);
                    copy.println(lineaCifrada);
                }
                System.out.println("Archivo codificado correctamente.");
            }catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
