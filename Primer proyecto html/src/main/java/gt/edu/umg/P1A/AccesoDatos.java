/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.p1asb;

import java.util.ArrayList;
import  java.util.List ;
/**
 *
 * @author Arana
 */
public class AccesoDatos {
    
private static List<Empleado> Todosempleados= new ArrayList<>();
      public static int contador=0;
      //devuelve la lista de todos los empleados
    public static List<Empleado> getEmpleados(){
    return Todosempleados;
    }
       //agrega datos a la lista de empleados
    public static void addEmpleados(Empleado empleado){
    contador++;
    empleado.setCodigo(contador);
    Todosempleados.add(empleado);
    }
    
    //cambia los valores de la lista de empleados
    public static void setEmpleados(List<Empleado> empleados) {
        Todosempleados = empleados;
    } 

}

