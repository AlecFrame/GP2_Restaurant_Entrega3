
package Vistas;

import Modelo.DetallePedido;
import Modelo.Pedido;
import Persistencia.DetallePedidoData;
import Persistencia.PedidoData;
import Persistencia.ProductosData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VDetallePedido extends javax.swing.JInternalFrame {
    
    private ArrayList<DetallePedido> lista = new ArrayList<>();
    private ProductosData pdata = new ProductosData();
    private DetallePedidoData ddata = new DetallePedidoData();
    private PedidoData ppdata = new PedidoData();
    private VPedido venPedido = null;
    private int rowSelected = -1;
    private int rowSelecteda = -1;
    private int rowSelectedg = -1;
    private boolean cargando = false;
    private boolean cambiando = false;
    
    private String idg = null;
    private String productog = null;
    private String pedidog = null;
    private String cantidadg = null;
    private String estadog = null;
    
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { 
            return false;
        }
    };
    
    private DefaultTableModel modelo_cargar = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { 
            return (fila == modelo_cargar.getRowCount() - 1)&(col!=3)&(col!=5);
        }
    };
    
    private DefaultTableModel modelo_editable = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { 
            return (col!=3)&(col!=5);
        }
    };
    
    public VDetallePedido(int buscar, VPedido venPedido) {
        this.venPedido = venPedido;
        initComponents();
        
        jbGuardar.setEnabled(false);
        Botones(false);
        cargarCabecera();
        
        if (buscar!=0) {
            jtfBuscar.setText(String.valueOf(buscar));
            if (!cargando) {
                try {
                    cargando = true;
                    jbActualizar.setEnabled(false);
                    jbCargar.setEnabled(false);
                    jbGuardar.setEnabled(true);
                    modelo_cargar.addRow(new Object[] {
                        Enumerar(),
                        jtfBuscar.getText(),
                        "",
                        "Automático",
                        0,
                        "Automático",
                        "true"
                    });
                    jTable.setModel(modelo_cargar);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error SQL: "+ex,"Error SQL",JOptionPane.ERROR_MESSAGE);
                }
             }
        }else{
            try {
                lista = ddata.listar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
            cargarTabla();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbCargar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLbuscar = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jLproductos = new javax.swing.JLabel();
        jProductos = new javax.swing.JComboBox<>();
        jLid = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 187, 165));
        setBorder(null);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo5.png"))); // NOI18N

        jTable.setBackground(new java.awt.Color(255, 255, 204));
        jTable.setBorder(new javax.swing.border.MatteBorder(null));
        jTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable.setForeground(new java.awt.Color(153, 90, 48));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null, null, null}
            },
            new String [] {
                "IDDetalle", "Código", "IDPedido", "Cantidad", "Total", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class
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

        jbCargar.setBackground(new java.awt.Color(162, 108, 72));
        jbCargar.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jbCargar.setForeground(new java.awt.Color(255, 255, 204));
        jbCargar.setText("Cargar");
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        jbActualizar.setBackground(new java.awt.Color(162, 108, 72));
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

        jbGuardar.setBackground(new java.awt.Color(162, 108, 72));
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

        jLbuscar.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLbuscar.setText("Buscar por ");
        jLbuscar.setAlignmentY(0.0F);

        jbBuscar.setBackground(new java.awt.Color(162, 108, 72));
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

        jLproductos.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jLproductos.setText("Productos");
        jLproductos.setAlignmentY(0.0F);

        jProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0-todos", "1-pizzas", "2-hamburguesas", "3-lomos", "4-tacos", "5-bebidas/a", "6-bebidasc/a", "7-gaseosas" }));
        jProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jProductosItemStateChanged(evt);
            }
        });

        jLid.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jLid.setText("ID pedido");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Detallepedido.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jbEliminar))
                            .addComponent(jLbuscar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jProductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLbuscar)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLproductos)
                            .addComponent(jProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCargar)
                    .addComponent(jbGuardar)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                    String mid = modelo_editable.getValueAt(rowSelectedg, 0).toString();
                    String mpedido = modelo_editable.getValueAt(rowSelectedg, 1).toString();
                    String mproducto = modelo_editable.getValueAt(rowSelectedg, 2).toString();
                    String mcantidad = modelo_editable.getValueAt(rowSelectedg, 4).toString();
                    String mestado = modelo_editable.getValueAt(rowSelectedg, 6).toString();
                    
                    if (mid.equals(idg)&mpedido.equals(pedidog)&
                        mproducto.equals(productog)&mcantidad.equals(cantidadg)&
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
                    modelo_editable.setValueAt(idg, rowSelectedg, 0);
                    modelo_editable.setValueAt(pedidog, rowSelectedg, 1);
                    modelo_editable.setValueAt(productog, rowSelectedg, 2);
                    modelo_editable.setValueAt(cantidadg, rowSelectedg, 4);
                    modelo_editable.setValueAt(estadog, rowSelectedg, 6);
                }
                rowSelectedg = rowSelecteda;
                idg = modelo.getValueAt(rowSelectedg, 0).toString();
                pedidog = modelo.getValueAt(rowSelectedg, 1).toString();
                productog = modelo.getValueAt(rowSelectedg, 2).toString();
                cantidadg = modelo.getValueAt(rowSelectedg, 4).toString();
                estadog = modelo.getValueAt(rowSelectedg, 6).toString();
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
           try {
               cargando = true;
               jbActualizar.setEnabled(false);
               jbCargar.setEnabled(false);
               jbGuardar.setEnabled(true);
               modelo_cargar.addRow(new Object[] {
                   Enumerar(),
                   jtfBuscar.getText(),
                   "",
                   "Automático",
                   0,
                   "Automático",
                   "true"
               });
               jTable.setModel(modelo_cargar);
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(this, "Error SQL: "+ex,"Error SQL",JOptionPane.ERROR_MESSAGE);
           }
        }
    }//GEN-LAST:event_jbCargarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        String mid = modelo_editable.getValueAt(rowSelecteda, 0).toString();
        String mpedido = modelo_editable.getValueAt(rowSelecteda, 1).toString();
        String mproducto = modelo_editable.getValueAt(rowSelecteda, 2).toString();
        String mcantidad = modelo_editable.getValueAt(rowSelecteda, 4).toString();
        String mestado = modelo_editable.getValueAt(rowSelecteda, 6).toString();
        DetallePedido dt = new DetallePedido();
        
        if (!mid.trim().equalsIgnoreCase("")) {
            try {
                int id = Integer.parseInt(mid);
                if (id<1) {
                    JOptionPane.showMessageDialog(this, "Invalido el ID no puede ser menor a uno", "Error ID menor a 1", JOptionPane.WARNING_MESSAGE);
                    return;
                }else
                if (ddata.buscar(id)==null) {
                    dt.setIdDetalle(id);
                }else{
                    if (mid.equals(idg)) {
                        dt.setIdDetalle(id);
                    }else{
                        JOptionPane.showMessageDialog(this, "Error el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
            }catch(NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error el ID ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error el ID del detalle_pedido esta vacío", "Error ID vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mpedido.trim().equalsIgnoreCase("")) {
            try {
                int idpedido = Integer.parseInt(mpedido);
                
                if (ppdata.buscarPedido(idpedido)!=null) {
                    dt.setPedido(ppdata.buscarPedido(idpedido));
                }else{
                    JOptionPane.showMessageDialog(this, "Error el ID del Pedido ingresado no existe en la base de datos", "Error ID Pedido inexistente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }catch(NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error el ID del pedido ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error el ID del pedido esta vacío", "Error ID Pedido vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mproducto.trim().equalsIgnoreCase("")) {
            try {
                int codigo = Integer.parseInt(mproducto);
                
                if (pdata.buscar(codigo)!=null) {
                    dt.setProducto(pdata.buscar(codigo));
                }else{
                    JOptionPane.showMessageDialog(this, "Error el Codigo del Producto ingresado no existe en la base de datos", "Error Codigo Producto inexistente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }catch(NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error el Codigo del producto ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error el Codigo del producto esta vacío", "Error Codigo Producto vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mcantidad.trim().equalsIgnoreCase("")) {
            try {
                int cantidad = Integer.parseInt(mcantidad);
                if (cantidad<1) {
                    JOptionPane.showMessageDialog(this, "La Cantidad de productos no debe ser inferior a 1", "Error cantidad inferior a 1", JOptionPane.WARNING_MESSAGE);
                }else
                    dt.setCantidad(cantidad);
            }catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error la Cantidad ingresada no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error la Cantidad esta vacía", "Error Cantidad vacía", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            dt.setEstado(mestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            ddata.actualizar(dt, Integer.parseInt(idg));
            if (!mproducto.equals(productog)|!mcantidad.equals(cantidadg)) {
                ppdata.actualizarPedido(dt.getPedido(), dt.getPedido().getIdPedido());
            }
            ddata.ConsistenciaDeDatos();
            if (venPedido!=null) {
                venPedido.quitarFiltros();
                venPedido.limpiarAcciones();
                venPedido.cargarFiltro();
            }
            
            cargando = false;
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jTable.setModel(modelo);
            jProductos.setSelectedIndex(0);
            lista = ddata.listar();
            cargarTabla();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cambiar el estado: "+e, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
      try {
            if (cargando) {
                cargarFiltro();
            }else{
                int idDetalle = Integer.parseInt(jTable.getValueAt(rowSelected, 0).toString());
                ddata.CambiarEstado(false,idDetalle);
                cargarFiltro();
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
        String mid = modelo_cargar.getValueAt(row, 0).toString();
        String mpedido = modelo_cargar.getValueAt(row, 1).toString();
        String mproducto = modelo_cargar.getValueAt(row, 2).toString();
        String mcantidad = modelo_cargar.getValueAt(row, 4).toString();
        String mestado = modelo_cargar.getValueAt(row, 6).toString();
        DetallePedido dt = new DetallePedido();
        
        if (!mid.trim().equalsIgnoreCase("")) {
            try {
                int id = Integer.parseInt(mid);
                if (id<1) {
                    JOptionPane.showMessageDialog(this, "Invalido el ID no puede ser menor a uno", "Error ID menor a 1", JOptionPane.WARNING_MESSAGE);
                    return;
                }else
                if (ddata.buscar(id)==null) {
                    dt.setIdDetalle(id);
                }else{
                    JOptionPane.showMessageDialog(this, "Error el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }catch(NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error el ID ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error el ID del detalle_pedido esta vacío", "Error ID vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mpedido.trim().equalsIgnoreCase("")) {
            try {
                int idpedido = Integer.parseInt(mpedido);
                
                if (ppdata.buscarPedido(idpedido)!=null) {
                    dt.setPedido(ppdata.buscarPedido(idpedido));
                }else{
                    JOptionPane.showMessageDialog(this, "Error el ID del Pedido ingresado no existe en la base de datos", "Error ID Pedido inexistente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }catch(NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error el ID del pedido ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error el ID del pedido esta vacío", "Error ID Pedido vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mproducto.trim().equalsIgnoreCase("")) {
            try {
                int codigo = Integer.parseInt(mproducto);
                
                if (pdata.buscar(codigo)!=null) {
                    dt.setProducto(pdata.buscar(codigo));
                }else{
                    JOptionPane.showMessageDialog(this, "Error el Codigo del Producto ingresado no existe en la base de datos", "Error Codigo Producto inexistente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }catch(NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error el Codigo del producto ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error el Codigo del producto esta vacío", "Error Codigo Producto vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mcantidad.trim().equalsIgnoreCase("")) {
            try {
                int cantidad = Integer.parseInt(mcantidad);
                if (cantidad<1) {
                    JOptionPane.showMessageDialog(this, "La Cantidad de productos no debe ser inferior a 1", "Error cantidad inferior a 1", JOptionPane.WARNING_MESSAGE);
                }else
                    dt.setCantidad(cantidad);
            }catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error la Cantidad ingresada no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error la Cantidad esta vacía", "Error Cantidad vacía", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            dt.setEstado(mestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            ddata.guardar(dt);
            ppdata.actualizarPedido(dt.getPedido(), dt.getPedido().getIdPedido());
            ddata.ConsistenciaDeDatos();
            if (venPedido!=null) {
                venPedido.quitarFiltros();
                venPedido.limpiarAcciones();
                venPedido.cargarFiltro();
            }
            
            cargando = false;
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jtfBuscar.setText("");
            jTable.setModel(modelo);
            jProductos.setSelectedIndex(0);
            lista = ddata.listar();
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al guardar el DetallePedido: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String texto = jtfBuscar.getText();
        try {
            if (!"".equals(texto)) {
                try {
                    int idPedido = Integer.parseInt(texto);
                    
                    if (ppdata.buscarPedido(idPedido)!=null) {
                        cargarFiltro();
                    }else {
                        JOptionPane.showMessageDialog(this, "El ID del pedido ingresado no existe","ID inexistente",JOptionPane.WARNING_MESSAGE);
                        cargarFiltro();
                    }
                } catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "El ID de los pedidos solo pueden ser numeros","Error tipos de datos",JOptionPane.WARNING_MESSAGE);
                }
                cargarTabla();
            }else{
                cargarFiltro();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Error SQL: "+e,"Error SQL",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jProductosItemStateChanged
        cargarFiltro();
    }//GEN-LAST:event_jProductosItemStateChanged
    
    public void limpiarAcciones() {
        jTable.setModel(modelo);
        Botones(false);
        jbCargar.setEnabled(true);
        jbGuardar.setEnabled(false);
        cambiando = false;
        idg = null;
        productog = null;
        pedidog = null;
        cantidadg = null;
        estadog = null;
        rowSelected = -1;
        rowSelecteda = -1;
        rowSelectedg = -1;
    }
    
    public void cargarModelo(DefaultTableModel modelos) {
        modelos.addColumn("ID");
        modelos.addColumn("ID_Pedido");
        modelos.addColumn("Codigo_Producto");
        modelos.addColumn("Descripción");
        modelos.addColumn("Cántidad");
        modelos.addColumn("Total");
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
        for (DetallePedido d: lista) {
            agregarFila(d);
        }
    }
    
    private void agregarFila(DetallePedido d) {
        modelo.addRow(new Object[] {
            d.getIdDetalle(),
            d.getPedido().getIdPedido(),
            d.getProducto().getCodigo(),
            d.getProducto().getNombre(),
            d.getCantidad(),
            d.getTotal(),
            d.isEstado()
        });
        modelo_cargar.addRow(new Object[] {
            d.getIdDetalle(),
            d.getPedido().getIdPedido(),
            d.getProducto().getCodigo(),
            d.getProducto().getNombre(),
            d.getCantidad(),
            d.getTotal(),
            d.isEstado()
        });
        modelo_editable.addRow(new Object[] {
            d.getIdDetalle(),
            d.getPedido().getIdPedido(),
            d.getProducto().getCodigo(),
            d.getProducto().getNombre(),
            d.getCantidad(),
            d.getTotal(),
            d.isEstado()
        });
    }
    
    private void Botones(boolean b) {
        jbActualizar.setEnabled(b);
        jbEliminar.setEnabled(b);
    }
    
    private int Enumerar() throws SQLException {
        int size = ddata.listar().size();
        int numero=0;
        for (int i=1; i<size+10; i++) {
            if (ddata.buscar(i)==null) {
                numero = i;
                break;
            }
        }
        return numero;
    }
    
    private void cargarFiltro() {
        String filtro;
        String idPedido = jtfBuscar.getText();
        switch (jProductos.getSelectedItem().toString()) {
            case ("0-todos") : {filtro="todos";break;}
            case ("1-pizzas") : {filtro="pizzas";break;}
            case ("2-hamburguesas") : {filtro="hamburguesas";break;}
            case ("3-lomos") : {filtro="lomos";break;}
            case ("4-tacos") : {filtro="tacos";break;}
            case ("5-bebidas/a") : {filtro="bebidas sin alcohol";break;}
            case ("6-bebidasc/a") : {filtro="bebidas con alcohol";break;}
            case ("7-gaseosas") : {filtro="bebidas gaseosas";break;}
            default : {filtro="ninguna";break;}
        }
        
        try {
            try {
                int numero = Integer.parseInt(idPedido);
                Pedido p = ppdata.buscarPedido(numero);

                if ("todos".equals(filtro)) {
                    lista = ddata.listar();
                }else if (p==null) {
                    lista = ddata.filtrarCategoriayPedido(0, filtro);
                }else{
                    lista = ddata.filtrarCategoriayPedido(p.getIdPedido(), filtro);
                }
            }catch(NumberFormatException e) {
                if ("todos".equals(filtro)) {
                    lista = ddata.listar();
                }else
                    lista = ddata.filtrarCategoriayPedido(0, filtro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla con filtro: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        cargarTabla();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLbuscar;
    private javax.swing.JLabel jLid;
    private javax.swing.JLabel jLproductos;
    private javax.swing.JComboBox<String> jProductos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}
