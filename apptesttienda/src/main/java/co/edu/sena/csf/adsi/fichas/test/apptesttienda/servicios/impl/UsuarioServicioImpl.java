/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.apptesttienda.servicios.impl;

import co.edu.sena.csf.adsi.fichas.test.apptesttienda.dao.UsuarioDAO;
import co.edu.sena.csf.adsi.fichas.test.apptesttienda.excepciones.ServicioException;
import co.edu.sena.csf.adsi.fichas.test.apptesttienda.modelo.Usuario;
import co.edu.sena.csf.adsi.fichas.test.apptesttienda.servicios.UsuarioServicio;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Ismael
 */
@Stateless
public class UsuarioServicioImpl implements UsuarioServicio {
    
    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario buscarPorId(Integer id) throws ServicioException {
        if(Objects.isNull(id)){
            throw new ServicioException(0, "Error validación", "El id no puede ser vacio");
        }
        try{
            return usuarioDAO.buscarPorId(id);
        } catch (Exception e){
            throw new ServicioException(1, "Error al buscar el usuario con el id " + id, e);
        }
    }

    @Override
    public List<Usuario> buscarTodos() throws ServicioException {
        try{
            return usuarioDAO.buscarTodos();
        } catch (Exception e){
            throw new ServicioException(1, "Error al buscar todos los usuarios.", e);
        }
    }
    
}
