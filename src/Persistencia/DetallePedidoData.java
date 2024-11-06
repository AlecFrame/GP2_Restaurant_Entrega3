
package Persistencia;

import Modelo.Conexion;
import Modelo.DetallePedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DetallePedidoData {
    Connection con = Conexion.cargaConexion();
    PedidoData pedido = new PedidoData();
    ProductosData productos = new ProductosData();

    public DetallePedidoData() {}
    
    public void guardar(DetallePedido p) throws SQLException {
        if (p.getIdDetalle()==0) {
            String sql = "INSERT INTO detalle_pedido(codigo, idPedido, cantidad, total, estado) VALUES(?,?,?,?,?)";
            
            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, p.getProducto().getCodigo());
            s.setInt(2, p.getPedido().getIdPedido());
            s.setInt(3, p.getCantidad());
            s.setDouble(4, p.getProducto().getPrecio()*p.getCantidad());
            s.setBoolean(5, p.isEstado());

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("DetallePedido registrado con éxito");
                JOptionPane.showMessageDialog(null, "DetallePedido registrado con éxito");
            } else {
                System.out.println("Error al registrar el DetallePedido");
            }
        }else {
            String sql = "INSERT INTO detalle_pedido(idDetalle, codigo, idPedido, cantidad, total, estado) VALUES(?,?,?,?,?,?)";
            
            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, p.getIdDetalle());
            s.setInt(2, p.getProducto().getCodigo());
            s.setInt(3, p.getPedido().getIdPedido());
            s.setInt(4, p.getCantidad());
            s.setDouble(5, p.getProducto().getPrecio()*p.getCantidad());
            s.setBoolean(6, p.isEstado());

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("DetallePedido registrado con éxito");
                JOptionPane.showMessageDialog(null, "DetallePedido registrado con éxito");
            } else {
                System.out.println("Error al registrar el DetallePedido");
            }
        }
    }
    
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM detalle_pedido WHERE idDetalle = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, id);
        
        int filas = s.executeUpdate();
        if (filas > 0) {
            System.out.println("El detalle_pedido " + id + " fue eliminado con éxito");
            JOptionPane.showMessageDialog(null, "El detalle_pedido fue eliminado con éxito");
        } else {
            System.out.println("Error al eliminar el detalle_pedido");
        }
    }
    
    public DetallePedido buscar(int id) throws SQLException {
        DetallePedido detalle = null;
        String sql = "SELECT * FROM detalle_pedido WHERE idDetalle = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            detalle = new DetallePedido(rs.getInt("idDetalle"),
                                        productos.buscar(rs.getInt("codigo")),
                                        pedido.buscarPedido(rs.getInt("idPedido")),
                                        rs.getInt("cantidad"),
                                        rs.getDouble("total"),
                                        rs.getBoolean("estado"));
        }
        
        return detalle;
    }
    
    public DetallePedido buscarPorPedido(int id) throws SQLException {
        DetallePedido detalle = null;
        String sql = "SELECT * FROM detalle_pedido WHERE idPedido = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            detalle = new DetallePedido(rs.getInt("idDetalle"),
                                        productos.buscar(rs.getInt("codigo")),
                                        pedido.buscarPedido(rs.getInt("idPedido")),
                                        rs.getInt("cantidad"),
                                        rs.getDouble("total"),
                                        rs.getBoolean("estado"));
        }
        
        return detalle;
    }
    
    public void actualizar(DetallePedido p, int id) throws SQLException {
        if (p.getIdDetalle()==0) {
            String sql = "UPDATE detalle_pedido SET codigo = ?, idPedido = ?, cantidad = ?, total = ?, estado = ? WHERE idDetalle = ?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, p.getProducto().getCodigo());
            s.setInt(2, p.getPedido().getIdPedido());
            s.setInt(3, p.getCantidad());
            s.setDouble(4, p.getProducto().getPrecio()*p.getCantidad());
            s.setBoolean(5, p.isEstado());
            s.setInt(6, id);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("DetallePedido actualizado con éxito");
                JOptionPane.showMessageDialog(null, "DetallePedido actualizado con éxito");
            } else {
                System.out.println("Error al actualizar el DetallePedido");
            }
        }else {
            String sql = "UPDATE detalle_pedido SET idDetalle = ?, codigo = ?, idPedido = ?, cantidad = ?, total = ?, estado = ? WHERE idDetalle = ?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, p.getIdDetalle());
            s.setInt(2, p.getProducto().getCodigo());
            s.setInt(3, p.getPedido().getIdPedido());
            s.setInt(4, p.getCantidad());
            s.setDouble(5, p.getProducto().getPrecio()*p.getCantidad());
            s.setBoolean(6, p.isEstado());
            s.setInt(7, id);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("DetallePedido actualizado con éxito");
                JOptionPane.showMessageDialog(null, "DetallePedido actualizado con éxito");
            } else {
                System.out.println("Error al actualizar el DetallePedido");
            }
        }
    }
    
    public ArrayList<DetallePedido> listar() throws SQLException {
        ArrayList<DetallePedido> detallespedidos = new ArrayList<>();
        String sql = "SELECT * FROM detalle_pedido";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            DetallePedido dpedido = new DetallePedido(rs.getInt("idDetalle"),
                                        productos.buscar(rs.getInt("codigo")),
                                        pedido.buscarPedido(rs.getInt("idPedido")),
                                        rs.getInt("cantidad"),
                                        rs.getDouble("total"),
                                        rs.getBoolean("estado"));
            detallespedidos.add(dpedido);
        }
        return detallespedidos;
    }
    
}
