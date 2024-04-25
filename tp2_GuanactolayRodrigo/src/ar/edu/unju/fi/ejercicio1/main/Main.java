package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {
	private static Scanner sc;
	private static List<Producto> productos;
	
	public static void main(String[] args) {
		int opcion=0;
		
		do {
			opcion=generarMenu();
			switch(opcion) {
				case 1: cargarProducto();break;
				case 2: mostrarProductos();break;
				case 3: modificarProducto();break;
				case 4: System.out.println("FIN DEL PROGRAMA.");break;
				default: System.out.println("OPCION INVALIDA.");break;
			}
			
		}while(opcion != 4);
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
			System.out.println("1 - Crear productos.");
			System.out.println("2 - Mostrar productos.");
			System.out.println("3 - Modificar producto.");
			System.out.println("4 - Salir.");
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
	 * AGREGA UN OBJETO AL ARRAYLIST.
	 */
	public static void cargarProducto() {
	
		if(productos == null) {
			productos = new ArrayList<>();
		}
		int codigo = pedirCodigo();
		sc.nextLine();
		System.out.println("Ingrese descripcion del producto: ");
		String nombre = sc.nextLine();
		float precio = pedirPrecio();
		OrigenFabricacion origen = pedirOrigen();
		Categoria categoria = pedirCategoria();
		productos.add(new Producto(codigo, nombre, precio, origen, categoria));
		System.out.println("================================");
		System.out.println("PRODUCTO AGREGADO EXITOSAMENTE.");
		System.out.println("================================");
		
	}
	/*
	 * VERIFICA QUE EL CODIGO DE PRODUCTO INGRESADO SEA UN NUMERO ENTERO
	 */
	public static int pedirCodigo() {
			boolean correcto = false;
			int num = 0;
			do {
				System.out.println("Ingrese codigo del producto: ");
				try {
					num = sc.nextInt();
					correcto = true;
					} catch (InputMismatchException ex) {
					System.out.println("SOLO SE PERMITEN CODIGOS CONFORMADOS POR NUMEROS ENTEROS! ");
					sc.next();
					}
			}while(correcto == false);
			
			return num;
	}
	/*
	 * VERIFICA QUE EL PRECIO UNITARIO DEL PRODUCTO INGRESADO SEA UN NUMERO REAL
	 */
	public static float pedirPrecio() {
		boolean correcto = false;
		float num = 0;
		do {
			System.out.println("Ingrese precio unitario del producto: ");
			try {
				num = sc.nextFloat();
				correcto = true;
				} catch (InputMismatchException ex) {
				System.out.println("POR FAVOR INGRESE UN NUMERO REAL SEPARANDO DECIMALES CON ','! ");
				sc.next();
				}
		}while(correcto == false);
		return num;
	}
	/*
	 * SOLICITA Y DEVUELVE UN ENUMERADO ORIGEN DE FABRICACION SOLICITADO POR EL USUARIO
	 */
	public static OrigenFabricacion pedirOrigen() {
		boolean correcto = false;
		int num = 0;
		OrigenFabricacion origenF = null;
		do {
			int i=0;
			System.out.println("****Origen de fabricacion****");
			for(Producto.OrigenFabricacion origen: Producto.OrigenFabricacion.values()) {
				i++;
				System.out.println(i+" - "+origen);
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
		origenF = OrigenFabricacion.values()[num-1];
		return origenF;
	}
	/*
	 * SOLICITA Y DEVUEVE UN ENUMERADO CATEGORIA SOLICITADO POR EL USUARIO.
	 */
	public static Categoria pedirCategoria () {
		boolean correcto = false;
		int num = 0;
		Categoria categoriaF = null;
		do {
			int i=0;
			System.out.println("****Categorias****");
			for(Producto.Categoria categoria: Producto.Categoria.values()) {
				i++;
				System.out.println(i+" - "+categoria);
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
		categoriaF = Categoria.values()[num-1];
		return categoriaF;	
	}
	/*
	 * MUESTRA LOS OBJETOS GUARDADOS EN EL ARRAYLIST
	 */
	public static void mostrarProductos() {
		if ( productos == null) {
			System.out.println("=========================");
			System.out.println("LISTA DE PRODUCTOS VACIA.");
			System.out.println("=========================");
		}else {
			System.out.println("=======================================LISTA DE PRODUCTOS=======================================");
			productos.forEach(p->System.out.println(p));
		}
	}
	/*
	 * BUSCA Y DEVUELVE UN OBJETO POR SU CODIGO
	 */
	public static Producto buscarProducto() {
		int codigo = pedirCodigo();
		Producto productoEncontrado = null;
		
		for(Producto producto : productos ) {
			if(producto.getCodigo() == codigo) {
				productoEncontrado = producto;
			}
		}
		return productoEncontrado;
	}
	/*
	 * MODIFICA DATOS DE UN OBJETO DE LA ARRAYLIST
	 */
	public static void modificarProducto() {
		if (productos == null) {
			System.out.println("=========================");
			System.out.println("LISTA DE PRODUCTOS VACIA.");
			System.out.println("=========================");
		}else {
			Producto productoEncontrado = buscarProducto();
			if (productoEncontrado == null) {
				System.out.println("================================");
				System.out.println("EL CODIGO DE PRODUCTO NO EXISTE!");
				System.out.println("================================");
			}else {
				System.out.println("Ingrese descripcion del producto: ");
				sc.next();
				String descripcion = sc.nextLine();
				float precio = pedirPrecio();
				OrigenFabricacion origen = pedirOrigen();
				Categoria categoria = pedirCategoria();
				productoEncontrado.setDescripcion(descripcion);
				productoEncontrado.setPrecioUnitario(precio);
				productoEncontrado.setOrigen(origen);
				productoEncontrado.setCategoria(categoria);
			}
		}
		
	}
}
