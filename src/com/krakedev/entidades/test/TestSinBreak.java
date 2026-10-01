package com.krakedev.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestSinBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Instanciar clase
		Directorio dir = new Directorio();

		Contacto c1 = new Contacto();
		c1.setNombre("Maria");
		c1.setCelular("12468/848");

		Contacto c2 = new Contacto();
		c2.setNombre("Juan");
		c2.setCelular("158484514");

		Contacto c3 = new Contacto();
		c3.setNombre("Carlos");
		c3.setCelular("485444");

		Contacto c4 = new Contacto();
		c4.setNombre("Pablo");
		c4.setCelular("0911");

		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);
		dir.agregarContacto(c4);

		Contacto encontrado = dir.buscarContacto("0911");
		System.out.println("Nombre: " + encontrado.getNombre());

	}

}
