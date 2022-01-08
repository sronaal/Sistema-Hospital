package models;

/**
 *
 * @author Ronal
 */
public class Paciente {
    
    private int Id;
    private String Nombre;
    private String Cedula;
    private String Telefono;

    public Paciente() {
    }

    public Paciente(int Id, String Nombre, String Cedula, String Telefon) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.Telefono = Telefon;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getTelefon() {
        return Telefono;
    }

    public void setTelefon(String Telefon) {
        this.Telefono = Telefon;
    }
    
    
    
}
