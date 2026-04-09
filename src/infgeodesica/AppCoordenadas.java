package infgeodesica;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class AppCoordenadas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCoordenadas lista = new ListaCoordenadas();
        String file = "C:\\Users\\alumno\\Documents\\jdk-25.0.1\\ficheros";
        int opc = -1;

        try (PrintWriter filewr = new PrintWriter(file)){
            while (opc != 6){
                System.out.print(mostrarMenu());
                opc = Integer.parseInt(sc.nextLine());
                if (opc < 1 || opc > 6) throw new NumberFormatException("::ERROR:: Has introducido una opcion no valida");
                switch (opc){
                    case 1:
                        System.out.println(addCoordenada(sc, lista)?"Se añadio correctamente":"No se ha podido añadir");
                    break;

                    case 2:


                }
            }

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    public static String mostrarMenu(){
        return "1) Añadir elemento geográfico\n2) Modificar elemento geográfico\n3) Eliminar elemento geográfico\n" +
                "4)Mostrar todos los datos greográficos\n5) Guardar\n6) Salir\n->";
    }

    public static boolean addCoordenada(Scanner sc, ListaCoordenadas lista){
        double x, y;
        String nombre;
        Coordenada coord;

        System.out.print("Introduce el nombre para la coordenada: ");
        nombre = sc.nextLine();
        System.out.print("Introduce el eje X de la coordenada: ");
        x = Double.parseDouble(sc.nextLine());
        System.out.print("Introduce el eje Y de la coordenada: ");
        y = Double.parseDouble(sc.nextLine());
        coord = new Coordenada(nombre, x, y);

        return lista.addCoordenada(coord);
    }
}
