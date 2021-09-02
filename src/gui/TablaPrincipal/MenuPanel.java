/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.TablaPrincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
/**
 *
 * @author dani_
 */
public class MenuPanel extends JPanel{
    private JButton btnNuevo;
    private JButton btnBorrar;
    private JButton btnGuardar;
    
    public MenuPanel(){
        super.setBackground(Color.white);
        super.setSize(1500, 100);
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));    
        
        this.btnNuevo = new JButton("Nuevo");
        this.btnBorrar = new JButton("Borrar");
        this.btnGuardar = new JButton("Guardar");
        
        btnNuevo.setFont(new Font("Arial", Font.PLAIN, 20));        
        btnNuevo.setFocusPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnBorrar.setFont(new Font("Arial", Font.PLAIN, 20));        
        btnBorrar.setFocusPainted(false);
        btnBorrar.setContentAreaFilled(false);
        btnGuardar.setFont(new Font("Arial", Font.PLAIN, 20));        
        btnGuardar.setFocusPainted(false);
        btnGuardar.setContentAreaFilled(false);
        
        add(Box.createRigidArea(new Dimension(900, 0)));
        add(btnGuardar);
        add(Box.createRigidArea(new Dimension(150, 0)));
        add(btnNuevo);
        add(Box.createRigidArea(new Dimension(20, 0)));
        add(btnBorrar);                
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(JButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }
}
