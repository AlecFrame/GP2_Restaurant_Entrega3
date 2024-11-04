
package Persistencia;

import Modelo.Conexion;
import Modelo.Pedido;
import Modelo.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PedidoData {
    private Connection con = Conexion.cargaConexion();
    private MesaData mesa = new MesaData();
    private MeseroData mesero = new MeseroData();

    public PedidoData() {}

    
    public void guardarPedido(Pedido p) throws SQLException {
        if (p.getIdPedido()==0) {
            String sql = "INSERT INTO pedido(dni_mesero, numero_mesa, importe, fecha, hora, cobrado, estado) VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, String.valueOf((int)p.getMesero().getDniMesero()));
            s.setInt(2, p.getMesa().getNumeroMesa());
            s.setDouble(3, p.getImporte());
            s.setDate(4, java.sql.Date.valueOf(p.getFecha()));
            s.setTime(5, java.sql.Time.valueOf( p.getHora()));
            s.setBoolean(6, p.isCobrado());
            s.setBoolean(7, p.isEstado());

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Pedido registrado con éxito");
                JOptionPane.showMessageDialog(null, "Pedido registrado con éxito");
            } else {
                System.out.println("Error al registrar el pedido");
            }
        }else {
            String sql = "INSERT INTO pedido(idPedido, dni_mesero, numero_mesa, importe, fecha, hora, cobrado, estado) VALUES(?,?,?,?,?,?,?,?)";
            
            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, p.getIdPedido());
            s.setString(2, String.valueOf((int)p.getMesero().getDniMesero()));
            s.setInt(3, p.getMesa().getNumeroMesa());
            s.setDouble(4, p.getImporte());
            s.setDate(5, java.sql.Date.valueOf(p.getFecha()));
            s.setTime(6, java.sql.Time.valueOf( p.getHora()));
            s.setBoolean(7, p.isCobrado());
            s.setBoolean(8, p.isEstado());

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Pedido registrado con éxito");
                JOptionPane.showMessageDialog(null, "Pedido registrado con éxito");
            } else {
                System.out.println("Error al registrar el pedido");
            }
        }
    }

    public void eliminarPedido(int idPedido) throws SQLException {
        String sql = "DELETE FROM pedido WHERE idPedido = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, idPedido);
        
        int filas = s.executeUpdate();
        if (filas > 0) {
            System.out.println("El pedido " + idPedido + " fue eliminado con éxito");
            JOptionPane.showMessageDialog(null, "El pedido fue eliminado con éxito");
        } else {
            System.out.println("Error al eliminar el pedido");
        }
    }

    public Pedido buscarPedido(int numero) throws SQLException {
        Pedido pedido = null;
        String sql = "SELECT * FROM pedido WHERE idPedido = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, numero);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pedido = new Pedido(rs.getInt("idPedido"),
                                mesero.buscar(rs.getString("dni_mesero")),
                                mesa.buscar(rs.getInt("numero_mesa")),
                                rs.getDouble("importe"),
                                rs.getDate("fecha").toLocalDate(),
                                rs.getTime("hora").toLocalTime(),
                                rs.getBoolean("cobrado"),
                                rs.getBoolean("estado"));
        }
        
        if (pedido==null) {
            sql = "SELECT * FROM pedido WHERE dni_mesero = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, numero);

            rs = ps.executeQuery();
            if (rs.next()) {
                pedido = new Pedido(rs.getInt("idPedido"),
                                    mesero.buscar(rs.getString("dni_mesero")),
                                    mesa.buscar(rs.getInt("numero_mesa")),
                                    rs.getDouble("importe"),
                                    rs.getDate("fecha").toLocalDate(),
                                    rs.getTime("hora").toLocalTime(),
                                    rs.getBoolean("cobrado"),
                                    rs.getBoolean("estado"));
            }
        }
        
        return pedido;
    }

    public void actualizarPedido(Pedido p, int id) throws SQLException {
        if (p.getIdPedido()==0) {
            String sql = "UPDATE pedido SET dni_mesero = ?, numero_mesa = ?, importe = ?, fecha = ?, hora = ?, cobrado = ?, estado = ? WHERE idPedido = ?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, String.valueOf((int)p.getMesero().getDniMesero()));
            s.setInt(2, p.getMesa().getNumeroMesa());
            s.setDouble(3, p.getImporte());
            s.setDate(4, java.sql.Date.valueOf(p.getFecha()));
            s.setTime(5, java.sql.Time.valueOf( p.getHora()));
            s.setBoolean(6, p.isCobrado());
            s.setBoolean(7, p.isEstado());
            s.setInt(8, id);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Pedido actualizado con éxito");
                JOptionPane.showMessageDialog(null, "Pedido actualizado con éxito");
            } else {
                System.out.println("Error al actualizar el pedido");
            }
        }else {
            String sql = "UPDATE pedido SET idPedido = ?, dni_mesero = ?, numero_mesa = ?, importe = ?, fecha = ?, hora = ?, cobrado = ?, estado = ? WHERE idPedido = ?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, p.getIdPedido());
            s.setString(2, String.valueOf((int)p.getMesero().getDniMesero()));
            s.setInt(3, p.getMesa().getNumeroMesa());
            s.setDouble(4, p.getImporte());
            s.setDate(5, java.sql.Date.valueOf(p.getFecha()));
            s.setTime(6, java.sql.Time.valueOf( p.getHora()));
            s.setBoolean(7, p.isCobrado());
            s.setBoolean(8, p.isEstado());
            s.setInt(9, id);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Pedido actualizado con éxito");
                JOptionPane.showMessageDialog(null, "Pedido actualizado con éxito");
            } else {
                System.out.println("Error al actualizar el pedido");
            }
        }
    }
    
    public void cambiarEstado(boolean estado, int idPedido) throws SQLException {
        String sql = "UPDATE pedido SET estado = ? WHERE idPedido = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setBoolean(1, estado);
        s.setInt(2, idPedido);
        
        int filas = s.executeUpdate();
        if (filas > 0) {
            System.out.println("El pedido " + idPedido + " fue eliminado con éxito");
            JOptionPane.showMessageDialog(null, "El estado del pedido fue actualizado con éxito");
        } else {
            System.out.println("Error al cambiar el estado de pedido");
        }
    }
    
    public ArrayList<Pedido> listarPedidos() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Pedido pedido = new Pedido(rs.getInt("idPedido"),
                                mesero.buscar(rs.getString("dni_mesero")),
                                mesa.buscar(rs.getInt("numero_mesa")),
                                rs.getDouble("importe"),
                                rs.getDate("fecha").toLocalDate(),
                                rs.getTime("hora").toLocalTime(),
                                rs.getBoolean("cobrado"),
                                rs.getBoolean("estado"));
            pedidos.add(pedido);
        }
        return pedidos;
    }

    public ArrayList<Pedido> listarPedidosCobrados() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE cobrado = 1";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Pedido pedido = new Pedido(rs.getInt("idPedido"),
                                mesero.buscar(rs.getString("dni_mesero")),
                                mesa.buscar(rs.getInt("numero_mesa")),
                                rs.getDouble("importe"),
                                rs.getDate("fecha").toLocalDate(),
                                rs.getTime("hora").toLocalTime(),
                                rs.getBoolean("cobrado"),
                                rs.getBoolean("estado"));
            pedidos.add(pedido);
        }
        return pedidos;
    }

    public ArrayList<Pedido> buscarPedidosPorFechayHorayCobro(LocalDate fecha, LocalTime hora, String cobrado) throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM pedido WHERE 1=1");

        ArrayList<Object> parameters = new ArrayList<>();

        if (fecha != null) {
            sql.append(" AND fecha = ?");
            parameters.add(java.sql.Date.valueOf(fecha));
        }
        if (hora != null) {
            sql.append(" AND hora = ?");
            parameters.add(hora);
        }
        if (cobrado != null && !"null".equals(cobrado)) {
            boolean cobro = (cobrado.equalsIgnoreCase("cobrado"));
            sql.append(" AND cobrado = ?");
            parameters.add(cobro);
        }

        PreparedStatement ps = con.prepareStatement(sql.toString());

        for (int i = 0; i < parameters.size(); i++) {
            ps.setObject(i + 1, parameters.get(i));
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Pedido pedido = new Pedido(rs.getInt("idPedido"),
                                mesero.buscar(rs.getString("dni_mesero")),
                                mesa.buscar(rs.getInt("numero_mesa")),
                                rs.getDouble("importe"),
                                rs.getDate("fecha").toLocalDate(),
                                rs.getTime("hora").toLocalTime(),
                                rs.getBoolean("cobrado"),
                                rs.getBoolean("estado"));
            pedidos.add(pedido);
        }
        return pedidos;
    }

}
