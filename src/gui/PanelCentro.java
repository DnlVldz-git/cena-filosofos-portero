package gui;

import exceptions.PasswordVacioException;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelCentro extends JPanel {


    private JLabel lblIntruccion;
    private JLabel lblIdentificador;
    private JLabel lblNumIdentificador;
    private JTextArea txtIntrucciones;
    private JLabel lblPregunta;
    private JTextArea txtPregunta;
    private JPanel panelContenedor;

    private JTable tablaRespuestas;
    private JButton btnAgregarRespuesta;
    private JButton btnEliminarRespuesta;
    private JButton btnAceptar;
    private JButton btnEstado;
    private JButton btnCancelar;
    private Object TitledBorder;
    private DefaultTableModel model;
    private int numResp;

    public PanelCentro(){
    }

    public JPanel getPanel(){
        super.setBackground(Color.WHITE);
        Color color = new Color(192, 57, 43);
        super.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color));
        numResp = 0;
        panelContenedor = new JPanel();
        panelContenedor.setSize(new Dimension(527,373));
        panelContenedor.setLayout(null);

        panelContenedor.setBackground(Color.WHITE);
        panelContenedor.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, color));
        lblIdentificador = new JLabel("Identificador: ");
        lblIdentificador.setSize(150,20);
        lblIdentificador.setLocation(40,20);
        lblIdentificador.setFont(new Font("Arial", Font.PLAIN, 20));              
                
        lblNumIdentificador = new JLabel("");
        lblNumIdentificador.setSize(95,20);
        lblNumIdentificador.setLocation(160,20);
        lblNumIdentificador.setFont(new Font("Arial", Font.PLAIN, 20));   

        lblIntruccion = new JLabel("Instrucciones:");
        lblIntruccion.setSize(150,20);
        lblIntruccion.setLocation(40,70);
        lblIntruccion.setFont(new Font("Arial", Font.PLAIN, 20));   

        txtIntrucciones = new JTextArea();
        txtIntrucciones.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color));
        txtIntrucciones.setFont(new Font("Arial", Font.PLAIN, 20));   
        txtIntrucciones.setSize(430,80);
        txtIntrucciones.setLocation(40,100);
        txtIntrucciones.setLineWrap(true);
        txtIntrucciones.setWrapStyleWord(true);
        Dimension dimension = new Dimension(430,80);        
        txtIntrucciones.setPreferredSize(dimension);

        lblPregunta = new JLabel("Pregunta: ");
        lblPregunta.setFont(new Font("Arial", Font.PLAIN, 20));   
        lblPregunta.setSize(100,20);
        lblPregunta.setLocation(40,210);

        txtPregunta = new JTextArea();         
        txtPregunta.setSize(430,30);
        
        txtPregunta.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color));
        txtPregunta.setLocation(40,250);
        txtPregunta.setFont(new Font("Arial", Font.PLAIN, 20)); 
        txtPregunta.setLineWrap(true);
        txtPregunta.setWrapStyleWord(true);
        Dimension dimension1 = new Dimension(350,30);
        txtPregunta.setPreferredSize(dimension1);

        JPanel panelTabla = new JPanel();

        model = new DefaultTableModel();
        tablaRespuestas = new JTable(model);        
        model.addColumn("ID");
        model.addColumn("Instrucción");
        JScrollPane scrollPane = new JScrollPane(tablaRespuestas);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);        
        tablaRespuestas.getTableHeader().setFont(new Font("Arial", Font.BOLD, 19));
        tablaRespuestas.setFont(new Font("Arial", Font.PLAIN, 19));
        tablaRespuestas.setRowHeight(24);
                
        scrollPane.setPreferredSize(new Dimension(480, 155));                
        
        tablaRespuestas.setFillsViewportHeight(true);

        panelTabla.setSize(480, 160);
        //scrollPane.setBorder(BorderFactory. createMatteBorder(0, 3, 3, 1, color));
        panelTabla.setLocation(20,300);

        panelTabla.add(scrollPane);       

        btnAgregarRespuesta = new JButton("Agregar");
        btnAgregarRespuesta.setFont(new Font("Arial", Font.PLAIN, 20));           
        btnAgregarRespuesta.setFocusPainted(false);
        btnAgregarRespuesta.setContentAreaFilled(false);
        
        btnAgregarRespuesta.setSize(120,30);
        btnAgregarRespuesta.setLocation(35,480);

        btnEliminarRespuesta = new JButton("Eliminar");
        btnEliminarRespuesta.setFont(new Font("Arial", Font.PLAIN, 20));   
        btnEliminarRespuesta.setFocusPainted(false);
        btnEliminarRespuesta.setContentAreaFilled(false);
        btnEliminarRespuesta.setSize(120,30);
        btnEliminarRespuesta.setLocation(200,480);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setFont(new Font("Arial", Font.PLAIN, 20));   
        btnAceptar.setFocusPainted(false);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setSize(120,30);
        btnAceptar.setLocation(370,480);

        btnEstado = new JButton("Terminar Flujo");
        btnEstado.setFont(new Font("Arial", Font.PLAIN, 20));   
        btnEstado.setFocusPainted(false);
        btnEstado.setContentAreaFilled(false);
        btnEstado.setSize(200,30);
        btnEstado.setLocation(260,540);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));   
        btnCancelar.setFocusPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setSize(160,30);
        btnCancelar.setLocation(60,540);

        panelContenedor.add(lblIdentificador);
        panelContenedor.add(lblNumIdentificador);
        panelContenedor.add(lblIntruccion);
        panelContenedor.add(txtIntrucciones);
        panelContenedor.add(lblPregunta);
        panelContenedor.add(txtPregunta);
        panelContenedor.add(panelTabla);

        panelContenedor.add(btnAgregarRespuesta);
        panelContenedor.add(btnEliminarRespuesta);
        panelContenedor.add(btnAceptar);
        panelContenedor.add(btnEstado);
        panelContenedor.add(btnCancelar);

        return this.panelContenedor;
    }

    public JButton getBtnEstado() {
        return btnEstado;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public String getTxtIntruccionesTxt() throws PasswordVacioException {
        if (txtIntrucciones.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Introduzca una Instrucción");
            throw new PasswordVacioException(""); 
        }else{
            return txtIntrucciones.getText();
        }
    }  

    public String getTxtPreguntaTxt() throws PasswordVacioException {
        if (txtPregunta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Introduzca una Pregunta");
            throw new PasswordVacioException(""); 
        }else{
            return txtPregunta.getText();
        }
    }

    public void setTxtPregunta(JTextArea txtPregunta) {
        this.txtPregunta = txtPregunta;
    }

    public JLabel getLblIntruccion() {
        return lblIntruccion;
    }

    public void setLblIntruccion(JLabel lblIntruccion) {
        this.lblIntruccion = lblIntruccion;
    }

    public JLabel getLblPregunta() {
        return lblPregunta;
    }

    public void setLblPregunta(JLabel lblPregunta) {
        this.lblPregunta = lblPregunta;
    }

    public JLabel getLblNumIdentificador() {
        return lblNumIdentificador;
    }
    
    public int numResp(){
        numResp++;
        return numResp;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JTable getTablaRespuestas() {
        return tablaRespuestas;
    }

    public void setTablaRespuestas(JTable tablaRespuestas) {
        this.tablaRespuestas = tablaRespuestas;
    }

    public JButton getBtnAgregarRespuesta() {
        return btnAgregarRespuesta;
    }

    public void setBtnAgregarRespuesta(JButton btnAgregarRespuesta) {
        this.btnAgregarRespuesta = btnAgregarRespuesta;
    }

    public JButton getBtnEliminarRespuesta() {
        return btnEliminarRespuesta;
    }

    public void setBtnEliminarRespuesta(JButton btnEliminarRespuesta) {
        this.btnEliminarRespuesta = btnEliminarRespuesta;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }
}
