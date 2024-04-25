package ar.edu.unju.fi.ejercicio3.main;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {
	private static List<Provincia>provincias;
	
	public static void main(String[] args) {
		if (provincias == null) {
			provincias = new ArrayList<>();
		}
		//AGREGA CADA VALOR DEL ENUMARADO AL ARRAYLIST
		for (Provincia provincia : Provincia.values()) {
			provincias.add(provincia);
		}
		//MUESTRA LOS ELEMENTOS DEL ARRAYLIST
		for (Provincia provincia : provincias) {
			System.out.println("========================================");
			System.out.println("Provincia: "+provincia.name());
			System.out.println("Poblacion: "+provincia.getPoblacion());
			System.out.println("Superficie en km2: "+provincia.getSuperficie());
			System.out.println("Densidad poblacional: "+provincia.calcularDensidad()+" hab./km2");
			System.out.println("========================================");
		}
		
	}

}
