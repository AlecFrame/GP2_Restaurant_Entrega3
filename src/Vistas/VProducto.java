
package Vistas;

import java.sql.*;
import Modelo.Producto;
import Persistencia.DetallePedidoData;
import Persistencia.ProductosData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VProducto extends javax.swing.JInternalFrame {
    
    private ArrayList<Producto> lista = new ArrayList<>();
    private ProductosData pdata = new ProductosData();
    private DetallePedidoData ddata = new DetallePedidoData();
    private JDesktopPane escritorio = null;
    private boolean estado = true;
    private int rowSelected = -1;
    private int rowSelecteda = -1;
    private int rowSelectedg = -1;
    private boolean cargando = false;
    private boolean cambiando = false;
    
    private String codigog = null;
    private String nombreg = null;
    private String preciog = null;
    private String stockg = null;
    private String categoriag = null;
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
    
    public VProducto(JDesktopPane escritorio) {
        this.escritorio = escritorio;
        initComponents();
        try {
            lista = pdata.listar(estado);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        
        jbGuardar.setEnabled(false);
        Botones(false);
        cargarCabecera();
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jcCategoria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbCargar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLfondo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JCheckBox();

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
        setTitle("Productos");
        setFont(new java.awt.Font("Calibri", 1, 10)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/LogoProductos.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel1.setText("Buscar por:  ");
        jLabel1.setAlignmentY(0.0F);

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

        jcCategoria.setForeground(new java.awt.Color(162, 108, 72));
        jcCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0-todas", "1-pizzas", "2-hamburguesas", "3-lomos", "4-tacos", "5-bebidas/a", "6-bebidasc/a", "7-gaseosas" }));
        jcCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcCategoriaItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jLabel2.setText("Categorías");

        jTable.setBackground(new java.awt.Color(255, 255, 204));
        jTable.setBorder(new javax.swing.border.MatteBorder(null));
        jTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable.setForeground(new java.awt.Color(153, 90, 48));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Hola", "50",  new Integer(10), "pizzas",  new Boolean(true)}
            },
            new String [] {
                "Código", "Nombre", "Precio", "Stock", "Categoría", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
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

        jLfondo.setBackground(new java.awt.Color(255, 204, 153));
        jLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/empanadas.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jLabel3.setText("Código/nombre");

        jcbEstado.setBackground(new java.awt.Color(204, 187, 165));
        jcbEstado.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jcbEstado.setSelected(true);
        jcbEstado.setText("Estado true");
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(355, 355, 355)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbCargar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jbGuardar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbActualizar)
                            .addGap(18, 18, 18)
                            .addComponent(jbEliminar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jcCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbEstado))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jcbEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbCargar)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcCategoriaItemStateChanged
        cargarFiltro();
    }//GEN-LAST:event_jcCategoriaItemStateChanged

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String buscar = jtfBuscar.getText();
        
        try {
            int codigo = Integer.parseInt(buscar);
            
            lista.clear();
            try {
                lista.add(pdata.buscar(codigo));
                jcbEstado.setSelected(false);
                estado = false;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al buscar por código: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }catch(NumberFormatException e) {
            try {
                lista = pdata.buscarPorNombre(buscar, estado);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al buscar por nombre: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
        cargarTabla();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed
        String filtro;
        switch (jcCategoria.getSelectedItem().toString()) {
            case ("0-todas") : {filtro="";break;}
            case ("1-pizzas") : {filtro="pizzas";break;}
            case ("2-hamburguesas") : {filtro="hamburguesas";break;}
            case ("3-lomos") : {filtro="lomos";break;}
            case ("4-tacos") : {filtro="tacos";break;}
            case ("5-bebida s/a") : {filtro="bebidas sin alcohol";break;}
            case ("6-bebida c/a") : {filtro="bebidas con alcohol";break;}
            case ("7-gaseosas") : {filtro="bebidas gaseosas";break;}
            default : {filtro="";break;}
        }
        
        if (!cargando) {
            cargando = true;
            jbActualizar.setEnabled(false);
            jbCargar.setEnabled(false);
            jbGuardar.setEnabled(true);
            try {
                modelo_cargar.addRow(new Object[] {
                    Enumerar(),
                    "",
                    "",
                    "",
                    filtro,
                    "true"
                });
                jTable.setModel(modelo_cargar);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al cargar el producto: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbCargarActionPerformed
    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        int row = modelo_cargar.getRowCount()-1;
        String mcodigo = modelo_cargar.getValueAt(row, 0).toString();
        String mnombre = modelo_cargar.getValueAt(row, 1).toString();
        String mprecio = modelo_cargar.getValueAt(row, 2).toString();
        String mstock = modelo_cargar.getValueAt(row, 3).toString();
        String mcategoria = modelo_cargar.getValueAt(row, 4).toString();
        mcategoria = mcategoria.replaceAll("\\s+", "");
        String mestado = modelo_cargar.getValueAt(row, 5).toString();
        Producto p = new Producto();
        
        Set<String> categorias = new HashSet<>();
        categorias.add("1");
        categorias.add("2");
        categorias.add("3");
        categorias.add("4");
        categorias.add("5");
        categorias.add("6");
        categorias.add("7");
        categorias.add("pizzas");
        categorias.add("lomos");
        categorias.add("hamburguesas");
        categorias.add("tacos");
        categorias.add("bebidasconalcohol");
        categorias.add("bebidassinalcohol");
        categorias.add("bebidasgaseosas");
        
        try {
            int codigo = Integer.parseInt(mcodigo);
            if (codigo<1) {
                JOptionPane.showMessageDialog(this, "Error, el código no puede ser menor a uno", "Error de tipo codigo", JOptionPane.ERROR_MESSAGE);
                return;
            }else
            if (pdata.buscar(codigo)==null) {
                p.setCodigo(codigo);
            }else{
                JOptionPane.showMessageDialog(this, "Error, el código ingresado ya existe en la base de datos", "Error código existente", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el código ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!mnombre.trim().equalsIgnoreCase("")) {
            p.setNombre(mnombre);
        }else{
            JOptionPane.showMessageDialog(this, "Error, el nombre está vacío", "Error nombre vacío", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            double precio = Double.parseDouble(mprecio);
            if (precio<=0) {
                JOptionPane.showMessageDialog(this, "Error, el precio no puede ser 0 o negativo", "Error de precio inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }else
                p.setPrecio(precio);
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error, el precio ingresado no es un número: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int stock = Integer.parseInt(mstock);
            if (stock<0) {
                JOptionPane.showMessageDialog(this, "Error, el stock no puede ser inferior a 0", "Error stock inferior a 0", JOptionPane.ERROR_MESSAGE);
                return;
            }else
                p.setStock(stock);
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error, el stock ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (categorias.contains(mcategoria)) {
            switch (mcategoria.toLowerCase()) {
                case ("1") : case ("pizzas") : {
                    p.setCategoria("pizzas");break;
                }
                case ("2") : case ("lomos") : {
                    p.setCategoria("lomos");break;
                }
                case ("3") : case ("hamburguesas") : {
                    p.setCategoria("hamburguesas");break;
                }
                case ("4") : case ("tacos") : {
                    p.setCategoria("tacos");break;
                }
                case ("5") : case ("bebidasconalcohol") : {
                    p.setCategoria("bebidas con alcohol");break;
                }
                case ("6") : case ("bebidassinalcohol") : {
                    p.setCategoria("bebidas sin alcohol");break;
                }
                case ("7") : case ("bebidasgaseosas") : {
                    p.setCategoria("bebidas gaseosas");break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error, la categoría solo puede ser:(1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas)", "Error nombre vacío", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            p.setEstado(mestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error, el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            pdata.guardarProducto(p);
            cargando = false;
            actualizarVentanas();
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jcCategoria.setSelectedIndex(0);
            jtfBuscar.setText("");
            jTable.setModel(modelo);
            lista = pdata.listar(estado);
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al guardar el producto: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

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

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            if (cargando) {
                cargarFiltro();
            }else{
                int codigo = Integer.parseInt(jTable.getValueAt(rowSelected, 0).toString());
                pdata.CambiarEstado(false, codigo);
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
                    String mcodigo = modelo_editable.getValueAt(rowSelectedg, 0).toString();
                    String mnombre = modelo_editable.getValueAt(rowSelectedg, 1).toString();
                    String mprecio = modelo_editable.getValueAt(rowSelectedg, 2).toString();
                    String mstock = modelo_editable.getValueAt(rowSelectedg, 3).toString();
                    String mcategoria = modelo_editable.getValueAt(rowSelectedg, 4).toString();
                    String mestado = modelo_editable.getValueAt(rowSelectedg, 5).toString();
                    
                    if (mcodigo.equals(codigog)&mnombre.equals(nombreg)&
                        mprecio.equals(preciog)&mstock.equals(stockg)&
                        mcategoria.equals(categoriag)&mestado.equals(estadog)) {
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
                    modelo_editable.setValueAt(codigog, rowSelectedg, 0);
                    modelo_editable.setValueAt(nombreg, rowSelectedg, 1);
                    modelo_editable.setValueAt(preciog, rowSelectedg, 2);
                    modelo_editable.setValueAt(stockg, rowSelectedg, 3);
                    modelo_editable.setValueAt(categoriag, rowSelectedg, 4);
                    modelo_editable.setValueAt(estadog, rowSelectedg, 5);
                }
                rowSelectedg = rowSelecteda;
                codigog = modelo.getValueAt(rowSelectedg, 0).toString();
                nombreg = modelo.getValueAt(rowSelectedg, 1).toString();
                preciog = modelo.getValueAt(rowSelectedg, 2).toString();
                stockg = modelo.getValueAt(rowSelectedg, 3).toString();
                categoriag = modelo.getValueAt(rowSelectedg, 4).toString();
                estadog = modelo.getValueAt(rowSelectedg, 5).toString();
                if (rowSelecteda!=-1) {
                    cambiando = false;
                    jbActualizar.setEnabled(false);
                    //System.out.println("("+rowSelecteda+") cambiando: "+cambiando);
                }
            }
        }
    }//GEN-LAST:event_jTablePropertyChange

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        String mcodigo = modelo_editable.getValueAt(rowSelectedg, 0).toString();
        String mnombre = modelo_editable.getValueAt(rowSelectedg, 1).toString();
        String mprecio = modelo_editable.getValueAt(rowSelectedg, 2).toString();
        String mstock = modelo_editable.getValueAt(rowSelectedg, 3).toString();
        String mcategoria = modelo_editable.getValueAt(rowSelectedg, 4).toString();
        mcategoria = mcategoria.replaceAll("\\s+", "");
        String mestado = modelo_editable.getValueAt(rowSelectedg, 5).toString();
        Producto p = new Producto();
        
        Set<String> categorias = new HashSet<>();
        categorias.add("1");
        categorias.add("2");
        categorias.add("3");
        categorias.add("4");
        categorias.add("5");
        categorias.add("6");
        categorias.add("7");
        categorias.add("pizzas");
        categorias.add("lomos");
        categorias.add("hamburguesas");
        categorias.add("tacos");
        categorias.add("bebidasconalcohol");
        categorias.add("bebidassinalcohol");
        categorias.add("bebidasgaseosas");
        String cambios = "";
        
        try {
            int codigo = Integer.parseInt(mcodigo);
            if (codigo<1) {
                JOptionPane.showMessageDialog(this, "Error, el código no puede ser menor a uno", "Error de tipo código", JOptionPane.ERROR_MESSAGE);
                return;
            }else
            if (pdata.buscar(codigo)==null) {
                p.setCodigo(codigo);
                cambios += "codigo";
            }else{
                if (mcodigo.equals(codigog)) {
                    p.setCodigo(codigo);
                }else{
                    JOptionPane.showMessageDialog(this, "Error, el código ingresado ya existe en la base de datos", "Error código existente", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el código ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!mnombre.trim().equalsIgnoreCase("")) {
            p.setNombre(mnombre);
            cambios += ",nombre";
        }else{
            JOptionPane.showMessageDialog(this, "Error, el nombre esta vacío", "Error nombre vacío", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            double precio = Double.parseDouble(mprecio);
            if (precio<=0) {
                JOptionPane.showMessageDialog(this, "Error, el precio no puede ser 0 o negativo", "Error de precio inválido", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                p.setPrecio(precio);
                cambios += ",precio";
            }
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error, el precio ingresado no es un número: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int stock = Integer.parseInt(mstock);
            if (stock<0) {
                JOptionPane.showMessageDialog(this, "Error, el stock no puede ser inferior a 0", "Error stock inferior a 0", JOptionPane.ERROR_MESSAGE);
                return;
            }else{
                p.setStock(stock);
                cambios += ",stock";
            }
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error, el stock ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (categorias.contains(mcategoria)) {
            switch (mcategoria.toLowerCase()) {
                case ("1") : case ("pizzas") : {
                    p.setCategoria("pizzas");break;
                }
                case ("2") : case ("lomos") : {
                    p.setCategoria("lomos");break;
                }
                case ("3") : case ("hamburguesas") : {
                    p.setCategoria("hamburguesas");break;
                }
                case ("4") : case ("tacos") : {
                    p.setCategoria("tacos");break;
                }
                case ("5") : case ("bebidasconalcohol") : {
                    p.setCategoria("bebidas con alcohol");break;
                }
                case ("6") : case ("bebidassinalcohol") : {
                    p.setCategoria("bebidas sin alcohol");break;
                }
                case ("7") : case ("bebidasgaseosas") : {
                    p.setCategoria("bebidas gaseosas");break;
                }
            }
            cambios += ",categoria";
        }else{
            JOptionPane.showMessageDialog(this, "Error, la categoría solo puede ser:(1:pizzas|2:lomos|3:hamburguesas|4:tacos|5:bebidas con alcohol|6:bebidas sin alcohol|7:bebidas gaseosas)", "Error nombre vacio", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            p.setEstado(mestado.equalsIgnoreCase("true"));
            cambios += ",estado";
        }else{
            JOptionPane.showMessageDialog(this, "Error, en el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        pdata.actualizar(p,cambios,Integer.parseInt(codigog));
        if (!p.isEstado()) {
            try {
                ddata.ConsistenciaDeDatosEstado();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error SQL: "+ex,"Error SQL",JOptionPane.ERROR_MESSAGE);
            }
        }
        actualizarVentanas();
        cargando = false;
        jbCargar.setEnabled(true);
        jbGuardar.setEnabled(false);
        jTable.setModel(modelo);
        cargarFiltro();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        estado = jcbEstado.isSelected();
        cargarFiltro();
    }//GEN-LAST:event_jcbEstadoActionPerformed
    
    public void limpiarAcciones() {
        jTable.setModel(modelo);
        Botones(false);
        jbCargar.setEnabled(true);
        jbGuardar.setEnabled(false);
        cambiando = false;
        codigog = null;
        nombreg = null;
        preciog = null;
        stockg = null;
        categoriag = null;
        estadog = null;
        rowSelected = -1;
        rowSelecteda = -1;
        rowSelectedg = -1;
    }
    
    public void cargarModelo(DefaultTableModel modelos) {
        modelos.addColumn("Código");
        modelos.addColumn("Nombre");
        modelos.addColumn("Precio");
        modelos.addColumn("Stock");
        modelos.addColumn("Categoría");
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
        for (Producto p: lista) {
            agregarFila(p);
        }
    }
    
    private void agregarFila(Producto p) {
        modelo.addRow(new Object[] {
            p.getCodigo(),
            p.getNombre(),
            p.getPrecio(),
            p.getStock(),
            p.getCategoria(),
            p.isEstado()
        });
        modelo_cargar.addRow(new Object[] {
            p.getCodigo(),
            p.getNombre(),
            p.getPrecio(),
            p.getStock(),
            p.getCategoria(),
            p.isEstado()
        });
        modelo_editable.addRow(new Object[] {
            p.getCodigo(),
            p.getNombre(),
            p.getPrecio(),
            p.getStock(),
            p.getCategoria(),
            p.isEstado()
        });
    }
    
    private void Botones(boolean b) {
        jbActualizar.setEnabled(b);
        jbEliminar.setEnabled(b);
    }
    
    public int Enumerar() throws SQLException {
        int size = pdata.listar(false).size();
        int numero=0;
        for (int i=1; i<size+10; i++) {
            if (pdata.buscar(i)==null) {
                numero = i;
                break;
            }
        }
        return numero;
    }
    
    public void cargarFiltro() {
        String filtro;
        String nombre = jtfBuscar.getText();
        switch (jcCategoria.getSelectedItem().toString()) {
            case ("0-todas") : {filtro="";break;}
            case ("1-pizzas") : {filtro="pizzas";break;}
            case ("2-hamburguesas") : {filtro="hamburguesas";break;}
            case ("3-lomos") : {filtro="lomos";break;}
            case ("4-tacos") : {filtro="tacos";break;}
            case ("5-bebidas/a") : {filtro="bebidas sin alcohol";break;}
            case ("6-bebidasc/a") : {filtro="bebidas con alcohol";break;}
            case ("7-gaseosas") : {filtro="bebidas gaseosas";break;}
            default : {filtro="";break;}
        }
        
        try {
            lista = pdata.filtrarCategoriaYNombre(filtro,nombre,estado);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla con filtro: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        cargarTabla();
    }
    
    private void actualizarVentanas() {
        VPedido pedido = null;
        VDetallePedido detalle = null;
        
        for (JInternalFrame frame : escritorio.getAllFrames()) {
            if (frame instanceof VPedido) {
                pedido = (VPedido) frame;
                break;
            }
        }
        for (JInternalFrame frame : escritorio.getAllFrames()) {
            if (frame instanceof VDetallePedido) {
                detalle = (VDetallePedido) frame;
                break;
            }
        }
        
        try {
            ddata.MantenerConsistenciaDatosCalculos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        
        if (pedido!=null) {
            pedido.quitarFiltros();
            pedido.limpiarAcciones();
            pedido.cargarFiltro();
        }
        
        if (detalle!=null) {
            detalle.quitarFiltros();
            detalle.limpiarAcciones();
            detalle.cargarFiltro();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLfondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcCategoria;
    private javax.swing.JCheckBox jcbEstado;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}
