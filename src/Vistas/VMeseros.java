package Vistas;

import java.sql.*;
import Modelo.Mesero;
import Persistencia.MeseroData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VMeseros extends javax.swing.JInternalFrame {

    private ArrayList<Mesero> lista = new ArrayList<>();
    private MeseroData msdata = new MeseroData();
    private int rowSelected = -1;
    private int rowSelecteda = -1;
    private int rowSelectedg = -1;
    private boolean cargando = false;
    private boolean cambiando = false;
    
    private String dnig = null;
    private String apellidog = null;
    private String nombreg = null;
    private String estadog = null;
    
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
    
    public VMeseros() {
        initComponents();
        
        try { 
            lista = msdata.listarMeseros();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de tipo SQL: "+ex,"Error SQL",JOptionPane.ERROR_MESSAGE);
        }
        
        jbGuardar.setEnabled(false);
        Botones(false);
        cargarCabecera();
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbCargar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jSalir = new javax.swing.JButton();
        jLfondo = new javax.swing.JLabel();
        jbBuscaPor = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 187, 165));
        setBorder(null);
        setForeground(new java.awt.Color(255, 255, 204));
        setTitle("Meseros");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo5.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(575, 418));
        setPreferredSize(new java.awt.Dimension(575, 418));

        jbBuscar.setBackground(new java.awt.Color(153, 102, 0));
        jbBuscar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbBuscar.setForeground(new java.awt.Color(255, 255, 204));
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(null);
        jbBuscar.setBorderPainted(false);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jTable.setBackground(new java.awt.Color(255, 255, 204));
        jTable.setBorder(new javax.swing.border.MatteBorder(null));
        jTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable.setForeground(new java.awt.Color(153, 102, 0));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null, null, null}
            },
            new String [] {
                "DNI", "Apellido", "Nombre", "Mesa Asignada", "Reemplazando", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jbCargar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbCargar.setForeground(new java.awt.Color(255, 255, 204));
        jbCargar.setText("Cargar");
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        jbActualizar.setBackground(new java.awt.Color(153, 102, 0));
        jbActualizar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbActualizar.setForeground(new java.awt.Color(255, 255, 204));
        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(204, 0, 0));
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setBackground(new java.awt.Color(153, 102, 0));
        jbGuardar.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(255, 255, 204));
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jSalir.setBackground(new java.awt.Color(204, 0, 0));
        jSalir.setFont(new java.awt.Font("Monotype Corsiva", 1, 14)); // NOI18N
        jSalir.setForeground(new java.awt.Color(255, 255, 204));
        jSalir.setText("Cerrar");
        jSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });

        jLfondo.setBackground(new java.awt.Color(255, 204, 153));
        jLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Mesero00.png"))); // NOI18N

        jbBuscaPor.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jbBuscaPor.setText("Buscar por DNI/Apellido:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbBuscaPor)
                        .addGap(18, 18, 18)
                        .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jbCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaPor))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbCargar)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar))
                .addGap(26, 26, 26))
        );

        setBounds(0, 0, 574, 418);
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String texto = jtfBuscar.getText();
        try {
            if (!"".equals(texto)) {
                try {
                    int dni = Integer.parseInt(texto);
                    
                    if (msdata.buscar(texto)!=null) {
                        lista.clear();
                        lista.add(msdata.buscar(texto));
                    }else {
                        JOptionPane.showMessageDialog(this, "El DNI ingresado no existe","DNI inexistente",JOptionPane.WARNING_MESSAGE);
                        lista = msdata.listarMeseros();
                        cargarTabla();
                    }
                } catch(NumberFormatException e) {
                    lista = msdata.buscarPorDniOApellido(texto);
                }
                cargarTabla();
            }else{
                lista = msdata.listarMeseros();
                cargarTabla();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Error SQL: "+e,"Error SQL",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        rowSelected = jTable.getSelectedRow();
        if (jTable.getModel()==modelo_editable) {
            if (jTable.isEditing()) {
                jTable.getCellEditor().stopCellEditing();
            }
            rowSelecteda = jTable.getSelectedRow();
            //System.out.println("srow:"+rowSelecteda);
        }
        if (!cambiando) {
            jbEliminar.setEnabled(true);
            if (cargando==false) {
                jTable.setModel(modelo_editable);
            }
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTablePropertyChange
       boolean cambiovalido = true;
        
        if (jTable.isEditing()) {
            jTable.getCellEditor().stopCellEditing();
        }
        
        if (jTable.getModel() == modelo_editable) {
            
            rowSelecteda = rowSelected;
            
            if (rowSelecteda == rowSelectedg) {
                if (rowSelectedg!=-1) {
                    String mdni = modelo_editable.getValueAt(rowSelectedg, 0).toString();
                    String mapellido = modelo_editable.getValueAt(rowSelectedg, 1).toString();
                    String mnombre = modelo_editable.getValueAt(rowSelectedg, 2).toString();
                    String mestado = modelo_editable.getValueAt(rowSelectedg, 3).toString();
                    
                    if (mdni.equals(dnig)&mapellido.equals(apellidog)&
                        mnombre.equals(nombreg)&mestado.equals(estadog)) {
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
                    modelo_editable.setValueAt(dnig, rowSelectedg, 0);
                    modelo_editable.setValueAt(apellidog, rowSelectedg, 1);
                    modelo_editable.setValueAt(nombreg, rowSelectedg, 2);
                    modelo_editable.setValueAt(estadog, rowSelectedg, 3);
                }
                rowSelectedg = rowSelecteda;
                dnig = modelo.getValueAt(rowSelectedg, 0).toString();
                apellidog = modelo.getValueAt(rowSelectedg, 1).toString();
                nombreg = modelo.getValueAt(rowSelectedg, 2).toString();
                estadog = modelo.getValueAt(rowSelectedg, 3).toString();
                if (rowSelecteda!=-1) {
                    cambiando = false;
                    jbActualizar.setEnabled(false);
                    //System.out.println("("+rowSelecteda+") cambiando: "+cambiando);
                }
            }
        }
    }//GEN-LAST:event_jTablePropertyChange

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed
        if (!cargando) {
            cargando = true;
            jbActualizar.setEnabled(false);
            jbCargar.setEnabled(false);
            jbGuardar.setEnabled(true);
            modelo_cargar.addRow(new Object[] {
                "",
                "",
                "",
                ""
            });
            jTable.setModel(modelo_cargar);
        }
    }//GEN-LAST:event_jbCargarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        String mdni = modelo_editable.getValueAt(rowSelecteda, 0).toString();
        String mapellido = modelo_editable.getValueAt(rowSelecteda, 1).toString();
        String mnombre = modelo_editable.getValueAt(rowSelecteda, 2).toString();
        String mestado = modelo_editable.getValueAt(rowSelecteda, 3).toString();
        Mesero ms = new Mesero();
        
        if (!mdni.trim().equalsIgnoreCase("")) {
            try {
                int dni = Integer.parseInt(mdni);
                if (dni<1) {
                    JOptionPane.showMessageDialog(this, "Invalido el DNI no puede ser menor a uno", "Error de tipo DNI", JOptionPane.WARNING_MESSAGE);
                    return;
                }else
                if (mdni.length()>8) {
                    JOptionPane.showMessageDialog(this, "Invalido el numero de caracteres del DNI es mayor a 8", "Error de tipo DNI", JOptionPane.WARNING_MESSAGE);
                    return;
                }else
                if (msdata.buscar(mdni)==null) {
                    ms.setDniMesero(dni);
                }else{
                    if (mdni.equals(dnig)) {
                        ms.setDniMesero(dni);
                    }else {
                        JOptionPane.showMessageDialog(this, "Error el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
            }catch(NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error el DNI ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error el DNI del mesero esta vacío", "Error DNI vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mapellido.trim().equalsIgnoreCase("")) {
            ms.setApellido(mapellido);
        }else{
            JOptionPane.showMessageDialog(this, "Error el Apellido del mesero esta vacío", "Error Apellido vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mnombre.trim().equalsIgnoreCase("")) {
            ms.setNombre(mnombre);
        }else{
            JOptionPane.showMessageDialog(this, "Error el Nombre del mesero esta vacío", "Error Apellido vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            ms.setEstado(mestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            msdata.actualizar(ms, Integer.parseInt(dnig));
            cargando = false;
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jTable.setModel(modelo);
            lista = msdata.listarMeseros();
            cargarTabla();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cambiar el estado: "+e, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            if (cargando) {
                lista = msdata.listarMeseros();
                cargarTabla();
            }else{
                int dni = Integer.parseInt(jTable.getValueAt(rowSelected, 0).toString());
                msdata.cambiarEstado(dni);
                lista = msdata.listarMeseros();
                cargarTabla();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error de numeracion: "+ex, "Error entero", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cambiar el estado: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        int row = modelo_cargar.getRowCount()-1;
        System.out.println(row);
        String mdni = modelo_cargar.getValueAt(row, 0).toString();
        String mapellido = modelo_cargar.getValueAt(row, 1).toString();
        String mnombre = modelo_cargar.getValueAt(row, 2).toString();
        String mestado = modelo_cargar.getValueAt(row, 3).toString();
        Mesero ms = new Mesero();
        
        if (!mdni.trim().equalsIgnoreCase("")) {
            try {
                int dni = Integer.parseInt(mdni);
                if (dni<1) {
                    JOptionPane.showMessageDialog(this, "Invalido el DNI no puede ser menor a uno", "Error de tipo DNI", JOptionPane.WARNING_MESSAGE);
                    return;
                }else
                if (mdni.length()>8) {
                    JOptionPane.showMessageDialog(this, "Invalido el numero de caracteres del DNI es mayor a 8", "Error de tipo DNI", JOptionPane.WARNING_MESSAGE);
                    return;
                }else
                if (msdata.buscar(mdni)==null) {
                    ms.setDniMesero(dni);
                }else{
                    JOptionPane.showMessageDialog(this, "Error el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }catch(NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error el DNI ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error el DNI del mesero esta vacío", "Error DNI vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mapellido.trim().equalsIgnoreCase("")) {
            ms.setApellido(mapellido);
        }else{
            JOptionPane.showMessageDialog(this, "Error el Apellido del mesero esta vacío", "Error Apellido vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mnombre.trim().equalsIgnoreCase("")) {
            ms.setNombre(mnombre);
        }else{
            JOptionPane.showMessageDialog(this, "Error el Nombre del mesero esta vacío", "Error Apellido vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            ms.setEstado(mestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            msdata.guardar(ms);
            cargando = false;
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jtfBuscar.setText("");
            jTable.setModel(modelo);
            lista = msdata.listarMeseros();
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al guardar el mesero: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jSalirActionPerformed

    public void limpiarAcciones() {
        jTable.setModel(modelo);
        Botones(false);
        jbCargar.setEnabled(true);
        jbGuardar.setEnabled(false);
        cambiando = false;
        dnig = null;
        apellidog = null;
        nombreg = null;
        estadog = null;
        rowSelected = -1;
        rowSelecteda = -1;
        rowSelectedg = -1;
    }
    
    public void cargarModelo(DefaultTableModel modelos) {
        modelos.addColumn("DNI");
        modelos.addColumn("Apellido");
        modelos.addColumn("Nombre");
        modelos.addColumn("Estado");
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
        for (Mesero ms: lista) {
            agregarFila(ms);
        }
    }
    
    private void agregarFila(Mesero ms) {
        modelo.addRow(new Object[] {
            ms.getDniMesero(),
            ms.getApellido(),
            ms.getNombre(),
            ms.isEstado()
        });
        modelo_cargar.addRow(new Object[] {
            ms.getDniMesero(),
            ms.getApellido(),
            ms.getNombre(),
            ms.isEstado()
        });
        modelo_editable.addRow(new Object[] {
            ms.getDniMesero(),
            ms.getApellido(),
            ms.getNombre(),
            ms.isEstado()
        });
    }
    
    private void Botones(boolean b) {
        jbActualizar.setEnabled(b);
        jbEliminar.setEnabled(b);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLfondo;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JLabel jbBuscaPor;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}
