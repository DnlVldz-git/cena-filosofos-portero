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
public class PasswordVacioException extends Exception {

    /**
     * Creates a new instance of <code>PasswordVacioException</code> without
     * detail message.
     */
    public PasswordVacioException() {
    }

    /**
     * Constructs an instance of <code>PasswordVacioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PasswordVacioException(String msg) {
        super(msg);
    }
}
