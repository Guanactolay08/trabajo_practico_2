package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private float estatura;
	private float peso;
	private Posicion posicion;
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, float estatura,
			float peso, Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Jugador: " + nombre +" "+ apellido +"\nFecha de Nacimiento: " + fechaNacimiento
				+ "\nEdad: "+calcularEdad()+"\nNacionalidad: " + nacionalidad + "\nEstatura: " + estatura + "\nPeso: " + peso + "\nPosicion: "
				+ posicion+"\n==============================";
	}
	/*
	 * METODO PARA CALCULAR LA EDAD, RETORNA UN VALOR ENTERO.
	 */
	
	public int calcularEdad() {
		LocalDate fechaActual = LocalDate.now();
		int añoActual = fechaActual.getYear();
		int edad = añoActual - this.fechaNacimiento.getYear();
		if (this.fechaNacimiento.getMonthValue() > fechaActual.getMonthValue()) {
				edad=edad-1;
		}else {
			if(this.fechaNacimiento.getMonthValue() == fechaActual.getMonthValue() && (this.fechaNacimiento.getDayOfMonth()>fechaActual.getDayOfMonth()) ) {	
					edad=edad-1;
			}
		}	
		return edad;
	}
	
}
