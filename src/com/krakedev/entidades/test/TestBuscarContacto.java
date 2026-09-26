package com.krakedev.entidades.test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestBuscarContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Directorio dir = new Directorio();

		Contacto c1 = new Contacto();
		c1.setNombre("Ana");
		c1.setCelular("26646");

		Contacto c2 = new Contacto();
		c2.setNombre("Brenda");
		c2.setCelular("156266");

		Contacto c3 = new Contacto();
		c3.setNombre("Astrid");
		c3.setCelular("16655888");

		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);

		// Caso 1 encontrado
		Contacto encontrado = dir.buscarContacto("26646");

		if (encontrado != null) {
			System.out.println("Nombre: " + encontrado.getNombre());
		} else {
			System.out.println("No existe ");
		}

		// Caso 2 No encontrado
		Contacto noEncontrado = dir.buscarContacto("45485254");

		if (noEncontrado != null) {
			System.out.println("Nombre: " + noEncontrado.getNombre());
		} else {
			System.out.println("No existe");
		}

	}

}
