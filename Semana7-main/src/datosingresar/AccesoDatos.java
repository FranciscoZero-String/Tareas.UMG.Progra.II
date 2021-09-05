/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosingresar;

import ingresard.AccesoDatosEx;
import ingresard.EscrituraDatosEx;
import ingresard.LecturaDatosEx;
import Inicio.MDEMPLEADOS;
import java.util.*;

/**
 *
 * @author Zero
 */
public interface AccesoDatos {
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public List<MDEMPLEADOS> listar(String nombreArchivo) throws LecturaDatosEx;
    void escribir(MDEMPLEADOS empleado, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    public String buscar(String nombreArchivo, Double buscar) throws LecturaDatosEx;
    public void crear(String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo) throws AccesoDatosEx;
}
