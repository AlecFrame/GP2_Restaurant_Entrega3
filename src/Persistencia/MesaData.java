
package Persistencia;

import Modelo.Conexion;
import Modelo.Mesa;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MesaData {
    private Connection con = Conexion.cargaConexion();

    public MesaData() {}
    
    public void guardarMesa(Mesa m) throws SQLException {
        if (m.getNumeroMesa()==0) {
            String sql = "Insert into mesa(capacidad,ocupada,dni_mesero,estado) values(?,?,?,?);";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, m.getCapacidad());
            s.setString(2, m.getOcupada());
            if (m.getMesero()==null) {
                s.setNull(3, java.sql.Types.VARCHAR);
            }else
                s.setString(3, String.valueOf(m.getMesero().getDniMesero()));
            s.setBoolean(4, m.isEstado());

            int filas = s.executeUpdate();
            if (filas>0) {
                System.out.println("Mesa registrada con éxito");
            }
        }else{
            String sql = "Insert into mesa(numero_mesa,capacidad,ocupada,dni_mesero,estado) values(?,?,?,?,?);";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, m.getNumeroMesa());
            s.setInt(2, m.getCapacidad());
            s.setString(3, m.getOcupada());
            if (m.getMesero()==null) {
                s.setNull(4, java.sql.Types.VARCHAR);
            }else
                s.setString(4, String.valueOf(m.getMesero().getDniMesero()));
            s.setBoolean(5, m.isEstado());

            int filas = s.executeUpdate();
            if (filas>0) {
                System.out.println("Mesa registrada con éxito");
            }
        }
    }
    
    public void eliminarMesa(int numero) throws SQLException {
        String sql = "delete from mesa where numero_mesa = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, numero);
        
        int filas = s.executeUpdate();
        if (filas>0) {
            System.out.println("La mesa "+numero+" fue eliminada");
        }
    }
    
    public Mesa buscar(int numero) throws SQLException {
        MeseroData mdata = new MeseroData();
        Mesa mesa = null;
        String sql = "Select * From mesa Where numero_mesa = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, numero);
        
        ResultSet r = s.executeQuery();
        
        while (r.next()) {
            mesa = new Mesa(r.getInt("numero_mesa"),
                    r.getInt("capacidad"),
                    r.getBoolean("estado"),
                    r.getString("ocupada"),
                    mdata.buscar(r.getString("dni_mesero")));
        }
        
        return mesa;
    }
    
    public void CambiarEstado(Boolean estado, int numero) throws SQLException {
        String sql = "Update mesa set estado = ? where numero_mesa = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setBoolean(1, estado);
        s.setInt(2, numero);
        
        int filas = s.executeUpdate();
        if (filas>0) {
            System.out.println("Mesa "+numero+" fue actualizada a "+estado);
        }
    }
    
    public void CambiarCondicion(String ocupada, int numero) throws SQLException {
        String sql = "Update mesa set ocupada = ? where numero_mesa = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setString(1, ocupada);
        s.setInt(2, numero);
        
        int filas = s.executeUpdate();
        if (filas>0) {
            System.out.println("Mesa "+numero+" fue actualizada a "+ocupada);
        }
    }
    
    public void Actualizar(Mesa m, int numero) throws SQLException {
        if (m.getNumeroMesa()==0){
            String sql = "UPDATE mesa SET capacidad=?, ocupada=?, dni_mesero=?, estado=? WHERE numero_mesa=?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, m.getCapacidad());
            s.setString(2, m.getOcupada());
            if (m.getMesero()==null) {
                s.setNull(3, java.sql.Types.VARCHAR);
            }else
                s.setString(3, String.valueOf(m.getMesero().getDniMesero()));
            s.setBoolean(4, m.isEstado());
            s.setInt(5, numero);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Mesa actualizada con éxito");
                JOptionPane.showMessageDialog(null, "Mesa actualizada con éxito");
            } else {
                System.out.println("Error al actualizar la reserva");
            }
        }else{
            String sql = "UPDATE mesa SET numero_mesa=?, capacidad=?, ocupada=?, dni_mesero=?, estado=? WHERE numero_mesa=?";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, m.getNumeroMesa());
            s.setInt(2,  m.getCapacidad());
            s.setString(3, m.getOcupada());
            if (m.getMesero()==null) {
                s.setNull(4, java.sql.Types.VARCHAR);
            }else
                s.setString(4, String.valueOf(m.getMesero().getDniMesero()));
            s.setBoolean(5, m.isEstado());
            s.setInt(6, numero);

            int filas = s.executeUpdate();
            if (filas > 0) {
                System.out.println("Mesa actualizada con éxito");
                JOptionPane.showMessageDialog(null, "Mesa actualizada con éxito");
            } else {
                System.out.println("Error al actualizar la reserva");
            }
        }
    }
    
    public ArrayList<Mesa> filtrarMesasOcupacion(String filtro) throws SQLException {
        MeseroData mdata = new MeseroData();
        ArrayList<Mesa> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM mesa WHERE ocupada = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setString(1, filtro);
        ResultSet r = s.executeQuery();
        
        while (r.next()) {
            lista.add(new Mesa(r.getInt("numero_mesa"),
                    r.getInt("capacidad"),
                    r.getBoolean("estado"),
                    r.getString("ocupada"),
                    mdata.buscar(r.getString("dni_mesero"))));
        }
        
        return lista;
    }
    
    public ArrayList<Mesa> filtrarMesasCapacidad(int filtro) throws SQLException {
        MeseroData mdata = new MeseroData();
        ArrayList<Mesa> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM mesa WHERE capacidad = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, filtro);
        ResultSet r = s.executeQuery();
        
        while (r.next()) {
            lista.add(new Mesa(r.getInt("numero_mesa"),
                    r.getInt("capacidad"),
                    r.getBoolean("estado"),
                    r.getString("ocupada"),
                    mdata.buscar(r.getString("dni_mesero"))));
        }
        
        return lista;
    }
    
    public ArrayList<Mesa> listarMesas() throws SQLException {
        MeseroData mdata = new MeseroData();
        ArrayList<Mesa> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM mesa";
        
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery(sql);
        
        while (r.next()) {
            lista.add(new Mesa(r.getInt("numero_mesa"),
                    r.getInt("capacidad"),
                    r.getBoolean("estado"),
                    r.getString("ocupada"),
                    mdata.buscar(r.getString("dni_mesero"))));
        }
        
        return lista;
    }
    
    public ArrayList<Mesa> filtrarCondicionNumeroMesero(String condicion, String filtro, int numero) throws SQLException { 
        ArrayList<Mesa> lista = new ArrayList<>();
        MeseroData mdata = new MeseroData();
        StringBuilder sql = new StringBuilder("SELECT * FROM mesa WHERE 1=1");

        ArrayList<Object> parameters = new ArrayList<>();
        
        if (!condicion.equals("")&!condicion.equals("todas")) {
            sql.append(" AND ocupada = ?");
            parameters.add(condicion);
        }
        
        if (filtro.equals("numero")&numero>0) {
            sql.append(" AND numero_mesa = ?");
            parameters.add(numero);
        }
        
        if (filtro.equals("capacidad")&numero>0) {
            sql.append(" AND capacidad = ?");
            parameters.add(numero);
        }

        if (filtro.equals("dni")&numero>0) {
            sql.append(" AND dni_mesero = ?");
            parameters.add(numero);
        }
        
        PreparedStatement ps = con.prepareStatement(sql.toString());

        for (int i = 0; i < parameters.size(); i++) {
            ps.setObject(i + 1, parameters.get(i));
        }
        
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            lista.add(new Mesa(rs.getInt("numero_mesa"),
                    rs.getInt("capacidad"),
                    rs.getBoolean("estado"),
                    rs.getString("ocupada"),
                    mdata.buscar(rs.getString("dni_mesero")))
            );
        }
        return lista;
    }
}
