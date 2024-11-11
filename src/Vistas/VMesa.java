
package Vistas;

import java.sql.*;
import Modelo.Mesa;
import Modelo.Mesero;
import Persistencia.MesaData;
import Persistencia.MeseroData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VMesa extends javax.swing.JInternalFrame {
    
    private ArrayList<Mesa> lista = new ArrayList<>();
    private MesaData mdata = new MesaData();
    private MeseroData msdata = new MeseroData();
    private String boton_buscar = "ninguno";
    private int buscarg = 0;
    private String condicion_filtro = "todas";
    private int rowSelected = -1;
    private int rowSelecteda = -1;
    private int rowSelectedg = -1;
    private boolean cargando = false;
    private boolean cambiando = false;
    
    private String numerog = null;
    private String capacidadg = null;
    private String condiciong = null;
    private String estadog = null;
    private String meserog = null;
    
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { 
            return false;
        }
    };
    
    private DefaultTableModel modelo_cargar = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { 
            return fila == modelo_cargar.getRowCount() - 1;
        }
    };
    
    private DefaultTableModel modelo_editable = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { 
            return true;
        }
    };
    
    public VMesa() {
        initComponents();
        try {
            lista = mdata.listarMesas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        
        jtfBuscar.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbBuscar.setEnabled(false);
        Botones(false);
        cargarCabecera();
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        GrupoBotMesa = new javax.swing.ButtonGroup();
        jbBuscar = new javax.swing.JButton();
        jcCategoria = new javax.swing.JComboBox<>();
        jbCondicion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbCargar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLfondo = new javax.swing.JLabel();
        jBotonMesa = new javax.swing.JRadioButton();
        jBotonCapacidad = new javax.swing.JRadioButton();
        jbBuscaPor = new javax.swing.JLabel();
        jBotonMesero = new javax.swing.JRadioButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(204, 187, 161));
        setBorder(null);
        setForeground(new java.awt.Color(255, 255, 204));
        setTitle("Mesa");
        setFont(new java.awt.Font("Calibri", 1, 10)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo_mesa.jpg"))); // NOI18N

        jbBuscar.setBackground(new java.awt.Color(153, 102, 0));
        jbBuscar.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(255, 255, 204));
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(null);
        jbBuscar.setBorderPainted(false);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jcCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0-todas", "1-libre", "2-ocupada", "3-atendida" }));
        jcCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcCategoriaItemStateChanged(evt);
            }
        });

        jbCondicion.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jbCondicion.setText("Condición");

        jTable.setBackground(new java.awt.Color(255, 255, 204));
        jTable.setBorder(new javax.swing.border.MatteBorder(null));
        jTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable.setForeground(new java.awt.Color(153, 102, 0));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null}
            },
            new String [] {
                "Nro de mesa", "Capacidad", "Condición", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.setGridColor(new java.awt.Color(92, 47, 7));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jbCargar.setBackground(new java.awt.Color(153, 102, 0));
        jbCargar.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jbCargar.setForeground(new java.awt.Color(255, 255, 204));
        jbCargar.setText("Cargar");
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        jbActualizar.setBackground(new java.awt.Color(153, 102, 0));
        jbActualizar.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jbActualizar.setForeground(new java.awt.Color(255, 255, 204));
        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(204, 0, 0));
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jtfBuscar.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N

        jbGuardar.setBackground(new java.awt.Color(153, 102, 0));
        jbGuardar.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(255, 255, 204));
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(204, 0, 0));
        jbSalir.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 204));
        jbSalir.setText("Cerrar");
        jbSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jLfondo.setBackground(new java.awt.Color(255, 204, 153));
        jLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/mesa1.jpg"))); // NOI18N

        jBotonMesa.setBackground(new java.awt.Color(204, 187, 161));
        GrupoBotMesa.add(jBotonMesa);
        jBotonMesa.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jBotonMesa.setText("Número de mesa");
        jBotonMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonMesaActionPerformed(evt);
            }
        });

        jBotonCapacidad.setBackground(new java.awt.Color(204, 187, 161));
        GrupoBotMesa.add(jBotonCapacidad);
        jBotonCapacidad.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jBotonCapacidad.setText("Capacidad");
        jBotonCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonCapacidadActionPerformed(evt);
            }
        });

        jbBuscaPor.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jbBuscaPor.setText("Buscar por:");

        jBotonMesero.setBackground(new java.awt.Color(204, 187, 161));
        GrupoBotMesa.add(jBotonMesero);
        jBotonMesero.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jBotonMesero.setText("DNI Mesero");
        jBotonMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonMeseroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbBuscaPor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jBotonCapacidad)
                                            .addComponent(jBotonMesero)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jBotonMesa)
                                                    .addComponent(jbCondicion, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jcCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar)
                        .addGap(30, 30, 30))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbBuscaPor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBotonMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBotonCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBotonMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCondicion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbCargar)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcCategoriaItemStateChanged
        if (!"numero".equals(boton_buscar)) {
            cargarFiltro();
        }
    }//GEN-LAST:event_jcCategoriaItemStateChanged

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String mbuscar = jtfBuscar.getText();
        
        if (!mbuscar.trim().equals("")) {
            try {
                int numero = Integer.parseInt(mbuscar);
                try {
                    switch (boton_buscar) {
                        case "numero":
                            jcCategoria.setSelectedIndex(0);
                            lista.clear();
                            lista.add(mdata.buscar(numero));
                            condicion_filtro = "todas";
                            buscarg = 0;
                            break;
                        case "capacidad":
                            buscarg = numero;
                            cargarFiltro();
                            break;
                        case "dni":
                            buscarg = numero;
                            cargarFiltro();
                            break;
                        default:
                            JOptionPane.showMessageDialog(this, "No se encontró a ninguno", "número inexistente", JOptionPane.INFORMATION_MESSAGE);
                            buscarg = 0;
                            break;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error de SQL al buscar por código: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
                }
            }catch(NumberFormatException e) {
                cargarFiltro();
            }
            cargarTabla();
        }else
            cargarFiltro();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed
        if (!cargando) {
            String capacidad="";
            String dni ="";
            String condicion = "";

            if (!"".equals(jtfBuscar.getText())) {
                try {
                    int cap = Integer.parseInt(jtfBuscar.getText());
                    if (cap>0) {
                        if (jBotonMesero.isSelected()) {
                            dni = String.valueOf(cap);
                        }
                        if (jBotonCapacidad.isSelected()) {
                            capacidad = String.valueOf(cap);
                        }
                    }
                }catch(NumberFormatException e) {}
            }

            if (condicion_filtro.equals("todas")) {
                condicion = "";
            }
            
            cargando = true;
            jbActualizar.setEnabled(false);
            jbCargar.setEnabled(false);
            jbGuardar.setEnabled(true);
            try {
                modelo_cargar.addRow(new Object[] {
                    Enumerar(),
                    capacidad,
                    condicion,
                    "true",
                    dni,
                });
                jTable.setModel(modelo_cargar);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al cargar el producto: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbCargarActionPerformed
    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        int row = modelo_cargar.getRowCount()-1;
        String mnumero = modelo_cargar.getValueAt(row, 0).toString();
        String mcapacidad = modelo_cargar.getValueAt(row, 1).toString();
        String mcondicion = modelo_cargar.getValueAt(row, 2).toString();
        String mestado = modelo_cargar.getValueAt(row, 3).toString();
        String mmesero = modelo_cargar.getValueAt(row, 4).toString();
        Mesa m = new Mesa();
        
        Set<String> ocupaciones = new HashSet<>();
        ocupaciones.add("1");
        ocupaciones.add("2");
        ocupaciones.add("3");
        ocupaciones.add("libre");
        ocupaciones.add("ocupada");
        ocupaciones.add("atendida");
        
        try {
            int numero = Integer.parseInt(mnumero);
            if (numero<1) {
                JOptionPane.showMessageDialog(this, "Error, el número no puede ser menor a uno", "Error de tipo número", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (mdata.buscar(numero)==null) {
                m.setNumeroMesa(numero);
            }else{
                JOptionPane.showMessageDialog(this, "Error, el número ingresado ya existe en la base de datos", "Error número existente", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el número ingresado no es entero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int capacidad = Integer.parseInt(mcapacidad);
            if (capacidad<1) {
                JOptionPane.showMessageDialog(this, "Error, la capacidad no puede ser menor a uno", "Error de tipo número", JOptionPane.WARNING_MESSAGE);
                return;
            }else
                m.setCapacidad(capacidad);
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error, la capacidad ingresada tiene que ser un número: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ocupaciones.contains(mcondicion)) {
            switch (mcondicion.toLowerCase()) {
                case ("1") : case ("libre") : {
                    m.setOcupada("libre");break;
                }
                case ("2") : case ("ocupada") : {
                    m.setOcupada("ocupada");break;
                }
                case ("3") : case ("atendida") : {
                    m.setOcupada("atendida");break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error, la condición solo puede ser:(1:libre|2:ocupada|3:atendida)", "Error condición invalida", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            m.setEstado(mestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error, el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            if (mmesero.equals("ninguno")) {
                m.setMesero(null);
            }else
            try {
                int dni = Integer.parseInt(mmesero);
                
                Mesero mesero = msdata.buscar(mmesero);

                if (mesero==null) {
                    JOptionPane.showMessageDialog(this, "Error, la mesa no encuentra el DNI del mesero ingresado", "Error DNI inválido", JOptionPane.ERROR_MESSAGE);
                    return;
                }else
                    m.setMesero(mesero);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error, el DNI ingresado no es un número: "+e, "Error DNI", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al guardar el mesero: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            mdata.guardarMesa(m);
            cargando = false;
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jcCategoria.setSelectedIndex(0);
            condicion_filtro = "todas";
            jtfBuscar.setText("");
            jTable.setModel(modelo);
            lista = mdata.listarMesas();
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al guardar el producto: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        rowSelected = jTable.getSelectedRow();
        if (jTable.getModel()==modelo_editable) {
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            rowSelecteda = jTable.getSelectedRow();
            System.out.println("ID_guardado: "+numerog);
        }
        if (!cambiando) {
            jbEliminar.setEnabled(true);
            if (cargando==false) {
                jTable.setModel(modelo_editable);
            }
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            if (cargando) {
                cargarFiltro();
            }else{
                int codigo = Integer.parseInt(jTable.getValueAt(rowSelected, 0).toString());
                mdata.CambiarEstado(false, codigo);
                cargarFiltro();
            }
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cambiar el estado: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTablePropertyChange
        boolean cambiovalido = true;
        
        if (jTable.isEditing()) {
            jTable.getCellEditor().stopCellEditing();
        }
        
        if (jTable.getModel() == modelo_editable) {
            
            rowSelecteda = rowSelected;
            
            if (rowSelecteda == rowSelectedg) {
                if (rowSelectedg!=-1) {
                    String mnumero = modelo_editable.getValueAt(rowSelectedg, 0).toString();
                    String mcapacidad = modelo_editable.getValueAt(rowSelectedg, 1).toString();
                    String mcondicion = modelo_editable.getValueAt(rowSelectedg, 2).toString();
                    String mestado = modelo_editable.getValueAt(rowSelectedg, 3).toString();
                    String mmesero = modelo_editable.getValueAt(rowSelectedg, 4).toString();
                    
                    if (mnumero.equals(numerog)&mcapacidad.equals(capacidadg)&
                        mcondicion.equals(condiciong)&mmesero.equals(meserog)&
                        mestado.equals(estadog)) {
                        cambiovalido = false;
                    }
                }
                if (rowSelecteda!=-1&cambiovalido) {
                    cambiando = true;
                    jbActualizar.setEnabled(true);
                    //System.out.println("("+rowSelecteda+") cambiando: "+cambiando);
                }
            } else {
                if (rowSelectedg!=-1) {
                    modelo_editable.setValueAt(numerog, rowSelectedg, 0);
                    modelo_editable.setValueAt(capacidadg, rowSelectedg, 1);
                    modelo_editable.setValueAt(condiciong, rowSelectedg, 2);
                    modelo_editable.setValueAt(estadog, rowSelectedg, 3);
                    modelo_editable.setValueAt(meserog, rowSelectedg, 4);
                }
                rowSelectedg = rowSelecteda;
                numerog = modelo.getValueAt(rowSelectedg, 0).toString();
                capacidadg = modelo.getValueAt(rowSelectedg, 1).toString();
                condiciong = modelo.getValueAt(rowSelectedg, 2).toString();
                estadog = modelo.getValueAt(rowSelectedg, 3).toString();
                meserog = modelo.getValueAt(rowSelectedg, 4).toString();
                if (rowSelecteda!=-1) {
                    cambiando = false;
                    jbActualizar.setEnabled(false);
                    //System.out.println("("+rowSelecteda+") cambiando: "+cambiando);
                }
            }
        }
    }//GEN-LAST:event_jTablePropertyChange

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        String mnumero = modelo_editable.getValueAt(rowSelectedg, 0).toString();
        String mcapacidad = modelo_editable.getValueAt(rowSelectedg, 1).toString();
        String mcondicion = modelo_editable.getValueAt(rowSelectedg, 2).toString();
        String mestado = modelo_editable.getValueAt(rowSelectedg, 3).toString();
        String mmesero = "ninguno";
        if (modelo_editable.getValueAt(rowSelectedg, 4)!="ninguno") {
            mmesero = modelo_editable.getValueAt(rowSelectedg, 4).toString();
        }
        Mesa m = new Mesa();
        
        Set<String> ocupaciones = new HashSet<>();
        ocupaciones.add("1");
        ocupaciones.add("2");
        ocupaciones.add("3");
        ocupaciones.add("libre");
        ocupaciones.add("ocupada");
        ocupaciones.add("atendida");
        
        try {
            int numero = Integer.parseInt(mnumero);
            if (numero<1) {
                JOptionPane.showMessageDialog(this, "Error, el número no puede ser menor a uno", "Error de tipo número", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (mdata.buscar(numero)==null) {
                m.setNumeroMesa(numero);
            }else{
                if (mnumero.equals(numerog)) {
                    m.setNumeroMesa(numero);
                }else {
                    JOptionPane.showMessageDialog(this, "Error, el número ingresado ya existe en la base de datos", "Error número existente", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el número ingresado no es entero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int capacidad = Integer.parseInt(mcapacidad);
            if (capacidad<1) {
                JOptionPane.showMessageDialog(this, "Error, la capacidad no puede ser menor a uno", "Error de tipo número", JOptionPane.WARNING_MESSAGE);
                return;
            }else
                m.setCapacidad(capacidad);
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error, la capacidad ingresada tiene que ser un número: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (ocupaciones.contains(mcondicion)) {
            switch (mcondicion.toLowerCase()) {
                case ("1") : case ("libre") : {
                    m.setOcupada("libre");break;
                }
                case ("2") : case ("ocupada") : {
                    m.setOcupada("ocupada");break;
                }
                case ("3") : case ("atendida") : {
                    m.setOcupada("atendida");break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error, la condición solo puede ser:(1:libre|2:ocupada|3:atendida)", "Error condición inválida", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            m.setEstado(mestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error, el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            if (mmesero.equals("ninguno")) {
                m.setMesero(null);
            }else
            try {
                int dni = Integer.parseInt(mmesero);
                
                Mesero mesero = msdata.buscar(mmesero);

                if (mesero==null) {
                    JOptionPane.showMessageDialog(this, "Error, la mesa no encuentra el DNI del mesero ingresado", "Error DNI inválido", JOptionPane.ERROR_MESSAGE);
                    return;
                }else
                    m.setMesero(mesero);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error, el DNI ingresado no es un número: "+e, "Error DNI", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al guardar el mesero: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            System.out.println(m);
            mdata.Actualizar(m, Integer.parseInt(numerog));
            cargando = false;
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jTable.setModel(modelo);
            cargarFiltro();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al actualizar: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jBotonMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonMesaActionPerformed
        jtfBuscar.setText("");
        buscarg = 0;
        if (jBotonMesa.isSelected()) {
            jtfBuscar.setEnabled(true);
            jbBuscar.setEnabled(true);
            boton_buscar = "numero";
            jcCategoria.setEnabled(false);
        }
    }//GEN-LAST:event_jBotonMesaActionPerformed

    private void jBotonCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonCapacidadActionPerformed
        jtfBuscar.setText("");
        buscarg = 0;
        if (jBotonCapacidad.isSelected()) {
            jtfBuscar.setEnabled(true);
            jbBuscar.setEnabled(true);
            boton_buscar = "capacidad";
            jcCategoria.setEnabled(true);
        }
    }//GEN-LAST:event_jBotonCapacidadActionPerformed

    private void jBotonMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonMeseroActionPerformed
        jtfBuscar.setText("");
        buscarg = 0;
        if (jBotonMesero.isSelected()) {
            jtfBuscar.setEnabled(true);
            jbBuscar.setEnabled(true);
            boton_buscar = "dni";
            jcCategoria.setEnabled(true);
        }
    }//GEN-LAST:event_jBotonMeseroActionPerformed
    
    public void limpiarAcciones() {
        jTable.setModel(modelo);
        Botones(false);
        jbCargar.setEnabled(true);
        jbGuardar.setEnabled(false);
        cambiando = false;
        numerog = null;
        capacidadg = null;
        condiciong = null;
        estadog = null;
        meserog = null;
        rowSelected = -1;
        rowSelecteda = -1;
        rowSelectedg = -1;
    }
    
    public void cargarModelo(DefaultTableModel modelos) {
        modelos.addColumn("N° de Mesa");
        modelos.addColumn("Capacidad");
        modelos.addColumn("Condición");
        modelos.addColumn("Estado");
        modelos.addColumn("Mesero Asignado");
    }
    
    public void cargarCabecera() {
        cargarModelo(modelo);
        cargarModelo(modelo_cargar);
        cargarModelo(modelo_editable);
        jTable.setModel(modelo);
    }
    
    private void cargarTabla() {
        limpiarAcciones();
        cargando = false;
        modelo.setRowCount(0);
        modelo_cargar.setRowCount(0);
        modelo_editable.setRowCount(0);
        for (Mesa m: lista) {
            agregarFila(m);
        }
    }
    
    private void agregarFila(Mesa m) {
        if (m!=null) {
            modelo.addRow(new Object[] {
                m.getNumeroMesa(),
                m.getCapacidad(),
                m.getOcupada(),
                m.isEstado(),
                (m.getMesero()!=null)? m.getMesero().getDniMesero():"ninguno",
            });
            modelo_cargar.addRow(new Object[] {
                m.getNumeroMesa(),
                m.getCapacidad(),
                m.getOcupada(),
                m.isEstado(),
                (m.getMesero()!=null)? m.getMesero().getDniMesero():"ninguno",
            });
            modelo_editable.addRow(new Object[] {
                m.getNumeroMesa(),
                m.getCapacidad(),
                m.getOcupada(),
                m.isEstado(),
                (m.getMesero()!=null)? m.getMesero().getDniMesero():"ninguno",
            });
        }
    }
    
    private void Botones(boolean b) {
        jbActualizar.setEnabled(b);
        jbEliminar.setEnabled(b);
    }
    
    private int Enumerar() throws SQLException {
        int size = mdata.listarMesas().size();
        int numero=0;
        for (int i=1; i<size+10; i++) {
            if (mdata.buscar(i)==null) {
                numero = i;
                break;
            }
        }
        return numero;
    }
    
    private void cargarFiltro() {
        switch (jcCategoria.getSelectedIndex()) {
            case (0) : {
                condicion_filtro="todas";
                break;
            }
            case (1) : {
                condicion_filtro="libre";
                break;
            }
            case (2) : {
                condicion_filtro="ocupada";
                break;
            }
            case (3) : {
                condicion_filtro="atendida";
                break;
            }
            default : {
                condicion_filtro="";
                break;
            }
        }
        
        try {
            lista = mdata.filtrarCondicionNumeroMesero(condicion_filtro,boton_buscar,buscarg);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla con filtro: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        cargarTabla();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotMesa;
    private javax.swing.JRadioButton jBotonCapacidad;
    private javax.swing.JRadioButton jBotonMesa;
    private javax.swing.JRadioButton jBotonMesero;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLfondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JLabel jbBuscaPor;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCargar;
    private javax.swing.JLabel jbCondicion;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcCategoria;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}
