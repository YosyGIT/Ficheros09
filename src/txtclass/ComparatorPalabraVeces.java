package txtclass;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class ComparatorPalabraVeces implements Comparator<Palabra> {
    private Collator collator;

    public ComparatorPalabraVeces() {
        collator = Collator.getInstance(new Locale("es", "ES"));
        collator.setStrength(Collator.SECONDARY);
    }

    @Override
    public int compare(Palabra o1, Palabra o2) {
        int compValor = Integer.compare(o2.getVeces(), o1.getVeces());
        if (compValor == 0) return collator.compare(o1.getPalabra(), o2.getPalabra());
        return compValor;
    }
}
