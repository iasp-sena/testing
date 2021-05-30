/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.apptesttienda.dao.jpa.impl;

import co.edu.sena.csf.adsi.fichas.test.apptesttienda.modelo.Usuario;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;


/**
 *
 * @author Ismael
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class UsuarioDAOJPATest {
    
    @InjectMocks
    private UsuarioDAOJPA usuarioDAO = new UsuarioDAOJPA();
    @Mock
    private EntityManager emMock;
    
    @Test
    public void testBuscarUsuarioPorIdQueExiste() {
        Usuario usuarioMock = Usuario.builder()
                .id(1)
                .build();
        //Given
        int idUsuario = 1;
        when(emMock.find(Usuario.class, idUsuario)).thenReturn(usuarioMock);
        //When
        Usuario usuarioResultante = usuarioDAO.buscarPorId(idUsuario);
        //Then
        assertNotNull(usuarioResultante);
        assertEquals(idUsuario, usuarioResultante.getId());
    }

    @Test
    public void testBuscarUsuarioPorIdQueNoExiste() {
        //Given
        int idUsuario = 2;
        when(emMock.find(Usuario.class, idUsuario)).thenReturn(null);
        //When
        Usuario usuarioResultante = usuarioDAO.buscarPorId(idUsuario);
        //Then
        assertNull(usuarioResultante);
    }

    @Test
    public void testBuscarUsuarioPorIdNulo() {
        //Given
        Integer idUsuario = null;
        //When
        Usuario usuarioResultante = usuarioDAO.buscarPorId(idUsuario);
        //Then
        assertNull(usuarioResultante);
    }


    @Test
    public void testBuscarTodosLosUsuarios() {
        //Given
        TypedQuery queryMock = Mockito.mock(TypedQuery.class);
        when(emMock.createNamedQuery(anyString(), any())).thenReturn(queryMock);
        when(queryMock.getResultList()).thenReturn(Collections.emptyList());
        //When
        List<Usuario> usuariosResultantes = usuarioDAO.buscarTodos();
        //Then
        assertNotNull(usuariosResultantes);
        assertTrue(usuariosResultantes.isEmpty());
    }
    
}
