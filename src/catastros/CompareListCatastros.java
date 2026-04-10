package catastros;

import java.util.Comparator;

public class CompareListCatastros implements Comparator<Catastro> {

    @Override
    public int compare(Catastro o1, Catastro o2) {
        return o1.getnCat() - o2.getnCat();
    }
}
