package database;

import java.sql.*;

/**
 *
 * @author Ronal
 */
public class ConexionDB {
    
    Connection conn;
    
    
    public Connection Conectar() throws ClassNotFoundException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","dev","contraseña");
            System.out.println("Conexion");
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return conn;
    }

}
