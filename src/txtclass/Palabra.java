package txtclass;

import java.io.FileNotFoundException;
import java.util.Objects;

public class Palabra {
    private String p;
    private int cont;

    public Palabra(String palabra) {
        if (!palabra.isEmpty()){
            this.p = palabra;
        }
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Palabra palabra)) return false;
        return Objects.equals(p, palabra.p);
    }
}

