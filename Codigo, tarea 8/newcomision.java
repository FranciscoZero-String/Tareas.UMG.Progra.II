/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newmodelo;

import ClsComisiones.Mdpartes;
import java.util.*;

/**
 *
 * @author Zero
 */
public class newcomision {
    
   List<Mdpartes> Todos = new ArrayList<Mdpartes>();
   
    Mdpartes Ingresarinformacion(){
       
       Mdpartes vende = new Mdpartes();
        Scanner t = new Scanner(System.in);
        System.out.println("Ingrese el nombre");
        vende.nombre = t.nextLine();
        System.out.println("Ingrese el enero");
        vende.Enero = t.nextDouble();
        System.out.println("Ingrese el febrero");
        vende.Febrero = t.nextDouble();
        System.out.println("Ingrese el marzo");
        vende.Marzo = t.nextDouble();
        
         vende.total=vende.Enero+vende.Febrero+vende.Marzo;
         vende.promedio=vende.total/3;
        
       
       Todos.add(vende);
        return vende;
        
    
   }
    
    private void imprimirD(){
        
        for(Mdpartes ele: Todos){
            System.out.println("Nombre="+ele.nombre);
            System.out.println("Enero="+ele.Enero);
            System.out.println("Febrero ="+ele.Febrero);
            System.out.println("Marzo="+ele.Marzo);
            
            
        
            
        }
    }    
        
    public static void ConsultaVmes(){
     
         String mes;
        do{
            System.out.println("CONSULTAS");
            System.out.println("1 - Enero");
            System.out.println("2 - Febrero");
            System.out.println("3 - Marzo");
            System.out.println("4 - De los 3 meses");
            System.out.println("5 - Regresar al menu anterior");
            
            System.out.println("Selecciona una opción: ");
            mes= t.nextLine();
            
            switch(mes){
                case "1": 
                    Collections.sort(Todos, new enero());
                    System.out.println("vendedor menos: ");
                    imprimirF(Todos.get(0));
                    System.out.println("vendedor mas: ");
                    imprimirF(Todos.get(todos.size()-1));
                    break;
                case "2": 
                    Collections.sort(Todos, new febrero());
                    System.out.println("vendedor menos: ");
                    imprimirF(Todos.get(0));
                    System.out.println("vendedor mas: ");
                    imprimirF(Todos.get(todos.size()-1));
                    break;
                case "3": 
                    Collections.sort(Todos, new marzo());
                    System.out.println("vendedor menos: ");
                    imprimirF(Todos.get(0));
                    System.out.println("vendedor mas: ");
                    imprimirF(Todos.get(Todos.size()-1));
                    break;
                case "4": 
                    Collections.sort(Todos, new total());
                    System.out.println("vendedor menos: ");
                    imprimirF(Todos.get(0));
                    System.out.println("vendedor mas: ");
                    imprimirF(Todos.get(Todos.size()-1));
                    break;
                case "5": 
                    break; 
            }
            S
        }while(!mes.equals("5"));
    }
    private void BuscarC(){
        System.out.println("Ingresa la cantidad a buscar: ");
        String cantidad = t.nextLine();
        for(Mdpartes a: Todos){
            if(a.Enero.equals(cantidad) && a.Febrero.equals(cantidad) && a.Marzo.equals(cantidad)){
                imprimirF(a);
            }else{
                
            }
        }
    }        
          
    
        private void imprimirF(Mdpartes vende){
        System.out.println(vende.nombre+"  "+vende.Enero+"  "+vende.Febrero+"  "+vende.Marzo+"  "+vende.total+"  "+vende.promedio);
    }

class enero implements Comparator<Mdpartes>{

    public int compare(Mdpartes a, Mdpartes b)
    {
        return a.Enero.compareTo(b.Enero);
    }
}
class febrero implements Comparator<Mdpartes>{

    public int compare(Mdpartes a, Mdpartes b)
    {
        return a.Febrero.compareTo(b.Febrero);
    }
}
class marzo implements Comparator<Mdpartes>{

    public int compare(Mdpartes a, Mdpartes b)
    {
        return a.Marzo.compareTo(b.Marzo);
    }
}
class total implements Comparator<Mdpartes>{

    public int compare(Mdpartes a, Mdpartes b)
    {
        return a.total.compareTo(b.total);
    }
}
class promedio implements Comparator<Mdpartes>{

    public int compare(Mdpartes a, Mdpartes b)
    {
        return a.promedio.compareTo(b.promedio);
    }
}
            
            
        
    

    public void menu (){
            
            Scanner t = new Scanner(System.in);
        String opc = ""; 
        do{
            System.out.println("1- Ingreso de informacion");
            System.out.println("2-Ver informacion");
            System.out.println("3-Ver ventas por mes");
             System.out.println("4-Buscar");
            System.out.println("3-Orales!!! bay!!!");
           opc = t.nextLine();
            
            switch (opc){
                case "1": Ingresarinformacion();
                break;
                case "2": imprimirD();
                break;
                case "3": ConsultaVmes();
                break;
                case "4": BuscarC();
                break;
            }
                 
        } while (!opc.equals("4"));
    }
        }

}
