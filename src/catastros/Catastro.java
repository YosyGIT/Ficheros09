package catastros;

import java.io.Serializable;

public class Catastro implements Comparable<Catastro>, Serializable {
    private String nombre;
    private String direccion;
    private String nombreRegex = "[A-Za-zÑñ]{1,20}";
    private String direccionRegex = "[A-Za-zÑñ]{1,50}";
    private boolean borrado;
    private double metros;
    private int nCat;

    public Catastro (String nombre, String direccion, double metros) throws CatastroFormatException{
        if (!nombre.matches(nombreRegex)){
            throw new CatastroFormatException("::ERROR:: El nombre se encuantra vacío o contiene más de 20 caracteres.");
        }
        if (!direccion.matches(direccionRegex)){
            throw new CatastroFormatException("::ERROR:: La dirección se encuentra vacía o contiene más de 50 caracteres");
        }
        if (metros <= 0){
            throw new CatastroFormatException("::ERROR:: Debe de tener más de 0 metros cuadrados.");
        }
        this.nombre = nombre;
        this.direccion = direccion;
        this.metros = metros;
        this.borrado = false;
    }

    public Catastro (String nombre, String direccion, double metros, int opc) throws CatastroFormatException{
        if (opc == 1){
            this.nombre = nombre;
            this.direccion = direccion;
            this.metros = metros;
            this.borrado = false;
        }
    }

    public Catastro(int nCat){
        this.nCat = nCat;
        this.nombre = "";
        this.direccion = "";
        this.metros = 0;
        this.borrado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getnCat(){
        return nCat;
    }

    public void setnCat(int nCat){
        this.nCat = nCat;
    }

    public double getMetros() {
        return metros;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

    public boolean isBorrado(){
        return borrado;
    }

    public void eliminarCatastro(){
        this.borrado = true;
    }

    public void recuperarCatastro(){
        this.borrado = false;
    }

    public void modificarCatastro(String nombre, String direccion, double metros){
        if (!nombre.isEmpty()) setNombre(nombre);
        if (!direccion.isEmpty()) setDireccion(direccion);
        if (metros > 0) setMetros(metros);
    }

    @Override
    public String toString(){
        return "NÚMERO DE CATASTRO [" + this.nCat + "], NOMBRE [" + this.nombre + "], DIRECCIÓN [" + this.direccion +
        "], METROS CUADRADOS [" + this.metros + "]";
    }

    @Override
    public int compareTo(Catastro o) {
        return this.nCat - o.getnCat();
    }
}
