
package Vistas;

import Modelo.Mesa;
import java.sql.*;
import Modelo.Reserva;
import Persistencia.MesaData;
import Persistencia.ReservaData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VReservas extends javax.swing.JInternalFrame {
    
    private ArrayList<Reserva> lista = new ArrayList<>();
    private ReservaData rdata = new ReservaData();
    private MesaData mdata = new MesaData();
    private boolean estado = true;
    private int rowSelected = -1;
    private int rowSelecteda = -1;
    private int rowSelectedg = -1;
    private boolean cargando = false;
    private boolean cambiando = false;
    private LocalTime hora = null;
    private LocalDate fecha = null;
    private String vigencia = "null";
    
    private String idg = null;
    private String mesag = null;
    private String dnig = null;
    private String apellidog = null;
    private String fechag = null;
    private String hora_desdeg = null;
    private String hora_hastag = null;
    private String vigenciag = null;
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
    
    public VReservas() {
        initComponents();
        try {
            lista = rdata.listarReservas(estado);
            
            for (Reserva r: lista) {
                if ((r.getFecha().isBefore(LocalDate.now())||(
                        r.getFecha().isEqual(LocalDate.now())&
                        r.getHora_hasta().isBefore(LocalTime.now())
                        ))&
                        !"no_vigente".equals(r.getVigencia())) {
                    rdata.cambiarVigencia("no_vigente", r.getIdReserva());
                }
            }
            
            lista = rdata.listarReservas(estado);
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
        jrVigencia = new javax.swing.JRadioButton();
        jrNoVigencia = new javax.swing.JRadioButton();
        jcbBuscar = new javax.swing.JCheckBox();
        jFecha = new com.toedter.calendar.JDateChooser();
        jtfHora = new javax.swing.JTextField();
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
        setTitle("Reservas");
        setFont(new java.awt.Font("Calibri", 1, 10)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Logo_Reservas.jpg"))); // NOI18N

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
                { new Integer(1), null, null, null, null, null, null}
            },
            new String [] {
                "ID", "N° de Mesa", "DNI Cliente", "Apellido", "Fecha Reser.", "Hora Reser.", "Vigencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
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

        jLfondo.setBackground(new java.awt.Color(255, 204, 153));
        jLfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/reserva2.png"))); // NOI18N

        jcbFecha.setBackground(new java.awt.Color(204, 187, 165));
        jcbFecha.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jcbFecha.setText("Fecha Reservada");
        jcbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFechaActionPerformed(evt);
            }
        });

        jcbHora.setBackground(new java.awt.Color(204, 187, 165));
        jcbHora.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jcbHora.setText("Hora Reservada");
        jcbHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbHoraActionPerformed(evt);
            }
        });

        jrVigencia.setBackground(new java.awt.Color(204, 187, 165));
        jrVigencia.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jrVigencia.setText("Vigencia");
        jrVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrVigenciaActionPerformed(evt);
            }
        });

        jrNoVigencia.setBackground(new java.awt.Color(204, 187, 165));
        jrNoVigencia.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jrNoVigencia.setText("No Vigencia");
        jrNoVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNoVigenciaActionPerformed(evt);
            }
        });

        jcbBuscar.setBackground(new java.awt.Color(204, 187, 165));
        jcbBuscar.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jcbBuscar.setText("ID / Apellido:");
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
            .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jrVigencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrNoVigencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbHora)
                            .addComponent(jcbFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbEstado)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jcbEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jrNoVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jcbBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCargar)
                    .addComponent(jbGuardar)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String texto = jtfBuscar.getText();
        try {
            if (!"".equals(texto)) {
                jrVigencia.setSelected(false);
                jrNoVigencia.setSelected(false);
                vigencia="null";
                try {
                    int id = Integer.parseInt(texto);
                    if (rdata.buscarInt(id)!=null) {
                        lista.clear();
                        lista.add(rdata.buscarInt(id));
                    }else {
                        JOptionPane.showMessageDialog(this, "La ID ingresada no existe","ID inexistente",JOptionPane.WARNING_MESSAGE);
                        lista = rdata.listarReservas(estado);
                        cargarTabla();
                    }
                } catch(NumberFormatException e) {
                    lista = rdata.buscarString(texto);
                }
                cargarTabla();
            }else{
                lista = rdata.listarReservas(estado);
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
                    "",
                    (!"null".equals(vigencia))? vigencia:"vigente",
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
        String mid = modelo_cargar.getValueAt(row, 0).toString();
        String mmesa = modelo_cargar.getValueAt(row, 1).toString();
        String mdni = modelo_cargar.getValueAt(row, 2).toString();
        String mapellido = modelo_cargar.getValueAt(row, 3).toString();
        String mfecha = "";
        if (modelo_cargar.getValueAt(row, 4)!=null) {
            mfecha = modelo_cargar.getValueAt(row, 4).toString();
        }
        String mhora_desde = "";
        if (modelo_cargar.getValueAt(row, 5)!=null) {
            mhora_desde = modelo_cargar.getValueAt(row, 5).toString();
        }
        String mhora_hasta = modelo_cargar.getValueAt(row, 6).toString();
        String mvigencia = modelo_cargar.getValueAt(row, 7).toString();
        String mestado = modelo_cargar.getValueAt(row, 8).toString();
        Reserva r = new Reserva();
        
        try {
            int id = Integer.parseInt(mid);
            if (id<1) {
                JOptionPane.showMessageDialog(this, "Error, el ID no puede ser menor a uno", "Error de tipo ID", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (rdata.buscarInt(id)==null) {
                r.setIdReserva(id);
            }else{
                JOptionPane.showMessageDialog(this, "Error, el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el ID ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int mesa = Integer.parseInt(mmesa);
            if (mesa<1) {
                JOptionPane.showMessageDialog(this, "Error, el Número de mesa no puede ser menor a uno", "Error de número de mesa", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (mdata.buscar(mesa)!=null) {
                r.setMesa(mdata.buscar(mesa));
            }else{
                JOptionPane.showMessageDialog(this, "Error, el número de mesa ingresado no existe", "Error mesa inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el número de mesa ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mdni.trim().equalsIgnoreCase("")) {
            try {
                int dni = Integer.parseInt(mdni);

                if (mdni.length()>8) {
                    JOptionPane.showMessageDialog(this, "Error, el DNI ha superado el máximo de 8 caracteres", "Error DNI superó 8 caracteres", JOptionPane.WARNING_MESSAGE);
                    return;
                }else
                    r.setDni_cliente(mdni);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error, el DNI ingresado no es un número entero: "+e, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error, el DNI del cliente está vacío", "Error DNI vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mapellido.trim().equalsIgnoreCase("")) {
            r.setApellido(mapellido);
        }else{
            JOptionPane.showMessageDialog(this, "Error, el Apellido del cliente está vacío", "Error Apellido vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            LocalDate fech = LocalDate.parse(mfecha);
            if (fech.isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(this, "Error, no es logico hacer una reserva a una fecha anterior a la actual", "Error Fecha incorrecta", JOptionPane.WARNING_MESSAGE);
                return;
            }else {
                r.setFecha(fech);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error, formato de fecha incorrecto, el formato es el siguiente (yyyy-MM-dd)", "Error Fecha incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        try {
            r.setHora_desde(LocalTime.parse(mhora_desde, formato));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error, formato de la hora incorrecto, el formato es el siguiente (HH:mm)", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            if (LocalTime.parse(mhora_hasta, formato).isAfter(LocalTime.parse(mhora_desde, formato))) {
                r.setHora_hasta(LocalTime.parse(mhora_hasta, formato));
            }else {
                JOptionPane.showMessageDialog(this, "Hora hasta no puede ser anterior a hora desde", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error, formato de hora incorrecto, el formato es el siguiente (HH:mm)", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        switch (mvigencia) {
            case ("vigente") : {
                r.setVigencia(mvigencia);
                break;
            }
            case ("no_vigente") : {
                r.setVigencia(mvigencia);
                break;
            }
            default : {
                JOptionPane.showMessageDialog(this, "Error, vigencia inválida, debe ser (vigente o no_vigente)", "Error vigencia incorrecta", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            r.setEstado(mestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error, el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            LocalDate vfecha = LocalDate.parse(mfecha);
            LocalTime vhora_desde = LocalTime.parse(mhora_desde);
            LocalTime vhora_hasta = LocalTime.parse(mhora_hasta);
            int vnumero = Integer.parseInt(mmesa);
            int vidReserva = Integer.parseInt(mid);
            Mesa mesa = mdata.buscar(Integer.parseInt(mmesa));
            
            if (!"libre".equals(mesa.getOcupada()) & LocalDate.now().isEqual(vfecha) & (LocalTime.now().isAfter(vhora_desde) & LocalTime.now().isBefore(vhora_hasta))) {
                JOptionPane.showMessageDialog(this, "Atención, la mesa que se desea ocupar en esta reseva ya está siendo ocupada actualmente", "Error de conflicto de mesas", JOptionPane.WARNING_MESSAGE);
            }else{
                if (rdata.validarReservaConflicto( vfecha, vhora_desde, vhora_hasta, vnumero, vidReserva)) {
                    JOptionPane.showMessageDialog(this, "La reserva entra en conflicto con las horas de otra reserva que fue hecha para el mismo dia y misma mesa", "Error de conflicto de reservas", JOptionPane.WARNING_MESSAGE);
                }else{
                    rdata.guardarReserva(r);
                    cargando = false;
                    jbCargar.setEnabled(true);
                    jbGuardar.setEnabled(false);
                    jtfBuscar.setText("");
                    quitarFiltros();
                    jTable.setModel(modelo);
                    lista = rdata.listarReservas(estado);
                    cargarTabla();
                    JOptionPane.showMessageDialog(this, "Reserva guardada con exito", "Reserva guardada", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL al guardar la reserva: "+ex, "Error SQL", JOptionPane.ERROR_MESSAGE);
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
        
        if (cargando) {
            int row = modelo_cargar.getRowCount()-1;
            
            if (modelo_cargar.getValueAt(row, 5)!=null) {
                String mhora_desde = modelo_cargar.getValueAt(row, 5).toString();
                String mhora_hasta = modelo_cargar.getValueAt(row, 6).toString();
                
                try {
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime hora_hasta = LocalTime.parse(mhora_desde, formato);
                    hora_hasta = hora_hasta.plusMinutes(20);

                    if ("".equals(mhora_hasta)) {
                        modelo_cargar.setValueAt(hora_hasta, row, 6);
                    }
                }catch (Exception e) {}
            }
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        try {
            if (cargando) {
                cargarFiltro();
            }else{
                int codigo = Integer.parseInt(jTable.getValueAt(rowSelected, 0).toString());
                rdata.cambiarEstado(false, codigo);
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
                    String mid = modelo_editable.getValueAt(rowSelectedg, 0).toString();
                    String mmesa = modelo_editable.getValueAt(rowSelectedg, 1).toString();
                    String mdni = modelo_editable.getValueAt(rowSelectedg, 2).toString();
                    String mapellido = modelo_editable.getValueAt(rowSelectedg, 3).toString();
                    String mfecha = modelo_editable.getValueAt(rowSelectedg, 4).toString();
                    String mhora_desde = modelo_editable.getValueAt(rowSelectedg, 5).toString();
                    String mhora_hasta = modelo_editable.getValueAt(rowSelectedg, 6).toString();
                    String mvigencia = modelo_editable.getValueAt(rowSelectedg, 7).toString();
                    String mestado = modelo_editable.getValueAt(rowSelectedg, 8).toString();
                    
                    if (mid.equals(idg)&mmesa.equals(mesag)&
                        mdni.equals(dnig)&mapellido.equals(apellidog)&
                        mfecha.equals(fechag)&mhora_desde.equals(hora_desdeg)&mhora_hasta.equals(hora_hastag)&
                        mvigencia.equals(vigenciag)&mestado.equals(estadog)) {
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
                    modelo_editable.setValueAt(mesag, rowSelectedg, 1);
                    modelo_editable.setValueAt(dnig, rowSelectedg, 2);
                    modelo_editable.setValueAt(apellidog, rowSelectedg, 3);
                    modelo_editable.setValueAt(fechag, rowSelectedg, 4);
                    modelo_editable.setValueAt(hora_desdeg, rowSelectedg, 5);
                    modelo_editable.setValueAt(hora_hastag, rowSelectedg, 6);
                    modelo_editable.setValueAt(vigenciag, rowSelectedg, 7);
                    modelo_editable.setValueAt(estadog, rowSelectedg, 8);
                }
                rowSelectedg = rowSelecteda;
                idg = modelo.getValueAt(rowSelectedg, 0).toString();
                mesag = modelo.getValueAt(rowSelectedg, 1).toString();
                dnig = modelo.getValueAt(rowSelectedg, 2).toString();
                apellidog = modelo.getValueAt(rowSelectedg, 3).toString();
                fechag = modelo.getValueAt(rowSelectedg, 4).toString();
                hora_desdeg = modelo.getValueAt(rowSelectedg, 5).toString();
                hora_hastag = modelo.getValueAt(rowSelectedg, 6).toString();
                vigenciag = modelo.getValueAt(rowSelectedg, 7).toString();
                estadog = modelo.getValueAt(rowSelectedg, 8).toString();
                if (rowSelecteda!=-1) {
                    cambiando = false;
                    jbActualizar.setEnabled(false);
                    //System.out.println("("+rowSelecteda+") cambiando: "+cambiando);
                }
            }
        }
    }//GEN-LAST:event_jTablePropertyChange

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        String mid = modelo_editable.getValueAt(rowSelectedg, 0).toString();
        String mmesa = modelo_editable.getValueAt(rowSelectedg, 1).toString();
        String mdni = modelo_editable.getValueAt(rowSelectedg, 2).toString();
        String mapellido = modelo_editable.getValueAt(rowSelectedg, 3).toString();
        String mfecha = "";
        if (modelo_editable.getValueAt(rowSelectedg, 4)!=null) {
            mfecha = modelo_editable.getValueAt(rowSelectedg, 4).toString();
        }
        String mhora_desde = "";
        if (modelo_editable.getValueAt(rowSelectedg, 5)!=null) {
            mhora_desde = modelo_editable.getValueAt(rowSelectedg, 5).toString();
        }
        String mhora_hasta = modelo_editable.getValueAt(rowSelectedg, 6).toString();
        String mvigencia = modelo_editable.getValueAt(rowSelectedg, 7).toString();
        String mestado = modelo_editable.getValueAt(rowSelectedg, 8).toString();
        Reserva r = new Reserva();
        
        try {
            int id = Integer.parseInt(mid);
            if (id<1) {
                JOptionPane.showMessageDialog(this, "Error, el ID no puede ser menor a uno", "Error de tipo ID", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (rdata.buscarInt(id)==null) {
                r.setIdReserva(id);
            }else{
                if (mid.equals(idg)) {
                    r.setIdReserva(id);
                }else {
                    JOptionPane.showMessageDialog(this, "Error, el ID ingresado ya existe en la base de datos", "Error ID existente", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el ID ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int mesa = Integer.parseInt(mmesa);
            if (mesa<1) {
                JOptionPane.showMessageDialog(this, "Error, el Número de mesa no puede ser menor a uno", "Error de numero de mesa", JOptionPane.WARNING_MESSAGE);
                return;
            }else
            if (mdata.buscar(mesa)!=null) {
                r.setMesa(mdata.buscar(mesa));
            }else{
                JOptionPane.showMessageDialog(this, "Error, el número de mesa ingresado no existe", "Error mesa inexistente", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }catch(NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error, el numero de mesa ingresado no es un número entero: "+ex, "Error por tipo de datos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mdni.trim().equalsIgnoreCase("")) {
            if (mdni.length()>8) {
                JOptionPane.showMessageDialog(this, "Error, el DNI ha superado el máximo de 8 caracteres", "Error DNI superó 8 caracteres", JOptionPane.WARNING_MESSAGE);
                return;
            }else
                r.setDni_cliente(mdni);
        }else{
            JOptionPane.showMessageDialog(this, "Error, el DNI del cliente está vacío", "Error DNI vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!mapellido.trim().equalsIgnoreCase("")) {
            r.setApellido(mapellido);
        }else{
            JOptionPane.showMessageDialog(this, "Error, el Apellido del cliente está vacío", "Error Apellido vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            LocalDate fech = LocalDate.parse(mfecha);
            r.setFecha(fech);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error, formato de fecha incorrecto, el formato es el siguiente (yyyy-MM-dd)", "Error Fecha incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        try {
            r.setHora_desde(LocalTime.parse(mhora_desde, formato));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error, formato de la hora incorrecto, el formato es el siguiente (HH:mm)", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            if (LocalTime.parse(mhora_hasta, formato).isAfter(LocalTime.parse(mhora_desde, formato))) {
                r.setHora_hasta(LocalTime.parse(mhora_hasta, formato));
            }else {
                JOptionPane.showMessageDialog(this, "Hora hasta no puede ser anterior a hora desde", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error, formato de la hora incorrecto, el formato es el siguiente (HH:mm)", "Error Hora incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        switch (mvigencia) {
            case ("vigente") : {
                r.setVigencia(mvigencia);
                break;
            }
            case ("no_vigente") : {
                r.setVigencia(mvigencia);
                break;
            }
            default : {
                JOptionPane.showMessageDialog(this, "Error, vigencia inválida, debe ser (vigente o no_vigente)", "Error vigencia incorrecta", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        if (mestado.equalsIgnoreCase("true")|mestado.equalsIgnoreCase("false")) {
            r.setEstado(mestado.equalsIgnoreCase("true"));
        }else{
            JOptionPane.showMessageDialog(this, "Error, el estado debe ser True o False", "Error de tipos de datos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            LocalDate vfecha = LocalDate.parse(mfecha);
            LocalTime vhora_desde = LocalTime.parse(mhora_desde);
            LocalTime vhora_hasta = LocalTime.parse(mhora_hasta);
            int vnumero = Integer.parseInt(mmesa);
            int vidReserva = Integer.parseInt(mid);
            Mesa mesa = mdata.buscar(Integer.parseInt(mmesa));
            
            if (!"libre".equals(mesa.getOcupada()) & LocalDate.now().isEqual(vfecha) & (LocalTime.now().isAfter(vhora_desde) & LocalTime.now().isBefore(vhora_hasta))) {
                JOptionPane.showMessageDialog(this, "Atención, la mesa que se desea ocupar en esta reseva ya está siendo ocupada actualmente", "Error de conflicto de mesas", JOptionPane.WARNING_MESSAGE);
            }else{
                if (rdata.validarReservaConflicto( vfecha, vhora_desde, vhora_hasta, vnumero, vidReserva)) {
                    JOptionPane.showMessageDialog(this, "La reserva entra en conflicto con las horas de otra reserva que fue hecha para el mismo dia y misma mesa", "Error de conflicto de reservas", JOptionPane.WARNING_MESSAGE);
                }else{
                    rdata.actualizarReserva(r,Integer.parseInt(idg));
                    cargando = false;
                    jbCargar.setEnabled(true);
                    jbGuardar.setEnabled(false);
                    jTable.setModel(modelo);
                    cargarFiltro();
                    JOptionPane.showMessageDialog(this, "Reserva actualizada con exito", "Reserva actualizada", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL al cambiar el estado: "+e, "Error SQL", JOptionPane.ERROR_MESSAGE);
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

    private void jrVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrVigenciaActionPerformed
        if (jrVigencia.isSelected()) {
            jrNoVigencia.setSelected(false);
            vigencia = "vigente";
        }else {
            vigencia = "null";
        }
        cargarFiltro();
    }//GEN-LAST:event_jrVigenciaActionPerformed

    private void jrNoVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNoVigenciaActionPerformed
        if (jrNoVigencia.isSelected()) {
            jrVigencia.setSelected(false);
            vigencia = "no_vigente";
        }else {
            vigencia = "null";
        }
        cargarFiltro();
    }//GEN-LAST:event_jrNoVigenciaActionPerformed

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
        fecha = null;
        jrVigencia.setSelected(false);
        jrNoVigencia.setSelected(false);
        vigencia = "null";
    }
    
    public void limpiarAcciones() {
        jTable.setModel(modelo);
        Botones(false);
        jbCargar.setEnabled(true);
        jbGuardar.setEnabled(false);
        cambiando = false;
        idg = null;
        mesag = null;
        dnig = null;
        apellidog = null;
        fechag = null;
        hora_desdeg = null;
        hora_hastag = null;
        vigenciag = null;
        rowSelected = -1;
        rowSelecteda = -1;
        rowSelectedg = -1;
    }
    
    public void cargarModelo(DefaultTableModel modelos) {
        modelos.addColumn("ID");
        modelos.addColumn("N° de Mesa");
        modelos.addColumn("DNI Cliente");
        modelos.addColumn("Apellido");
        modelos.addColumn("Fecha Reserva");
        modelos.addColumn("Desde Hora");
        modelos.addColumn("Hasta Hora");
        modelos.addColumn("Vigencia");
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
        for (Reserva r: lista) {
            agregarFila(r);
        }
    }
    
    private void agregarFila(Reserva r) {
        modelo.addRow(new Object[] {
            r.getIdReserva(),
            r.getMesa().getNumeroMesa(),
            r.getDni_cliente(),
            r.getApellido(),
            r.getFecha(),
            r.getHora_desde(),
            r.getHora_hasta(),
            r.getVigencia(),
            r.isEstado()
        });
        modelo_cargar.addRow(new Object[] {
            r.getIdReserva(),
            r.getMesa().getNumeroMesa(),
            r.getDni_cliente(),
            r.getApellido(),
            r.getFecha(),
            r.getHora_desde(),
            r.getHora_hasta(),
            r.getVigencia(),
            r.isEstado()
        });
        modelo_editable.addRow(new Object[] {
            r.getIdReserva(),
            r.getMesa().getNumeroMesa(),
            r.getDni_cliente(),
            r.getApellido(),
            r.getFecha(),
            r.getHora_desde(),
            r.getHora_hasta(),
            r.getVigencia(),
            r.isEstado()
        });
    }
    
    private void Botones(boolean b) {
        jbActualizar.setEnabled(b);
        jbEliminar.setEnabled(b);
    }
    
    private int Enumerar() throws SQLException {
        int size = rdata.listarReservas(false).size();
        int numero=0;
        for (int i=1; i<size+10; i++) {
            if (rdata.buscarInt(i)==null) {
                numero = i;
                break;
            }
        }
        return numero;
    }
    
    private void cargarFiltro() {
        try {
            if (hora!=null|fecha!=null|!"null".equals(vigencia)) {
                lista = rdata.buscarReservasPorFechayHorayVigencia(fecha, hora, vigencia, estado);
            }else {
                lista = rdata.listarReservas(estado);
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
    private javax.swing.JCheckBox jcbEstado;
    private javax.swing.JCheckBox jcbFecha;
    private javax.swing.JCheckBox jcbHora;
    private javax.swing.JRadioButton jrNoVigencia;
    private javax.swing.JRadioButton jrVigencia;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfHora;
    // End of variables declaration//GEN-END:variables
}
