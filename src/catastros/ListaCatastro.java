package catastros;
import java.util.TreeSet;
public class ListaCatastro {
    private TreeSet<Catastro> lista;

    public ListaCatastro (){
        this.lista = new TreeSet<>(new CompareListCatastros());
    }

    public boolean addCatastro(String nombre, String direccion, double metros) throws CatastroFormatException{
        Catastro auxnCatastro = lista.last();
        Catastro cat = new Catastro(nombre, direccion, metros);
        cat.setnCat(auxnCatastro.getnCat() + 1);
        return addCatastro(cat);
    }

    public boolean addCatastro(Catastro cat){
        return lista.add(cat);
    }

    public boolean delCatastro(int numero){
        Catastro aux = new Catastro(numero);
        Catastro delCat = lista.ceiling(aux);
        //return (delCat.getnCat() );
        return true;
    }
}
