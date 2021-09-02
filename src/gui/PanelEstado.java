/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import exceptions.PasswordVacioException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
/**
 *
 * @author dani_
 */
public class PanelEstado extends JPanel{
    private JLabel lbl;
    private JTextField fld;
    private JButton btn;
    private JButton btnCancelar;
    private JPanel pnl;
    
    public PanelEstado(){        
        super.setBackground(Color.WHITE);
        Color color = new Color(192, 57, 43);
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));    
        super.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color));
        pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
        pnl.setBackground(Color.WHITE);
        this.lbl = new JLabel("Introduzca el estado de terminación");
        this.btn = new JButton("Aceptar");
        this.btnCancelar = new JButton("Cancelar");
        this.fld = new JTextField(10);                
        lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        btn.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
        fld.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color));
        fld.setFont(new Font("Arial", Font.PLAIN, 20));        
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setContentAreaFilled(false);
        lbl.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        btnCancelar.setAlignmentX(JComponent.CENTER_ALIGNMENT);
                
        add(lbl);
        add(Box.createRigidArea(new Dimension(0, 10)));        
        add(fld);
        add(Box.createRigidArea(new Dimension(0, 10)));        
        pnl.add(btn);
        pnl.add(Box.createRigidArea(new Dimension(10, 0)));        
        pnl.add(btnCancelar);        
        pnl.add(Box.createRigidArea(new Dimension(0, 10)));        
        add(pnl);
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
    
    public String getFldTxt() throws PasswordVacioException {
        if (this.fld.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Introduzca algo válido", "Error", JOptionPane.INFORMATION_MESSAGE);
            throw new PasswordVacioException(""); 
        }else{
            return fld.getText();
        }
    }
    
    public JButton getBtn(){
        return this.btn;
    }
    
}
