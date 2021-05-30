/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.apptesttienda.dao.jpa.impl;

import co.edu.sena.csf.adsi.fichas.test.apptesttienda.dao.UsuarioDAO;
import co.edu.sena.csf.adsi.fichas.test.apptesttienda.dao.jpa.AbstractDAO;
import co.edu.sena.csf.adsi.fichas.test.apptesttienda.modelo.Usuario;
import javax.ejb.Stateless;

/**
 *
 * @author Ismael
 */
@Stateless
public class UsuarioDAOJPA extends AbstractDAO<Usuario, Integer> implements UsuarioDAO{
    
    public UsuarioDAOJPA() {
        super(Usuario.class);
    }
    
}
