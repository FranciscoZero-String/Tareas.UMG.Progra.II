/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 *
 * @author Zero
 */
public class Tarea {
    public static void main(String[] args) throws IOException{
       BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
        
       Scanner lector1 = new Scanner(System.in);  
       
       
       int num1;
       double resultado;
       
       final double dolar = (double) 0.13;
       final double euros = (double) 0.11;
       final double yuanes = (double) 0.84;
        
       System.out.println("Ingrese nombre: ");
       String nombre = lector.readLine();
       System.out.println("Ingrese su sueldo: ");
       num1 = Integer.parseInt(lector.readLine());       
        
       System.out.println(" Elija una opcion para convertir su la moneda:");
       System.out.println("1. Dolares.");
       System.out.println("2. Euros.");
       System.out.println("3. Yuanes.");
        
       int opciones = lector1.nextInt();
       
       
       switch (opciones){
            
            case 1:
                resultado = (num1*dolar);
        
                System.out.println("El resultado es"+resultado);
                break;
                
            case 2:
                resultado = (num1*euros);
        
                System.out.println("El resultado es"+resultado);
                break;
                
            case 3:
                resultado = (num1*yuanes);
        
                System.out.println("El resultado es"+resultado);
                break;
       }
       
    }

}
