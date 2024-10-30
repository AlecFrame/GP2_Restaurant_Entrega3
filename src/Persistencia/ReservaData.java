
package Persistencia;

import Modelo.Conexion;
import Modelo.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaData {
    private Connection con = Conexion.cargaConexion();
    private MesaData mesaData = new MesaData();

    public ReservaData() {}

    public void guardarReserva(Reserva r) throws SQLException {
        if (r.getIdReserva()==0) {
            String sql = "INSERT INTO reserva(numero_mesa, dni_cliente, apellido, fecha, hora_desde, hora_hasta, vigencia, estado) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, r.getMesa().getNumeroMesa());
            s.setString(2, r.getDni_cliente());
            s.setString(3, r.getApellido());
            s.setDate(4, java.sql.Date.valueOf(r.getFecha()));
            s.setTime(5, java.sql.Time.valueOf(r.getHora_desde()));
            s.setTime(6, java.sql.Time.valueOf(r.getHora_hasta()));
            s.setString(7, r.getVigencia());
            s.setBoolean(8, (r.getVigencia().equals("vigencia")));

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Reserva registrada con éxito");
                JOptionPane.showMessageDialog(null, "Reserva registrada con éxito");
            } else {
                System.out.println("Error al registrar la reserva");
            }
        }else{
            String sql = "INSERT INTO reserva(idReserva, numero_mesa, dni_cliente, apellido, fecha, hora_desde, hora_hasta, vigencia, estado) VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, r.getIdReserva());
            s.setInt(2, r.getMesa().getNumeroMesa());
            s.setString(3, r.getDni_cliente());
            s.setString(4, r.getApellido());
            s.setDate(5, java.sql.Date.valueOf(r.getFecha()));
            s.setTime(6, java.sql.Time.valueOf(r.getHora_desde()));
            s.setTime(7, java.sql.Time.valueOf(r.getHora_hasta()));
            s.setString(8, r.getVigencia());
            s.setBoolean(9, (r.getVigencia().equals("vigencia")));

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Reserva registrada con éxito");
                JOptionPane.showMessageDialog(null, "Reserva registrada con éxito");
            } else {
                System.out.println("Error al registrar la reserva");
            }
        }
    }

    public void eliminarReserva(int idReserva) throws SQLException {
        String sql = "DELETE FROM reserva WHERE idReserva = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, idReserva);
        
        int filas = s.executeUpdate();
        if (filas > 0) {
            System.out.println("La reserva " + idReserva + " fue eliminada con éxito");
            JOptionPane.showMessageDialog(null, "La reserva fue eliminada con éxito");
        } else {
            System.out.println("Error al eliminar la reserva");
        }
    }

    public Reserva buscarInt(int idReserva) throws SQLException {
        Reserva reserva = null;
        String sql = "SELECT * FROM reserva WHERE idReserva = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idReserva);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            reserva = new Reserva(rs.getInt("idReserva"),
                                  mesaData.buscar(rs.getInt("numero_mesa")),
                                  rs.getString("dni_cliente"),
                                  rs.getString("apellido"),
                                  rs.getDate("fecha").toLocalDate(),
                                  rs.getTime("hora_desde").toLocalTime(),
                                  rs.getTime("hora_hasta").toLocalTime(),
                                  rs.getString("vigencia"),
                                  rs.getBoolean("estado"));
        }
        
        return reserva;
    }
    
    public ArrayList<Reserva> buscarString(String apellido) throws SQLException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE apellido LIKE CONCAT(\"%\",?,\"%\")";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, apellido);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Reserva reserva = new Reserva(rs.getInt("idReserva"),
                                          mesaData.buscar(rs.getInt("numero_mesa")),
                                          rs.getString("dni_cliente"),
                                          rs.getString("apellido"),
                                            rs.getDate("fecha").toLocalDate(),
                                            rs.getTime("hora_desde").toLocalTime(),
                                            rs.getTime("hora_hasta").toLocalTime(),
                                          rs.getString("vigencia"),
                                          rs.getBoolean("estado"));
            reservas.add(reserva);
        }
        return reservas;
    }
    
    public void actualizarReserva(Reserva r, int id) throws SQLException {
        if (r.getIdReserva()==0){
            String sql = "UPDATE reserva SET numero_mesa = ?, dni_cliente = ?, apellido = ?, fecha = ?, hora_desde = ?, hora_hasta = ?, vigencia = ?, estado = ? WHERE idReserva = ?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, r.getMesa().getNumeroMesa());
            s.setString(2, r.getDni_cliente());
            s.setString(3, r.getApellido());
            s.setDate(4, java.sql.Date.valueOf(r.getFecha()));
            s.setTime(5, java.sql.Time.valueOf(r.getHora_desde()));
            s.setTime(6, java.sql.Time.valueOf(r.getHora_hasta()));
            s.setString(7, r.getVigencia());
            s.setBoolean(8, (r.getVigencia().equals("vigencia")));
            s.setInt(9, id);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Reserva actualizada con éxito");
                JOptionPane.showMessageDialog(null, "Reserva actualizada con éxito");
            } else {
                System.out.println("Error al actualizar la reserva");
            }
        }else{
            String sql = "UPDATE reserva SET idReserva = ?, numero_mesa = ?, dni_cliente = ?, apellido = ?, fecha = ?, hora_desde = ?, hora_hasta = ?, vigencia = ?, estado = ? WHERE idReserva = ?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, r.getIdReserva());
            s.setInt(2, r.getMesa().getNumeroMesa());
            s.setString(3, r.getDni_cliente());
            s.setString(4, r.getApellido());
            s.setDate(5, java.sql.Date.valueOf(r.getFecha()));
            s.setTime(6, java.sql.Time.valueOf(r.getHora_desde()));
            s.setTime(7, java.sql.Time.valueOf(r.getHora_hasta()));
            s.setString(8, r.getVigencia());
            s.setBoolean(9, (r.getVigencia().equals("vigencia")));
            s.setInt(10, id);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Reserva actualizada con éxito");
                JOptionPane.showMessageDialog(null, "Reserva actualizada con éxito");
            } else {
                System.out.println("Error al actualizar la reserva");
            }
        }
    }

    public void cambiarVigencia(String vigencia, int id) throws SQLException {
        String sql = "UPDATE reserva SET vigencia = ?, estado = ? WHERE idReserva = ?";

        PreparedStatement s = con.prepareStatement(sql);
        s.setString(1, vigencia);
        s.setBoolean(2, (vigencia.equals("vigencia")));
        s.setInt(3, id);
        
        int filas = s.executeUpdate();
        if (filas > 0) {
            System.out.println("Reserva actualizada con éxito");
            JOptionPane.showMessageDialog(null, "Reserva actualizada con éxito");
        } else {
            System.out.println("Error al actualizar la reserva");
        }
    }
    
    public ArrayList<Reserva> listarReservas() throws SQLException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Reserva reserva = new Reserva(rs.getInt("idReserva"),
                                          mesaData.buscar(rs.getInt("numero_mesa")),
                                          rs.getString("dni_cliente"),
                                          rs.getString("apellido"),
                                           rs.getDate("fecha").toLocalDate(),
                                            rs.getTime("hora_desde").toLocalTime(),
                                            rs.getTime("hora_hasta").toLocalTime(),
                                          rs.getString("vigencia"),
                                          rs.getBoolean("estado"));
            reservas.add(reserva);
        }
        return reservas;
    }

    public ArrayList<Reserva> listarReservasActivas() throws SQLException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reserva WHERE estado = 1";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Reserva reserva = new Reserva(rs.getInt("idReserva"),
                                          mesaData.buscar(rs.getInt("numero_mesa")),
                                          rs.getString("dni_cliente"),
                                          rs.getString("apellido"),
                                            rs.getDate("fecha").toLocalDate(),
                                            rs.getTime("hora_desde").toLocalTime(),
                                            rs.getTime("hora_hasta").toLocalTime(),
                                          rs.getString("vigencia"),
                                          rs.getBoolean("estado"));
            reservas.add(reserva);
        }
        return reservas;
    }
    
    public boolean validarReservaConflicto(LocalDate fecha, LocalTime hora_desde, LocalTime hora_hasta, int numero, int idReserva) throws SQLException {
        boolean conflicto = false;
        
        String sql = "SELECT * FROM reserva WHERE idReserva != ? AND fecha = ? AND numero_mesa = ? AND ((hora_desde BETWEEN ? AND ?) OR (hora_hasta BETWEEN ? AND ?));";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idReserva);
        ps.setDate(2, java.sql.Date.valueOf(fecha));
        ps.setInt(3, numero);
        ps.setTime(4, java.sql.Time.valueOf(hora_desde));
        ps.setTime(5, java.sql.Time.valueOf(hora_hasta));
        ps.setTime(6, java.sql.Time.valueOf(hora_desde));
        ps.setTime(7, java.sql.Time.valueOf(hora_hasta));
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            conflicto = true;
        }
        
        return conflicto;
    }
    
    public ArrayList<Reserva> buscarReservasPorFechayHorayVigencia(LocalDate fecha, LocalTime hora, String vigencia) throws SQLException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM (SELECT *, FIELD(vigencia, 'vigente', 'no_vigente') AS vindex FROM reserva) AS subreserva WHERE 1=1");

        ArrayList<Object> parameters = new ArrayList<>();

        if (fecha != null) {
            sql.append(" AND fecha = ?");
            parameters.add(java.sql.Date.valueOf(fecha));
        }
        if (hora != null) {
            sql.append(" AND hora_desde = ?");
            parameters.add(hora);
        }
        if (vigencia != null && !"null".equals(vigencia)) {
            int vigencias = "no_vigente".equals(vigencia) ? 2 : 1;
            sql.append(" AND vindex = ?");
            parameters.add(vigencias);
        }

        PreparedStatement ps = con.prepareStatement(sql.toString());

        for (int i = 0; i < parameters.size(); i++) {
            ps.setObject(i + 1, parameters.get(i));
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Reserva reserva = new Reserva(
                rs.getInt("idReserva"),
                mesaData.buscar(rs.getInt("numero_mesa")),
                rs.getString("dni_cliente"),
                rs.getString("apellido"),
                rs.getDate("fecha").toLocalDate(),
                rs.getTime("hora_desde").toLocalTime(),
                rs.getTime("hora_hasta").toLocalTime(),
                rs.getString("vigencia"),
                rs.getBoolean("estado")
            );
            reservas.add(reserva);
        }
        return reservas;
    }
}
