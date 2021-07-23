/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptacionascii;

import javax.swing.JOptionPane;

/**
 *
 * @author Zero
 */
public class Encriptacion {
    
    public static void main(String[] args) 
    
    {
        
        String mensaje;
        String mensajeencriptado;
        String mensajedesemcriptado;
        char  array[];
        
        mensaje = JOptionPane.showInputDialog("Ingrese su mensaje a encriptar");
        
        array=mensaje.toCharArray();
        
        for (int i = 0; i < array.length; i++) 
        { 
             array[i]=(char)(array[i]+(char)6+(char)3);
             
        }
        mensajeencriptado = String.valueOf(array);
        System.out.println(mensaje);
        System.out.println(mensajeencriptado);
        
        for (int i = 0; i < array.length; i++) 
        {
            array[i]=(char)(array[i]-(char)6-(char)3);
            
            mensajedesemcriptado = String.valueOf(array);
            System.out.println(mensajedesemcriptado);
        }
    }
    
}
