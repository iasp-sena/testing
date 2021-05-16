/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.app01.servicios;

import co.edu.sena.csf.adsi.fichas.test.app01.modelo.Habitacion;
import co.edu.sena.csf.adsi.fichas.test.app01.modelo.Usuario;
import java.util.Objects;
import javax.inject.Inject;
/**
 *
 * @author Ismael
 */
public class ServicioHotel implements IServicioHotel{

    @Inject
    private IServicioUsuario servicioUsuario;
    @Inject
    private IServicioHabitacion servicioHabitacion;

    public ServicioHotel() {
    }

    public boolean ocuparHabitacion(int numeroHabitacion, String numeroDocumento) {
        if(numeroHabitacion <= 0 || Objects.isNull(numeroDocumento) || numeroDocumento.isEmpty()){
            throw new IllegalArgumentException("El número de la habitación debe ser mayor a cero y el número de documento del usuario no puede ser vacío");
        }
        Usuario usuario = servicioUsuario.buscarUsuario(numeroDocumento);
        Habitacion habitacion = servicioHabitacion.buscarHabitacion(numeroHabitacion);
        servicioHabitacion.validarDisponibilidad(habitacion);
        servicioHabitacion.ocuparHabitacion(habitacion, usuario);
        return true;
    }

}
