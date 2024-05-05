package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class Main {
	private static Consumer<Producto> printConsumerProd = p -> System.out.println(p);
	private static Scanner sc;
	private static List<Producto> productos;
	public static void main(String[] args) {
		precargarProductos();
		int opcion =0;
		do {
			opcion=generarMenu();
			switch(opcion) {
				case 1: mostrarProducto();break;
				case 2: mostrarProductosFaltantes();break;
				case 3: aumentarPrecios();break;
				case 4: mostrarElectrohogarTrue();break;
				case 5: ordenarPorPrecio();break;
				case 6: cambiarAMayusculas();break;
				case 7:System.out.println("FIN DEL PROGRAMA");break;
				
			}
		}while (opcion!=7);
		sc.close();
		
	}
	/*
	 * PRECARGA DE 15 PRODUCTOS
	 */
	public static void precargarProductos() {
		if (productos==null) {
			productos = new ArrayList<>();
		}
		productos.add(new Producto(1,"Celular Nokia 8" , 900000, OrigenFabricacion.CHINA, Categoria.TELEFONIA, false));
		productos.add(new Producto(2,"Celular Xperia X8" , 100000, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
		productos.add(new Producto(3,"Celular IPhone S" , 1000000, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true));
		productos.add(new Producto(4,"Celular Samsung J8 PRO" , 260000, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false));
		productos.add(new Producto(5,"Notebook ASUS X541" , 500000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		productos.add(new Producto(6,"Teclado Mecanico Marvo Kg962" , 50000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		productos.add(new Producto(7,"Kit Gamer 4 en 1 Marvo Cm409" , 80000, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, false));
		productos.add(new Producto(8,"Monitor PHILIPS LED 21.5" , 150000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		productos.add(new Producto(9,"Smart TV LED 52'' FHD PHILCO" , 450000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(10,"Lavavajillas Samnsung DW60M6050FS" , 350000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
		productos.add(new Producto(11,"Lavarropas DREAN Next 8.12" , 340000, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(12,"Calefactor LILIANA Tcv110d" , 230000, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto(13,"Soldador Inverter Daewoo 100Mma" , 155000, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto(14,"Amoladora Angular 820w Black Decker" , 100000, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto(15,"Soldador de estaño Dowen Tipo Pistola" , 99999, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true));
	}
	/*
	 * CONSTRUCCION DEL MENU.
	 */
	public static int generarMenu() {
		boolean correcto=false;
		int opcion=0;
		sc=new Scanner(System.in);
		do {
			System.out.println("***********MENU DE OPCIONES***********");
			System.out.println("1 - Mostrar productos.");
			System.out.println("2 - Mostrar los productos fatantes.");
			System.out.println("3 - Incrementar los precios de los productos en un 20%.");
			System.out.println("4 - Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta.");
			System.out.println("5 - Ordenar los productos por precio de foorma descendente.");
			System.out.println("6 - Mostrar los productos con los nombres en mayuscula.");
			System.out.println("7 - Salir.");
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
	 * MUESTRA OBJETOS DEL ARRAYLIST UTILIZANDO CONSUMER
	 */
	public static void mostrarProducto() {
		//Consumer<Producto> printConsumerProd = p -> System.out.println(p);
		List<Producto> productosDisponibles = new ArrayList<>();
		for(Producto producto : productos){
			if(producto.isEstado()) {
				productosDisponibles.add(producto);
			}
		}
		productosDisponibles.forEach(printConsumerProd);
		
	}
	/*
	 * MUESTRA OBJETOS DEL ARRAYLIST UTILIZANDO PREDICATE Y FILTER
	 */
	public static void mostrarProductosFaltantes() {
		Predicate<Producto> filterEstadoFalse = p -> !p.isEstado();
		productos.stream().filter(filterEstadoFalse).forEach(System.out::println);
	}
	/*
	 * MUESTRA OBJETOS DEL ARRAYLIST UTILIZANDO FUNTION Y MAP() AUMENTADO SUS PRECIOS UNITARIOS
	 */
	public static void aumentarPrecios() {
		Function<Producto, Producto> functionIncrementar = (p)->{
		float resultado = p.getPrecioUnitario() + (p.getPrecioUnitario()*0.2f);	
		p.setPrecioUnitario(resultado);
		return p;
		};
		List<Producto> productosIncrementados = new ArrayList<>();
		productosIncrementados = productos.stream().map(functionIncrementar).collect(Collectors.toList());
	    productosIncrementados.forEach(printConsumerProd);
	}
	/*
	 * MUESTRA OBJETOS DEL ARRAYLIST CON CATEGORIA ELECTROHOGAR 
	 * Y ESTADO TRUE
	 */
	public static void mostrarElectrohogarTrue() {
		Predicate<Producto> filterElectrohogarTrue = p -> p.isEstado() && p.getCategoria().equals(Categoria.ELECTROHOGAR);
		productos.stream().filter(filterElectrohogarTrue).forEach(System.out::println);
	}
	/*
	 * ORDENA LOS OBJETOS POR SU PRECIO USANDO SORT Y COMPARATOR.COMPARING
	 */
	public static void ordenarPorPrecio() {
		productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
		productos.forEach(printConsumerProd);
	}
	/*
	 * MUESTRA OBJETOS DEL ARRAYLIST UTILIZANDO FUNTION Y MAP() CAMBIANDO SUS NOMBRES A MAYUSCULA
	 */
	public static void cambiarAMayusculas() {
		Function<Producto, Producto> functionMayuscula = (p)->{
			String nombre = p.getDescripcion().toUpperCase();
			p.setDescripcion(nombre);
			return p;
			};
			productos.stream().map(functionMayuscula).forEach(printConsumerProd);		
	}

}
