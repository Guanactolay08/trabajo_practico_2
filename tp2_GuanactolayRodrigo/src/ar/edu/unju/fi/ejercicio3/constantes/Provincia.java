package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	//DATOS RECAUDADOS DEL INSTITUTO GEOGRAFICO NACIONAL-MINISTEREIO DE DEFENSA
		JUJUY(770881,53244.2), SALTA(1424397,155340.5), TUCUMAN(1694656,22592.1), 
		CATAMARCA(415328,101486.1), LA_RIOJA(393531,91493.7), SANTIAGO_DEL_ESTERO(978313,136934.3);
		private double superficie;
		private int poblacion;
		
		private Provincia(int poblacion, double superficie) {
			this.superficie = superficie;
			this.poblacion = poblacion;
		}

		public double getSuperficie() {
			return superficie;
		}

		public void setSuperficie(double superficie) {
			this.superficie = superficie;
		}

		public int getPoblacion() {
			return poblacion;
		}

		public void setPoblacion(int poblacion) {
			this.poblacion = poblacion;
		}
		public float calcularDensidad() {
			double densidadB=this.poblacion/this.superficie;
			float densidad = (float)densidadB;
			return densidad;
		}
		
}
