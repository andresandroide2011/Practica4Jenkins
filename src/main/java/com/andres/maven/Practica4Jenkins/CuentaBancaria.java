package com.andres.maven.Practica4Jenkins;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author andres huertas martin
 */
public class CuentaBancaria {
    
    //Declaramos los atributos necesarios para la clase Cuenta
    private String titular,entidad,oficina,digitosdecontrol,numerodecuenta;
    private double saldo;

    //Aqui tenemos el constructor que se encarga de crear el objeto siempre y cuando cumpla los requisitos de nombre y CCC
    public CuentaBancaria(String titular, String entidad, String oficina, String digitosdecontrol, String numerodecuenta) {
        
        //Comprobamos que el nombre es mayor que 5 y menor que 50
        if (titular.length()<5 || titular.length()>50) 
            throw new IllegalArgumentException("Datos incorrectos,el nombre tiene que ser mayor que 5 y menor que 50");
        
        //Comprobamos que la cuenta bancaria tiene 20 digitos
        if (entidad.length()!=4 || oficina.length()!=4 || digitosdecontrol.length()!=2 || numerodecuenta.length()!=10 ) 
            throw new IllegalArgumentException("Longitud de datos bancarios incorrectos");
        
   
       
        //Comprobamos que son numericos
        try{ 
            Integer.parseInt(entidad);
            Integer.parseInt(oficina);
            Integer.parseInt(digitosdecontrol);
            Double.parseDouble(numerodecuenta);
        }catch(NumberFormatException e){ 
            throw new NumberFormatException("Uno de los valores bancarios no es un numero");   
        }  
        
        
        //Incializamos el objeto al ser todo correcto.
        this.titular = titular;
        this.entidad = entidad;
        this.oficina = oficina;
        this.digitosdecontrol = digitosdecontrol;
        this.numerodecuenta = numerodecuenta;
        this.saldo = 0;
        
        //Comprobamos que los digitos de control son correctos por si se metieron mal
        if (!(esValidaCCC(entidad,oficina,digitosdecontrol,numerodecuenta))) 
            throw new IllegalArgumentException("Los digitos de control son incorrectos");

    }
    //Metodo que obtiene el nombre del titular
    public String getTitular() {
        return titular;
    }

    //metodo que obtiene el nombre de la entidad
    public String getEntidad() {
        return entidad;
    }

    //metodo que obtiene el nombre de la oficina
    public String getOficina() {
        return oficina;
    }

    //metodo que obtiene los digitos de control
    public String getDigitosdecontrol() {
        return digitosdecontrol;
    }

    //metodo que obtiene el numero de cuenta
    public String getNumerodecuenta() {
        return numerodecuenta;
    }

    //metodo que obtiene el saldo
    public double getSaldo() {
        return saldo;
    }
    
    //metodo que he usado para probar el programa cuando me ha hecho falta,saca los atriburos del objeto
    @Override
    public String toString() {
        return "CuentaBancaria{" + "titular=" + titular + ", entidad=" + entidad + ", oficina=" + oficina + ", digitosdecontrol=" + digitosdecontrol + ", numerodecuenta=" + numerodecuenta + ", saldo=" + saldo + '}';
    }
    
    //este metodo recibe una cadena de 10 caracteres y a partir de ella calcula el digito de control correspondiente
    //mediante el algoritmo que he encontrado por internet y que se usa para ello
    public int digitoControl(String cadena){
        
	int cifras[]= {1,2,4,8,5,10,9,7,3,6};
        int chequeo= 0;
        for (int i=0; i < cifras.length; i++){
        chequeo += (Integer.parseInt(cadena.substring(i,i+1))) * cifras[i];
        }
        chequeo = 11 - (chequeo % 11);
            if (chequeo == 11) {chequeo = 0;}
            if (chequeo == 10) {chequeo = 1;}
      return chequeo;
      
    }
    
    //este metodo se encarga de validar la CCC,para ello hace uso del metodo DigitoControl 
    //al que llama dos veces para conseguir los dos digitos de control que le hacen falta
    //devuelve verdadero si CCC es correcta
    public boolean esValidaCCC(String ent, String ofi, String digitos, String numcuenta){
    
        //Suponemos que la entrada es correcta
        boolean resultado=true;
        
        // Introducimos la cadena para comprobar el primer digito de control
	String primer_control="00"+entidad+oficina;
        
        //Comparamos el primer digito calculado por la clase cuenta con el que nos da el usuario
	int primer_digito=digitoControl(primer_control);
        int entradaprimerdigito=Integer.parseInt(digitos.substring(0,1));
      
	if ( primer_digito != entradaprimerdigito){
        resultado=false;
        }
	
        //Introducimos la cadena para comprobar el segundo digito de control
	String segundo_control=numcuenta;
	
        // Comparamos el segundo digito de control calculado por la clase cuenta con el que nos da el usuario
        int segundo_digito=digitoControl(segundo_control);
        int entradasegundodigito=Integer.parseInt(digitos.substring(1,2));
	if (segundo_digito != entradasegundodigito){
		resultado=false;
        }  
        
    return resultado;
    
    }



   //metodo que se encarga de actualizar el atributo saldo de la clase cuando hay un ingreso
     public void ingreso(double dinero){
     
        if (dinero>0){
           this.saldo=this.saldo+dinero;
           }
           else{
           System.out.println("Lo sentimos no se ha podido realizar la transacción,introduzca una cantidad correcta");     
           }
        }
     
     
     
 

     //metodo que se encarga de actualizar el atributo saldo de la clase cuando se saca dinero
     public void retirar(double dinero){
     
     if (dinero>0){
        if (this.getSaldo()>=dinero)
            this.saldo=this.saldo-dinero;
        else{
        System.out.println("Lo sentimos no se ha podido realizar la transacción,no tiene suficiente dinero");     
        }
     
     }
     
     
     } 
    
    
 
    
}


