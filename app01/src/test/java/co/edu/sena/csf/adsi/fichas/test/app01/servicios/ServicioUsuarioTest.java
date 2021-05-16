/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.app01.servicios;

import co.edu.sena.csf.adsi.fichas.test.app01.modelo.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author Ismael
 */
@RunWith(JUnitPlatform.class)
class ServicioUsuarioTest {
    
    private ServicioUsuario servicioUsuario;

    private String paramNumeroDocumento;
    private Usuario usuarioEncontrado;
    private Exception exception;
    
    @BeforeAll
    static void startTests(){
        System.out.println("Inciamos los test de la clase.....");
    }
    
    @BeforeEach
    void initTest(){
        servicioUsuario = new ServicioUsuario();
        paramNumeroDocumento = null;
        usuarioEncontrado = null;
        exception = null;
    }
    
    @AfterEach
    void endtest(){
        System.out.println("Termianos la ejecución de un test.....");
    }
    
    @AfterAll
    static void endtests(){
        System.out.println("Termianos los test de la clase.....");
    }

    @Test
    void buscarUsuarioCuandoExiste() {
        //Given
        dadoUnNumeroDocumentoQueExiste();
        //When
        cuandoBuscoElUsuarioPorNumeroDocumento();
        //Then
        entoncesElUsuarioExiste();
    }
    
    @Test
    void buscarUsuarioCuandoNoExiste() {
        //Given
        dadoUnNumeroDocumentoQueNoExiste();
        //When
        cuandoBuscoElUsuarioPorNumeroDocumento();
        //Then
        entoncesSeGeneraExpecion();
    }


    private void dadoUnNumeroDocumentoQueExiste() {
        this.paramNumeroDocumento = "234567890";
    }
    
    private void entoncesElUsuarioExiste() {
        assertNull(exception);
        assertNotNull(usuarioEncontrado);
        assertEquals(paramNumeroDocumento, usuarioEncontrado.getNumeroDocumento());
    }

    private void dadoUnNumeroDocumentoQueNoExiste() {
        this.paramNumeroDocumento = "5734785978934579";
    }
    
    private void entoncesSeGeneraExpecion() {
        assertNull(usuarioEncontrado);
        assertNotNull(exception);
        assertEquals(RuntimeException.class, exception.getClass());
        assertEquals("Usuario no registrado con el número: " + paramNumeroDocumento, exception.getMessage());
    }
    
    private void cuandoBuscoElUsuarioPorNumeroDocumento() {
        try {
            this.usuarioEncontrado = servicioUsuario.buscarUsuario(paramNumeroDocumento);
        } catch (Exception e){
            this.exception = e;
        }
    }
    
}
