package Persistencia;
import Modelo.Conexion;
import Modelo.Mesero;
import java.sql.*;
import java.util.ArrayList;

public class MeseroData {
    private Connection con = Conexion.cargaConexion();
    
    public MeseroData() {}
    
    public void consistenciaDeDatosDNIMesero(String viejo_dni,String nuevo_dni) {
        try {
            if (!viejo_dni.equals(nuevo_dni)) {
                String sqlMesa = "UPDATE mesa SET dni_mesero = ? WHERE dni_mesero = ?;";
                try (PreparedStatement s = con.prepareStatement(sqlMesa)) {
                    s.setString(1, nuevo_dni);
                    s.setString(2, viejo_dni);
                    s.executeUpdate();
                }

                String sqlPedido = "UPDATE pedido SET dni_mesero = ? WHERE dni_mesero = ?;";
                try (PreparedStatement s = con.prepareStatement(sqlPedido)) {
                    s.setString(1, nuevo_dni);
                    s.setString(2, viejo_dni);
                    s.executeUpdate();
                }
            }
        } catch(SQLException e) {
            System.err.println("Error al cambiar las otras tablas: Pedido y Mesa");
        }
    }
    
    public ArrayList<Mesero> listarMeseros(boolean estado) throws SQLException {
        ArrayList<Mesero> lista = new ArrayList<>();

        String sql = "SELECT * FROM mesero";
        
        if (estado) {
            sql += " WHERE estado = true";
        }

        Statement s = con.createStatement();
        ResultSet r = s.executeQuery(sql);
        
        while (r.next()) {
            Mesero mesero = new Mesero();
            mesero.setDniMesero(r.getInt("dni_mesero"));
            mesero.setApellido(r.getString("apellido"));
            mesero.setNombre(r.getString("nombre"));
            mesero.setEstado(r.getBoolean("estado"));

            lista.add(mesero);
        }

        r.close();
        s.close();

        return lista;
    }

    public void guardar(Mesero mesero) throws SQLException {
        if (mesero.getDniMesero()!=0) {
            String sql = "INSERT INTO mesero(dni_mesero, apellido, nombre, estado) VALUES(?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(mesero.getDniMesero()));
            ps.setString(2, mesero.getApellido());
            ps.setString(3, mesero.getNombre());
            ps.setBoolean(4, mesero.isEstado());


            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Mesero registrado con éxito.");
            }
        }else {
            System.err.println("Falta ingresar un dni al mesero.");
        }
    }

    public void eliminar(String dni) throws SQLException {
        String sql = "DELETE FROM mesero WHERE dni_mesero = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        
        int filas = ps.executeUpdate();
        if (filas > 0) {
            System.out.println("Mesero con DNI " + dni + " fue eliminado.");
        }
    }

    public Mesero buscar(String dni) throws SQLException {
        Mesero mesero = null;
        String sql = "SELECT * FROM mesero WHERE dni_mesero = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            mesero = new Mesero(
                rs.getInt("dni_mesero"), 
                rs.getString("nombre"), 
                rs.getString("apellido"),
                rs.getBoolean("estado"));
        }
        
        return mesero;
    }

    public void actualizar(Mesero mesero, String viejo_dni) throws SQLException {
        if (mesero.getDniMesero()==0) {
            String sql = "UPDATE mesero SET apellido=?, nombre=?, estado=? WHERE dni_mesero=?";
        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mesero.getApellido());
            ps.setString(2, mesero.getNombre());
            ps.setBoolean(3, mesero.isEstado());
            ps.setInt(4, Integer.parseInt(viejo_dni));
            
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Mesero actualizado con éxito.");
            }
        }else {
            String sql = "UPDATE mesero SET dni_mesero=?, apellido=?, nombre=?, estado=? WHERE dni_mesero=?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(mesero.getDniMesero()));
            ps.setString(2, mesero.getApellido());
            ps.setString(3, mesero.getNombre());
            ps.setBoolean(4, mesero.isEstado());
            ps.setInt(5, Integer.parseInt(viejo_dni));
            
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Mesero actualizado con éxito.");
            }
        }
    }

    public ArrayList<Mesero> buscarPorDniOApellido(String criterio, boolean estado) throws SQLException {
        ArrayList<Mesero> lista = new ArrayList<>();
        String sql = "SELECT * FROM mesero WHERE (dni_mesero = ? OR apellido LIKE ?)";

        if (estado) {
            sql += " AND estado = true";
        }

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, criterio);
        ps.setString(2, "%" + criterio + "%"); 
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            lista.add(new Mesero(
                rs.getInt("dni_mesero"), 
                rs.getString("nombre"), 
                rs.getString("apellido"),
                rs.getBoolean("estado")));
        }

        return lista;
    }
    
    public void cambiarEstado(int dniMesero) throws SQLException {
        String sql = "UPDATE mesero SET estado=? WHERE dni_mesero=?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setBoolean(1, false);
        ps.setInt(2, dniMesero);
            
        int filas = ps.executeUpdate();
        if (filas > 0) {
            System.out.println("Mesero actualizado con éxito.");
        }
    }
}
