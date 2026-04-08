package spanishtxt;

public class PalabraDic {
    private String palabra;
    private String definicion;

    public PalabraDic(String palabra, String definicion) {
        this.palabra = palabra;
        this.definicion = definicion;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getDefinicion() {
        return definicion;
    }


}
