package catastros;
import java.io.*;
import java.util.TreeSet;
public class ListaCatastro {
    private TreeSet<Catastro> lista;

    public ListaCatastro (){
        this.lista = new TreeSet<>(new CompareListCatastros());
    }

    public boolean addCatastro(String nombre, String direccion, double metros) throws CatastroFormatException{
        Catastro auxnCatastro = null;
        Catastro cat = new Catastro(nombre, direccion, metros);

        if (!lista.isEmpty()){
            auxnCatastro = lista.last();
            cat.setnCat(auxnCatastro.getnCat() + 1);
        }else cat.setnCat(1);

        return addCatastro(cat);
    }

    public boolean addCatastro(Catastro cat){
        return lista.add(cat);
    }

    public Catastro identificarCatastro(int numero) throws CatastroFormatException{
        Catastro aux = new Catastro(numero);
        Catastro Cat = lista.ceiling(aux);

        if (!(Cat.getnCat() == numero)){
            throw new CatastroFormatException("::ERROR:: Catastro no encontrado");
        }
        return Cat;
    }

    public boolean delCatastro(int numero) throws CatastroFormatException {
        Catastro delCat = identificarCatastro(numero);
        delCat.eliminarCatastro();
        return true;
    }

    public boolean recuperarCatastro(int numero) throws CatastroFormatException{
        Catastro delCat = identificarCatastro(numero);
        if (delCat.getnCat() == numero && delCat.isBorrado()){
            delCat.recuperarCatastro();
            return true;
        }
        return false;
    }

    public void modificarCatastro(String nombre, String direccion, double metros, int numero) throws CatastroFormatException {
        Catastro modiCat = identificarCatastro(numero);
        modiCat.modificarCatastro(nombre, direccion, metros);
    }

    public StringBuilder listarCatastros(){
        StringBuilder texto = new StringBuilder();
        for (Catastro catastro : lista){
            if (!catastro.isBorrado()) texto.append(catastro.toString()).append("\n\n");
        }
        return texto;
    }

    public StringBuilder listarCatastro(int numero) throws CatastroFormatException{
        StringBuilder texto = new StringBuilder();
        identificarCatastro(numero);
        for (Catastro catastro : lista){
            if (catastro.getnCat() == numero){
                return texto.append(catastro.toString());
            }
        }
        return texto.append("No se encontro el catastro");
    }

    public boolean cargarFichero(File f) throws IOException {
        if (!f.exists()) throw new IOException("Fichero no encontrado");

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))){
            lista = (TreeSet<Catastro>) in.readObject();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean guardarFichero(File f) throws IOException {
        if (!f.exists()) throw new IOException("Fichero no encontrado");

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))){
            out.writeObject(lista);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
