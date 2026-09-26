package com.krakedev.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestEliminarContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Instancia objeto
		Directorio dir = new Directorio();
		// Instanciar objeto y designarle valors a atributos nombre y telefono
		Contacto c1 = new Contacto();
		c1.setNombre("Maria");
		c1.setCelular("12326499");
		
		Contacto c2 = new Contacto();
		c2.setNombre("Ana");
		c2.setCelular("155466261");
		
		Contacto c3 = new Contacto();
		c3.setNombre("Astrid");
		c3.setCelular("58548451");
		
		//Agregar contacto 
		
		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);
		
		// eliminar contacto guardandolo en una valiable de tipo boolean y luego llamar al metoddo ontener cantidad
		boolean r1 = dir.eliminarContacto("12326499");
		System.out.println("Resultado de eliminar contacto 1: " + r1);
		System.out.println("Cantidad de contactos: " + dir.obtenerCantidadContactos());
		

	}

}
