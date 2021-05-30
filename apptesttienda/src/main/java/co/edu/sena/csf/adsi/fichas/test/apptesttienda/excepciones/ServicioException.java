/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.apptesttienda.excepciones;

import lombok.Getter;

/**
 *
 * @author Ismael
 */
@Getter
public class ServicioException extends Exception {

    private final int codigo;
    private final String mensaje;
    private final String detalle;

    public ServicioException(int codigo, String mensaje) {
        super(mensaje);
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.detalle = "";
    }

    public ServicioException(int codigo, String mensaje, String detalle) {
        super(mensaje);
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.detalle = detalle;
    }

    public ServicioException(int codigo, String mensaje, Throwable thrwbl) {
        super(mensaje, thrwbl);
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.detalle = "";
    }

    public ServicioException(int codigo, String mensaje, String detalle, Throwable thrwbl) {
        super(mensaje, thrwbl);
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.detalle = detalle;
    }

}
