package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	private static Scanner sc;
	private static List<Jugador> jugadores;

	public static void main(String[] args) {
		int opcion=0;
		do {
			opcion=generarMenu();
			switch(opcion) {
				case 1: System.out.println("******AGREGAR JUGADOR******");
						agregarJugadores();break;
				case 2: mostrarJugadores();break;
				case 3: System.out.println("******MODICAR POSICION DE UN JUGADOR******");
						modificarJugador();break;
				case 4: System.out.println("******ELIMINAR JUGADOR******");
						eliminarJugador();break;
				case 5:System.out.println("FIN DEL PROGRAMA.");break;
				default: System.out.println("OPCION INCORRECTA.");break;
					
			}
		}while(opcion != 5);
		sc.close();
	}
	/*
	 * CONSTRUCCION DEL MENU
	 */
	public static int generarMenu() {
		boolean correcto=false;
		int opcion=0;
		sc=new Scanner(System.in);
		do {
			System.out.println("****************************MENU DE OPCIONES****************************");
			System.out.println("1 - Alta de jugador.");
			System.out.println("2 - Mostrar todos los jugadores.");
			System.out.println("3 - Modificar la posicion de un  jugador.");
			System.out.println("4 - Eliminar un jugador.");
			System.out.println("5 - Salir.");
			System.out.println("Ingrese opcion: ");
			try {
				opcion = sc.nextInt();
				correcto=true;
			} catch (InputMismatchException e) {
				System.out.println("OPCION INCORRECTA.");
				sc.next();
			}
		}while(correcto == false);
		return opcion;
	}
	/*
	 * GENERA UN NUEVO JUGADOR CON DATOS INGRESADOS POR EL USUARIO
	 */
	public static void agregarJugadores() {
		
		if ( jugadores == null) {
			jugadores = new ArrayList<>();
		}
		System.out.println("Ingrese nombre del jugador: ");
		String nombre = sc.next();
		sc.nextLine();
		System.out.println("Ingrese apellido del jugador: ");
		String apellido = sc.next();
		sc.nextLine();
		LocalDate fechaNac = pedirFecha();
		sc.nextLine();
		System.out.println("Ingrese nacionalidad del jugador: ");
		String nacionalidad = sc.next();
		sc.nextLine();
		float estatura = pedirEstatura();
		sc.nextLine();
		float peso = pedirPeso();
		sc.nextLine();
		Posicion posicion = solicitarPosicion();
		jugadores.add(new Jugador(nombre, apellido, fechaNac, nacionalidad, estatura, peso, posicion));
		System.out.println("==============================");
		System.out.println("JUGADOR AGREGADO EXITOSAMENTE.");
		System.out.println("==============================");
	}
	/*
	 * VERIFICA QUE EL FORMATO DE FECHA SEA AGREGADO CORRECTAMENTE
	 */
	public static LocalDate pedirFecha() {
		LocalDate fechaNac=null;
		boolean fechaCorrecta=false;
		do {
			System.out.println("Ingrese fecha de nacimiento del jugador (dd/mm/yyyy): ");
			String fechaNaciString = sc.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			try {
				fechaNac = LocalDate.parse(fechaNaciString,formatter);
				fechaCorrecta = true;
			} catch (Exception e) {
				System.out.println("FORMATO DE FECHA INCORRECTO. POR FAVOR INGRESE LA FECHA DE ACUERDO AL FORMATO SOLICITADO!");
			}
		}while (fechaCorrecta == false);
		return fechaNac;
	}
	/*
	 * VERIFICA QUE EL DATO INGRESADO POR EL USUARIO PARA LA ESTATURA SEA UN NUMERO REAL.
	 * RETORNA EL VALOR INGRESADO SI ES CORRECTO.
	 */
	public static float pedirEstatura() {
		boolean correcto = false;
		float num = 0;
		do {
			System.out.println("Ingrese estatura del jugador: ");
			try {
				num = sc.nextFloat();
				if(num<=0) {
					System.out.println("SOLO SE PERMITEN NUMEROS MAYORES A 0!");
				}else {
					correcto = true;
				}
				} catch (InputMismatchException ex) {
				System.out.println("POR FAVOR INGRESE UN NUMERO REAL SEPARANDO DECIMALES CON ','!! ");
				sc.next();
				}
		}while(correcto == false);
		return num;
	}
	/*
	 * VERIFICA QUE EL DATO INGRESADO POR EL USUARIO PARA EL PESO SEA UN NUMERO REAL.
	 * RETORNA EL VALOR INGRESADO SI ES CORRECTO.
	 */
	public static float pedirPeso() {
		boolean correcto = false;
		float num = 0;
		do {
			System.out.println("Ingrese peso del jugador: ");
			try {
				num = sc.nextFloat();
				if(num<=0) {
					System.out.println("SOLO SE PERMITEN NUMEROS MAYORES A 0!");
				}else {
					correcto = true;
				}
				} catch (InputMismatchException ex) {
				System.out.println("POR FAVOR INGRESE UN NUMERO REAL SEPARANDO DECIMALES CON ','!! ");
				sc.next();
				}
		}while(correcto == false);	
		return num;
	}
	/*
	 * MUESTRA LOS VALORES DEL ENUMARADO POSICION Y SOLICITA AL USUARIO QUE ESCOJA UNA OPCION
	 * RETORNA UN VALOR DEL ENUMERADO.
	 */
	public static Posicion solicitarPosicion() {
		boolean correcto = false;
		int num = 0, i=0;
		Posicion posicion = null;
		do {
			System.out.println("****POSICIONES****");
			for(Posicion pos: Posicion.values()) {
				i++;
				System.out.println(i+" - "+pos);
			}
			System.out.println("Elija una opcion: ");
			try {
				num = sc.nextInt();
				if (num <= 0 || num > 4) {
					System.out.println("OPCION INVALIDA.");
				}else {
					correcto = true;
				}
				} catch (InputMismatchException ex) {
				System.out.println("OPCION INVALIDA.");
				sc.next();
				}
		}while(correcto == false);
		posicion = Posicion.values()[num-1];
		return posicion;
	}
	/*
	 * MUESTRA LOS OBJETOS DE LA ARRAYLIST jugadores
	 */
	public static void mostrarJugadores() {
		if ( jugadores == null) {
			System.out.println("=========================");
			System.out.println("LISTA DE JUGADORES VACIA.");
			System.out.println("=========================");
		}else {
			System.out.println("**************LISTA DE JUGADORES**************");
			jugadores.forEach(j->System.out.println(j));
		}
	}
	/*
	 * MODIFICA LA POSICION DE UN JUGADOR SOLICITADO POR EL USUARIO.
	 */
	public static void modificarJugador() {
		Jugador jugadorEncontrado=null;
		if (jugadores == null) {
			System.out.println("=========================");
			System.out.println("LISTA DE JUGADORES VACIA.");
			System.out.println("=========================");
		}else {
			System.out.println("Ingrese nombre del jugador: ");
			String nombre=sc.next();
			sc.nextLine();
			System.out.println("Ingrese apellido del jugador: ");
			String apellido=sc.next();
			sc.nextLine();
			for(Jugador jugador : jugadores ) {
				if(jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
					jugadorEncontrado = jugador;
				}
			}
			if(jugadorEncontrado==null) {
				System.out.println("======================");
				System.out.println("EL JUGADAOR NO EXISTE.");
				System.out.println("======================");
			}else {
				jugadorEncontrado.setPosicion(solicitarPosicion());	
				System.out.println("===================================");
				System.out.println("POSICION ACTUALIZADA CORRECTAMENTE.");
				System.out.println("===================================");
			}	
		}
	}
	/*
	 * ELIMINA UN OBJETO DE LA ARRAYLIST MEDIANTE EL NOMBRE Y APELLIDO 
	 * INGRESADO POR EL USUARIO
	 */
	public static void eliminarJugador() {
		boolean borrado= false;
		if (jugadores == null) {
			System.out.println("=========================");
			System.out.println("LISTA DE JUGADORES VACIA.");
			System.out.println("=========================");
		}else {
			System.out.println("Ingrese nombre del jugador: ");
			String nombre=sc.next();
			sc.nextLine();
			System.out.println("Ingrese apellido del jugador: ");
			String apellido=sc.next();
			sc.nextLine();
			Iterator<Jugador> iterator = jugadores.iterator();
			while(iterator.hasNext()) {
				Jugador jugador = iterator.next();
				if(jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido )) {
					iterator.remove();
					System.out.println("================================");
					System.out.println("JUGADOR ELIMINADO CORRECTAMENTE.");
					System.out.println("================================");
					borrado=true;
				}
			}
			if (borrado==false) {
				System.out.println("======================");
				System.out.println("EL JUGADAOR NO EXISTE.");
				System.out.println("======================");
			}
		}
	}
}
