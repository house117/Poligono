package Poligono;

public class PoligonoRegular extends Poligono{
	private static final Double GRADOSCIRCULO = 360.0;
	//private static final Integer ANGULO = 72;
	//private Linea[] lado = new Linea[5]; //En el futuro para calcular los lados del pentagono
	private Punto centro;
	private Double anguloExterior;
	public PoligonoRegular(Integer numeroDeLados, Punto centro, Double longitudDeRadio, Double anguloInicial) {
		super(numeroDeLados);
		anguloExterior = GRADOSCIRCULO/numeroDeLados;
		this.setCentro(new Punto());
		this.getCentro().setX(centro.getX());
		this.getCentro().setY(centro.getY());
		setVerticesCentroVariable(this.getCentro(), longitudDeRadio, anguloInicial); //para poner vertices con centro a tu gusto.
	}
	public PoligonoRegular(Double longitudDeRadio, Double anguloInicial) { //centro origen, vertice inicial, angulo inical
		//centro.setX(0.0);;
		//centro.setY(0.0);
		setVerticesCentroOrigen(longitudDeRadio, anguloInicial);
	}
	/**
	 * @return the centro
	 */
	private Punto getCentro() {
		return centro;
	}
	/**
	 * @param centro the centro to set
	 */
	private void setCentro(Punto centro) {
		this.centro = centro;
	}
	/**
	 * @return the anguloExterior
	 */
	public Double getAnguloExterior() {
		return anguloExterior;
	}
	/*
	 *Calcula los vertices de acuerdo al centro en el origen
	 */
	public void setVerticesCentroOrigen(Double longitudDeLinea, Double anguloInicial) {
		for(int i=0; i<super.getNumeroDeLados(); i++) {
			verticeArreglo[i] = new Punto();
			if(getCuadranteAngulo(anguloInicial) == Cuadrante.I) {
				verticeArreglo[i].setX(catAdyacente(anguloInicial, longitudDeLinea));
				verticeArreglo[i].setY(catOpuesto(anguloInicial, longitudDeLinea));	
			}else if(getCuadranteAngulo(anguloInicial) == Cuadrante.II) {
				verticeArreglo[i].setX(-catAdyacente(180-anguloInicial, longitudDeLinea));
				verticeArreglo[i].setY(catOpuesto(180-anguloInicial, longitudDeLinea));
			}else if(getCuadranteAngulo(anguloInicial) == Cuadrante.III) {
				verticeArreglo[i].setX(-catAdyacente(anguloInicial-180, longitudDeLinea));
				verticeArreglo[i].setY(-catOpuesto(anguloInicial-180, longitudDeLinea));
			}else if(getCuadranteAngulo(anguloInicial) == Cuadrante.IV) {
				verticeArreglo[i].setX(catAdyacente(360-anguloInicial, longitudDeLinea));
				verticeArreglo[i].setY(-catOpuesto(360-anguloInicial, longitudDeLinea));
			}
			anguloInicial+=anguloExterior;
		}
	}
	/*
	 * Calcula los vértices de acuerdo a un centro variable.
	 */
	public void setVerticesCentroVariable(Punto centro,Double longitudDeLinea, Double anguloInicial) {
		setVerticesCentroOrigen(longitudDeLinea, anguloInicial);
		for(int i=0; i<super.getNumeroDeLados(); i++) {
			verticeArreglo[i].setX(verticeArreglo[i].getX()+centro.getX());
			verticeArreglo[i].setY(verticeArreglo[i].getY()+centro.getY());
		}
	}
	public static Double catOpuesto(Double angulo, Double longitudDeLinea) { //Funcion que calcula el cateto Opuesto (Y)
		Double catetoOpuesto = longitudDeLinea*Math.sin(Math.toRadians(angulo));
		return catetoOpuesto;
	}
	public static Double catAdyacente(Double angulo, Double longitudDeLinea) {//Funcion que calcula el cateto Adyacente (X)
		Double catetoAdyacente = longitudDeLinea*Math.cos(Math.toRadians(angulo));
		return catetoAdyacente;
	}
	public static Cuadrante getCuadranteAngulo(Double angulo) { //para verificar en que cuadrante esta el angulo
		if((angulo>=0 && angulo<90) || angulo == 360) {  // Cuadrante I [0,90) Ó 360
			return Cuadrante.I;
		}else if(angulo>=90 && angulo<180) {			 // Cuadrante II [90,180)
			return Cuadrante.II;
		}else if(angulo>=180 && angulo<270) {			// Cuadrante III [180,270)
			return Cuadrante.III;
		}else if(angulo>=270 && angulo<360) {			// Cuadrante IV [270,360)
			return Cuadrante.IV;
		}else {
			if(angulo<0) {								//Si angulo menor a 0 sumamos 360 hasta hacerlo positivo
				while(angulo<0)							//y asi sabremos en que cuadrante esta
					angulo+=360;
				return getCuadranteAngulo(angulo);     //llamamos de nuevo a la funcion que ahora se detendra en un if
			}else {										//y retornara un cuadrante y esta a su vez retornara un cuadrante
				while(angulo>360)						//lo mismo pero ahora restamos
					angulo-=360;
				return getCuadranteAngulo(angulo);
			}
		}
	}
	
}
