/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.p1asb;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
/**
 *
 * @author Arana
 */
@Data
public class Empleado {
  private int codigo;
 @NotBlank
 private String nombre;
 @NotNull
 private double enero;
 @NotNull
 private double febrero;
 @NotNull
 private double marzo;
 @NotNull
 private double total;
 @NotNull
 private double promedio;
 
  /*public MdEmpleado(int codigo, String nombre, Double enero,Double febrero, Double marzo){
    this.nombre=nombre;
    this.enero=enero;
    this.febrero=febrero;
    this.marzo=marzo;
    this.total=enero+febrero+marzo;
    this.promedio=(enero+febrero+marzo)/3;
    }*/
  
}
