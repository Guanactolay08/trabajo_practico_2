package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;


public class Main {
	private static Scanner sc;
	private static List<Efemeride> efemerides;
	
	public static void main(String[] args) {
		int opcion=0;
		do {
			opcion=generarMenu();
			switch(opcion) {
				case 1: agregarEfemeride();break;
				case 2: mostrarEfemerides();break;
				case 3: eliminarEfemeride();break;
				case 4: modificarEfemeride();break;
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
			System.out.println("*********MENU DE OPCIONES*********");
			System.out.println("1 - Crear efemeride.");
			System.out.println("2 - Mostrar efemeride.");
			System.out.println("3 - Eliminar efemeride.");
			System.out.println("4 - Modificar efemeride.");
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
	 * AGREGAR UN ONJETO EFEMERIDE AL ARRAYLIST.
	 */
	public static void agregarEfemeride() {
		if (efemerides == null) {
			efemerides = new ArrayList<>();
		}
		int codigo = pedirCodigo();
		Mes mes = pedirMes();
		int dia = pedirDia();
		sc.nextLine();
		System.out.println("Ingrese detalle de la efemeride: ");
		String detalle = sc.nextLine();
		efemerides.add(new Efemeride(codigo, mes, dia, detalle));
		System.out.println("================================");
		System.out.println("EFEMERIDE AGREGADA EXITOSAMENTE.");
		System.out.println("================================");
		
	}
	/*
	 * AEGURA QUE EL USUARIO INGRESE UN NUMERO ENTERO PARA EL CODIGO
	 */
	public static int pedirCodigo() {
		boolean correcto = false;
		int num = 0;
		do {
			System.out.println("Ingrese codigo: ");
			try {
				num = sc.nextInt();
				correcto = true;
				} catch (InputMismatchException ex) {
				System.out.println("SOLO SE PERMITEN NUMEROS ENTEROS PARA EL CODIGO! ");
				sc.next();
				}
		}while(correcto == false);
		
		return num;
	}
	/*
	 * DEVUELVE EL VALOR QUE TOMARA EL ENUMERADO MEDIANTE LA SELECCION DEL USUARIO
	 */
	public static Mes pedirMes() {
		boolean correcto = false;
		int num = 0;
		do {
			System.out.println("Ingrese el mes (Formato numerico del 1 al 12): ");
			try {
				num = sc.nextInt();
				if (num <= 0 || num > 12) {
					System.out.println("OPCION INVALIDA.");
				}else {
					correcto = true;
				}
				} catch (InputMismatchException ex) {
				System.out.println("OPCION INVALIDA.");
				sc.next();
				}
		}while(correcto == false);
		Mes mes = Mes.values()[num-1];
		return mes;
	}
	/*
	 * ASEGURA QUE EL USUARIO INGRESE UN NUMERO ENTERO PARA EL DIA 
	 */
	public static int pedirDia() {
		boolean correcto = false;
		int num = 0;
		do {
			System.out.println("Ingrese dia: ");
			try {
				num = sc.nextInt();
				if (num <= 0 || num > 31) {
					System.out.println("SOLO SE PERMITEN NUMEROS ENTEROS MAYORES A 0 Y MENORES A 31 PARA EL DIA!");
				}else {
					correcto = true;
				}
				} catch (InputMismatchException ex) {
				System.out.println("SOLO SE PERMITEN NUMEROS ENTEROS MAYORES A 0 Y MENORES A 31 PARA EL DIA! ");
				sc.next();
				}
		}while(correcto == false);
		return num;
	}
	/*
	 * MUESTRA LOS OBJETOS GUARDADOS EN EL ARRAYLIST
	 */
	public static void mostrarEfemerides() {
		if ( efemerides == null) {
			System.out.println("=========================");
			System.out.println("LISTA DE EFEMERIDES VACIA.");
			System.out.println("=========================");
		}else {
			System.out.println("==================================LISTA DE EFEMERIDES==================================");
			efemerides.forEach(e->System.out.println(e));
		}
	}
	/*
	 * ELIMINA UN OBJETO DE LA ARRAYLISTE MEDIANTES SU CODIGO IDENTIFICADOR
	 * INGRESADO POR EL USUARIO
	 */
	public static void eliminarEfemeride() {
		boolean borrado=false;
		if (efemerides == null) {
			System.out.println("=========================");
			System.out.println("LISTA DE EFEMERIDES VACIA.");
			System.out.println("=========================");
		}else {
				int codigo = pedirCodigo();
				Iterator<Efemeride> iterator = efemerides.iterator();
				while(iterator.hasNext()) {
					Efemeride efemeride = iterator.next();
					if(efemeride.getCodigo() == codigo ) {
						iterator.remove();
						System.out.println("==================================");
						System.out.println("EFEMERIDE ELIMINADA CORRECTAMENTE.");
						System.out.println("==================================");
						borrado=true;
					}
				}
				if (borrado==false) {
					System.out.println("=================================");
					System.out.println("EL CODIGO DE EFEMERIDE NO EXISTE.");
					System.out.println("=================================");
				}
			}
	}
	/*
	 * MODIFICA LOS ATRIBUTOS DE UN OBJETO MEDIANTE SU CODIGO IDENTIFICADOR
	 * INGRESADO POR EL USUARIO.
	 */
	public static void modificarEfemeride() {
		if (efemerides == null) {
			System.out.println("=========================");
			System.out.println("LISTA DE EFEMERIDES VACIA.");
			System.out.println("=========================");
		}else {
			int codigo = pedirCodigo();
			Efemeride efemerideEncontrada=null;
			for(Efemeride efemeride : efemerides ) {
				if(efemeride.getCodigo() == codigo) {
					efemerideEncontrada = efemeride;
				}
			}
			if(efemerideEncontrada ==null) {
				System.out.println("=================================");
				System.out.println("EL CODIGO DE EFEMERIDE NO EXISTE.");
				System.out.println("=================================");
			}else {
				Mes mes = pedirMes();
				int dia = pedirDia();
				sc.nextLine();
				System.out.println("Ingrese detalle de la efemeride: ");
				String detalle = sc.nextLine();
				efemerideEncontrada.setMes(mes);
				efemerideEncontrada.setDia(dia);
				efemerideEncontrada.setDetalle(detalle);
				System.out.println("=================================");
				System.out.println("EFEMERIDE MODIFICADA EXITOSAMENTE.");
				System.out.println("=================================");
			}
		}
	}
	
}
