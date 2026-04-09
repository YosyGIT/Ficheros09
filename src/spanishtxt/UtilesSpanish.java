package spanishtxt;

import txtclass.ComparatorPalabra;
import txtclass.ListaPalabras;
import txtclass.Palabra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public abstract class UtilesSpanish {

    public static boolean equalsFiles(File f1, File f2) throws FileNotFoundException {
        try (Scanner sc1 = new Scanner(f1) ; Scanner sc2 = new Scanner(f2)) {
            while (sc1.hasNextLine() && sc2.hasNextLine()) {
                String line1 = sc1.nextLine();
                String line2 = sc2.nextLine();
                if (!line1.equals(line2)) return false;
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("::ERROR:: Ha ocurrido un error al intentar comparar los archivos, tipo de error:\n" +
                    e.getMessage());
        }

        return true;
    }

    public static String contarP (File f) throws FileNotFoundException {
        StringBuilder texto = new StringBuilder();
        String palabra;
        TreeMap<String, Integer> palabraCont = new TreeMap<>(new ComparatorPalabra());

        try (Scanner file = new Scanner(f)){

            while(file.hasNext()){
                palabra = file.next().toLowerCase();
                palabra = palabra.replaceAll("[\\p{P}\\p{S}]", " ").trim();
                if (!palabra.isEmpty()){
                    if (palabraCont.containsKey(palabra)){
                        palabraCont.put(palabra, palabraCont.get(palabra) + 1);
                    }else {
                        palabraCont.put(palabra, 1);
                    }
                }
            }
        }catch (FileNotFoundException e){
            throw new FileNotFoundException("::ERROR:: Ocurrio un error al intentar contar las palabras, tipo de error: \n" +
                    e.getMessage());
        }

        for (Map.Entry<String, Integer> pal : palabraCont.entrySet()){
            texto.append(pal.getKey()).append(", ").append(pal.getValue()).append(" veces\n");
        }

        return texto.length() != 0?"-:Contador de palabras:-\n\n" + texto.toString():"El fichero esta vacío o contiene caracteres no validos.";
    }

    public static String contarN (File f) throws FileNotFoundException {
        StringBuilder texto = new StringBuilder();
        String palabra;
        TreeMap<String, Integer> palabraCont = new TreeMap<>(new ComparatorPalabra());
        ListaPalabras listaPalabras = new ListaPalabras();

        try (Scanner file = new Scanner(f)){

            while(file.hasNext()){
                palabra = file.next().toLowerCase();
                palabra = palabra.replaceAll("[\\p{P}\\p{S}]", " ").trim();
                if (!palabra.isEmpty()){
                    if (palabraCont.containsKey(palabra)){
                        palabraCont.put(palabra, palabraCont.get(palabra) + 1);
                    }else {
                        palabraCont.put(palabra, 1);
                    }
                }
            }

            listaPalabras.crearLista(palabraCont);
        }catch (FileNotFoundException e){
            throw new FileNotFoundException("::ERROR:: Ocurrio un error al intentar contar las palabras, tipo de error: \n" +
                    e.getMessage());
        }

        for (Palabra p : listaPalabras.getLista()){
            texto.append(p.getPalabra()).append(", ").append(p.getVeces()).append(" veces\n");
        }

        return texto.length() != 0?"-:Contador de palabras:-\n\n" + texto.toString():"El fichero esta vacío o contiene caracteres no validos.";
    }

    public static StringBuilder mostrarDefinicion(ArrayList<PalabraDic> lista, String palabra){
        StringBuilder texto = new StringBuilder();
        int cont = 1;

        for (PalabraDic p : lista){
            if (palabra.charAt(0) > p.getPalabra().charAt(0)){
                return texto.isEmpty()?texto.append("No se encontro definiciones con esa palabra"):texto;
            }
            if (palabra.equals(p.getPalabra())){
                texto.append(cont).append(". ").append(p.getDefinicion()).append("\n");
                cont++;
            }
        }

        return texto;
    }
}
