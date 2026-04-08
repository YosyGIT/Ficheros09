package spanishtxt;
import java.io.File;
import java.util.*;
public class Diccionario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaPalabrasDic palabras = new ListaPalabrasDic();
        String palabra = "", linea;
        File dic = new File ("C:\\Users\\stwon\\Documents\\WORKSPACE_Poryectos_Java\\WORKSPACE_IntelliJ\\Ficheros09\\ind\\Spanish.txt");
        int opc = -1;

        try{
            UtilesSpanish.generadorLista(dic);
            while(opc != 2){
                System.out.println(mostrarMenu());
                opc = Integer.parseInt(sc.nextLine()) ;
                switch (opc) {
                    case 1:
                        System.out.print("Escriba la palabra que sea buscar: ");
                        palabra = sc.nextLine();
                        if (palabra.isEmpty()) throw new Exception("La palabra no puede ser vacia");
                        System.out.println(palabra);
                        for (PalabraDic p : palabras.getPalabras()){
                            while (palabra.charAt(0) <= p.getPalabra().charAt(0)){
                                if (palabra.equals(p.getPalabra())){
                                    System.out.println(p.getDefinicion());
                                }
                            }
                        }
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String mostrarMenu(){
        return "1) Buscar definición\n2) Salir";
    }
}
