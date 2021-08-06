/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Comisiones;

import com.ventas.Clsvendedores;
import java.util.Scanner;

/**
 *
 * @author Zero
 */
public class ClsPares {
    
    
    private String [][] CalculoProrrafeo; 
private static final int dato1 =0; 
private static final int dato2 =1; 
private static final int dato3 =2; 
private static final int dato4 =3; 
private static final int dato5 =4;
private static final int dato6 =5; 
private static final int dato7 =6;
private int filaActual =0;

private final int MAX_FILAS =4;
private final int MAX_COLUMNAS =7;
private int totalFilas =0;
    
Scanner t = new Scanner(System.in);

public ClsPares (int filas){
    
    if (filas > MAX_FILAS)
    {
    throw (new IllegalArgumentException());
    }else{
     totalFilas = filas;
     CalculoProrrafeo = new String[totalFilas][MAX_COLUMNAS];
    }
}

public String AgregarDato (Clsvendedores vende){
 if (filaActual >= MAX_FILAS){
     return "Ya llegaste al final";
 }   else{
        CalculoProrrafeo[filaActual][dato1]=vende.getNombre1()+"";
        CalculoProrrafeo[filaActual][dato2]=vende.getNombre();
        CalculoProrrafeo[filaActual][dato3]=vende.getEnero()+"";
        CalculoProrrafeo[filaActual][dato4]=vende.getFebrero()+"";
        CalculoProrrafeo[filaActual][dato5]=vende.getMarzo()+"";
        filaActual = filaActual +1;
 }
 return "OK";
}

public void imprimedecorado (){
    for (int x = 0; x < CalculoProrrafeo.length; x++) {
            System.out.print("|");
            for (int y = 0; y < CalculoProrrafeo[x].length; y++) {
                System.out.print(CalculoProrrafeo[x][y]);
                if (y != CalculoProrrafeo[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
}
   
public double sumaColumnas (int columna){
    double total = 0;
    for(int y = 0; y<filaActual; y++){
        String col = CalculoProrrafeo[y][columna];
        total = total + Double.valueOf(col);
    }return total;  
}

public double sumaFila (int fila){
    double total = 0.0;
    for(int y = 2; y<5; y++){
        String fil = CalculoProrrafeo[fila][y];
        
        total =total + Double.valueOf(fil);
    double nn1 = Double.parseDouble(CalculoProrrafeo[fila][dato1]);
    
    
    CalculoProrrafeo[fila][dato6]=total+"";
    
    double n1 = Double.parseDouble(CalculoProrrafeo[fila][dato6]);
    
    CalculoProrrafeo[fila][dato7]=(nn1 * n1)+"";
    }
    
    return total;
}


}
    
    

