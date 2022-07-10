package com.andres.maven.Practica4Jenkins;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.andres.maven.Practica4Jenkins.CuentaBancaria;


class  TestJUnit1{

	 
   
    
	@Test
	public void testgetTitular() {
		//Andrés Huertas 0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR: TITULAR,ENTIDAD,OFICINA,DIGITOSCONTROL,NUMERODECUENTA
	    CuentaBancaria cuenta1=new CuentaBancaria("Andrés Huertas","0633" ,"2076" ,"82","1025372623");
		assertEquals("Andrés Murcia",cuenta1.getTitular());
		
	}
	
	@Test
	public void testgetEntidad() {
		//Andrés Huertas 0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR: TITULAR,ENTIDAD,OFICINA,DIGITOSCONTROL,NUMERODECUENTA
	    CuentaBancaria cuenta1=new CuentaBancaria("Andrés Huertas","0633" ,"2076" ,"82","1025372623");
		assertEquals("0633",cuenta1.getEntidad());
		
	}
	
	@Test
	public void testgetOficina() {
		//Andrés Huertas 0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR: TITULAR,ENTIDAD,OFICINA,DIGITOSCONTROL,NUMERODECUENTA
	    CuentaBancaria cuenta1=new CuentaBancaria("Andrés Huertas","0633" ,"2076" ,"82","1025372623");
		assertEquals("2076",cuenta1.getOficina());
		
	}
	
	@Test
	public void testgetDigitosdecontrol() {
		//Andrés Huertas 0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR: TITULAR,ENTIDAD,OFICINA,DIGITOSCONTROL,NUMERODECUENTA
	    CuentaBancaria cuenta1=new CuentaBancaria("Andrés Huertas","0633" ,"2076" ,"82","1025372623");
		assertEquals("82",cuenta1.getDigitosdecontrol());
		
	}
	
	@Test
	public void testgetNumerodecuenta() {
		//Andrés Huertas 0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR: TITULAR,ENTIDAD,OFICINA,DIGITOSCONTROL,NUMERODECUENTA
	    CuentaBancaria cuenta1=new CuentaBancaria("Andrés Huertas","0633" ,"2076" ,"82","1025372623");
		assertEquals("1025372623",cuenta1.getNumerodecuenta());
		
	}
	
	@Test
	public void testtoString() {
		//Andrés Huertas 0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR: TITULAR,ENTIDAD,OFICINA,DIGITOSCONTROL,NUMERODECUENTA
	    CuentaBancaria cuenta1=new CuentaBancaria("Andrés Huertas","0633" ,"2076" ,"82","1025372623");
		assertEquals("CuentaBancaria{titular=Andrés Huertas, entidad=0633, oficina=2076, digitosdecontrol=82, numerodecuenta=1025372623, saldo=0.0}",cuenta1.toString());
		
		
	}
	
	@Test
	public void testdigitoControl() {
		//Andrés Huertas 0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR: TITULAR,ENTIDAD,OFICINA,DIGITOSCONTROL,NUMERODECUENTA
	    CuentaBancaria cuenta1=new CuentaBancaria("Andrés Huertas","0633" ,"2076" ,"82","1025372623");
		assertEquals(2,cuenta1.digitoControl("1025372623"));
		
	}
	
	@Test
	public void testesValidaCCC() {
		//Andrés Huertas 0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR: TITULAR,ENTIDAD,OFICINA,DIGITOSCONTROL,NUMERODECUENTA
	    CuentaBancaria cuenta1=new CuentaBancaria("Andrés Huertas","0633" ,"2076" ,"82","1025372623");
		assertEquals(true,cuenta1.esValidaCCC(cuenta1.getEntidad(), cuenta1.getOficina(), cuenta1.getDigitosdecontrol(), cuenta1.getNumerodecuenta()));
		
	}
	
	@Test
	public void testgetSaldo() {
		//Andrés Huertas 0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR: TITULAR,ENTIDAD,OFICINA,DIGITOSCONTROL,NUMERODECUENTA
	    CuentaBancaria cuenta1=new CuentaBancaria("Andrés Huertas","0633" ,"2076" ,"82","1025372623");
		assertEquals(0.0,cuenta1.getSaldo());
		
	}
	
	@Test
	public void testingreso() {
		//Andrés Huertas 0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR: TITULAR,ENTIDAD,OFICINA,DIGITOSCONTROL,NUMERODECUENTA
	    CuentaBancaria cuenta1=new CuentaBancaria("Andrés Huertas","0633" ,"2076" ,"82","1025372623");
		cuenta1.ingreso(100);
		assertEquals(100.0,cuenta1.getSaldo());
		
	}
	
	@Test
	public void testretirar() {
		//Andrés Huertas 0633 2076 82 1025372623  CUENTA VALIDA PARA PROBAR: TITULAR,ENTIDAD,OFICINA,DIGITOSCONTROL,NUMERODECUENTA
	    CuentaBancaria cuenta1=new CuentaBancaria("Andrés Huertas","0633" ,"2076" ,"82","1025372623");
		cuenta1.retirar(0);
		assertEquals(0.0,cuenta1.getSaldo());
		
	}
	
	
	
}
