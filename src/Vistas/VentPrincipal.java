package Vistas;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;


public class VentPrincipal extends javax.swing.JFrame {

   private EscritorioPersonalizado escritorio;
   
    public VentPrincipal() {
        initComponents();
        
        escritorio= new VentPrincipal.EscritorioPersonalizado();
        this.setContentPane(escritorio);
        this.setLocationRelativeTo(this);
        
        setIconImage(getIconImage());
    }
    
    //Logo ventana principal
   @Override
    public Image getIconImage(){
        Image retValue= Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos/logo4.png"));
        return retValue;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenu = new javax.swing.JMenuBar();
        jDetPedido = new javax.swing.JMenu();
        jPedido = new javax.swing.JMenuItem();
        jProductos = new javax.swing.JMenu();
        jCategoria = new javax.swing.JMenuItem();
        jReserva = new javax.swing.JMenu();
        jMesero = new javax.swing.JMenu();
        jMesa = new javax.swing.JMenu();
        jSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú");
        setBackground(new java.awt.Color(255, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jDesktopPane1.setMinimumSize(new java.awt.Dimension(1, 10));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jMenu.setBackground(new java.awt.Color(152, 102, 0));
        jMenu.setBorder(null);
        jMenu.setForeground(new java.awt.Color(153, 102, 0));
        jMenu.setBorderPainted(false);
        jMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenu.setInheritsPopupMenu(true);

        jDetPedido.setBorder(null);
        jDetPedido.setForeground(new java.awt.Color(255, 255, 204));
        jDetPedido.setText("Detalle de Pedidos");
        jDetPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDetPedidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jDetPedidoMouseExited(evt);
            }
        });

