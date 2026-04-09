package spanishtxt;
import txtclass.Palabra;

import java.io.File;
import java.util.*;
public class AppDiccionario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaPalabrasDic palabras = new ListaPalabrasDic();
        String palabra = "", linea;
        File dic = new File ("C:\\Users\\alumno\\Documents\\jdk-25.0.1\\Spanish.txt");
        int opc = -1;

        try{
            palabras.generadorLista(dic);
            while(opc != 2){
                System.out.print(mostrarMenu());
                opc = Integer.parseInt(sc.nextLine()) ;
                switch (opc) {
                    case 1:
                        System.out.print("\nEscriba la palabra que sea buscar: ");
                        palabra = sc.nextLine();
                        if (palabra.isEmpty()) throw new Exception("La palabra no puede ser vacia");
                        System.out.println("\n-:" + palabra + ":-");
                        System.out.println(UtilesSpanish.mostrarDefinicion(palabras.getPalabras(), palabra));
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String mostrarMenu(){
        return "1) Buscar definición\n2) Salir\n->";
    }
}
