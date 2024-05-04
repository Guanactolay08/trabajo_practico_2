package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		//EJEMPLO
		/*
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),
		x.getEdad(), x.getPeso());
		
		FelinoSalvaje felino1 = converter.convert(gato);
		
		converter.mostrarObjeto(felino1);
		*/
		
		FelinoSalvaje felino = new FelinoSalvaje("Tanner", (byte)20, 186f);
		Converter<FelinoSalvaje, FelinoDomestico> converter2 = f -> new FelinoDomestico(f.getNombre(),
				f.getEdad(), f.getPeso());
		//VERIFICA QUE EL OBJETO NO ES NULO
		if (!Converter.isNotNull(felino)) {
			System.out.println("El objeto a convertir está vacio.");
		}else {
			FelinoDomestico felino2 = converter2.convert(felino);
			converter2.mostrarObjeto(felino2);
		}
		
	}

}
