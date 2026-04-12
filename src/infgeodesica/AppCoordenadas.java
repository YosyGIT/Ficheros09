package infgeodesica;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class AppCoordenadas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaCoordenadas lista = new ListaCoordenadas();
        File file = new File("coordenadas.txt");
        String nombreCoord;
        int opc = -1, opc2 = -1;
        boolean guardado = false;

        try {
            System.out.println(lista.cargarCoordenadas(file)?"Datos cargados":"No se ha podido cargar coordenadas");
            while (opc != 6 && !guardado){
                System.out.print(mostrarMenu());
                opc = Integer.parseInt(sc.nextLine());
                if (opc < 1 || opc > 6) throw new NumberFormatException("::ERROR:: Has introducido una opcion no valida");
                switch (opc){
                    case 1:
                        System.out.println(addCoordenada(sc, lista)?"Se añadio correctamente":"No se ha podido añadir");
                    break;

                    case 2:
                        cambiarCoordenada(sc, lista);
                    break;

                    case 3:
                        System.out.print("Dime el nombre de la coordenada que desea eliminar: ");
                        nombreCoord = sc.nextLine();
                        System.out.println(lista.delCoordenada(nombreCoord)?"Eliminada correctamente":"No se ha podido eliminar");
                    break;

                    case 4:
                        System.out.println(lista.listarCoordenadas());
                    break;

                    case 5:
                        System.out.println(lista.guardarCoordenadas(file)?"Datos guardados":"No se ha podido guardar");
                        guardado = true;
                    break;

                    case 6:
                        if (!guardado){
                            System.out.println("No has guardado los datos\n" +
                                    "¿Deseas guardarlos?\n1)Si\n2)No");
                            opc2=Integer.parseInt(sc.nextLine());
                            if (opc2 == 1){
                                System.out.println(lista.guardarCoordenadas(file)?"Datos guardados":"No se ha podido guardar");
                                guardado = true;
                            }else if (opc2 == 2){
                                System.out.println("Saliendo...");
                            }
                        }
                }
            }

        }catch (FileNotFoundException | CoordenadaFormatException e){
            System.out.println(e.getMessage());
        }

    }

    public static String mostrarMenu(){
        return "1) Añadir elemento geográfico\n2) Modificar elemento geográfico\n3) Eliminar elemento geográfico\n" +
                "4)Mostrar todos los datos greográficos\n5) Guardar\n6) Salir\n->";
    }

    public static boolean addCoordenada(Scanner sc, ListaCoordenadas lista) throws CoordenadaFormatException {
        double x, y;
        String nombre;
        Coordenada coord;

        System.out.print("Introduce el nombre para la coordenada: ");
        nombre = sc.nextLine();
        System.out.print("Introduce el eje X de la coordenada: ");
        x = Double.parseDouble(sc.nextLine());
        System.out.print("Introduce el eje Y de la coordenada: ");
        y = Double.parseDouble(sc.nextLine());

        return lista.addCoordenada(nombre, x, y);
    }

    public static void cambiarCoordenada(Scanner sc, ListaCoordenadas lista) throws CoordenadaFormatException{
        String nombre;
        double x = 0, y = 0;
        int opc;

        System.out.print("Introduce el nombre para la coordenada: ");
        nombre = sc.nextLine();

        System.out.println("¿Que desea modificar?");
        System.out.println("1) X\n2) Y\n3) Ambas\n4Salir");
        opc = Integer.parseInt(sc.nextLine());

        if (opc != 4){
            if (opc == 1) {
                System.out.print("Introduce el eje X de la coordenada: ");
                x = Double.parseDouble(sc.nextLine());

            }else if (opc == 2){
                System.out.print("Introduce el eje Y de la coordenada: ");
                y = Double.parseDouble(sc.nextLine());
            } else if (opc == 3) {
                System.out.print("Introduce el eje X de la coordenada: ");
                x = Double.parseDouble(sc.nextLine());
                System.out.print("Introduce el eje Y de la coordenada: ");
                y = Double.parseDouble(sc.nextLine());
            }
        }
        lista.modificarCoordenada(nombre, x, y, opc);
    }
}
