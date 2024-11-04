
package Vistas;

import Modelo.Pedido;
import java.sql.*;
import Persistencia.MesaData;
import Persistencia.MeseroData;
import Persistencia.PedidoData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VPedido extends javax.swing.JInternalFrame {
    
    private ArrayList<Pedido> lista = new ArrayList<>();
    private PedidoData pdata = new PedidoData();
    private MesaData mdata = new MesaData();
    private MeseroData msdata = new MeseroData();
    private int rowSelected = -1;
    private int rowSelecteda = -1;
    private int rowSelectedg = -1;
    private boolean cargando = false;
    private boolean cambiando = false;
    private LocalTime hora = null;
    private LocalDate fecha = null;
    private String cobrado = "null";
    
    private String idPedidog = null;
    private String dni_meserog = null;
    private String numero_mesag = null;
    private String importeg = null;
    private String fechag = null;
    private String horag = null;
    private String cobradog = null;
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
    
    public VPedido() {
        initComponents();
        try {
            lista = pdata.listarPedidos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        
        jbBuscar.setEnabled(false);
        jtfBuscar.setEnabled(false);
        jtfHora.setEnabled(false);
        jFecha.setEnabled(false);
        jbGuardar.setEnabled(false);
        Botones(false);
        cargarCabecera();
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        GrupoBotVigencia = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbCargar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLfondo = new javax.swing.JLabel();
        jcbFecha = new javax.swing.JCheckBox();
        jcbHora = new javax.swing.JCheckBox();
        jrCobrado = new javax.swing.JRadioButton();
        jrNoCobrado = new javax.swing.JRadioButton();
        jcbBuscar = new javax.swing.JCheckBox();
        jFecha = new com.toedter.calendar.JDateChooser();
        jtfHora = new javax.swing.JTextField();

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

        setBackground(new java.awt.Color(204, 187, 165));
        setBorder(null);
        setForeground(new java.awt.Color(255, 255, 204));
        setTitle("Reservas");
        setFont(new java.awt.Font("Calibri", 1, 10)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo5.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel1.setText("Busca por:");
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

        jTable.setBackground(new java.awt.Color(255, 255, 204));
        jTable.setBorder(new javax.swing.border.MatteBorder(null));
        jTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable.setForeground(new java.awt.Color(153, 90, 48));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "N° de Mesa", "DNI Mesero", "Importe", "Fecha Reser.", "Hora Reser.", "Cobrado", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
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
        jLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pedido1.jpg"))); // NOI18N

        jcbFecha.setBackground(new java.awt.Color(204, 187, 165));
        jcbFecha.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jcbFecha.setText("Fecha ");
        jcbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFechaActionPerformed(evt);
            }
        });

        jcbHora.setBackground(new java.awt.Color(204, 187, 165));
        jcbHora.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jcbHora.setText("Hora ");
        jcbHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbHoraActionPerformed(evt);
            }
        });

        jrCobrado.setBackground(new java.awt.Color(204, 187, 165));
        GrupoBotVigencia.add(jrCobrado);
        jrCobrado.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jrCobrado.setText("Cobrado");
        jrCobrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrCobradoActionPerformed(evt);
            }
        });

        jrNoCobrado.setBackground(new java.awt.Color(204, 187, 165));
        GrupoBotVigencia.add(jrNoCobrado);
        jrNoCobrado.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jrNoCobrado.setText("No cobrado");
        jrNoCobrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNoCobradoActionPerformed(evt);
            }
        });

        jcbBuscar.setBackground(new java.awt.Color(204, 187, 165));
        jcbBuscar.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jcbBuscar.setText("N°Mesa / DNIMesero:");
        jcbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarActionPerformed(evt);
            }
        });

        jFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFechaPropertyChange(evt);
            }
        });

        jtfHora.setText("00:00");
        jtfHora.setToolTipText("");
        jtfHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfHoraKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcbFecha)
                                            .addComponent(jcbBuscar)
                                            .addComponent(jcbHora))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jrCobrado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jrNoCobrado)
                                        .addComponent(jbSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbBuscar)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrNoCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbCargar)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String texto = jtfBuscar.getText();
        try {
            if (!"".equals(texto)) {
                try {
                    int id = Integer.parseInt(texto);
                    if (pdata.buscarPedido(id)!=null) {
                        lista.clear();
                        lista.add(pdata.buscarPedido(id));
                    }else {
                        JOptionPane.showMessageDialog(this, "La ID o DNI ingresados no existen","ID/DNI inexistente",JOptionPane.WARNING_MESSAGE);
                        lista = pdata.listarPedidos();
                        cargarTabla();
                    }
                } catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "El campo buscar solo admite enteros pa ID y DNI","revisar tipos de datos",JOptionPane.WARNING_MESSAGE);
                    lista = pdata.listarPedidos();
                    cargarTabla();
                }
                cargarTabla();
            }else{
                lista = pdata.listarPedidos();
                cargarTabla();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Error SQL: "+e,"Error SQL",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed
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
                    fecha,
                    hora,
                    (!"null".equals(cobrado))? cobrado:"",
                    ""
                });
                jTable.setModel(modelo_cargar);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error de SQL al cargar el pedido: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbCargarActionPerformed
    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        int row = modelo_cargar.getRowCount()-1;
        String cidPedido = modelo_cargar.getValueAt(row, 0).toString();
        String cdni_mesero = modelo_cargar.getValueAt(row, 1).toString();
        String cnumero_mesa = modelo_cargar.getValueAt(row, 2).toString();
        String cimporte = modelo_cargar.getValueAt(row, 3).toString();
        String cfecha = "";
        if (modelo_cargar.getValueAt(row, 4)!=null) {
            cfecha = modelo_cargar.getValueAt(row, 4).toString();
        }
        String chora = "";
        if (modelo_cargar.getValueAt(row, 5)!=null) {
            chora = modelo_cargar.getValueAt(row, 5).toString();
        }
        String ccobrado = modelo_cargar.getValueAt(row, 6).toString();
        String cestado = modelo_cargar.getValueAt(row, 7).toString();
        Pedido p = new Pedido();
        
        try {
            int id = Integer.parseInt(cidPedido);
            if (id<1) {
                JOptionPane.showMessageDialog(this, "Error el ID no puede ser menor a uno", "Error de tipo ID", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (pdata.buscarPedido(id)==null) {
                p.setIdPedido(id);
            }else{
                JOptionPane.showMessageDialog(this, "Error el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el ID ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int dnimesero = Integer.parseInt(cdni_mesero);
            if (dnimesero<1) {
                JOptionPane.showMessageDialog(this, "Error el DNI del mesero no puede ser menor a uno", "Error de DNI mesero", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (msdata.buscar(String.valueOf(dnimesero))!=null) {
                p.setMesero(msdata.buscar(String.valueOf(dnimesero)));
            }else{
                JOptionPane.showMessageDialog(this, "Error el DNI del mesero ingresado no existe", "Error mesero inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el DNI del mesero ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int mesa = Integer.parseInt(cnumero_mesa);
            if (mesa<1) {
                JOptionPane.showMessageDialog(this, "Error el Numero de mesa no puede ser menor a uno", "Error de numero de mesa", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (mdata.buscar(mesa)!=null) {
                p.setMesa(mdata.buscar(mesa));
            }else{
                JOptionPane.showMessageDialog(this, "Error el numero de mesa ingresado no existe", "Error mesa inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el numero de mesa ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            double importe = Double.parseDouble(cimporte);
            if (importe<1) {
                JOptionPane.showMessageDialog(this, "Error el Importe puede ser menor a uno", "Error de valor menor a 1", JOptionPane.WARNING_MESSAGE);
                return;
            }else
                p.setImporte(importe);
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error el Importe ingresado no es un double: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            LocalDate fech = LocalDate.parse(cfecha);
            p.setFecha(fech);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error formato de fecha incorrecto, el formato es el siguiente (yyyy-MM-dd)", "Error Fecha incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        try {
            p.setHora(LocalTime.parse(chora, formato));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error formato de la hora incorrecto, el formato es el siguiente (HH:mm)", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        switch (ccobrado) {
            case ("cobrado") : {
                p.setCobrado(true);
                break;
            }
            case ("no_cobrado") : {
                p.setCobrado(false);
                break;
            }
            default : {
                JOptionPane.showMessageDialog(this, "Error cobro invalido, debe ser (cobrado o no_cobrado)", "Error cobro incorrecto", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        if (cestado.equalsIgnoreCase("true")|cestado.equalsIgnoreCase("false")) {
            p.setEstado(cestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            pdata.guardarPedido(p);
            cargando = false;
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jtfBuscar.setText("");
            quitarFiltros();
            jTable.setModel(modelo);
            lista = pdata.listarPedidos();
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al guardar el pedido: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
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
                pdata.cambiarEstado(false, codigo);
                cargarFiltro();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error de numeracion: "+ex, "Error entero", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
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
                    String cid = modelo_editable.getValueAt(rowSelectedg, 0).toString();
                    String cmesero = modelo_editable.getValueAt(rowSelectedg, 1).toString();
                    String cmesa = modelo_editable.getValueAt(rowSelectedg, 2).toString();
                    String cimporte = modelo_editable.getValueAt(rowSelectedg, 3).toString();
                    String cfecha = modelo_editable.getValueAt(rowSelectedg, 4).toString();
                    String chora = modelo_editable.getValueAt(rowSelectedg, 5).toString();
                    String ccobrado = modelo_editable.getValueAt(rowSelectedg, 6).toString();
                    String cestado = modelo_editable.getValueAt(rowSelectedg, 7).toString();
                    
                    if (cid.equals(idPedidog)&cmesa.equals(numero_mesag)&
                        cmesero.equals(dni_meserog)&cimporte.equals(importeg)&
                        cfecha.equals(fechag)&chora.equals(horag)&ccobrado.equals(cobradog)&
                        cestado.equals(estadog)) {
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
                    modelo_editable.setValueAt(idPedidog, rowSelectedg, 0);
                    modelo_editable.setValueAt(dni_meserog, rowSelectedg, 1);
                    modelo_editable.setValueAt(numero_mesag, rowSelectedg, 2);
                    modelo_editable.setValueAt(importeg, rowSelectedg, 3);
                    modelo_editable.setValueAt(fechag, rowSelectedg, 4);
                    modelo_editable.setValueAt(horag, rowSelectedg, 5);
                    modelo_editable.setValueAt(cobradog, rowSelectedg, 6);
                    modelo_editable.setValueAt(estadog, rowSelectedg, 7);
                }
                rowSelectedg = rowSelecteda;
                idPedidog = modelo.getValueAt(rowSelectedg, 0).toString();
                dni_meserog = modelo.getValueAt(rowSelectedg, 1).toString();
                numero_mesag = modelo.getValueAt(rowSelectedg, 2).toString();
                importeg = modelo.getValueAt(rowSelectedg, 3).toString();
                fechag = modelo.getValueAt(rowSelectedg, 4).toString();
                horag = modelo.getValueAt(rowSelectedg, 5).toString();
                cobradog = modelo.getValueAt(rowSelectedg, 6).toString();
                estadog = modelo.getValueAt(rowSelectedg, 7).toString();
                if (rowSelecteda!=-1) {
                    cambiando = false;
                    jbActualizar.setEnabled(false);
                    //System.out.println("("+rowSelecteda+") cambiando: "+cambiando);
                }
            }
        }
    }//GEN-LAST:event_jTablePropertyChange

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        String cidPedido = modelo_cargar.getValueAt(rowSelecteda, 0).toString();
        String cdni_mesero = modelo_cargar.getValueAt(rowSelecteda, 1).toString();
        String cnumero_mesa = modelo_cargar.getValueAt(rowSelecteda, 2).toString();
        String cimporte = modelo_cargar.getValueAt(rowSelecteda, 3).toString();
        String cfecha = "";
        if (modelo_cargar.getValueAt(rowSelecteda, 4)!=null) {
            cfecha = modelo_cargar.getValueAt(rowSelecteda, 4).toString();
        }
        String chora = "";
        if (modelo_cargar.getValueAt(rowSelecteda, 5)!=null) {
            chora = modelo_cargar.getValueAt(rowSelecteda, 5).toString();
        }
        String ccobrado = modelo_cargar.getValueAt(rowSelecteda, 6).toString();
        String cestado = modelo_cargar.getValueAt(rowSelecteda, 7).toString();
        Pedido p = new Pedido();
        
        try {
            int id = Integer.parseInt(cidPedido);
            if (id<1) {
                JOptionPane.showMessageDialog(this, "Error el ID no puede ser menor a uno", "Error de tipo ID", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (pdata.buscarPedido(id)==null) {
                p.setIdPedido(id);
            }else{
                if (idPedidog.equals(cidPedido)) {
                    p.setIdPedido(id);
                }else{
                    JOptionPane.showMessageDialog(this, "Error el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el ID ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int dnimesero = Integer.parseInt(cdni_mesero);
            if (dnimesero<1) {
                JOptionPane.showMessageDialog(this, "Error el DNI del mesero no puede ser menor a uno", "Error de DNI mesero", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (msdata.buscar(String.valueOf(dnimesero))!=null) {
                p.setMesero(msdata.buscar(String.valueOf(dnimesero)));
            }else{
                JOptionPane.showMessageDialog(this, "Error el DNI del mesero ingresado no existe", "Error mesero inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el DNI del mesero ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int mesa = Integer.parseInt(cnumero_mesa);
            if (mesa<1) {
                JOptionPane.showMessageDialog(this, "Error el Numero de mesa no puede ser menor a uno", "Error de numero de mesa", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (mdata.buscar(mesa)!=null) {
                p.setMesa(mdata.buscar(mesa));
            }else{
                JOptionPane.showMessageDialog(this, "Error el numero de mesa ingresado no existe", "Error mesa inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error el numero de mesa ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            double importe = Double.parseDouble(cimporte);
            if (importe<1) {
                JOptionPane.showMessageDialog(this, "Error el Importe puede ser menor a uno", "Error de valor menor a 1", JOptionPane.WARNING_MESSAGE);
                return;
            }else
                p.setImporte(importe);
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error el Importe ingresado no es un double: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            LocalDate fech = LocalDate.parse(cfecha);
            p.setFecha(fech);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error formato de fecha incorrecto, el formato es el siguiente (yyyy-MM-dd)", "Error Fecha incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        try {
            p.setHora(LocalTime.parse(chora, formato));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error formato de la hora incorrecto, el formato es el siguiente (HH:mm)", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        switch (ccobrado) {
            case ("cobrado") : {
                p.setCobrado(true);
                break;
            }
            case ("no_cobrado") : {
                p.setCobrado(false);
                break;
            }
            default : {
                JOptionPane.showMessageDialog(this, "Error cobro invalido, debe ser (cobrado o no_cobrado)", "Error cobro incorrecto", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        if (cestado.equalsIgnoreCase("true")|cestado.equalsIgnoreCase("false")) {
            p.setEstado(cestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            pdata.actualizarPedido(p,Integer.parseInt(idPedidog));
            cargando = false;
            jbCargar.setEnabled(true);
            jbGuardar.setEnabled(false);
            jTable.setModel(modelo);
            cargarFiltro();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL al actualizar el pedido: "+e, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jcbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFechaActionPerformed
        jFecha.setEnabled(jcbFecha.isSelected());
        if (!jcbFecha.isSelected()) {
            jFecha.setDate(null);
            fecha = null;
            cargarFiltro();
        }
    }//GEN-LAST:event_jcbFechaActionPerformed

    private void jrCobradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrCobradoActionPerformed
        if (jrCobrado.isSelected()) {
            cobrado = "cobrado";
            cargarFiltro();
        }
    }//GEN-LAST:event_jrCobradoActionPerformed

    private void jrNoCobradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNoCobradoActionPerformed
        if (jrNoCobrado.isSelected()) {
            cobrado = "no_cobrado";
            cargarFiltro();
        }
    }//GEN-LAST:event_jrNoCobradoActionPerformed

    private void jcbHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbHoraActionPerformed
        jtfHora.setEnabled(jcbHora.isSelected());
        if (!jcbHora.isSelected()) {
            jtfHora.setText("00:00");
            hora = null;
            cargarFiltro();
        }
    }//GEN-LAST:event_jcbHoraActionPerformed

    private void jtfHoraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfHoraKeyReleased
        String texto = jtfHora.getText();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        try {
            hora = LocalTime.parse(texto, formato);
            cargarFiltro();
        } catch (DateTimeParseException e) {
            hora = null;
            cargarFiltro();
        }
    }//GEN-LAST:event_jtfHoraKeyReleased

    private void jFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFechaPropertyChange
        if (jFecha.getDate()!=null) {
            fecha = LocalDate.of((jFecha.getDate().getYear()+1900), jFecha.getDate().getMonth()+1, jFecha.getDate().getDate());
            cargarFiltro();
        }else {
            fecha = null;
            cargarFiltro();
        }
    }//GEN-LAST:event_jFechaPropertyChange

    private void jcbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarActionPerformed
        jtfBuscar.setEnabled(jcbBuscar.isSelected());
        jbBuscar.setEnabled(jcbBuscar.isSelected());
        if (jcbBuscar.isSelected()==false) {
            jtfBuscar.setText("");
            cargarFiltro();
        }
    }//GEN-LAST:event_jcbBuscarActionPerformed
    
    public void quitarFiltros() {
        jcbHora.setSelected(false);
        jtfHora.setEnabled(false);
        jtfHora.setText("00:00");
        hora = null;
        jcbFecha.setSelected(false);
        jFecha.setDate(null);
        fecha = null;
        jrCobrado.setSelected(false);
        jrNoCobrado.setSelected(false);
        cobrado = "null";
    }
    
    public void limpiarAcciones() {
        jTable.setModel(modelo);
        Botones(false);
        jbCargar.setEnabled(true);
        jbGuardar.setEnabled(false);
        cambiando = false;
        idPedidog = null;
        dni_meserog = null;
        numero_mesag = null;
        importeg = null;
        fechag = null;
        horag = null;
        cobradog = null;
        estadog = null;
        rowSelected = -1;
        rowSelecteda = -1;
        rowSelectedg = -1;
    }
    
    public void cargarModelo(DefaultTableModel modelos) {
        modelos.addColumn("ID");
        modelos.addColumn("DNI Mesero");
        modelos.addColumn("N° de Mesa");
        modelos.addColumn("Importe");
        modelos.addColumn("Fecha");
        modelos.addColumn("Hora");
        modelos.addColumn("Cobrado");
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
        for (Pedido p: lista) {
            agregarFila(p);
        }
    }
    
    private void agregarFila(Pedido p) {
        modelo.addRow(new Object[] {
            p.getIdPedido(),
            p.getMesero().getDniMesero(),
            p.getMesa().getNumeroMesa(),
            p.getImporte(),
            p.getFecha(),
            p.getHora(),
            p.isCobrado(),
            p.isEstado()
        });
        modelo_cargar.addRow(new Object[] {
            p.getIdPedido(),
            p.getMesero().getDniMesero(),
            p.getMesa().getNumeroMesa(),
            p.getImporte(),
            p.getFecha(),
            p.getHora(),
            (p.isCobrado()),
            p.isEstado()
        });
        modelo_editable.addRow(new Object[] {
            p.getIdPedido(),
            p.getMesero().getDniMesero(),
            p.getMesa().getNumeroMesa(),
            p.getImporte(),
            p.getFecha(),
            p.getHora(),
            p.isCobrado(),
            p.isEstado()
        });
    }
    
    private void Botones(boolean b) {
        jbActualizar.setEnabled(b);
        jbEliminar.setEnabled(b);
    }
    
    private int Enumerar() throws SQLException {
        int size = pdata.listarPedidos().size();
        int numero=0;
        for (int i=1; i<size+10; i++) {
            if (pdata.buscarPedido(i)==null) {
                numero = i;
                break;
            }
        }
        return numero;
    }
    
    private void cargarFiltro() {
        try {
            if (hora!=null|fecha!=null|!"null".equals(cobrado)) {
                lista = pdata.buscarPedidosPorFechayHorayCobro(fecha, hora, cobrado);
            }else {
                lista = pdata.listarPedidos();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL: "+e,"SQL Error",JOptionPane.ERROR_MESSAGE);
        }
        cargarTabla();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotVigencia;
    private javax.swing.JDesktopPane jDesktopPane1;
    private com.toedter.calendar.JDateChooser jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLfondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbBuscar;
    private javax.swing.JCheckBox jcbFecha;
    private javax.swing.JCheckBox jcbHora;
    private javax.swing.JRadioButton jrCobrado;
    private javax.swing.JRadioButton jrNoCobrado;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfHora;
    // End of variables declaration//GEN-END:variables
}
