package com.krakedev.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestAgregar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Instaciar clase que tiene el metodo de agregar contacto 
		Directorio dir = new Directorio();
		
		//Instanciar clase que tiene los contactos 
		Contacto c1 = new Contacto();
		c1.setNombre("Ana");
		
		//probar agregar contacto
		dir.agregarContacto(c1);
		
		//
		System.out.println(dir.getContactos().size());
		
		

	}

}
