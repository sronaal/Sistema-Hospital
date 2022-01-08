package models;

/**
 *
 * @author Ronal
 */
public class Medico {
    
    private int IdMedico;
    private String Nombre;
    private String Telefono;
    private int Consultorio;

    public Medico() {
    }

    
    public Medico(int IdMedico, String Nombre, String Telefono, int Consultorio) {
        this.IdMedico = IdMedico;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Consultorio = Consultorio;
    }

    public int getIdMedico() {
        return IdMedico;
    }

    public void setIdMedico(int IdMedico) {
        this.IdMedico = IdMedico;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getConsultorio() {
        return Consultorio;
    }

    public void setConsultorio(int Consultorio) {
        this.Consultorio = Consultorio;
    }


    

    
}
