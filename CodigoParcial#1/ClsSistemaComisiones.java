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
public class ClsSistemaComisiones {
    
    
    Scanner t = new Scanner (System.in);

private String [][] CacularProrrafeo; 
private static final int comenzar =0; 
private static final int Paso5 =1; 
private static final int Paso4 =2; 
private static final int comenzar1 =3; 
private static final int Calcular =4;
private int filaActual =0;

private final int MAX_FILAS =4;
private final int MAX_COLUMNAS =5;
private int totalFilas =0;

public ClsSistemaComisiones (int filas){
    
    if (filas > MAX_FILAS)
    {
    throw (new IllegalArgumentException());
    }else{
     totalFilas = filas;
     CacularProrrafeo = new String[totalFilas][MAX_COLUMNAS];
    }
}

public String AgregarVendedorMatriz (Clsvendedores vende){
 if (filaActual >= MAX_FILAS){
     return "Ya llegaste al final";
 }   else{
        CacularProrrafeo[filaActual][comenzar]=vende.getNombre();
        CacularProrrafeo[filaActual][Paso5]=vende.getEnero()+"";
        CacularProrrafeo[filaActual][Paso4]=vende.getFebrero()+"";
        filaActual = filaActual +1;
 }
 return "OK";
}

public void imprimirDecoradoAvanzado (){
    for (int x = 0; x < CacularProrrafeo.length; x++) {
            System.out.print("|");
            for (int y = 0; y < CacularProrrafeo[x].length; y++) {
                System.out.print(CacularProrrafeo[x][y]);
                if (y != CacularProrrafeo[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
}
    
public String MayorxMes(int columna){
    Double mayor = 0.0;
    String res = "";
    for(int y=0; y<filaActual; y++){
        String col =CacularProrrafeo[y][columna];
         
        if(Double.valueOf(col)>mayor){
         mayor =Double.valueOf(col);
         res = CacularProrrafeo[y][comenzar]+" tiene una venta de: "+mayor;
        }
    } return res;
}

public double sumaColumna (int columna){
    double total = 0;
    for(int y = 0; y<filaActual; y++){
        String col = CacularProrrafeo[y][columna];
        total = total + Double.valueOf(col);
    }return total;  
}

public double sumaFila (int fila){
    double total = 1;
    for(int y = 1; y<3; y++){
        String fil = CacularProrrafeo[fila][y];
        
        total =total * Double.valueOf(fil);
    }
    CacularProrrafeo[fila][comenzar1]=total+"";
    CacularProrrafeo[fila][Calcular]=(total/2)+"";
    return total;
}

public void partesP (){
    double Seguro = 3500;
    double Impuestos = 5000;
    double ComisionesBancarias = 200;
    double n = Seguro + Impuestos + ComisionesBancarias;
    System.out.println("Paso #2");
    System.out.println("Gastos que generan valor: Q. " +n);
    
    double a = (double)(n / sumaColumna(3));
    
    System.out.println("Paso #3");
    System.out.println("Valor total de los materiales: "+a);

    System.out.println("Paso #4");
    double pro1 =Double.parseDouble(CacularProrrafeo[0][Paso4]);
    double pro2 =Double.parseDouble(CacularProrrafeo[1][Paso4]);
    double pro3 =Double.parseDouble(CacularProrrafeo[2][Paso4]);
    double pro4 =Double.parseDouble(CacularProrrafeo[3][Paso4]);
    double result1 =  pro1 * a;
    System.out.println("Gastos al valor que genera cada producto 60: " + result1);    
    double result2 =  pro2 * a;
    System.out.println("Gastos al valor que genera cada producto 40: " + result2);
    double result3 =  pro3 * a;
    System.out.println("Gastos al valor que genera cada producto 55: " + result3);
    double result4 =  pro4 * a;
    System.out.println("Gastos al valor que genera cada producto 350: " + result4);
    
    System.out.println("Paso #5"); 
    double Pesounidad  = Double.parseDouble(CacularProrrafeo[0][Paso5]);
    double Pesounidad1 = Double.parseDouble(CacularProrrafeo[1][Paso5]);
    double Pesounidad2 = Double.parseDouble(CacularProrrafeo[2][Paso5]);
    double Pesounidad3 = Double.parseDouble(CacularProrrafeo[3][Paso5]);
    
    double peso  = 50 *Pesounidad;
    double peso1 = 20 *Pesounidad1;
    double peso2 = 10 *Pesounidad2;
    double peso3 = 50 *Pesounidad3;
    
    System.out.println("Peso total de mercaderia 50kgs: " + peso);
    System.out.println("Peso total de mercaderia 20kgs: " + peso1);
    System.out.println("Peso total de mercaderia 10kgs: " + peso2);
    System.out.println("Peso total de mercaderia 50kgs: " + peso3);
    
    double total = peso + peso1 + peso2 + peso3;
    System.out.println("Peso total en KG: " + total);      
    
    System.out.println("Paso #6");
    double fletes =2500;
    double acarreo =5000;
    
    double totalPeso = fletes + acarreo;
    System.out.println("total gastado por peso: Q."+ totalPeso);
    System.out.println("Paso #7");
    double PesoT = totalPeso/total;
    System.out.println("Coeficiente de gasto por peso: " + PesoT);
    
    double Pesototal  = 50 * PesoT;
    double Pesototal1 = 20 * PesoT;
    double Pesototal2 = 10 * PesoT;
    double Pesototal3 = 50 * PesoT;
    System.out.println("Paso #8");
    System.out.println("Gasto: 50 klg por coeficiente de gasto: Q. "+ Pesototal);
    System.out.println("Gasto: 20 klg por coeficiente de gasto: Q. "+ Pesototal1);
    System.out.println("Gasto: 10 klg por coeficiente de gasto: Q. "+ Pesototal2);
    System.out.println("Gasto: 50 klg por coeficiente de gasto: Q. "+ Pesototal3);
    
    
    System.out.println("Paso #10");
    double comproFinal = sumaColumna(3) + n + totalPeso;
    System.out.println("GRAN TOTAL: Q." + comproFinal);
}

}

    
    

