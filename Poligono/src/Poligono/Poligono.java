package Poligono;

public abstract class Poligono {
	private Integer numeroDeLados;
	protected Punto[] verticeArreglo;
	//private Linea[] ladoArreglo;
	public Poligono () { }
	public Poligono (Integer numeroDeLados) {
		this.setNumeroDeLados(numeroDeLados);
		verticeArreglo = new Punto[numeroDeLados];
		//ladoArreglo = new Linea[numeroDeLados];
	}
	public Integer getNumeroDeLados() {
		return numeroDeLados;
	}
	public void setNumeroDeLados(Integer numeroDeLados) {
		this.numeroDeLados = numeroDeLados;
	}
	public void showVertices() { //Mostrar vertices
		for(int i=0;i<this.getNumeroDeLados();i++) {
			System.out.printf("Vertice %d en coordenadas (%.2f , %.2f)\n",i, verticeArreglo[i].getX(), verticeArreglo[i].getY());
		}
	}//No recomendable para irregular (aun)
	

	
	
}
