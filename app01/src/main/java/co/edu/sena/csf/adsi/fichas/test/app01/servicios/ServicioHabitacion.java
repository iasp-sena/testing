/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.app01.servicios;

import co.edu.sena.csf.adsi.fichas.test.app01.modelo.Habitacion;
import co.edu.sena.csf.adsi.fichas.test.app01.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Ismael
 */
public class ServicioHabitacion implements IServicioHabitacion{
    
    private List<Habitacion> habitaciones = new ArrayList<>();

    public ServicioHabitacion() {
        habitaciones.add(new Habitacion(101, true));
        habitaciones.add(new Habitacion(102, true));
        habitaciones.add(new Habitacion(103, false));
        habitaciones.add(new Habitacion(104, true));
        habitaciones.add(new Habitacion(201, true));
        habitaciones.add(new Habitacion(202, false));
        habitaciones.add(new Habitacion(203, true));
        habitaciones.add(new Habitacion(204, true));
    }

    @Override
    public Habitacion buscarHabitacion(int numeroHabitacion) {
        try {
            return habitaciones.stream()
                    .filter(h -> h.getNumero() == numeroHabitacion)
                    .findFirst()
                    .get();
        } catch (Exception e) {
            throw new RuntimeException("No existe la habitación con el número: " + numeroHabitacion, e);
        }
    }

    private Habitacion buscarHabitacion2(int numeroHabitacion) {
        Optional<Habitacion> hab =  habitaciones.stream()
                    .filter(h -> h.getNumero() == numeroHabitacion)
                    .findFirst();
        if(hab.isPresent()){
            return hab.get();
        } else {
            throw new RuntimeException("No existe la habitación con el número: " + numeroHabitacion);
        }
    }

    public void validarDisponibilidad(Habitacion habitacion) {
        if(!habitacion.isEstaLibre()){
            throw new RuntimeException("La habitación ya se encuentra ocupada.");
        }
    }

    public void ocuparHabitacion(Habitacion habitacion, Usuario usuario) {
        habitacion.setEstaLibre(false);
    }
}
