package com.krakedev.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestRecuperarNumero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Directorio dir = new Directorio();
		
		Contacto c1 = new Contacto();
		c1.setNombre("Maria");
		c1.setCelular("1588454");
		
		Contacto c2 = new Contacto();
		c2.setNombre("Juan");
		c2.setCelular("51656656");
		
		Contacto c3 = new Contacto();
		c3.setNombre("Ana");
		c3.setCelular("5154644");
		
		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);
		
		String numeroRecuperado = dir.recuperarNumero(0);
		String numeroRecuperado1 = dir.recuperarNumero(1);
		String numeroRecuperado2 = dir.recuperarNumero(2);
		
		
		System.out.println("Numero celular: " + numeroRecuperado);
		System.out.println("Numero cecular: " + numeroRecuperado1);
		System.out.println("Numero celular: " + numeroRecuperado2);
		

	}

}
