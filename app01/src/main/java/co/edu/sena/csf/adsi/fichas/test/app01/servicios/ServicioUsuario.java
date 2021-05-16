/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.app01.servicios;

import co.edu.sena.csf.adsi.fichas.test.app01.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ismael
 */
public class ServicioUsuario implements IServicioUsuario{

    private List<Usuario> usuarios = new ArrayList<>();
    
    public ServicioUsuario() {
        usuarios.add(new Usuario(1, "123123123", "Andrés", "Sanabria", 24));
        usuarios.add(new Usuario(2, "234567890", "Carlos", "Buendía", 32));
        usuarios.add(new Usuario(3, "789456123", "Daniela", "Castro", 21));
        usuarios.add(new Usuario(4, "894561230", "Adriana", "Niño", 31));
        usuarios.add(new Usuario(5, "894461235", "Edwin", "Pérez", 32));

    }

    @Override
    public Usuario buscarUsuario(String numeroDocumento) {
        for (Usuario u : usuarios) {
            if (u.getNumeroDocumento().equals(numeroDocumento)) {
                return u;
            }
        }
        throw new RuntimeException("Usuario no registrado con el número: " + numeroDocumento);
    }
}
