
package Vistas;

import Modelo.DetallePedido;
import Modelo.Pedido;
import Persistencia.DetallePedidoData;
import java.sql.*;
import Persistencia.MesaData;
import Persistencia.MeseroData;
import Persistencia.PedidoData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VPedido extends javax.swing.JInternalFrame {
    
    private ArrayList<Pedido> lista = new ArrayList<>();
    private PedidoData pdata = new PedidoData();
    private DetallePedidoData ddata = new DetallePedidoData();
    private MesaData mdata = new MesaData();
    private MeseroData msdata = new MeseroData();
    private JDesktopPane escritorio = null;
    private int rowSelected = -1;
    private int rowSelecteda = -1;
    private int rowSelectedg = -1;
    private boolean cargando = false;
    private boolean cambiando = false;
    private LocalTime hora = null;
    private LocalDate fecha = null;
    private String cobrado = "null";
    private boolean estado = true;
    
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
            return fila == modelo_cargar.getRowCount() - 1 & col!=3;
        }
    };
    
    private DefaultTableModel modelo_editable = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { 
            return col!=3;
        }
    };
    
    public VPedido(JDesktopPane escritorio) {
        this.escritorio = escritorio;
        initComponents();
        try {
            lista = pdata.listarPedidos(estado);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cargar la tabla: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        
        jbBuscar.setEnabled(false);
        jtfBuscar.setEnabled(false);
        jtfHora.setEnabled(false);
        jFecha.setEnabled(false);
        jbGuardar.setEnabled(false);
        jbTicket.setEnabled(false);
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
        jcbFecha = new javax.swing.JCheckBox();
        jcbHora = new javax.swing.JCheckBox();
        jrCobrado = new javax.swing.JRadioButton();
        jrNoCobrado = new javax.swing.JRadioButton();
        jcbBuscar = new javax.swing.JCheckBox();
        jFecha = new com.toedter.calendar.JDateChooser();
        jtfHora = new javax.swing.JTextField();
        jbDetalle = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbCobrar = new javax.swing.JButton();
        jbTicket = new javax.swing.JButton();
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

        setBackground(new java.awt.Color(204, 187, 165));
        setBorder(null);
        setForeground(new java.awt.Color(255, 255, 204));
        setTitle("Pedidos");
        setFont(new java.awt.Font("Calibri", 1, 10)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo_Pedidos.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel1.setText("Buscar por:");
        jLabel1.setAlignmentY(0.0F);

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

        jTable.setBackground(new java.awt.Color(255, 255, 204));
        jTable.setBorder(new javax.swing.border.MatteBorder(null));
        jTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable.setForeground(new java.awt.Color(153, 90, 48));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "N°Mesa", "DNI Mesero", "Importe", "Fecha Reser.", "Hora Reser.", "Cobrado", "Estado"
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

        jcbFecha.setBackground(new java.awt.Color(204, 187, 165));
        jcbFecha.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jcbFecha.setText("Fecha ");
        jcbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFechaActionPerformed(evt);
            }
        });

        jcbHora.setBackground(new java.awt.Color(204, 187, 165));
        jcbHora.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jcbHora.setText("Hora ");
        jcbHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbHoraActionPerformed(evt);
            }
        });

        jrCobrado.setBackground(new java.awt.Color(204, 187, 165));
        jrCobrado.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jrCobrado.setText("Cobrado");
        jrCobrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrCobradoActionPerformed(evt);
            }
        });

        jrNoCobrado.setBackground(new java.awt.Color(204, 187, 165));
        jrNoCobrado.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jrNoCobrado.setText("No cobrado");
        jrNoCobrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNoCobradoActionPerformed(evt);
            }
        });

        jcbBuscar.setBackground(new java.awt.Color(204, 187, 165));
        jcbBuscar.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jcbBuscar.setText("N°Mesa / DNI Mesero:");
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

        jbDetalle.setBackground(new java.awt.Color(153, 102, 0));
        jbDetalle.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jbDetalle.setForeground(new java.awt.Color(255, 255, 204));
        jbDetalle.setText("Dar Detalle");
        jbDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDetalleActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pedido1.jpg"))); // NOI18N

        jbCobrar.setBackground(new java.awt.Color(204, 153, 0));
        jbCobrar.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jbCobrar.setForeground(new java.awt.Color(255, 255, 204));
        jbCobrar.setText("Cobrar");
        jbCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCobrarActionPerformed(evt);
            }
        });

        jbTicket.setBackground(new java.awt.Color(204, 153, 0));
        jbTicket.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jbTicket.setForeground(new java.awt.Color(255, 255, 204));
        jbTicket.setText("Generar Ticket");
        jbTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTicketActionPerformed(evt);
            }
        });

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
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbCargar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbGuardar))
                            .addComponent(jbDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(jbEliminar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jcbBuscar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jcbHora)
                                                .addComponent(jcbFecha))
                                            .addGap(126, 126, 126)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                                .addComponent(jtfHora))))
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jrNoCobrado)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jcbEstado)
                                            .addComponent(jrCobrado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jbSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbBuscar)
                            .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbEstado)
                        .addGap(5, 5, 5)
                        .addComponent(jrCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jrNoCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCobrar)
                    .addComponent(jbDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbEliminar)
                        .addComponent(jbTicket))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbCargar)
                        .addComponent(jbGuardar)
                        .addComponent(jbActualizar)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String texto = jtfBuscar.getText();
        try {
            if (!"".equals(texto)) {
                try {
                    int numero = Integer.parseInt(texto);
                    
                    if (!pdata.buscarPorMesayDNI(numero).isEmpty()) {
                        lista = pdata.buscarPorMesayDNI(numero);
                    }else {
                        JOptionPane.showMessageDialog(this, "El Número de mesa o DNI de mesero ingresados no existen","ID/DNI inexistente",JOptionPane.WARNING_MESSAGE);
                        lista = pdata.listarPedidos(estado);
                        cargarTabla();
                    }
                } catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "El campo buscar solo admite enteros para ID y DNI","revisar tipos de datos",JOptionPane.WARNING_MESSAGE);
                    lista = pdata.listarPedidos(estado);
                    cargarTabla();
                }
                cargarTabla();
            }else{
                lista = pdata.listarPedidos(estado);
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
            jbDetalle.setEnabled(false);
            jbGuardar.setEnabled(true);
            jbCobrar.setEnabled(false);
            jbTicket.setEnabled(false);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
            String hora_now = LocalTime.now().format(formato);
            try {
                modelo_cargar.addRow(new Object[] {
                    Enumerar(),
                    "",
                    "",
                    "Automático",
                    LocalDate.now(),
                    hora_now,
                    "no_cobrado",
                    "true"
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
                JOptionPane.showMessageDialog(this, "Error, el ID no puede ser menor a uno", "Error de tipo ID", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (pdata.buscarPedido(id)==null) {
                p.setIdPedido(id);
            }else{
                JOptionPane.showMessageDialog(this, "Error, el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el ID ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int dnimesero = Integer.parseInt(cdni_mesero);
            if (dnimesero<1) {
                JOptionPane.showMessageDialog(this, "Error, el DNI del mesero no puede ser menor a uno", "Error de DNI mesero", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (msdata.buscar(String.valueOf(dnimesero))!=null) {
                p.setMesero(msdata.buscar(String.valueOf(dnimesero)));
            }else{
                JOptionPane.showMessageDialog(this, "Error, el DNI del mesero ingresado no existe", "Error mesero inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el DNI del mesero ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int mesa = Integer.parseInt(cnumero_mesa);
            if (mesa<1) {
                JOptionPane.showMessageDialog(this, "Error, el Número de mesa no puede ser menor a uno", "Error de número de mesa", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (mdata.buscar(mesa)!=null) {
                if (Integer.parseInt(cdni_mesero)==mdata.buscar(mesa).getMesero().getDniMesero()) {
                    p.setMesa(mdata.buscar(mesa));
                }else{
                    JOptionPane.showMessageDialog(this, "Esa mesa no le pertenece a ese mesero", "Error mesa incorrecta con mesero", JOptionPane.WARNING_MESSAGE);
                    return; 
                }
            }else{
                JOptionPane.showMessageDialog(this, "Error el numero de mesa ingresado no existe", "Error mesa inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el número de mesa ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            LocalDate fech = LocalDate.parse(cfecha);
            p.setFecha(fech);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error, formato de fecha incorrecto, el formato es el siguiente (yyyy-MM-dd)", "Error Fecha incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        try {
            p.setHora(LocalTime.parse(chora, formato));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error, formato de la hora incorrecto, el formato es el siguiente (HH:mm)", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
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
                JOptionPane.showMessageDialog(this, "Error, cobro inválido, debe ser (cobrado o no_cobrado)", "Error cobro incorrecto", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        if (cestado.equalsIgnoreCase("true")|cestado.equalsIgnoreCase("false")) {
            p.setEstado(cestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error, el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
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
            pdata.MantenerConsistenciaDatos();
            lista = pdata.listarPedidos(estado);
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
            jbDetalle.setEnabled(true);
            if (!cargando) {
                try {
                    Pedido p = pdata.buscarPedido(Integer.parseInt(modelo.getValueAt(rowSelected, 0).toString()));
                    if (p!=null) {
                        if (!p.isCobrado()) {
                            jbCobrar.setEnabled(true);
                        }else
                            jbCobrar.setEnabled(false);
                    }
                    jbTicket.setEnabled(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error de SQL: "+ex,"SQL Error",JOptionPane.ERROR_MESSAGE);
                }
                jTable.setModel(modelo_editable);
            }
        }
        if (cargando) {
            jbDetalle.setEnabled(false);
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
            JOptionPane.showMessageDialog(this, "Error de numeración: "+ex, "Error entero", JOptionPane.ERROR_MESSAGE);
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
        String cidPedido = modelo_editable.getValueAt(rowSelectedg, 0).toString();
        String cdni_mesero = modelo_editable.getValueAt(rowSelectedg, 1).toString();
        String cnumero_mesa = modelo_editable.getValueAt(rowSelectedg, 2).toString();
        String cimporte = modelo_editable.getValueAt(rowSelectedg, 3).toString();
        String cfecha = "";
        if (modelo_editable.getValueAt(rowSelectedg, 4)!=null) {
            cfecha = modelo_editable.getValueAt(rowSelectedg, 4).toString();
        }
        String chora = "";
        if (modelo_editable.getValueAt(rowSelectedg, 5)!=null) {
            chora = modelo_editable.getValueAt(rowSelectedg, 5).toString();
        }
        String ccobrado = modelo_editable.getValueAt(rowSelectedg, 6).toString();
        String cestado = modelo_editable.getValueAt(rowSelectedg, 7).toString();
        Pedido p = new Pedido();
        
        try {
            int id = Integer.parseInt(cidPedido);
            if (id<1) {
                JOptionPane.showMessageDialog(this, "Error, el ID no puede ser menor a uno", "Error de tipo ID", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (pdata.buscarPedido(id)==null) {
                p.setIdPedido(id);
            }else{
                if (idPedidog.equals(cidPedido)) {
                    p.setIdPedido(id);
                }else{
                    JOptionPane.showMessageDialog(this, "Error, el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el ID ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int dnimesero = Integer.parseInt(cdni_mesero);
            if (dnimesero<1) {
                JOptionPane.showMessageDialog(this, "Error, el DNI del mesero no puede ser menor a uno", "Error de DNI mesero", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (msdata.buscar(String.valueOf(dnimesero))!=null) {
                p.setMesero(msdata.buscar(String.valueOf(dnimesero)));
            }else{
                JOptionPane.showMessageDialog(this, "Error, el DNI del mesero ingresado no existe", "Error mesero inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el DNI del mesero ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int mesa = Integer.parseInt(cnumero_mesa);
            if (mesa<1) {
                JOptionPane.showMessageDialog(this, "Error, el Número de mesa no puede ser menor a uno", "Error de número de mesa", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (mdata.buscar(mesa)!=null) {
                if (Integer.parseInt(cdni_mesero)==mdata.buscar(mesa).getMesero().getDniMesero()) {
                    p.setMesa(mdata.buscar(mesa));
                }else{
                    JOptionPane.showMessageDialog(this, "Esa mesa no le pertenece a ese mesero", "Error mesa incorrecta con mesero", JOptionPane.WARNING_MESSAGE);
                    return; 
                }
            }else{
                JOptionPane.showMessageDialog(this, "Error, el número de mesa ingresado no existe", "Error mesa inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el número de mesa ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            LocalDate fech = LocalDate.parse(cfecha);
            p.setFecha(fech);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error, formato de fecha incorrecto, el formato es el siguiente (yyyy-MM-dd)", "Error Fecha incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        try {
            p.setHora(LocalTime.parse(chora, formato));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error, formato de la hora incorrecto, el formato es el siguiente (HH:mm)", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
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
                JOptionPane.showMessageDialog(this, "Error, cobro inválido, debe ser (cobrado o no_cobrado)", "Error cobro incorrecto", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        if (cestado.equalsIgnoreCase("true")|cestado.equalsIgnoreCase("false")) {
            p.setEstado(cestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error, el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            pdata.actualizarPedido(p,Integer.parseInt(idPedidog));
            if (!p.isEstado()) {
                ddata.ConsistenciaDeDatos();
            }
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
            jrNoCobrado.setSelected(false);
            cobrado = "cobrado";
        }else {
            cobrado = "null";
        }
        cargarFiltro();
    }//GEN-LAST:event_jrCobradoActionPerformed

    private void jrNoCobradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNoCobradoActionPerformed
        if (jrNoCobrado.isSelected()) {
            jrCobrado.setSelected(false);
            cobrado = "no_cobrado";
        }else {
            cobrado = "null";
        }
        cargarFiltro();
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

    private void jbDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDetalleActionPerformed
        int buscar = (int) jTable.getValueAt(rowSelected, 0);
        for (JInternalFrame frame : escritorio.getAllFrames()) {
            if (frame instanceof VDetallePedido) {
                frame.dispose();
                break;
            }
        }
        
        VDetallePedido v = new VDetallePedido(buscar,this);
        v.setVisible(true);
        escritorio.add(v);
        escritorio.moveToFront(v);
    }//GEN-LAST:event_jbDetalleActionPerformed

    private void jbCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCobrarActionPerformed
        try {
            if (!cargando) {
                int codigo = Integer.parseInt(jTable.getValueAt(rowSelected, 0).toString());
                pdata.cambiarCobro("cobrado", codigo);
                cargarFiltro();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error de numeración: "+ex, "Error entero", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cambiar el estado: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbCobrarActionPerformed

    private void jbTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTicketActionPerformed
         try {
            Pedido pedido = pdata.buscarPedido(Integer.parseInt(modelo.getValueAt(rowSelected, 0).toString()));
            ArrayList<DetallePedido> listadetalles = new ArrayList<>();
            jbTicket.setEnabled(false);
            
            if (pedido!=null) {
                
                for (DetallePedido d: ddata.buscarPorPedido(pedido.getIdPedido())) {
                    listadetalles.add(d);
                }
                
                String rutaEscritorio = System.getProperty("user.home") + "/Documents/";
                System.out.println("ruta: "+rutaEscritorio);
                File archivo = new File(rutaEscritorio + "ticket_pedido" + pedido.getIdPedido() + ".txt");

                BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

                writer.write("RESTAURANTE ENTRE AMIGOS\n");
                writer.write("Fecha: "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\n");
                writer.write("Mesa: "+pedido.getMesa().getNumeroMesa()+"\n");
                writer.write("Mesero: "+pedido.getMesero().getNombre()+", DNI: "+pedido.getMesero().getDniMesero()+"\n");
                writer.write("-----------------------------------\n");
                writer.write(String.format("%-20s %-10s %-10s\n", "Producto", "Cant", "Precio"));
                writer.write("-----------------------------------\n");
                
                double total = 0.0;

                for (DetallePedido d : listadetalles) {
                    String nombreProducto = d.getProducto().getNombre();
                    int cantidad = d.getCantidad();
                    double precioUnitario = d.getProducto().getPrecio();
                    double subtotal = cantidad * precioUnitario;

                    writer.write(String.format("%-20s %-10d %-10.2f\n", nombreProducto, cantidad, subtotal));

                    total += subtotal;
                }

                writer.write("-----------------------------------\n");
                writer.write(String.format("TOTAL: %30.2f\n", total));
                writer.write("Gracias por su visita!\n");

                writer.close();

                JOptionPane.showMessageDialog(this, "Tiquet creado en el escritorio","Tiquet creado",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al crear el tiquet: "+ex,"tiquet Error",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL: "+ex,"SQL Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbTicketActionPerformed

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        estado = jcbEstado.isSelected();
        cargarFiltro();
    }//GEN-LAST:event_jcbEstadoActionPerformed
    
    public void quitarFiltros() {
        jcbHora.setSelected(false);
        jtfHora.setEnabled(false);
        jtfHora.setText("00:00");
        hora = null;
        jcbFecha.setSelected(false);
        jFecha.setDate(null);
        jFecha.setEnabled(false);
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
        jbTicket.setEnabled(false);
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
    
    public void cargarTabla() {
        limpiarAcciones();
        jbDetalle.setEnabled(false);
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
            (p.isCobrado())? "cobrado":"no_cobrado",
            p.isEstado()
        });
        modelo_cargar.addRow(new Object[] {
            p.getIdPedido(),
            p.getMesero().getDniMesero(),
            p.getMesa().getNumeroMesa(),
            p.getImporte(),
            p.getFecha(),
            p.getHora(),
            (p.isCobrado())? "cobrado":"no_cobrado",
            p.isEstado()
        });
        modelo_editable.addRow(new Object[] {
            p.getIdPedido(),
            p.getMesero().getDniMesero(),
            p.getMesa().getNumeroMesa(),
            p.getImporte(),
            p.getFecha(),
            p.getHora(),
            (p.isCobrado())? "cobrado":"no_cobrado",
            p.isEstado()
        });
    }
    
    private void Botones(boolean b) {
        jbActualizar.setEnabled(b);
        jbEliminar.setEnabled(b);
        jbCobrar.setEnabled(b);
    }
    
    private int Enumerar() throws SQLException {
        int size = pdata.listarPedidos(estado).size();
        int numero=0;
        for (int i=1; i<size+10; i++) {
            if (pdata.buscarPedido(i)==null) {
                numero = i;
                break;
            }
        }
        return numero;
    }
    
    public void cargarFiltro() {
        try {
            pdata.MantenerConsistenciaDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cambiar el estado: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (hora!=null|fecha!=null|!"null".equals(cobrado)) {
                lista = pdata.buscarPedidosPorFechayHorayCobro(fecha, hora, cobrado, estado);
            }else {
                lista = pdata.listarPedidos(estado);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbCobrar;
    private javax.swing.JButton jbDetalle;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbTicket;
    private javax.swing.JCheckBox jcbBuscar;
    private javax.swing.JCheckBox jcbEstado;
    private javax.swing.JCheckBox jcbFecha;
    private javax.swing.JCheckBox jcbHora;
    private javax.swing.JRadioButton jrCobrado;
    private javax.swing.JRadioButton jrNoCobrado;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfHora;
    // End of variables declaration//GEN-END:variables
}
