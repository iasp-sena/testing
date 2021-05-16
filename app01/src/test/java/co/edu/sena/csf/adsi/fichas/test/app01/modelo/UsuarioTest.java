/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.app01.modelo;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 *
 * @author Ismael
 */
@RunWith(JUnitPlatform.class)
class UsuarioTest {

    @Test
    void getNombresCuandoEsNulo() {
        //Condiciones iniciales             -> Dado     -> Given
        Usuario miUsuario = new Usuario();
        //Ejecución del método a probar     -> Cuando   -> When
        String nombreDevuelto = miUsuario.getNombres();
        //Comprobar el resultado            -> Entonces -> Then
        assertNull(nombreDevuelto);
    }

    @Test
    void getNombreCuandoNoEsNulo() {
        //Given
        Usuario miUsuario = new Usuario(1, "123456", "Iván", "Ramirez", 20);
        //When
        String nombreDevuelto = miUsuario.getNombres();
        //
        assertNotNull(nombreDevuelto);
        assertEquals("Iván", nombreDevuelto);
    }

    @Test
    void equalsCuandoEsNuloElObjeto() {
        //Given
        Usuario miUsuario = new Usuario(1, "123456", "Iván", "Ramirez", 20);
        //When
        boolean resultado = miUsuario.equals(null);
        //
        assertFalse(resultado);
    }

    @Test
    void equalsCuandoEsElMismoObjeto() {
        //Given
        Usuario miUsuario = new Usuario(1, "123456", "Iván", "Ramirez", 20);
        Usuario otroUsuario = miUsuario;
        //When
        boolean resultado = miUsuario.equals(otroUsuario);
        //
        assertTrue(resultado);
    }

    @Test
    void equalsCuandoElIdEsElMismo() {
        //Given
        Usuario miUsuario = new Usuario(1);
        Object otroObjeto = new Usuario(1);
        //When
        boolean resultado = miUsuario.equals(otroObjeto);
        //
        assertTrue(resultado);
    }

    @Test
    void equalsCuandoSoloElIdEsElMismo() {
        //Given
        Usuario miUsuario = new Usuario(1, "123456", "Iván", "Ramirez", 20);
        Usuario otroUsuario = new Usuario(1, "123456", "Pepe", "Díaz", 19);
        //When
        boolean resultado = miUsuario.equals(otroUsuario);
        //
        assertTrue(resultado);
    }

    @Test
    void esMayorDeEdadCuandoTiene18() {
        //Given
        Usuario miUsuario = new Usuario();
        miUsuario.setEdad(18);
        //When
        boolean respuesta = miUsuario.esMayorDeEdad();
        //Then
        assertTrue(respuesta);
    }

    @Test
    void esMayorDeEdadCuandoTieneMenosDe18() {
        //Given
        Usuario miUsuario = new Usuario();
        miUsuario.setEdad(17);
        //When
        boolean respuesta = miUsuario.esMayorDeEdad();
        //Then
        assertFalse(respuesta);
    }
}
