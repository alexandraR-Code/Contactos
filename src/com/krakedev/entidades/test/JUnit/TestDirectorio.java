package com.krakedev.entidades.test.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

/**
 * Pruebas unitarias de la clase Directorio.
 * Cada prueba revisa un solo comportamiento y no usa parámetros.
 */
public class TestDirectorio {

	// Objeto que se prueba; se crea de nuevo antes de cada prueba
	private Directorio directorio;

	// Contactos de ejemplo que se usan en varias pruebas
	private Contacto contacto1;
	private Contacto contacto2;
	private Contacto contacto3;

	/**
	 * Se ejecuta antes de cada prueba.
	 * Crea un directorio vacío y tres contactos con celulares distintos,
	 * para que ninguna prueba dependa de otra.
	 */
	@BeforeEach
	public void inicializar() {
		directorio = new Directorio();

		contacto1 = new Contacto();
		contacto1.setNombre("Maria");
		contacto1.setApellido("Lopez");
		contacto1.setCelular("0991111111");

		contacto2 = new Contacto();
		contacto2.setNombre("Juan");
		contacto2.setApellido("Perez");
		contacto2.setCelular("0992222222");

		contacto3 = new Contacto();
		contacto3.setNombre("Ana");
		contacto3.setApellido("Torres");
		contacto3.setCelular("0993333333");
	}

	// ------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------

	/**
	 * Revisa que el constructor cree la lista y que empiece vacía.
	 */
	@Test
	@DisplayName("El directorio nuevo tiene una lista creada y vacía")
	public void testConstructorListaVacia() {
		assertNotNull(directorio.getContactos(), "La lista no debe ser null");
		assertEquals(0, directorio.obtenerCantidadContactos(), "El directorio debe iniciar vacío");
	}

	// ------------------------------------------------------------
	// agregarContacto
	// ------------------------------------------------------------

	/**
	 * Revisa que agregar un contacto nuevo devuelva true y que la cantidad suba.
	 */
	@Test
	@DisplayName("Agregar un contacto nuevo devuelve true")
	public void testAgregarContactoNuevo() {
		boolean resultado = directorio.agregarContacto(contacto1);

		assertTrue(resultado, "Debe permitir agregar un contacto nuevo");
		assertEquals(1, directorio.obtenerCantidadContactos());
	}

	/**
	 * Revisa que se puedan agregar varios contactos con celulares distintos.
	 */
	@Test
	@DisplayName("Agregar varios contactos distintos")
	public void testAgregarVariosContactos() {
		assertTrue(directorio.agregarContacto(contacto1));
		assertTrue(directorio.agregarContacto(contacto2));
		assertTrue(directorio.agregarContacto(contacto3));

		assertEquals(3, directorio.obtenerCantidadContactos());
	}

	/**
	 * Revisa que no se agregue un contacto cuyo celular ya existe.
	 * El método debe devolver false y la cantidad no debe cambiar.
	 */
	@Test
	@DisplayName("No se agrega un contacto con celular repetido")
	public void testAgregarContactoCelularDuplicado() {
		directorio.agregarContacto(contacto1);

		// Contacto diferente, pero con el mismo número de celular
		Contacto duplicado = new Contacto();
		duplicado.setNombre("Otro");
		duplicado.setCelular("0991111111");

		boolean resultado = directorio.agregarContacto(duplicado);

		assertFalse(resultado, "No debe permitir celulares repetidos");
		assertEquals(1, directorio.obtenerCantidadContactos());
	}

	/**
	 * Revisa que agregar dos veces el mismo objeto también se rechace.
	 */
	@Test
	@DisplayName("No se agrega dos veces el mismo contacto")
	public void testAgregarMismoContactoDosVeces() {
		assertTrue(directorio.agregarContacto(contacto1));
		assertFalse(directorio.agregarContacto(contacto1));

		assertEquals(1, directorio.obtenerCantidadContactos());
	}

	/**
	 * Documenta el comportamiento actual: agregar null lanza NullPointerException,
	 * porque el método llama a contacto.getCelular() sin validar antes.
	 */
	@Test
	@DisplayName("Agregar un contacto null lanza NullPointerException")
	public void testAgregarContactoNull() {
		assertThrows(NullPointerException.class, () -> directorio.agregarContacto(null));
	}

	// ------------------------------------------------------------
	// obtenerCantidadContactos
	// ------------------------------------------------------------

	/**
	 * Revisa que la cantidad solo cuente los contactos que sí se agregaron
	 * y no los rechazados por estar duplicados.
	 */
	@Test
	@DisplayName("La cantidad no cuenta los contactos rechazados")
	public void testCantidadIgnoraDuplicados() {
		directorio.agregarContacto(contacto1);
		directorio.agregarContacto(contacto2);
		directorio.agregarContacto(contacto1); // repetido, no se agrega

		assertEquals(2, directorio.obtenerCantidadContactos());
	}

	// ------------------------------------------------------------
	// obtenerContacto
	// ------------------------------------------------------------

	/**
	 * Revisa que obtenerContacto devuelva el mismo objeto que se agregó
	 * en esa posición, respetando el orden de inserción.
	 */
	@Test
	@DisplayName("Obtener un contacto por posición")
	public void testObtenerContactoPorPosicion() {
		directorio.agregarContacto(contacto1);
		directorio.agregarContacto(contacto2);
		directorio.agregarContacto(contacto3);

		assertSame(contacto1, directorio.obtenerContacto(0));
		assertSame(contacto2, directorio.obtenerContacto(1));
		assertSame(contacto3, directorio.obtenerContacto(2));
	}

