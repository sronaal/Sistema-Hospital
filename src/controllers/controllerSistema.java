package controllers;

import database.daoSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.Hospital;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.Paciente;


public class controllerSistema implements ActionListener{
    
    daoSistema sistemaDAO = new daoSistema();
    Hospital viewHospital = new Hospital();
    
    
    
    public controllerSistema(daoSistema sistemaDAO, Hospital viewHospital) {
        this.sistemaDAO = sistemaDAO;
        this.viewHospital = viewHospital;
        
        this.viewHospital.btnRegistrarCita.addActionListener(this);
    }
    
    
    public void ejecutar() throws SQLException, ClassNotFoundException{
        viewHospital.setTitle("SISTEMA AGENDAMIENTO DE CITAS");
        viewHospital.setLocationRelativeTo(null);
        viewHospital.setVisible(true);
        
        listarMedicos();
        
    }
    
    public void listarMedicos() throws ClassNotFoundException, SQLException{
        
        ResultSet medicos =   sistemaDAO.listarMedicos();
        String NombreMedico;
        while(medicos.next()){
            NombreMedico =  medicos.getString("Nombre");
            viewHospital.cbMedico.addItem(NombreMedico);
        }
       
    }
    public int validarFormulario(String nombre, String cedula,String telefono){
        if(nombre.equals("") || cedula.equals("") || telefono.equals("")){
            return 0;
        }
        
        return 1;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == viewHospital.btnRegistrarCita){
            String nombre = viewHospital.txtNombrePaciente.getText();
            String cedula = viewHospital.txtCedulaPaciente.getText();
            String telefono = viewHospital.txtTelefono.getText();
            String medico = viewHospital.cbMedico.getSelectedItem().toString();
            int valor = validarFormulario(nombre, cedula, telefono);
            
            if(valor == 0){
                JOptionPane.showMessageDialog(null,"Todos los campos son requeridos");
            }else{
                Paciente paciente = new Paciente();
                paciente.setNombre(nombre);
                paciente.setCedula(cedula);
                paciente.setTelefon(telefono);
            
            try {
                
                int IdMedico = sistemaDAO.obtenerIdMedico(medico);
                sistemaDAO.registrarPaciente(paciente);
                int IdPaciente = sistemaDAO.obtenerIdPaciente(nombre);
                int resultado = sistemaDAO.agendarCita(IdPaciente,IdMedico);
                
                if(resultado == 1){
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
               }
                
            }catch(ClassNotFoundException ex) {
                System.out.println(ex);
            }
            }

            

                

        }

    }
    
    
}
