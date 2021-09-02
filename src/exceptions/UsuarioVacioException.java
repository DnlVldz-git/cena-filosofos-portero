/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author logra
 */
public class UsuarioVacioException extends Exception {

    /**
     * Creates a new instance of <code>UsuarioVacioException</code> without
     * detail message.
     */
    public UsuarioVacioException() {
    }

    /**
     * Constructs an instance of <code>UsuarioVacioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UsuarioVacioException(String msg) {
        super(msg);
    }
}
