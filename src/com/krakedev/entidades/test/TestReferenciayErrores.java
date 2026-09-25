package com.krakedev.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestReferenciayErrores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Directorio dir = new Directorio();
		
		Contacto c1 =new Contacto();
		c1.setNombre("Maria");
		
		// contacto 1
		dir.agregarContacto(c1);
		
		//Contacto vacio 
		dir.agregarContacto(new Contacto());
		
		Contacto c = dir.obtenerContacto(6);
		
		System.out.println("Nombre: " + c.getNombre());
		
		

	}

}
