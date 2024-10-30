
package Modelo;

import java.sql.*;

public class Conexion {
    private static String URL = "jdbc:mysql://localhost/";
    private static String BD = "gp2_restaurant_entrega2";
    private static String USUARIO = "root";
    private static String PASSWORD = "";
    
    public static Connection conexion = null;
    
    public static Connection cargaConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion=DriverManager.getConnection(URL+BD,USUARIO,PASSWORD);
            }catch(SQLException|ClassNotFoundException e) {
                System.err.println("No se cargo la base de datos, (puede que no tenga el XAMPP abierto)");
            }
        }
        return conexion;
    }
}
