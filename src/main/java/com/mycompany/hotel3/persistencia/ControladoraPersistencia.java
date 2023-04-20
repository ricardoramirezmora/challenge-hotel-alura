package com.mycompany.hotel3.persistencia;

import com.mycompany.hotel3.logica.Huespedes;
import com.mycompany.hotel3.logica.Reservas;
import com.mycompany.hotel3.logica.Usuarios;
import com.mycompany.hotel3.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    UsuariosJpaController usuJpa = new UsuariosJpaController();
    HuespedesJpaController huesJpa = new HuespedesJpaController();
    ReservasJpaController resJpa = new ReservasJpaController();
    
    public List<Usuarios> validarUsuario() {
       return usuJpa.findUsuariosEntities();
    }
    
    //------------------Huesped---------------------

    public void crearHuesped(Huespedes huesped) {
        huesJpa.create(huesped);
    }

    public void eliminarHuesped(int idHuesped) {
        try {
            huesJpa.destroy(idHuesped);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarHuesped(Huespedes huesped) {
        try {
            huesJpa.edit(huesped);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Huespedes traerHuesped(int idHuesped) {
       return huesJpa.findHuespedes(idHuesped);
    }

    public List<Huespedes> traerHuespedes() {
        return huesJpa.findHuespedesEntities();
    }
    
    //-------------------Reservas--------------------------

    public void crearReseva(Reservas reserva) {
        resJpa.create(reserva);
    }

    public void eliminarReserva(int idReserva) {
        try {
            resJpa.destroy(idReserva);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarReserva(Reservas reserva) {
        
    }

    public Reservas traerReserva(int idReserva) {
        return resJpa.findReservas(idReserva);
    }

    public List<Reservas> traerReservas() {
        return resJpa.findReservasEntities();
    }

   
}