	/**
	 * Revisa que pedir una posición que no existe lance IndexOutOfBoundsException.
	 */
	@Test
	@DisplayName("Obtener un contacto en una posición inválida lanza excepción")
	public void testObtenerContactoPosicionInvalida() {
		directorio.agregarContacto(contacto1);

		assertThrows(IndexOutOfBoundsException.class, () -> directorio.obtenerContacto(5));
		assertThrows(IndexOutOfBoundsException.class, () -> directorio.obtenerContacto(-1));
	}

	/**
	 * Revisa que pedir un contacto a un directorio vacío lance excepción.
	 */
	@Test
	@DisplayName("Obtener un contacto de un directorio vacío lanza excepción")
	public void testObtenerContactoDirectorioVacio() {
		assertThrows(IndexOutOfBoundsException.class, () -> directorio.obtenerContacto(0));
	}

	// ------------------------------------------------------------
	// recuperarNumero
	// ------------------------------------------------------------

	/**
	 * Revisa que recuperarNumero devuelva el celular del contacto
	 * que está en la posición indicada.
	 */
	@Test
	@DisplayName("Recuperar el número de celular por posición")
	public void testRecuperarNumero() {
		directorio.agregarContacto(contacto1);
		directorio.agregarContacto(contacto2);
		directorio.agregarContacto(contacto3);

		assertEquals("0991111111", directorio.recuperarNumero(0));
		assertEquals("0992222222", directorio.recuperarNumero(1));
		assertEquals("0993333333", directorio.recuperarNumero(2));
	}

	/**
	 * Revisa que recuperar el número en una posición inexistente lance excepción.
	 */
	@Test
	@DisplayName("Recuperar un número en una posición inválida lanza excepción")
	public void testRecuperarNumeroPosicionInvalida() {
		directorio.agregarContacto(contacto1);

		assertThrows(IndexOutOfBoundsException.class, () -> directorio.recuperarNumero(3));
	}

	// ------------------------------------------------------------
	// buscarContacto
	// ------------------------------------------------------------

	/**
	 * Revisa que buscar por un celular existente devuelva el contacto correcto.
	 */
	@Test
	@DisplayName("Buscar un contacto que existe")
	public void testBuscarContactoExistente() {
		directorio.agregarContacto(contacto1);
		directorio.agregarContacto(contacto2);

		Contacto encontrado = directorio.buscarContacto("0992222222");

		assertNotNull(encontrado, "Debe encontrar el contacto");
		assertSame(contacto2, encontrado);
		assertEquals("Juan", encontrado.getNombre());
	}

	/**
	 * Revisa que buscar un celular que no está registrado devuelva null.
	 */
	@Test
	@DisplayName("Buscar un contacto que no existe devuelve null")
	public void testBuscarContactoInexistente() {
		directorio.agregarContacto(contacto1);

		assertNull(directorio.buscarContacto("0999999999"));
	}

	/**
	 * Revisa que buscar en un directorio vacío devuelva null.
	 */
	@Test
	@DisplayName("Buscar en un directorio vacío devuelve null")
	public void testBuscarContactoDirectorioVacio() {
		assertNull(directorio.buscarContacto("0991111111"));
	}

	/**
	 * Revisa que la búsqueda compare el número exacto:
	 * un número parecido o con espacios no debe coincidir.
	 */
	@Test
	@DisplayName("La búsqueda exige el número exacto")
	public void testBuscarContactoNumeroExacto() {
		directorio.agregarContacto(contacto1);

		assertNull(directorio.buscarContacto("099111111"));    // le falta un dígito
		assertNull(directorio.buscarContacto(" 0991111111 ")); // tiene espacios
	}

	// ------------------------------------------------------------
	// getContactos / setContactos
	// ------------------------------------------------------------

	/**
	 * Revisa que setContactos reemplace la lista interna
	 * y que los demás métodos trabajen con la lista nueva.
	 */
	@Test
	@DisplayName("setContactos reemplaza la lista interna")
	public void testSetContactos() {
		ArrayList<Contacto> nuevaLista = new ArrayList<Contacto>();
		nuevaLista.add(contacto1);
		nuevaLista.add(contacto2);

		directorio.setContactos(nuevaLista);

		assertSame(nuevaLista, directorio.getContactos());
		assertEquals(2, directorio.obtenerCantidadContactos());
		assertSame(contacto2, directorio.buscarContacto("0992222222"));
	}

	// ------------------------------------------------------------
	// imprimirContactos
	// ------------------------------------------------------------

	/**
	 * Revisa que imprimirContactos muestre el nombre de cada contacto.
	 * Durante la prueba, la salida de consola se guarda en memoria para poder revisarla.
	 */
	@Test
	@DisplayName("imprimirContactos muestra los nombres en consola")
	public void testImprimirContactos() {
		directorio.agregarContacto(contacto1);
		directorio.agregarContacto(contacto2);

		// Se guarda la salida original para restaurarla al terminar
		PrintStream salidaOriginal = System.out;
		ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();

		try {
			System.setOut(new PrintStream(salidaCapturada));
			directorio.imprimirContactos();
		} finally {
			// Siempre se restaura la consola, incluso si ocurre un error
			System.setOut(salidaOriginal);
		}

		String texto = salidaCapturada.toString();
		assertTrue(texto.contains("Nombre: Maria"));
		assertTrue(texto.contains("Nombre: Juan"));
	}

	/**
	 * Revisa que imprimir un directorio vacío no muestre nada.
	 */
	@Test
	@DisplayName("imprimirContactos no muestra nada si el directorio está vacío")
	public void testImprimirContactosVacio() {
		PrintStream salidaOriginal = System.out;
		ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();

		try {
			System.setOut(new PrintStream(salidaCapturada));
			directorio.imprimirContactos();
		} finally {
			System.setOut(salidaOriginal);
		}

		assertEquals("", salidaCapturada.toString());
	}
}