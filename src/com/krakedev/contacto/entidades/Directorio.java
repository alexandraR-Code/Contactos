package com.krakedev.contacto.entidades;

import java.util.ArrayList;

public class Directorio {

	// Lista de contactos con ArrayList

	ArrayList<Contacto> contactos;

	// Constructor de directorio con instancia
	public Directorio() {
		contactos = new ArrayList<Contacto>();

	}
	// Metodos getter y setter

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	// Metodo para agregar contactos

	public void agregarContacto(Contacto contacto) {
		contactos.add(contacto);
	}

	// Metodo para cantidadd de contato
	public int obtenerCantidadContactos() {
		int cantidad;
		cantidad = contactos.size();
		return cantidad;

	}

	// Metodo para devolver un (contacto)

	public Contacto obtenerContacto(int posicion) {
		return contactos.get(posicion);

	}

	// Metodo que recorra todo el arreglo y pueda acceder a cualquier atributo

	public void imprimirContactos() {

		for (int i = 0; i < contactos.size(); i++) {
			Contacto contacto = contactos.get(i);

			System.out.println("Nombre: " + contacto.getNombre());
		}
	}

	// Metodo para recuperra un numero telefonico
	public String recuperarNumero(int posicion) {

		Contacto c = contactos.get(posicion);

		String numero = c.getCelular();
		return numero;

	}

}
