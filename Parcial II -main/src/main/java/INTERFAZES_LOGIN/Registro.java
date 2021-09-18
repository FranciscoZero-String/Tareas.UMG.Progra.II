
package INTERFAZES_LOGIN;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import USUARIO.Usuario;
import USUARIO.UsuarioJDBC;
import javax.swing.JOptionPane;

public class Registro implements Initializable {

    @FXML
    private TextField txtRegistrarUsuario;
    @FXML
    private PasswordField txtRegistrarContraseña;
    @FXML
    private PasswordField txtConfirmarContraseña;
    

   UsuarioJDBC modSql = new UsuarioJDBC();
        Usuario mod = new Usuario();
        
        
        String pass = new String (txtRegistrarContraseña.getText());
        String passCon = new String (txtConfirmarContraseña.getText());
        
        if(pass.equals(passCon)
        {
            String nuevoPass = hash.sha1(pass);
            
            mod.setUsername(txtRegistrarUsuario.getText());
            mod.setPassword(nuevoPass);          
            mod.setPassword(txtConfirmarContraseña.getText());
    
            
            
            if(modSql.registrar(mod))
            {
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
            } else 
            {
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
            }
        return null;
       
        } else
        {
            JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
        }

}
