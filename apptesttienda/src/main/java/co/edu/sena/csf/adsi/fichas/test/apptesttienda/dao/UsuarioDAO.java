/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.apptesttienda.dao;

import co.edu.sena.csf.adsi.fichas.test.apptesttienda.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ismael
 */
@Local
public interface UsuarioDAO extends Serializable {

    Usuario buscarPorId(Integer id);

    List<Usuario> buscarTodos();
    
}
