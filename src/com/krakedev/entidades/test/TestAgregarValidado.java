package com.krakedev.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestAgregarValidado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Directorio dir = new Directorio();
		
		Contacto c1 = new Contacto();
		c1.setNombre("Julian");
		c1.setCelular("46545456151");
		
		Contacto c2 = new Contacto();
		c2.setNombre("David");
		c2.setCelular("2456874");
		
		Contacto c3 = new Contacto();
		c3.setNombre("Alexandra");
		c3.setCelular("515484115");
		
		boolean r1 = dir.agregarContacto(c1);
		boolean r2 = dir.agregarContacto(c2);
		boolean r3 = dir.agregarContacto(c3);
		
		System.out.println("Agregado C1: " + r1);
		System.out.println("Agregado C2: " + r2);
		System.out.println("Agregado C3: " + r3);
		
		System.out.println("Cantidad: " + dir.obtenerCantidadContactos());
	}

}
