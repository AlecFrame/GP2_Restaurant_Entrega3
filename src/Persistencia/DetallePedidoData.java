
package Persistencia;

import Modelo.Conexion;
import Modelo.DetallePedido;
import Modelo.Pedido;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DetallePedidoData {
    Connection con = Conexion.cargaConexion();

    public DetallePedidoData() {}
    
    public void MantenerConsistenciaDatos() throws SQLException {
        ProductosData pdata = new ProductosData();
        PedidoData ppdata = new PedidoData();
        String sql = "SELECT idDetalle, codigo, cantidad, total FROM detalle_pedido;";
        
        PreparedStatement s = con.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
        
        while (rs.next()) {
            Producto p = pdata.buscar(rs.getInt("codigo"));
            String sql2 = "UPDATE detalle_pedido SET total = ? WHERE idDetalle = ?;";
            
            PreparedStatement s2 = con.prepareStatement(sql2);
            s2.setDouble(1, p.getPrecio()*rs.getInt("cantidad"));
            s2.setInt(2, rs.getInt("idDetalle"));
            s2.executeUpdate();
        }
        
        ppdata.MantenerConsistenciaDatos();
    }
    
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
        PedidoData pedido = new PedidoData();
        ProductosData productos = new ProductosData();
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
        PedidoData pedido = new PedidoData();
        ProductosData productos = new ProductosData();
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
    
    public void CambiarEstado(boolean estado, int numero) throws SQLException {
        String sql = "Update detalle_pedido set estado = ? where idDetalle = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setBoolean(1, estado);
        s.setInt(2, numero);
        
        int filas = s.executeUpdate();
        if (filas>0) {
            String palabra = (estado)? "habilitado":"inhabilitado";
            System.out.println("\nEl estado del detalle_pedido "+numero+" fue actualizado a "+palabra+"\n");
        }
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
    
    public void ConsistenciaDeDatos() throws SQLException {
        PedidoData ppdata = new PedidoData();
        ProductosData pdata = new ProductosData();
        String sql = "SELECT idDetalle, idPedido, codigo, estado FROM detalle_pedido";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idDetalle = rs.getInt("idDetalle");
            int idPedido = rs.getInt("idPedido");
            int codigo = rs.getInt("codigo");
            Pedido pedido = ppdata.buscarPedido(idPedido);
            Producto producto = pdata.buscar(codigo);
            
            boolean estadoDetalle = rs.getBoolean("estado");

            boolean estadoPedido = pedido.isEstado();

            boolean estadoProducto = producto.isEstado();

            if (!estadoPedido || !estadoProducto) {
                if (estadoDetalle) {
                    CambiarEstado(false, idDetalle);
                }
            }
        }

        ps.close();
    }
    
    public ArrayList<DetallePedido> listar() throws SQLException {
        PedidoData pedido = new PedidoData();
        ProductosData productos = new ProductosData();
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
    
    public ArrayList<DetallePedido> filtrarCategoriayPedido(int idPedido, String categoria) throws SQLException { 
        ArrayList<DetallePedido> listaDetalle = new ArrayList<>();
        ProductosData pdata = new ProductosData();
        PedidoData ppdata = new PedidoData();
        StringBuilder sql = new StringBuilder("SELECT * FROM detalle_pedido WHERE 1=1");

        ArrayList<Object> parameters = new ArrayList<>();

        if (idPedido != 0) {
            sql.append(" AND idPedido = ?");
            parameters.add(idPedido);
        }

        if (categoria != null) {
            ArrayList<Producto> lista = pdata.filtrarCategoria(categoria);

            if (lista != null && !lista.isEmpty()) {
                sql.append(" AND codigo IN (");
                for (int i = 0; i < lista.size(); i++) {
                    sql.append("?");
                    if (i < lista.size() - 1) {
                        sql.append(", ");
                    }
                    parameters.add(lista.get(i).getCodigo());
                }
                sql.append(")");
            }
        }

        PreparedStatement ps = con.prepareStatement(sql.toString());

        for (int i = 0; i < parameters.size(); i++) {
            ps.setObject(i + 1, parameters.get(i));
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            DetallePedido dpedido = new DetallePedido(
                rs.getInt("idDetalle"),
                pdata.buscar(rs.getInt("codigo")),
                ppdata.buscarPedido(rs.getInt("idPedido")),
                rs.getInt("cantidad"),
                rs.getDouble("total"),
                rs.getBoolean("estado")
            );
            listaDetalle.add(dpedido);
        }
        return listaDetalle;
    }
}
