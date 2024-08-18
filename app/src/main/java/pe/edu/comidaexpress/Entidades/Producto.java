package pe.edu.comidaexpress.Entidades;

public class Producto {
    private String codigo;
    private String nombre;
    private Double precio;
    private int imageId;

    public Producto(String codigo, String nombre, Double precio, int imageId) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.imageId = imageId;
    }

    public Producto(String codigo) { this.codigo = codigo; }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
