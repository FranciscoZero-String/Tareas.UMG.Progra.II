/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.p1asb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Arana
 */
@Controller
public class ControladorInicio {
     CatalogoEmpleados catalogo= new CatalogoEmpleados();
    
            
        @GetMapping("/")
        public String iniciar(Model model) {//la funcion model es para mandar info a la parte visual
        String msg = "Desde el controlador...";
     
        return "index";
    }
    
    
     @GetMapping("/lista")
      public String listar(Model model) {
          model.addAttribute("empleados", AccesoDatos.getEmpleados());
   
        return "lista";
    }
      
          @GetMapping("/Agregar")
      public String Agregar() {
       return "Agregar";
      } 
      
      
      @GetMapping("/Editar")
      public String Editar(Model model,@ModelAttribute Empleado empleado) {
       model.addAttribute("empleados", AccesoDatos.getEmpleados());
       return "Editar";
      } 
      
       @GetMapping("/Eliminar")
      public String Eliminar(Model model) {
          model.addAttribute("empleados", AccesoDatos.getEmpleados());
       return "Eliminar";
      } 
       @GetMapping("/BuscaPorCantidad")
      public String BuscaPorCantidad() {
       return "BuscaPorCantidad";
      } 
      
     @GetMapping("/Mayor3meses")
      public String Mayor3meses(Model model) {
       String msg = catalogo.vendioMas3Meses();
       if (msg==null){
      msg="NO HAY VENDEDORES";
       }
        model.addAttribute("msg", msg);
       return "Mayor3meses";
      }
      
      @GetMapping("/MayorMenorMes")
      public String MayorMenorMes() {
       return "MayorMenorMes";
      }
}
