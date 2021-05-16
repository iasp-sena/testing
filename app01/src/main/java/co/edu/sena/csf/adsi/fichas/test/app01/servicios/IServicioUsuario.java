/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.app01.servicios;

import co.edu.sena.csf.adsi.fichas.test.app01.modelo.Usuario;

/**
 *
 * @author Ismael
 */
public interface IServicioUsuario {
    Usuario buscarUsuario(String numeroDocumento);
}
