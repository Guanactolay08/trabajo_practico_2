package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	@Override
	public void realizarPago(double monto) {
		this.montoPagado = this.montoPagado+this.montoPagado*0.15;
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("=======================================");
		System.out.println("Numero de tarjeta: "+this.numeroTarjeta+"\nFecha de pago: "+this.fechaPago);
		System.out.println("Monto pagado: $"+this.montoPagado);
		System.out.println("=======================================");
	}
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

}
