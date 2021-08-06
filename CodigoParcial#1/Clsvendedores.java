/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas;

import java.util.Scanner;

/**
 *
 * @author Zero
 */
public class Clsvendedores {

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the enero
     */
    public double getEnero() {
        return enero;
    }

    /**
     * @param enero the enero to set
     */
    public void setEnero(double enero) {
        this.enero = enero;
    }

    /**
     * @return the febrero
     */
    public double getFebrero() {
        return febrero;
    }

    /**
     * @param febrero the febrero to set
     */
    public void setFebrero(double febrero) {
        this.febrero = febrero;
    }

    /**
     * @return the marzo
     */
    public double getMarzo() {
        return marzo;
    }

    /**
     * @param marzo the marzo to set
     */
    public void setMarzo(double marzo) {
        this.marzo = marzo;
    }
    
    private String nombre;
    private double enero;
    private double febrero;
    private double marzo;
    
    
    public void llenainformacion(){
        Scanner t = new Scanner (System.in);
        System.out.println("Ingrese nombre");
        setNombre(t.nextLine());
        System.out.println("Ingres enero");
        setEnero((double) Double.valueOf(t.nextLine()));
        System.out.println("Ingrese febrero");
        setFebrero(t.nextDouble());
        System.out.println("Ingrese marzo");
        setMarzo(t.nextDouble());
        
            
    }

    void llenaInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
