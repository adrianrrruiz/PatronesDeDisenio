/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Proxy
 * Tipo de Clase: Java
 */
package servicios;

import java.sql.*;

/**
 *
 * @author Fabrizio Bolaño
 */
public class Seguridad {

    // URL de conexión a PostgreSQL en Supabase
    private static final String URL = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres";
    private static final String USER = "postgres.zgbdezzptkuhhyhiaynu";
    private static final String PASSWORD = "8A9jOBr5T7HftOVY";

    public boolean Autorizacion(String user,String password){
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT COUNT(*) FROM users WHERE usuario = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if(rs.next() && rs.getInt(1) > 0){
                System.out.println("Usuario " + user + " autorizado");
                return true;
            }else{
                System.out.println("Usuario " + user + " no autorizado");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }




    }
}