        jPedido.setBackground(new java.awt.Color(204, 102, 0));
        jPedido.setForeground(new java.awt.Color(255, 255, 204));
        jPedido.setText("Pedido");
        jPedido.setBorder(null);
        jPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPedidoActionPerformed(evt);
            }
        });
        jDetPedido.add(jPedido);

        jMenu.add(jDetPedido);

        jProductos.setBackground(new java.awt.Color(153, 102, 0));
        jProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 102, 0)));
        jProductos.setForeground(new java.awt.Color(255, 255, 204));
        jProductos.setText("Productos");
        jProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jProductosMouseExited(evt);
            }
        });

        jCategoria.setBackground(new java.awt.Color(204, 102, 0));
        jCategoria.setForeground(new java.awt.Color(255, 255, 204));
        jCategoria.setText("Categoría");
        jCategoria.setBorder(null);
        jCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCategoriaActionPerformed(evt);
            }
        });
        jProductos.add(jCategoria);

        jMenu.add(jProductos);

        jReserva.setBackground(new java.awt.Color(153, 102, 0));
        jReserva.setBorder(null);
        jReserva.setForeground(new java.awt.Color(255, 255, 204));
        jReserva.setText("Reserva");
        jReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jReservaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jReservaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jReservaMouseExited(evt);
            }
        });
        jMenu.add(jReserva);

        jMesero.setBackground(new java.awt.Color(153, 102, 0));
        jMesero.setBorder(null);
        jMesero.setForeground(new java.awt.Color(255, 255, 204));
        jMesero.setText("Mesero");
        jMesero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMeseroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMeseroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMeseroMouseExited(evt);
            }
        });
        jMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeseroActionPerformed(evt);
            }
        });
        jMenu.add(jMesero);

        jMesa.setBackground(new java.awt.Color(153, 102, 0));
        jMesa.setBorder(null);
        jMesa.setForeground(new java.awt.Color(255, 255, 204));
        jMesa.setText("Mesa");
        jMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMesaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMesaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMesaMouseExited(evt);
            }
        });
        jMenu.add(jMesa);

        jSalir.setBorder(null);
        jSalir.setForeground(new java.awt.Color(255, 255, 255));
        jSalir.setText("Salir");
        jSalir.setDoubleBuffered(true);
        jSalir.setInheritsPopupMenu(true);
        jSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSalirMouseExited(evt);
            }
        });
        jMenu.add(jSalir);

        setJMenuBar(jMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPedidoActionPerformed
        JOptionPane.showMessageDialog(this, "Este apartado es para la proxima entrega", "Profes los queremos <3", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jPedidoActionPerformed

    private void jCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCategoriaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VProducto v = new VProducto();
        v.setVisible(true);
        escritorio.add(v);
        escritorio.moveToFront(v);
    }//GEN-LAST:event_jCategoriaActionPerformed

    private void jReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jReservaMouseClicked
        escritorio.removeAll();
        escritorio.repaint();
        VReservas v = new VReservas();
        v.setVisible(true);
        escritorio.add(v);
        escritorio.moveToFront(v);        
    }//GEN-LAST:event_jReservaMouseClicked

    private void jMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMesaMouseClicked
        escritorio.removeAll();
        escritorio.repaint();
        VMesa v = new VMesa();
        v.setVisible(true);
        escritorio.add(v);
        escritorio.moveToFront(v);
    }//GEN-LAST:event_jMesaMouseClicked

    private void jReservaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jReservaMouseExited
        jReserva.setForeground(java.awt.Color.yellow);
    }//GEN-LAST:event_jReservaMouseExited

    private void jSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalirMouseExited
        jSalir.setForeground(java.awt.Color.white);
    }//GEN-LAST:event_jSalirMouseExited

    private void jSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalirMouseEntered
        jSalir.setForeground(java.awt.Color.red);
    }//GEN-LAST:event_jSalirMouseEntered

    private void jMeseroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMeseroMouseEntered
        jMesero.setForeground(java.awt.Color.orange);
    }//GEN-LAST:event_jMeseroMouseEntered

    private void jMeseroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMeseroMouseExited
        jMesero.setForeground(java.awt.Color.yellow);
    }//GEN-LAST:event_jMeseroMouseExited

    private void jMesaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMesaMouseEntered
        jMesa.setForeground(java.awt.Color.orange);
    }//GEN-LAST:event_jMesaMouseEntered

    private void jMesaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMesaMouseExited
        jMesa.setForeground(java.awt.Color.yellow);
    }//GEN-LAST:event_jMesaMouseExited

    private void jReservaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jReservaMouseEntered
        jReserva.setForeground(java.awt.Color.orange);
    }//GEN-LAST:event_jReservaMouseEntered

    private void jProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProductosMouseEntered
        jProductos.setForeground(java.awt.Color.orange);
    }//GEN-LAST:event_jProductosMouseEntered

    private void jProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProductosMouseExited
        jProductos.setForeground(java.awt.Color.yellow);
    }//GEN-LAST:event_jProductosMouseExited

    private void jDetPedidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDetPedidoMouseEntered
        jDetPedido.setForeground(java.awt.Color.orange);
    }//GEN-LAST:event_jDetPedidoMouseEntered

    private void jDetPedidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDetPedidoMouseExited
        jDetPedido.setForeground(java.awt.Color.yellow); 
    }//GEN-LAST:event_jDetPedidoMouseExited

    private void jSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalirMouseClicked
        int rta=JOptionPane.showConfirmDialog(this,"¿Desea salir del sistema?","Advertencia", JOptionPane.YES_NO_OPTION);
        if(rta==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jSalirMouseClicked

    private void jMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeseroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMeseroActionPerformed

    private void jMeseroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMeseroMouseClicked
        escritorio.removeAll();
        escritorio.repaint();
        VMeseros v = new VMeseros();
        v.setVisible(true);
        escritorio.add(v);
        escritorio.moveToFront(v);   
    }//GEN-LAST:event_jMeseroMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jCategoria;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jDetPedido;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMesa;
    private javax.swing.JMenu jMesero;
    private javax.swing.JMenuItem jPedido;
    private javax.swing.JMenu jProductos;
    private javax.swing.JMenu jReserva;
    private javax.swing.JMenu jSalir;
    // End of variables declaration//GEN-END:variables
   
    //INCORPORAR IMAGEN AL ESCRITORIO
    public class EscritorioPersonalizado extends JDesktopPane{
        private BufferedImage img;

        public EscritorioPersonalizado() {
            try{
                img=ImageIO.read(getClass().getResourceAsStream("/Recursos/r20.png"));
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }

      }
}
