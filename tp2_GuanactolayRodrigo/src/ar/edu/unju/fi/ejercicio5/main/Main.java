package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class Main {
	private static Scanner sc;
	private static List<Producto> productos;
	private static List<Producto> productosComprados;
	public static void main(String[] args) {
		int opcion=0;
		precargarProductos();
		do {
			opcion = generarMenu();
			switch(opcion) {
			case 1: mostrarProductos();break;
			case 2: seleccionarProductos();
					pagarProductos();
					break;
			case 3: System.out.println("FIN DEL PROGRAMA.");break;
			default: System.out.println("OPCION INVALIDA.");break;
			}
		}while(opcion!=3);

	}
	/*
	 * PRECARGA DE 15 PRODUCTOS
	 */
	public static void precargarProductos() {
		if (productos==null) {
			productos = new ArrayList<>();
		}
		productos.add(new Producto(1,"Celular Xiaomi Note 8 Pro" , 250000, OrigenFabricacion.CHINA, Categoria.TELEFONIA, false));
		productos.add(new Producto(2,"Celular Samsung A13" , 150000, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
		productos.add(new Producto(3,"Celular Motorola C3" , 300000, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
		productos.add(new Producto(4,"Celular IPhone X" , 800000, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false));
		productos.add(new Producto(5,"Notebook ASUS X541" , 500000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		productos.add(new Producto(6,"Notebook Lenovo V15 G3" , 600000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		productos.add(new Producto(7,"Notebook HP 240 G8" , 700000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, false));
		productos.add(new Producto(8,"Notebook BANGHO Gamer GTX 1650" , 900000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		productos.add(new Producto(9,"Smart TV LED 43'' FHD PHILIPS" , 450000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(10,"Heladera DREAN 277l" , 850000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
		productos.add(new Producto(11,"Lavarropas DREAN Next 8.12" , 300000, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(12,"Aire acondicionado Split PHILCO" , 500000, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(13,"Taladro Percutor Daewoo Daid850" , 99000, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto(14,"Amoladora Angular 820w Black Decker" , 80000, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto(15,"Motosierra Electrica Pektra 2000w" , 50500, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true));
	}
	/*
	 * CONSTRUCCION DEL PRIMER MENU
	*/
	public static int generarMenu() {
		boolean correcto=false;
		int opcion=0;
		sc=new Scanner(System.in);
		do {
			if (productosComprados != null) {
				productosComprados.clear();
			}
			System.out.println("***********MENU DE OPCIONES***********");
			System.out.println("1 - Mostrar productos.");
			System.out.println("2 - Comprar productos.");
			System.out.println("3 - Salir.");
			System.out.println("Ingrese opcion: ");
			try {
				opcion = sc.nextInt();
				sc.nextLine();
				correcto=true;
			} catch (InputMismatchException e) {
				System.out.println("OPCION INCORRECTA.");
				sc.nextLine();
			}
		}while(correcto == false);
		return opcion;
	}
	/*
	 * MOSTRAR LOS OBJETOS DE LA ARRAYLIST PRODUCTOS
	 */
	public static void mostrarProductos() {
		System.out.println("=====================================================LISTA DE PRODUCTOS=====================================================");
		productos.forEach(p-> System.out.println(p));
	}
	/*
	 * GUARDA LOS OBJETOS ELEGIDOS POR EL USUARIO EN EL NUEVO ARRAYLIST PRODCTOSCOMPRADOS
	 */
	public static void seleccionarProductos() {
		int opcion=0;
		Producto producto=null;
		do {
			opcion=generarMenuSeleccionPoducto();
			switch(opcion) {
			case 1: producto = buscarProducto();
					cargarProductosComprados(producto);
					break;
			case 2: System.out.println("=================================");
					System.out.println("SELECION DE PRODUCTOS FINALIZADA.");
					System.out.println("=================================");
					break;
			default: System.out.println("OPCION INVALIDA.");break;
			}
		}while(opcion!=2);
	}
	/*
	 * CONSTRUCCION DEL MENU DE COMPRA
	 */
	public static int generarMenuSeleccionPoducto() {
		boolean correcto=false;
		int opcion=0;
		sc=new Scanner(System.in);
		do {
			System.out.println("----------SELECCION DE PRODUCTOS----------");
			System.out.println("1 - Agregar producto a la compra.");
			System.out.println("2 - Terminar compra.");
			System.out.println("Ingrese opcion: ");
			try {
				opcion = sc.nextInt();
				sc.nextLine();
				correcto=true;
			} catch (InputMismatchException e) {
				System.out.println("OPCION INCORRECTA.");
				sc.nextLine();
			}
		}while(correcto == false);
		return opcion;
	}
	/*
	 * BUSCA UN OBJETO PRODUCTO POR SU CODIGO 
	 */
	public static Producto buscarProducto() {
		Producto productoEncontrado = null;
		boolean correcto = false;
		int codigo = 0;
		do {
			System.out.println("Ingrese codigo del producto: ");
			try {
				codigo = sc.nextInt();
				correcto = true;
				for(Producto producto : productos) {
					if(producto.getCodigo()==codigo) {
						productoEncontrado=producto;
					}
				}
				} catch (InputMismatchException ex) {
				System.out.println("SOLO SE PERMITEN CODIGOS CONFORMADOS POR NUMEROS ENTEROS! ");
				sc.next();
				}
		}while(correcto == false);
		
		return productoEncontrado;
	}
	/*
	 * CARGA OBJETOS PRODUCTO AL ARRAYLIST PRODUCTOSCOMPRADOS
	 */
	public static void cargarProductosComprados(Producto producto) {
		if (producto==null) {
			System.out.println("EL CODIGO DE PRODUCTO NO EXISTE.");
		}else {
			if(producto.isEstado()==false)
			{	
				System.out.println("===========================================");
				System.out.println("NO HAY STOCK DISPONIBLE PARA ESTE PRODUCTO.");
				System.out.println("===========================================");
			}else {
				if (productosComprados == null) {
					productosComprados = new ArrayList<>();
				}
				productosComprados.add(producto);
				System.out.println("=========================================");
				System.out.println("PRODUCTO AGREGADO A SU CARRITO DE COMPRA.");
				System.out.println("=========================================");
			}
		}
		
	}
	/*
	 * VERIFICA QUE EL ARRAYLIST DE PRODUCTOSCOMPRADOS CONTENGA OBJETOS CARGADOS.
	 * CREA EL OBJETO PAGOTARJETA O PAGOEFECTIVO DE ACUERDO A LA SELECCION DEL USUARIO.
	 */
	public static void pagarProductos() {
		double monto=0;
		int opcion=0;
		if(productosComprados==null || productosComprados.isEmpty()) {
			System.out.println("=============================");
			System.out.println("NO SE COMRPO NINGUN PRODUCTO.");
			System.out.println("=============================");
		}else {
		for(Producto producto : productosComprados) {
			monto=monto+producto.getPrecioUnitario();
		}
		opcion=generarMenuPago();
		if(opcion==1) {
			System.out.println("Ingrese el numero de la tarjeta: ");
			String tarjeta = sc.next();
			PagoTarjeta pagoT = new PagoTarjeta(tarjeta, LocalDate.now(), monto);
			pagoT.realizarPago(monto);
			pagoT.imprimirRecibo();	
		}else {
			PagoEfectivo pagoE = new PagoEfectivo(monto, LocalDate.now());
			pagoE.realizarPago(monto);
			pagoE.imprimirRecibo();
		}
		}
	}
	/*
	 * GENERAR MENU DE FORMA DE PAGO
	 */
	public static int generarMenuPago() {
		boolean correcto=false;
		int opcion=0;
		sc=new Scanner(System.in);
		do {
			System.out.println("----------FORMA DE PAGO----------");
			System.out.println("1 - Pago con Tarjeta de credito.");
			System.out.println("2 - Pago en efectivo.");
			System.out.println("Ingrese opcion: ");
			try {
				opcion = sc.nextInt();
				sc.nextLine();
				if(opcion != 1 && opcion != 2) {
					System.out.println("OPCION INCORRECTA.");
				}else {
					correcto=true;
				}
			} catch (InputMismatchException e) {
				System.out.println("OPCION INCORRECTA.");
				sc.nextLine();
			}
		}while(correcto == false);
		return opcion;
	}
	/*
	 * 
	 */
	
}
