/*
 * To change this license header, choose License Headers in Project Properties.  
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.andres.maven.Practica4Jenkins;

import java.util.Scanner;

/**
 *
 * @author andres huertas martin
 */
public class AplicacionCuentaBancaria {
    
    static CuentaBancaria cuenta;
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        String opcion="";
        boolean datosvalidos=false;
        try (Scanner entrada = new Scanner(System.in)) {
			String cantidad;
			
			while(datosvalidos==false){
			    
			//Introducimos los datos
			System.out.println("");
			System.out.print("Introduce el nombre del titular: ");
			String nombre=entrada.nextLine();
			System.out.print("Introduce la entidad: ");
			String entidad=entrada.nextLine();
			System.out.print("Introduce la oficina: ");
			String oficina=entrada.nextLine();
			System.out.print("Introduce los digitos de control: ");
			String digitosdecontrol=entrada.nextLine();
			System.out.print("Introduce el numero de cuenta: ");
			String numerodecuenta=entrada.nextLine();
			
			
			//Intentamos crear el objeto con los datos que nos han dado,sino son correctos lanza una excepcion
			try{ 
			   //0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR
			    cuenta=new CuentaBancaria(nombre,entidad,oficina,digitosdecontrol,numerodecuenta);
   
			  datosvalidos=true;
			    
			}catch(NumberFormatException e){ 
			    System.out.println(e);  
			}  
			catch(IllegalArgumentException e){ 
			    System.out.println(e);   
			}  
			}
			
			
			//Mientras no presionemos 0 ira saliendo un menu para ir haciendo operaciones
			do{
			  try{ 
			       System.out.println("");
			       System.out.println("");
			       System.out.println("BANCO A DISTANCIA,introduzca una opcion");  
			       System.out.println("-------------------------------------------");
			       System.out.println("1  -  Ver el n??mero de cuenta completo (CCC - C??digo Cuenta Cliente).");  
			       System.out.println("2  - Ver el titular de la cuenta.");  
			       System.out.println("3  -  Ver el c??digo de la entidad.");  
			       System.out.println("4  -  Ver el c??digo de la oficina.");  
			       System.out.println("5  -  Ver el n??mero de la cuenta (solamente el n??mero de cuenta, sin entidad, oficina ni d??gitos de control).");  
			       System.out.println("6  -  Ver los d??gitos de control de la cuenta.");  
			       System.out.println("7  -   Realizar un ingreso. Habr?? que solicitar por teclado la cantidad que se desea ingresar.");  
			       System.out.println("8  -  Retirar efectivo. Habr?? que solicitar por teclado la cantidad que se desea retirar.");  
			       System.out.println("9  -  Consultar saldo.");  
			       System.out.println("0  - Salir de la aplicaci??n");  
			       
			       opcion=entrada.nextLine();
			       System.out.println("");
			       System.out.println("------RESULTADO DE LA OPERACION-----"); 
			       
			       //COn el switch elegimos la accion correspondiente que hemos elegido en pantalla
			       switch(opcion){
			       
			           case "0":
			               break;
			           case "1":
			               System.out.println(cuenta.getEntidad()+" "+cuenta.getOficina()+" "+cuenta.getDigitosdecontrol()+" "+cuenta.getNumerodecuenta());
			               break;
			               
			           case "2":
			               System.out.println(cuenta.getTitular());
			               break;
			               
			           case "3":
			               System.out.println(cuenta.getEntidad());
			               break;
			               
			           case "4":
			               System.out.println(cuenta.getOficina());
			               break;
			               
			            case "5":
			               System.out.println(cuenta.getNumerodecuenta());
			               break;  
			               
			           case "6":
			               System.out.println(cuenta.getDigitosdecontrol());
			               break;
			               
			           case "7":
			               System.out.println("Introduzca la cantidad a ingresar");
			               cantidad=entrada.nextLine();
			               cuenta.ingreso(Double.parseDouble(cantidad));
			               break;
			               
			           case "8":
			               System.out.println("Introduzca la cantidad a retirar");
			               cantidad=entrada.nextLine();
			               cuenta.retirar(Double.parseDouble(cantidad));
			               break;
			               
			            case "9":
			               System.out.println(cuenta.getSaldo());
			               break;   
			               
			               
			           default: 
			               System.out.println("");
			               System.out.println("-----------------------------------");
			       }
			       
			       
			  }catch(NumberFormatException e){ 
			      System.out.println(e);  
			  }  
			  catch(IllegalArgumentException e){ 
			      System.out.println(e);   
			  }  
			

			}while(!opcion.equals("0"));
		}

    
    }  

}
