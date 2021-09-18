
package CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ClsConexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/dbcomisiones?";
    private static final String USERNAME = "root";
    private static final String CONTRASEÑA = "fabl";
    
    public static Connection getConnection() {
        Connection con = null;
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL,USERNAME,CONTRASEÑA);
            JOptionPane.showMessageDialog(null, "LA CONEXION FUE EXITOSA");
        }
        catch (Exception a){
            System.out.println(a);
                   
        }
        return con;
                
     }
    
}
