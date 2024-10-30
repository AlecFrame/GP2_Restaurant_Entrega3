
package Persistencia;

import Modelo.Conexion;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductosData {
    private Connection con = Conexion.cargaConexion();

    public ProductosData() {}
    
    public void guardarProducto(Producto p) throws SQLException {
        if (p.getCodigo()==0) {
            String sql = "Insert into productos(nombre,precio,stock,categoria,estado) values(?,?,?,?,?);";
        
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, p.getNombre());
            s.setDouble(2, p.getPrecio());
            s.setInt(3, p.getStock());
            s.setString(4, p.getCategoria());
            s.setBoolean(5, p.isEstado());

            int filas = s.executeUpdate();
            if (filas>0) {
                System.out.println("El producto fue registrado con exito");
            }
        }else{
            String sql = "Insert into productos(codigo,nombre,precio,stock,categoria,estado) values(?,?,?,?,?,?);";

            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, p.getCodigo());
            s.setString(2, p.getNombre());
            s.setDouble(3, p.getPrecio());
            s.setInt(4, p.getStock());
            s.setString(5, p.getCategoria());
            s.setBoolean(6, p.isEstado());

            int filas = s.executeUpdate();
            if (filas>0) {
                System.out.println("El producto fue registrado con exito");
            }
        }
    }
    
    public void eliminarProducto(int numero) throws SQLException {
        String sql = "delete from productos where codigo = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, numero);
        
        int filas = s.executeUpdate();
        if (filas>0) {
            System.out.println("El producto "+numero+" fue eliminado");
        }
    }
    
    public Producto buscar(int numero) throws SQLException {
        Producto producto = null;
        String sql = "Select * From productos Where codigo = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setInt(1, numero);
        
        ResultSet r = s.executeQuery();
        
        while (r.next()) {
            producto = new Producto(
                    numero,r.getString("nombre"),
                    r.getDouble("precio"),
                    r.getBoolean("estado"),
                    r.getInt("stock"),
                    r.getString("categoria"));
        }
        
        return producto;
    }
    
    public ArrayList<Producto> buscarPorNombre(String nombre) throws SQLException {
        ArrayList<Producto> lista = new ArrayList<>();
        String sql = "Select * From productos Where nombre LIKE CONCAT(\"%\",?,\"%\")";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setString(1, nombre);
        ResultSet r = s.executeQuery();
        
        while (r.next()) {
            lista.add(new Producto(
                    r.getInt("codigo"),r.getString("nombre"),
                    r.getDouble("precio"),
                    r.getBoolean("estado"),
                    r.getInt("stock"),
                    r.getString("categoria")));
        }
        
        return lista;
    }
    
    public void CambiarEstado(boolean estado, int numero) throws SQLException {
        String sql = "Update productos set estado = ? where codigo = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setBoolean(1, estado);
        s.setInt(2, numero);
        
        int filas = s.executeUpdate();
        if (filas>0) {
            String palabra = (estado)? "habilitado":"inhabilitado";
            System.out.println("\nEl estado de producto "+numero+" fue actualizado a "+palabra+"\n");
        }
    }
    
    public ArrayList<Producto> filtrarCategoria(String filtro) throws SQLException {
        ArrayList<Producto> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM productos WHERE categoria = ?";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setString(1, filtro);
        ResultSet r = s.executeQuery();
        
        while (r.next()) {
            lista.add(new Producto(
                    r.getInt("codigo"),r.getString("nombre"),
                    r.getDouble("precio"),
                    r.getBoolean("estado"),
                    r.getInt("stock"),
                    r.getString("categoria")));
        }
        
        return lista;
    }
    
    public ArrayList<Producto> filtrarCategoriaYNombre(String filtro,String nombre) throws SQLException {
        ArrayList<Producto> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM productos WHERE categoria = ? AND nombre LIKE CONCAT(\"%\",?,\"%\")";
        
        PreparedStatement s = con.prepareStatement(sql);
        s.setString(1, filtro);
        s.setString(2,nombre);
        ResultSet r = s.executeQuery();
        
        while (r.next()) {
            lista.add(new Producto(
                    r.getInt("codigo"),
                    r.getString("nombre"),
                    r.getDouble("precio"),
                    r.getBoolean("estado"),
                    r.getInt("stock"),
                    r.getString("categoria")));
        }
        
        return lista;
    }
    
    public ArrayList<Producto> listar() throws SQLException {
        ArrayList<Producto> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM productos ORDER BY codigo";
        
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery(sql);
        
        while (r.next()) {
            lista.add(new Producto(
                    r.getInt("codigo"),r.getString("nombre"),
                    r.getDouble("precio"),
                    r.getBoolean("estado"),
                    r.getInt("stock"),
                    r.getString("categoria")));
        }
        
        return lista;
    }
    
    public void actualizar(Producto p,String cambiar) {
        try {
            int filas=0;
            if (cambiar.contains("nombre")) {
                if (p.getNombre()!=null) {
                    String sql = "update productos set nombre=? where codigo=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, p.getNombre());
                    st.setInt(2, p.getCodigo());

                    filas = st.executeUpdate();
                }else
                    System.err.println("No se actualizo el nombre del producto ("+p.getCodigo()+") porque es nulo");
            }
            if (cambiar.contains("precio")) {
                if (p.getPrecio()!=0) {
                    String sql = "update productos set precio=? where codigo=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setDouble(1, p.getPrecio());
                    st.setInt(2, p.getCodigo());

                    filas = st.executeUpdate();
                }else
                    System.err.println("No se actualizo el precio del producto ("+p.getCodigo()+") porque es 0");
            }
            if (cambiar.contains("stock")) {
                if (p.getStock()!=0) {
                    String sql = "update productos set stock=? where codigo=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, p.getStock());
                    st.setInt(2, p.getCodigo());

                    filas = st.executeUpdate();
                }else
                    System.err.println("No se actualizo el stock del producto ("+p.getCodigo()+") porque es 0");
            }
            if (cambiar.contains("categoria")) {
                if (p.getCategoria()!=null) {
                    String sql = "update productos set categoria=? where codigo=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, p.getCategoria());
                    st.setInt(2, p.getCodigo());

                    filas = st.executeUpdate();
                }else
                    System.err.println("No se actualizo la categoria del producto ("+p.getCodigo()+") porque es null");
            }
            if (cambiar.contains("estado")) {
                String sql = "update productos set estado=? where codigo=?";

                PreparedStatement st = con.prepareStatement(sql);
                st.setBoolean(1, p.isEstado());
                st.setInt(2, p.getCodigo());

                filas = st.executeUpdate();
            }
            if (filas>0) {
                System.out.println("\n//// Actualizado con exito");
            }else
                System.err.println("No se encontra el codigo del producto");
        }catch(SQLException e) {
            System.err.println("Error SQL");
        }
    }
    
    public void actualizar(Producto p,String cambiar, int codigo) {
        try {
            int filas=0;
            if (cambiar.contains("nombre")) {
                if (p.getNombre()!=null) {
                    String sql = "update productos set nombre=? where codigo=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, p.getNombre());
                    st.setInt(2, codigo);

                    filas = st.executeUpdate();
                }else
                    System.err.println("No se actualizo el nombre del producto ("+codigo+") porque es nulo");
            }
            if (cambiar.contains("precio")) {
                if (p.getPrecio()!=0) {
                    String sql = "update productos set precio=? where codigo=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setDouble(1, p.getPrecio());
                    st.setInt(2, codigo);

                    filas = st.executeUpdate();
                }else
                    System.err.println("No se actualizo el precio del producto ("+codigo+") porque es 0");
            }
            if (cambiar.contains("stock")) {
                if (p.getStock()!=0) {
                    String sql = "update productos set stock=? where codigo=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, p.getStock());
                    st.setInt(2, codigo);

                    filas = st.executeUpdate();
                }else
                    System.err.println("No se actualizo el stock del producto ("+codigo+") porque es 0");
            }
            if (cambiar.contains("categoria")) {
                if (p.getCategoria()!=null) {
                    String sql = "update productos set categoria=? where codigo=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, p.getCategoria());
                    st.setInt(2, codigo);

                    filas = st.executeUpdate();
                }else
                    System.err.println("No se actualizo la categoria del producto ("+codigo+") porque es null");
            }
            if (cambiar.contains("estado")) {
                String sql = "update productos set estado=? where codigo=?";

                PreparedStatement st = con.prepareStatement(sql);
                st.setBoolean(1, p.isEstado());
                st.setInt(2, codigo);

                filas = st.executeUpdate();
            }
            if (cambiar.contains("codigo")) {
                if (p.getStock()!=0) {
                    String sql = "update productos set codigo=? where codigo=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, p.getCodigo());
                    st.setInt(2, codigo);

                    filas = st.executeUpdate();
                }else
                    System.err.println("No se actualizo el stock del producto ("+codigo+") porque es 0");
            }
            if (filas>0) {
                System.out.println("\n//// Actualizado con exito");
            }else
                System.err.println("No se encontra el codigo del producto");
        }catch(SQLException e) {
            System.err.println("Error SQL");
        }
    }
}
