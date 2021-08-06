/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventas;

import com.Comisiones.ClsPares;
import com.Comisiones.ClsSistemaComisiones;
import java.util.Scanner;

/**
 *
 * @author Zero
 */
public class ClsPrincipal {
    
    
    public static void temporal(){
        
        Clsvendedores maria = new Clsvendedores();
        maria.llenaInformacion();
        System.out.println("maria.nombre1 = " + maria.getNombre());
        System.out.println("maria.enero = " + maria.getEnero());
        maria.setEnero(30);
        System.out.println("v.enero modificar"+ maria.getEnero());
         Clsvendedores juan = new Clsvendedores();
        juan.llenaInformacion();
        System.out.println("juan.nombre2 = " + juan.getNombre());
        System.out.println("juan.enero = " + juan.getEnero());
        
        System.out.println("Venta de juan y maria en enero = "+(juan.getEnero() + maria.getEnero()));
    }
    
    public static void main(String[] args){
        Scanner w = new Scanner(System.in);
         ClsSistemaComisiones co = new ClsSistemaComisiones(4);
         Clsvendedores vendedor = new Clsvendedores();
         ClsPares b = new ClsPares(4);
         
         System.out.println("paso #9");
        
        vendedor.setNombre("CementoTol");
        vendedor.setEnero(50);
        vendedor.setFebrero(60);
        co.AgregarVendedorMatriz(vendedor);  
        System.out.println(" ");
        
        //2
        vendedor.setNombre("BolsasCal");
        vendedor.setEnero(150);
        vendedor.setFebrero(40);
        co.AgregarVendedorMatriz(vendedor);  
        System.out.println(" ");
        
        //3
        vendedor.setNombre("TuboPC");
        vendedor.setEnero(200);
        vendedor.setFebrero(55);
        co.AgregarVendedorMatriz(vendedor);  
        System.out.println(" ");
        
        //4
        vendedor.setNombre("QuintalesHierro");
        vendedor.setEnero(50);
        vendedor.setFebrero(350);
        co.AgregarVendedorMatriz(vendedor);  
        System.out.println(" ");

        co.imprimirDecoradoAvanzado();
        co.sumaFila(0);
        co.sumaFila(1);
        co.sumaFila(2);
        co.sumaFila(3);
        
        
        co.imprimirDecoradoAvanzado();
        
        System.out.println(" ");
        System.out.println("Paso #1");
        System.out.println("Sumatoria total Q. " + co.sumaColumna(3));
        co.partesP();
        System.out.println(" ");
          
          
       //n1
        vendedor.setNombre1(50);
        vendedor.setNombre("CementoTol");
        vendedor.setEnero(60);
        vendedor.setFebrero(13.92);
        vendedor.setMarzo(37.5);
        b.AgregarDato(vendedor);
        
        //n2
        vendedor.setNombre1(150);
        vendedor.setNombre("BolsasCal");
        vendedor.setEnero(40); 
        vendedor.setFebrero(9.28);
        vendedor.setMarzo(15);
        b.AgregarDato(vendedor);
        
        //n3
        vendedor.setNombre1(200);
        vendedor.setNombre("TuboPC");
        vendedor.setEnero(55);
        vendedor.setFebrero(12.76);
        vendedor.setMarzo(7.5);
        b.AgregarDato(vendedor);  
       
        
        //n4
        vendedor.setNombre1(50);
        vendedor.setNombre("QuintaleHierro");
        vendedor.setEnero(350);
        vendedor.setFebrero(81.2);
        vendedor.setMarzo(37.5);
        b.AgregarDato(vendedor);
      
       b.sumaFila(0);
       b.sumaFila(1);
       b.sumaFila(2);
       b.sumaFila(3);
       
        b.AgregarDato(vendedor);  
        System.out.println(" ");    
        b.imprimedecorado();
        System.out.println(" ");
        
        System.out.println("Sumatoria COSTO TOTAL. Q."+b.sumaColumnas(6));
    
   
    }    
            
}
    
    

