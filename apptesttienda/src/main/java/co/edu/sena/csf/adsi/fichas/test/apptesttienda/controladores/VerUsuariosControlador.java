/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.apptesttienda.controladores;

import co.edu.sena.csf.adsi.fichas.test.apptesttienda.excepciones.ServicioException;
import co.edu.sena.csf.adsi.fichas.test.apptesttienda.modelo.Usuario;
import co.edu.sena.csf.adsi.fichas.test.apptesttienda.servicios.UsuarioServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

/**
 *
 * @author Ismael
 */
@Named
@ViewScoped
public class VerUsuariosControlador implements Serializable {

    @Inject
    private UsuarioServicio usuarioServicio;

    @Getter
    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {
        try {
            usuarios = usuarioServicio.buscarTodos();
        } catch (ServicioException se) {
            FacesMessage message = new FacesMessage(se.getMensaje(), se.getDetalle());
            se.printStackTrace(System.out);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
