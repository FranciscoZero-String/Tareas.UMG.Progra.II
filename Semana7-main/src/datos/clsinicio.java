/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import empleadosing.empleados;
import empleadosing.empleadosimpl;
import java.util.*;

/**
 *
 * @author Zero
 */
public class clsinicio {
    private static final Scanner scanner = new Scanner(System.in);
    private static int a = -1;
    private static final String nombrearchivo = "c:\\tmp\\Empleados.txt";
    private static final empleados emple = new empleadosimpl();
    
    /**
     * @param args the commando line arguments
     */
    public static void main(String[] args) {
        while (a != 0) {
            try {
                System.out.println("opciones"
                        + "1. Agregar empleado"
                        + "2. Mayor y menor de las ventas por mes"
                        + "3. Venta mayor"
                        + "4. edite dato "
                        + "5. Buscar en la lista agregada"
                        + "6. Info"
                        + "7. Salir");
                
                a = Integer.parseInt(scanner.nextLine());
                switch (a) {
                    case 1:
                        emple.archivoingresar(nombrearchivo);
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese enero: ");
                        Double enero = scanner.nextDouble();
                        System.out.println("Ingrese febrero: ");
                        Double febrero = scanner.nextDouble();
                        System.out.println("Ingrese marzo: ");
                        Double marzo = scanner.nextDouble();
                        emple.empleado(nombrearchivo, nombre, enero, febrero, marzo);
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Ingrese el mes: "
                                + "\n<1>Enero <2>Febrero <3>Marzo");
                        int mes = Integer.parseInt(scanner.nextLine());
                        emple.mayormenor(nombrearchivo, mes);
                        break;
                    case 4:
                        emple.mayorventa(nombrearchivo);
                        break;
                    case 5:
                        System.out.println("Ingrese el registro que desea verificar: ");
                        int registro = Integer.parseInt(scanner.nextLine());
                        System.out.println("Elija el dato que desea editar: "
                                + "\n<1>Nombre <2>Enero <3>Febrero <4>Marzo");
                        int columna = Integer.parseInt(scanner.nextLine());
                        System.out.println("Ingrese dato: ");
                        String nuevoDato = scanner.nextLine();
                        emple.actualizard(nombrearchivo, nuevoDato, registro, columna);
                        break;
                    case 6:
                        System.out.println("Ingrese cantidad: ");
                        Double cantidad = scanner.nextDouble();
                        scanner.nextLine();
                        emple.buscar(nombrearchivo, cantidad);
                        break;
                    case 7:
                        emple.listaEmpleado(nombrearchivo);
                        break;
                    case 0:
                        System.out.println("ADIOS!!!");
                        break;
                    default:
                        System.out.println("¡ERROR!");
                        break;
                }
                System.out.println("\n");
            } catch (Exception ex) {
                System.out.println("Error\n");
            }
        }
    }
}
