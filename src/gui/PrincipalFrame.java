/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import gui.TablaPrincipal.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Cuestionario.*;
import exceptions.PasswordVacioException;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import Files.*;
import java.util.Set;

/**
 *
 * @author dani_
 */
public class PrincipalFrame extends JFrame {

    private MenuPanel menuPanel;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private PanelCentro panelCentro;
    private Cuestionario cuestionario;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane2;
    private JTable tabla;
    private JTable tabla2;
    private int num;
    private int num2;
    private boolean bandera;
    private FilesJSON write;
    private PanelEstado panelEstado;

    public PrincipalFrame() {
        write = new FilesJSON();
        num = 1;
        num2 = 0;
        bandera = false;
        super.setTitle("Tabla");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(1500, 1000);
        super.setLayout(new BorderLayout());

        super.setLocationRelativeTo(null);
        model = new DefaultTableModel();
        model2 = new DefaultTableModel();
        menuPanel = new MenuPanel();
        cuestionario = new Cuestionario();

        config();

        menuPanel.getBtnNuevo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    panelCentro = new PanelCentro();
                    JDialog dialog = new JDialog();
                    dialog.setResizable(false);
                    dialog.setUndecorated(true);
                    dialog.add(panelCentro.getPanel());
                    if (num == 1) {
                        panelCentro.getLblNumIdentificador().setText("1");
                        configNuevo(dialog);
                    } else {
                        if (tabla2.getSelectedRow() != -1) {
                            for (int t = 0; t < cuestionario.getPreguntas().size(); t++) {
                                if ((cuestionario.getPreguntas().get(tabla.getSelectedRow()).getRespuestas().get(tabla2.getSelectedRow()).getIndice() == cuestionario.getPreguntas().get(t).getId())) {
                                    JOptionPane.showMessageDialog(panelCentro, "Ya existe una pregunta o estado para la respuesta seleccionada");

                                    dialog.setVisible(false);
                                    dialog.dispose();
                                    return;
                                }
                            }
                            if (!(cuestionario.getPreguntas().get(tabla.getSelectedRow()).getRespuestas().get(tabla2.getSelectedRow()).getEstado().equals("Sin estado"))) {
                                JOptionPane.showMessageDialog(panelCentro, "Ya existe una pregunta o estado para la respuesta seleccionada");
                                dialog.setVisible(false);
                            } else {
                                configNuevo(dialog);
                            }
                        } else if ((tabla.getSelectedRow() == -1)) {
                            JOptionPane.showMessageDialog(null, "Seleccione una pregunta y una respuesta");
                        } else if ((tabla2.getSelectedRow() == -1)) {
                            JOptionPane.showMessageDialog(null, "Seleccione la respuesta que le agregará una pregunta");
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.toString() + e.getMessage() + e.getLocalizedMessage());
                }
            }
        });

        menuPanel.getBtnBorrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = tabla.getSelectedRow();

                if (i == model.getRowCount() - 1) {
                    num2--;
                    for (int j = 0; j < cuestionario.getPreguntas().get(i).getRespuestas().size(); j++) {
                        num--;
                    }
                    cuestionario.getPreguntas().remove(i);
                    if (i < 0 && model.getRowCount() > 0) {
                        i = 0;
                    }

                    if (i >= 0) {
                        model.removeRow(i);
                        tabla.revalidate();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No puede eliminar preguntas que no sean recientes, su flujo podría verse alterado");
                }

            }
        });

        menuPanel.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                write.saveFile(cuestionario.getPreguntas(), "preguntas.json");
            }
        });

        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if ((!event.getValueIsAdjusting())) {

                    for (int i = model2.getRowCount() - 1; i >= 0; i--) {
                        model2.removeRow(i);
                    }
                    if (tabla.getSelectedRow() >= 0 && tabla.getSelectedRow() < tabla.getRowCount()) {
                        for (int i = 0; i < cuestionario.getPreguntas().get(tabla.getSelectedRow()).getRespuestas().size(); i++) {
                            Object[] ob = {cuestionario.getPreguntas().get(tabla.getSelectedRow()).getRespuestas().get(i).getIndice(), cuestionario.getPreguntas().get(tabla.getSelectedRow()).getRespuestas().get(i).getRespuesta(), cuestionario.getPreguntas().get(tabla.getSelectedRow()).getRespuestas().get(i).getEstado()};
                            model2.addRow(ob);
                        }
                    }
                }
            }
        });

        add(menuPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(scrollPane2, BorderLayout.SOUTH);

        super.setVisible(true);
    }

    public void configNuevo(JDialog dialog) {
        for (int i = 0; i < tabla2.getRowCount(); i++) {
            if (tabla2.isRowSelected(i)) {
                tabla2.revalidate();
                panelCentro.getLblNumIdentificador().setText(String.valueOf(model2.getValueAt(i, 0)));
                bandera = true;
            }
        }
        System.out.println(bandera);
        System.out.println(num);
        if ((num != 1) && bandera == false) {
            JOptionPane.showMessageDialog(null, "Seleccione la respuesta que le agregará una pregunta");
        } else {
            bandera = false;
            dialog.setSize(527, 600);
            dialog.setLocationRelativeTo(null);

            dialog.setVisible(true);

            panelCentro.getBtnAgregarRespuesta().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.out.println(num);
                    Object[] ob = {getNum(), "introduzca la respuesta"};
                    panelCentro.getModel().addRow(ob);

                }
            });
            panelCentro.getBtnEliminarRespuesta().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    int temp = panelCentro.getTablaRespuestas().getSelectedRow();
                    panelCentro.getModel().removeRow(temp);
                    if (temp == panelCentro.getTablaRespuestas().getRowCount()) {
                        num--;
                    } else {
                        num--;
                        for (int i = temp; i < panelCentro.getTablaRespuestas().getRowCount(); i++) {
                            int num2 = (int) panelCentro.getModel().getValueAt(i, 0);
                            panelCentro.getModel().setValueAt(num2 - 1, i, 0);
                        }
                    }
                }
            });
            panelCentro.getBtnAceptar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {

                    try {
                        if (panelCentro.getTablaRespuestas().getCellEditor() != null) {
                            panelCentro.getTablaRespuestas().getCellEditor().stopCellEditing();
                        }
                        if (panelCentro.getModel().getRowCount() != 0) {
                            cuestionario.addPregunta(panelCentro.getTxtPreguntaTxt(), panelCentro.getTxtIntruccionesTxt(), Integer.valueOf(panelCentro.getLblNumIdentificador().getText()));
                            Object[] ob = {Integer.valueOf(panelCentro.getLblNumIdentificador().getText()), panelCentro.getTxtIntruccionesTxt(), panelCentro.getTxtPreguntaTxt()};
                            model.addRow(ob);
                            dialog.setVisible(false);
                            int temp = getNum2();
                            for (int i = 0; i < model2.getRowCount(); i++) {
                                model2.removeRow(i);
                                tabla2.revalidate();
                            }
                            for (int i = 0; i < panelCentro.getModel().getRowCount(); i++) {
                                cuestionario.getPreguntas().get(temp - 1).addRespuesta((String) panelCentro.getModel().getValueAt(i, 1), (int) panelCentro.getModel().getValueAt(i, 0));
                                Object[] ob2 = {(int) panelCentro.getModel().getValueAt(i, 0), (String) panelCentro.getModel().getValueAt(i, 1)};
                                model2.addRow(ob2);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Introduzca alguna respuesta");
                        }

                    } catch (PasswordVacioException ex) {
                        Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            panelCentro.getBtnEstado().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (num != 1) {
                        JDialog dialog2 = new JDialog();
                        panelEstado = new PanelEstado();
                        dialog2.setResizable(false);
                        dialog2.setUndecorated(true);
                        dialog2.setLocationRelativeTo(null);
                        dialog2.add(panelEstado);
                        dialog2.setSize(500, 200);
                        dialog2.setVisible(true);

                        panelEstado.getBtn().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                try {
                                    cuestionario.getPreguntas().get(tabla.getSelectedRow()).getRespuestas().get(tabla2.getSelectedRow()).setEstado(panelEstado.getFldTxt());
                                    model2.setValueAt(cuestionario.getPreguntas().get(tabla.getSelectedRow()).getRespuestas().get(tabla2.getSelectedRow()).getEstado(), tabla2.getSelectedRow(), 2);
                                    dialog2.setVisible(false);
                                    dialog.setVisible(false);
                                } catch (PasswordVacioException ex) {
                                    Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
                        panelEstado.getBtnCancelar().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {

                                dialog2.setVisible(false);
                            }
                        });
                    } else {
                        JOptionPane.showMessageDialog(null, "Primero necesita introducir preguntas");
                    }

                }
            });
            panelCentro.getBtnCancelar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (panelCentro.getTablaRespuestas().getRowCount() == 0) {
                        dialog.setVisible(false);
                    } else {
                        for (int i = 0; i < panelCentro.getTablaRespuestas().getRowCount(); i++) {
                            num--;
                        }
                        dialog.setVisible(false);
                    }

                }
            });
        }
    }

    public int getNum() {
        num++;
        return num;
    }

    public int getNum2() {
        num2++;
        return num2;
    }

    public void config() {
        tabla = new JTable(model);
        tabla.setSize(1500, 500);
        model.addColumn("ID");
        model.addColumn("Instrucción");
        model.addColumn("Pregunta");
        tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        tabla.setFont(new Font("Arial", Font.PLAIN, 20));
        tabla.setRowHeight(24);
        tabla.getColumnModel().getColumn(0).setMinWidth(200);
        tabla.getColumnModel().getColumn(1).setMinWidth(590);
        tabla.getColumnModel().getColumn(2).setMinWidth(580);
        tabla.getColumnModel().getColumn(0).setMaxWidth(400);
        tabla.getColumnModel().getColumn(1).setMaxWidth(800);
        tabla.getColumnModel().getColumn(2).setMaxWidth(720);
        scrollPane = new JScrollPane(tabla);
        tabla.setFillsViewportHeight(true);

        tabla2 = new JTable(model2);
        tabla.setSize(1000, 500);
        model2.addColumn("Índice");
        model2.addColumn("Respuesta");
        model2.addColumn("Estado");
        tabla2.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        tabla2.setFont(new Font("Arial", Font.PLAIN, 20));
        tabla2.setRowHeight(24);
        tabla2.getColumnModel().getColumn(0).setMinWidth(200);
        tabla2.getColumnModel().getColumn(1).setMinWidth(590);
        tabla2.getColumnModel().getColumn(2).setMinWidth(580);
        tabla2.getColumnModel().getColumn(0).setMaxWidth(400);
        tabla2.getColumnModel().getColumn(1).setMaxWidth(800);
        tabla2.getColumnModel().getColumn(2).setMaxWidth(720);

        scrollPane2 = new JScrollPane(tabla2);
        tabla2.setFillsViewportHeight(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalFrame();

            }
        });
    }
}
