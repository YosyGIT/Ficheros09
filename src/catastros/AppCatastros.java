package catastros;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
public class AppCatastros {
    public static void main(String[] args) throws CatastroFormatException {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        ListaCatastro lista = new ListaCatastro();
        int opc = -1, numCat;
        File f = new File("catastros.txt");

        try{
            System.out.println(lista.cargarFichero(f)?"Se cargaron los datos correctamente":"No se cargaron los datos");
            while (opc != 7) {
                System.out.println();
                System.out.println("1. Añadir nuevo catastro");
                System.out.println("2. Modificar catastro");
                System.out.println("3. Listar todos los catastros");
                System.out.println("4. Listar un catastro");
                System.out.println("5. Borrar un catastro");
                System.out.println("6. Recuperar un catastro");
                System.out.println("7. Salir");
                System.out.println("Introduce una opción:");
                opc = Integer.parseInt(sc.nextLine());

                switch (opc) {
                    case 1:
                        System.out.println(crearCatastro(sc, lista)?"Se creo correctamente":"No se pudo crear");
                        break;

                    case 2:
                        modificarCatastro(sc, lista);
                        break;

                    case 3:
                        System.out.println(lista.listarCatastros());
                        break;

                    case 4:
                        System.out.print("Introduce el numero del catastro: ");
                        numCat = Integer.parseInt(sc.nextLine());
                        System.out.println(lista.listarCatastro(numCat));
                        break;

                    case 5:
                        System.out.println(delCatastro(sc, lista)?"Se elimino correctamente":"No se pudo elimino");
                        break;

                    case 6:
                        System.out.println(recuperarCatastro(sc, lista)?"Se recupero el catastro":"No se encontro");
                        break;

                    case 7:
                        System.out.println(lista.guardarFichero(f)?"Se guardaron los datos correctamente":"Ocurrio un error");
                        break;

                }
            }
        }catch(CatastroFormatException | IOException e){
            System.err.println(e.getMessage());
        }


    }

    public static Catastro crearDatos(Scanner sc) throws CatastroFormatException {
        String nombre, direccion;
        double metros;

        System.out.print("Introduce el nombre del catastro: ");
        nombre = sc.nextLine();
        System.out.print("Introduce el direccion del catastro: ");
        direccion = sc.nextLine();
        System.out.print("Introduce el metros del catastro: ");
        metros = Double.parseDouble(sc.nextLine());

        return new Catastro(nombre, direccion, metros);
    }

    public static boolean crearCatastro (Scanner sc, ListaCatastro lista) throws CatastroFormatException {
        Catastro cat = crearDatos(sc);
        return lista.addCatastro(new Catastro(cat.getNombre(), cat.getDireccion(), cat.getMetros()));
    }

    public static void modificarCatastro(Scanner sc, ListaCatastro lista) throws CatastroFormatException {
        int numero;

        System.out.print("Introduce el numero del catastro: ");
        numero = Integer.parseInt(sc.nextLine());
        lista.identificarCatastro(numero);
        Catastro cat = crearDatos(sc);
        lista.modificarCatastro(cat.getNombre(), cat.getDireccion(), cat.getMetros(), numero);
    }

    public static boolean delCatastro (Scanner sc, ListaCatastro lista) throws CatastroFormatException {
        int numero;

        System.out.print("Introduce el numero del catastro: ");
        numero = Integer.parseInt(sc.nextLine());
        return lista.delCatastro(numero);
    }

    public static boolean recuperarCatastro(Scanner sc, ListaCatastro lista) throws CatastroFormatException {
        int numero;

        System.out.print("Introduce el numero del catastro: ");
        numero = Integer.parseInt(sc.nextLine());
        return lista.recuperarCatastro(numero);
    }
}
