package txtclass;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class ComparatorPalabra implements Comparator<String> {
    private Collator c;

    public ComparatorPalabra(){
        this.c = Collator.getInstance(new Locale("es", "ES"));
        c.setStrength(Collator.SECONDARY);
    }

    @Override
    public int compare(String s1, String s2){
        return c.compare(s1,s2);
    }
}
