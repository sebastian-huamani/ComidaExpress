package pe.edu.comidaexpress.Entidades;

public class Persona  {
    private String nombre;
    private String fechanacimiento;
    private int imagenId;


    public Persona(String nombre, String fechanacimiento, int imagenId) {
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
        this.imagenId = imagenId;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
