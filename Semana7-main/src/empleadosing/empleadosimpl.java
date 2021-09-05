/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosing;

import ingresard.AccesoDatosEx;
import ingresard.EscrituraDatosEx;
import ingresard.LecturaDatosEx;
import datosingresar.calcular;
import datosingresar.AccesoDatos;
import Inicio.MDEMPLEADOS;
import java.util.*;

/**
 *
 * @author Zero
 */
public class empleadosimpl implements empleados{

    private final AccesoDatos datos;
    private final String errordedato = "Error de acceso a datos";
    private final String erroralregistrar = "Error de lectura de datos";
    private final String erroringreso = "Error de escritura de datos";
    
    public empleadosimpl(){
        this.datos = new calcular();
    }
    
    @Override
    public void archivoingresar(String nombreArchivo) {
        try {
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println(errordedato);
            ex.printStackTrace();
        }
    }

    @Override
    public void empleado(String nombreArchivo, String nombreEmpleado, Double enero, Double febrero, Double marzo) {
        MDEMPLEADOS empleado = new MDEMPLEADOS(nombreEmpleado, enero, febrero, marzo);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);
            datos.escribir(empleado, nombreArchivo, anexar);
            System.out.println("registro terminado"
                    + "");
        } catch (AccesoDatosEx ex) {
            System.out.println(errordedato);
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void mayormenor(String nombreArchivo, int mes) {
        Double mayor = 0.0;
        Double menor = 999999999999.9;
        String nombreMayor = null;
        String nombreMenor = null;
        try {
            List<MDEMPLEADOS> empleados = datos.listar(nombreArchivo);
            for (MDEMPLEADOS empleado : empleados) {
                String[] empDatos = empleado.toString().split("\\|");
                if (Double.valueOf(empDatos[mes]) > mayor) {
                    mayor = Double.valueOf(empDatos[mes]);
                    nombreMayor = empDatos[0];
                }
                if (Double.valueOf(empDatos[mes]) < menor) {
                    menor = Double.valueOf(empDatos[mes]);
                    nombreMenor = empDatos[0];
                }
            }
            if (nombreMayor != null && nombreMenor != null) {
                System.out.println("Mayor vendedor: " + nombreMayor + " con " + mayor
                               + "\nMenor vendedor: " + nombreMenor + " con " + menor);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println(erroralregistrar);
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void mayorventa(String nombreArchivo) {
        Double mayor = 0.0;
        String resultado = null;
        try {
            List<MDEMPLEADOS> empleados = datos.listar(nombreArchivo);
            for(MDEMPLEADOS empleado : empleados) {
                if (empleado.getTotal() > mayor) {
                    resultado = empleado.getNombre() + " con " + empleado.getTotal();
                }
            }
            System.out.println("venta mayor " + resultado);
        } catch (AccesoDatosEx ex) {
            System.out.println(errordedato);
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void actualizard(String nombreArchivo, String datoingresado, int registro, int columna) {
        registro--;
        try {
            List<MDEMPLEADOS> empleados = datos.listar(nombreArchivo);
            String nombre = empleados.get(registro).getNombre();
            Double enero = empleados.get(registro).getEnero();
            Double febrero = empleados.get(registro).getFebrero();
            Double marzo = empleados.get(registro).getMarzo();
            switch (columna) {
                case 1:
                    nombre = datoingresado;
                    break;
                case 2:
                    enero = Double.valueOf(datoingresado);
                    break;
                case 3:
                    febrero = Double.valueOf(datoingresado);
                    break;
                case 4:
                    marzo = Double.valueOf(datoingresado);
                    break;
                default:
                    System.out.println("Columna no valida");
                    break;
            }
            MDEMPLEADOS empleado = new MDEMPLEADOS(nombre, enero, febrero, marzo);
            empleados.set(registro, empleado);
            boolean anexar = false;
            for (MDEMPLEADOS linea : empleados) {
                datos.escribir(linea, nombreArchivo, anexar);
                anexar = datos.existe(nombreArchivo);
            }  
        } catch (LecturaDatosEx ex) {
            System.out.println(erroralregistrar);
            ex.printStackTrace(System.out);
        } catch (EscrituraDatosEx ex) {
            System.out.println(erroringreso);
            ex.printStackTrace(System.out);
        } catch (AccesoDatosEx ex) {
            System.out.println(errordedato);
            ex.printStackTrace(System.out);
        } catch (NumberFormatException ex) {
            System.out.println("Error de formato");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscar(String nombreArchivo, Double cantidad) {
        String resultado = null;
        try {
            resultado = datos.buscar(nombreArchivo, cantidad);
        } catch (LecturaDatosEx ex) {
            System.out.println(erroralregistrar);
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado: " + resultado);
    }

    @Override
    public void listaEmpleado(String nombreArchivo) {
        try {
            List<MDEMPLEADOS> empleados = datos.listar(nombreArchivo);
            if (empleados.size() > 0) {
                empleados.forEach(empleado -> {
                    System.out.println(empleado);
                });
            } else {
                System.out.println("No exiten registros");
            }
        } catch (LecturaDatosEx ex) {
            System.out.println(errordedato);
            ex.printStackTrace(System.out);
        }
    }
}