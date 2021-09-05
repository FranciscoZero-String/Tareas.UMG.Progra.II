/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosing;

/**
 *
 * @author Zero
 */
public interface empleados {
    public void archivoingresar(String nombreArchivo);
    public void empleado(String nombreArchivo, String nombreEmpleado, Double enero, Double febrero, Double marzo);
    public void mayormenor(String nombreArchivo, int mes);
    public void mayorventa(String nombreArchivo);
    public void actualizard(String nombreArchivo, String nuevoDato, int registro, int columna);
    public void buscar(String nombreArchivo, Double cantidad);
    public void listaEmpleado(String nombreArchivo);
}
