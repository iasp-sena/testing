/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.app01.servicios;

import co.edu.sena.csf.adsi.fichas.test.app01.modelo.Habitacion;
import co.edu.sena.csf.adsi.fichas.test.app01.modelo.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyObject;
import org.mockito.Mockito;
/**
 *
 * @author Ismael
 */
@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT) 77 Deshabilita las validaciones de Mockito
@RunWith(JUnitPlatform.class)
public class ServicioHotelTest {

    @InjectMocks
    private ServicioHotel servicioHotel;
    @Mock
    private IServicioHabitacion servicioHabitacion;
    @Mock
    private IServicioUsuario servicioUsuario;
    
    @BeforeEach
    void startTests(){
    }

    @Test
    public void ocuparHabitacionCuandoUsuarioNoExite() {
        //Given
        String numeroDocumento = "4672674867362784";
        when(servicioUsuario.buscarUsuario(anyString()))
                .thenThrow(new RuntimeException());
        /* No se deben generar mocks si no se ejecutan en el flujo que se está probando
        Habitacion habMock = new Habitacion(1, true);
        when(servicioHabitacion.buscarHabitacion(anyInt())).thenReturn(habMock);
        */
        //No es necesario crear mock para métodos void
        //when(servicioHabitacion.validarDisponibilidad(habMock));
        
        //Crear mock que genera excepción sobre un método void;
        //Mockito.doThrow(new RuntimeException()).when(servicioHabitacion).validarDisponibilidad(habMock);
        
        //When //Then
        Assertions.assertThrows(RuntimeException.class, () -> servicioHotel.ocuparHabitacion(0, numeroDocumento));
    }
    
    @Test
    public void ocuparHabitacionExitosamente() {
        //Given
        String numeroDocumento = "4672674867362784";
        Usuario usuarioMock = new Usuario(1, "4672674867362784", "Andrés", "Pérez", 12);
        when(servicioUsuario.buscarUsuario(numeroDocumento))
                .thenReturn(usuarioMock);
        
        int numeroHabitacion = 101;
        Habitacion habMock = new Habitacion(101, false);
        when(servicioHabitacion.buscarHabitacion(101))
                .thenReturn(habMock);
        
        //When 
        boolean respuesta = servicioHotel.ocuparHabitacion(numeroHabitacion, numeroDocumento);
        
        //Then
        Assertions.assertTrue(respuesta);
    }
    
}
