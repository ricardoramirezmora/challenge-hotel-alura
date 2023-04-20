package com.mycompany.hotel3.logica;

import com.mycompany.hotel3.igu.VentanaInicio;
import com.mycompany.hotel3.igu.VentanaReservas;
import com.mycompany.hotel3.persistencia.ControladoraPersistencia;
import java.sql.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ControladoraLogica {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void validarUsuario(String usuario, String contrasenia) {
        List<Usuarios> listaUsuarios = controlPersis.validarUsuario();
        
        if(listaUsuarios != null){
            for(Usuarios usu:listaUsuarios){
                if(usu.getUsuario().equals(usuario)){
                    if(usu.getContrasenia().equals(contrasenia)){
                        mostrarMensaje("Usuario y contraseña correctos. Bienvenido/a", "Info", "Ingresar");
                        VentanaInicio ventanaInicio = new VentanaInicio();
                        ventanaInicio.setVisible(true);
                        ventanaInicio.setLocationRelativeTo(null);
                    }else{
                        mostrarMensaje("Contraseña Incorrecta", "Error", "Error");
                    }
                }else{
                    mostrarMensaje("Usuario Incorrecto", "Error", "Error");
                }
            }
        }
        
    }
    
    //--------------Huespedes---------------------
    public void crearHuesped(String nombreHuesped, String apellido, String fechaNac, String nacionalidad, String telefono) {
        Huespedes huesped = new Huespedes();
        huesped.setNombre(nombreHuesped);
        huesped.setApellido(apellido);
        huesped.setFechaNacimiento(Date.valueOf(fechaNac));
        huesped.setNacionalidad(nacionalidad);
        huesped.setTelefono(telefono);
        
        controlPersis.crearHuesped(huesped);
    }
    
    public void eliminarHuesped(int idHuesped){
        controlPersis.eliminarHuesped(idHuesped);
    }
    
     public void editarHuesped(Huespedes huesped, String nombreHuesped, String apellido, String fechaNac, String nacionalidad, String telefono) {
        huesped.setNombre(nombreHuesped);
        huesped.setApellido(apellido);
        huesped.setFechaNacimiento(Date.valueOf(fechaNac));
        huesped.setNacionalidad(nacionalidad);
        huesped.setTelefono(telefono);
        
        controlPersis.editarHuesped(huesped);
    }
     
     public void editarHuesped(int num_huesped) {
        
    }
     
     public Huespedes traerHuesped(int idHuesped){
        return controlPersis.traerHuesped(idHuesped);
    }
     
    public List<Huespedes> traerHuespedes(){
        return controlPersis.traerHuespedes();
    }
    
    //----------------Reservas------------------------
     public void crearReserva(String fechaEntrada, String fechaSalida, String costo, String formaPago) {
        Reservas reserva = new Reservas();
        
        reserva.setFechaEntrada(Date.valueOf(fechaEntrada));
        reserva.setFechaSalida(Date.valueOf(fechaSalida));
        reserva.setValor(Integer.parseInt(costo));
        reserva.setFormaPago(formaPago);
        
        controlPersis.crearReseva(reserva);
    }
    
    public void eliminarReserva(int idReserva){
        controlPersis.eliminarReserva(idReserva);
    }
    
     public void editarReserva(Reservas reserva){
        controlPersis.editarReserva(reserva);
    }
     
     public Reservas traerReserva(int idReserva){
        return controlPersis.traerReserva(idReserva);
    }
     
    public List<Reservas> traerReservas(){
        return controlPersis.traerReservas();
    }
    
    
    private void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if(tipo.equals("Info")){
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(tipo.equals("Error")){
                optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
            }
        }
        
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }    

    

    

    
}
