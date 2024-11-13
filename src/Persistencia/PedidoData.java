
package Persistencia;

import Modelo.Conexion;
import Modelo.DetallePedido;
import Modelo.Pedido;
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

    public PedidoData() {}
    
    public double calcularImporte(int idPedido) throws SQLException {
        DetallePedidoData ddata = new DetallePedidoData();
        double importe = 0;
        ArrayList<DetallePedido> Detallelist = ddata.buscarPorPedido(idPedido);
        
        if (!Detallelist.isEmpty()) {
            String sql = "SELECT SUM(total) AS importe FROM detalle_pedido WHERE idPedido = ? AND estado = true";

            try (PreparedStatement s = con.prepareStatement(sql)) {
                s.setInt(1, idPedido);
                try (ResultSet rs = s.executeQuery()) {
                    if (rs.next()) {
                        importe = rs.getDouble("importe");
                    }
                }
            }
        }
        
        return importe;
    }
    
    public void MantenerConsistenciaDatos() throws SQLException {
        String sql = "SELECT idPedido, importe FROM pedido;";
        
        PreparedStatement s = con.prepareStatement(sql);
        ResultSet rs = s.executeQuery();
        
        while (rs.next()) {
            String sql2 = "UPDATE pedido SET importe = ? WHERE idPedido = ?;";
            
            PreparedStatement s2 = con.prepareStatement(sql2);
            s2.setDouble(1, calcularImporte(rs.getInt("idPedido")));
            s2.setInt(2, rs.getInt("idPedido"));
            s2.executeUpdate();
        }
    }
    
    public void guardarPedido(Pedido p) throws SQLException {
        if (p.getIdPedido()==0) {
            String sql = "INSERT INTO pedido(dni_mesero, numero_mesa, importe, fecha, hora, cobrado, estado) VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, String.valueOf((int)p.getMesero().getDniMesero()));
            s.setInt(2, p.getMesa().getNumeroMesa());
            s.setDouble(3, calcularImporte(p.getIdPedido()));
            s.setDate(4, java.sql.Date.valueOf(p.getFecha()));
            s.setTime(5, java.sql.Time.valueOf( p.getHora()));
            s.setBoolean(6, p.isCobrado());
            s.setBoolean(7, p.isEstado());

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Pedido registrado con éxito");
            } else {
                System.out.println("Error al registrar el pedido");
            }
        }else {
            String sql = "INSERT INTO pedido(idPedido, dni_mesero, numero_mesa, importe, fecha, hora, cobrado, estado) VALUES(?,?,?,?,?,?,?,?)";
            
            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, p.getIdPedido());
            s.setString(2, String.valueOf((int)p.getMesero().getDniMesero()));
            s.setInt(3, p.getMesa().getNumeroMesa());
            s.setDouble(4, calcularImporte(p.getIdPedido()));
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
        } else {
            System.out.println("Error al eliminar el pedido");
        }
    }

    public Pedido buscarPedido(int numero) throws SQLException {
        MesaData mesa = new MesaData();
        MeseroData mesero = new MeseroData();
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
        
        return pedido;
    }
    
    public ArrayList<Pedido> buscarPorMesayDNI(int numero) throws SQLException {
        MesaData mesa = new MesaData();
        MeseroData mesero = new MeseroData();
        ArrayList<Pedido> lista = new ArrayList<>();
        boolean seguir = true;
        
        String sql = "SELECT * FROM pedido WHERE dni_mesero = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, numero);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            seguir = false;
            lista.add(new Pedido(rs.getInt("idPedido"),
                                mesero.buscar(rs.getString("dni_mesero")),
                                mesa.buscar(rs.getInt("numero_mesa")),
                                rs.getDouble("importe"),
                                rs.getDate("fecha").toLocalDate(),
                                rs.getTime("hora").toLocalTime(),
                                rs.getBoolean("cobrado"),
                                rs.getBoolean("estado"))
            );
        }
        
        if (seguir) {
            sql = "SELECT * FROM pedido WHERE numero_mesa = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, numero);

            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Pedido(rs.getInt("idPedido"),
                                    mesero.buscar(rs.getString("dni_mesero")),
                                    mesa.buscar(rs.getInt("numero_mesa")),
                                    rs.getDouble("importe"),
                                    rs.getDate("fecha").toLocalDate(),
                                    rs.getTime("hora").toLocalTime(),
                                    rs.getBoolean("cobrado"),
                                    rs.getBoolean("estado"))
                );
            }
        }
        return lista;
    }

    public void actualizarPedido(Pedido p, int id) throws SQLException {
        if (p.getIdPedido()==0) {
            String sql = "UPDATE pedido SET dni_mesero = ?, numero_mesa = ?, importe = ?, fecha = ?, hora = ?, cobrado = ?, estado = ? WHERE idPedido = ?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, String.valueOf((int)p.getMesero().getDniMesero()));
            s.setInt(2, p.getMesa().getNumeroMesa());
            s.setDouble(3, calcularImporte(p.getIdPedido()));
            s.setDate(4, java.sql.Date.valueOf(p.getFecha()));
            s.setTime(5, java.sql.Time.valueOf( p.getHora()));
            s.setBoolean(6, p.isCobrado());
            s.setBoolean(7, p.isEstado());
            s.setInt(8, id);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Pedido actualizado con éxito");
            } else {
                System.out.println("Error al actualizar el pedido");
            }
        }else {
            String sql = "UPDATE pedido SET idPedido = ?, dni_mesero = ?, numero_mesa = ?, importe = ?, fecha = ?, hora = ?, cobrado = ?, estado = ? WHERE idPedido = ?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, p.getIdPedido());
            s.setString(2, String.valueOf((int)p.getMesero().getDniMesero()));
            s.setInt(3, p.getMesa().getNumeroMesa());
            s.setDouble(4, calcularImporte(p.getIdPedido()));
            s.setDate(5, java.sql.Date.valueOf(p.getFecha()));
            s.setTime(6, java.sql.Time.valueOf( p.getHora()));
            s.setBoolean(7, p.isCobrado());
            s.setBoolean(8, p.isEstado());
            s.setInt(9, id);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Pedido actualizado con éxito");
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
        } else {
            System.out.println("Error al cambiar el estado de pedido");
        }
    }
    
    public void cambiarCobro(String cobrado, int idPedido) throws SQLException {
        String sql = "UPDATE pedido SET cobrado = ? WHERE idPedido = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setBoolean(1, (cobrado.equalsIgnoreCase("cobrado")));
        s.setInt(2, idPedido);
        s.executeUpdate();
    }
    
    public ArrayList<Pedido> listarPedidos(boolean estado) throws SQLException {
        MesaData mesa = new MesaData();
            MeseroData mesero = new MeseroData();
            ArrayList<Pedido> pedidos = new ArrayList<>();
        if (!estado) {
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
        }else {
            String sql = "SELECT * FROM pedido WHERE estado = true";

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
        }
        return pedidos;
    }

    public ArrayList<Pedido> buscarPedidosPorFechayHorayCobro(LocalDate fecha, LocalTime hora, String cobrado, boolean estado) throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        MesaData mesa = new MesaData();
        MeseroData mesero = new MeseroData();
        StringBuilder sql = null;
        
        if (estado) {
            sql = new StringBuilder("SELECT * FROM pedido WHERE estado = true");
        }else
            sql = new StringBuilder("SELECT * FROM pedido WHERE 1=1");

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
