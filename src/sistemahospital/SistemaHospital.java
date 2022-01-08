package sistemahospital;

import controllers.controllerSistema;
import database.daoSistema;
import java.sql.SQLException;
import views.Hospital;

/**
 *
 * @author Ronal
 */
public class SistemaHospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Hospital viewHospital = new Hospital();
        daoSistema sistemaDAO = new daoSistema();
        controllerSistema controlador = new controllerSistema(sistemaDAO, viewHospital);
        
        controlador.ejecutar();
    }
    
}
