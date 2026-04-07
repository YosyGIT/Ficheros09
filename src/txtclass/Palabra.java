package txtclass;

public class Palabra {
    private String palabra;
    private int veces;

    public Palabra(String palabra, Integer value) {
        this.palabra = palabra;
        this.veces = value;
    }

    public int getVeces() {
        return veces;
    }

    public String getPalabra() {
        return palabra;
    }
}
