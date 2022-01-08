package database;

import java.sql.*;
import models.Medico;
import models.Paciente;
public class daoSistema {    
    
    Connection conn;
    PreparedStatement ps;
    ResultSet result;
    ConexionDB conexion = new ConexionDB();
    Medico medico = new Medico();
    Paciente paciente = new Paciente();
    
    
    
    public ResultSet listarMedicos() throws ClassNotFoundException{
        
        conn = conexion.Conectar();
        String sql = "SELECT Nombre FROM Medico";
        
        try {
           ps = conn.prepareStatement(sql);
           result = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error Listar Medicos " +e);
        }
        
        return result;
    }
    
    public int obtenerIdMedico(String nombre) throws ClassNotFoundException{
        
        conn = conexion.Conectar();
        String sql = "SELECT * FROM medico where Nombre = ?";
        int IdMedico = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            result = ps.executeQuery();
            while(result.next()){
                IdMedico = result.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error obtener Id Medico " + e);
        }
        
        
        return IdMedico;
    }
    
    
    public void registrarPaciente(Paciente paciente) throws ClassNotFoundException{
        
        conn = conexion.Conectar();
        String sql = "INSERT INTO paciente(Nombre,Cedula,Telefono) values(?,?,?)";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getCedula());
            ps.setString(3, paciente.getTelefon());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Registro Paciente " + e);
        }
    }

    public int obtenerIdPaciente(String nombre) throws ClassNotFoundException{
        
        int IdPaciente = 0;
        String sql  = "SELECT IdPaciente from paciente where Nombre = ?";
        conn = conexion.Conectar();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            result = ps.executeQuery();
            
            while(result.next()){
                IdPaciente = result.getInt(1);
            }
            
        } catch (SQLException e) {
            System.out.println("Obtener IdPaciente " + e);
        }
        
        return IdPaciente;
    }
    
    
    public int agendarCita(int IdPaciente, int IdMedico) throws ClassNotFoundException{
        int resultado = 0;
        conn = conexion.Conectar();
        String sql = "INSERT INTO citas(Paciente_IdPaciente,Medico_IdMedico) values(?,?)";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, IdPaciente);
            ps.setInt(2, IdMedico);
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Agendar Cita " + e);
        }
        
        return resultado;
        
    
    }
}
