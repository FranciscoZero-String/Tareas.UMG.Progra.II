/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.p1asb;
import static  gt.edu.umg.p1asb.AccesoDatos.setEmpleados ;
import  java.util.HashSet ;
import  java.util.List ;
import  java.util.Objects ;
import  java.util.Set ;
import  org.springframework.web.bind.annotation.ModelAttribute ;
/**
 *
 * @author Arana
 */
public class CatalogoEmpleados {
     public void agregar(Empleado empleado){
    Double total,promedio;
    try {
    total=empleado.getEnero()+empleado.getFebrero()+empleado.getMarzo();
    promedio=Math.round((total/3)*100.0)/100.0;
    empleado.setTotal(total);
    empleado.setPromedio(promedio);
    AccesoDatos.addEmpleados(empleado);
    } catch (Exception ex) {
            System.out.println("Error de acceso a datos");

        }
    }

    public String editar2(int codigo, String nuevoNombre, double nuevoEnero, double nuevoFebrero, double nuevoMarzo) {
        String Respuesta = null;
        try {
            List<Empleado> emple = null;
            emple = AccesoDatos.getEmpleados();
            for (Empleado empleado : emple) {
                if (empleado.getCodigo() == codigo) {
                    empleado.setCodigo(codigo);
                    empleado.setNombre(nuevoNombre);
                    empleado.setEnero(nuevoEnero);
                    empleado.setFebrero(nuevoFebrero);
                    empleado.setMarzo(nuevoMarzo);
                    double total = empleado.getEnero() + empleado.getFebrero() + empleado.getMarzo();
                    empleado.setTotal(total);
                    empleado.setPromedio(Math.round((empleado.getTotal() / 3) * 100.0) / 100.0);
                    Respuesta = "DATO EDITADO CON EXITO";

                }
            }
            AccesoDatos.setEmpleados(emple);

        } catch (Exception ex) {
            System.out.println("Error de acceso a datos");

        }
      return Respuesta;
    }

    public String borrar(int codigo) {
        String Respuestas = null;
        try {
            List<Empleado> emple = null;
            emple = AccesoDatos.getEmpleados();
            for (Empleado empleado : emple) {
                if (Objects.equals(empleado.getCodigo(), codigo)) {
                    emple.remove(emple.indexOf(empleado));
                    Respuestas = "DATO ELIMINADO CON EXITO";
                    break;
            }
            }

        } catch (Exception ex) {
            System.out.println("Error de acceso a datos");

        }
        return Respuestas;
    }

    public String vendioMas3Meses() {
        String resultado = null, nom = null;
        double mayor = 0.0, num = 0.0;

        try {
            List<Empleado> emple = null;
            emple = AccesoDatos.getEmpleados();
            for (Empleado empleado : emple) {
                if (empleado.getTotal() > mayor) {
                    num = empleado.getTotal();
                    nom = empleado.getNombre();
                    mayor = num;
                }
                resultado = "La persona con mayor venta en tres meses es: " + nom + " y la venta en tres meses es: " + mayor;
            }
        } catch (Exception ex) {
            System.out.println("Error de acceso a datos");
        }
        return resultado;
    }

    public String buscarEmpleado(double cantidad) {
        String resultado = null;
        String mes = null;
        String resultadoFinal=null;
        try {
            List<Empleado> emple = null;
            emple = AccesoDatos.getEmpleados();
            for (Empleado empleado : emple) {
                if (Objects.equals(empleado.getEnero(), cantidad)) {
                    resultado = empleado.getNombre();
                    mes = "enero";
                    resultadoFinal = "Resultado Busqueda: " + resultado + " en el mes: " + mes;
                } else if (Objects.equals(empleado.getFebrero(), cantidad)) {
                    resultado = empleado.getNombre();
                    mes = "febrero";
                    resultadoFinal = "Resultado Busqueda: " + resultado + " en el mes: " + mes;
                } else if (Objects.equals(empleado.getMarzo(), cantidad)) {
                    resultado = empleado.getNombre();
                    mes = "marzo";
                    resultadoFinal = "Resultado Busqueda: " + resultado + " en el mes: " + mes;
                }else if (empleado.getEnero()!= cantidad || empleado.getFebrero()!= cantidad|| empleado.getMarzo()!= cantidad){
                resultadoFinal="DATO NO ENCONTRADO";
                }
            }
        } catch (Exception ex) {
            System.out.println("Error de acceso a datos");

        }
 
        return resultadoFinal;
    } 
}
