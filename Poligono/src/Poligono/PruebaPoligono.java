package Poligono;

public class PruebaPoligono {
	public static void main(String[] args) {
		/*Ejemplo con dodecaedro, clase PoligonoRegular*/
		//Breve explicacion del constructor:
		//(numeroDeLados, Punto para el centro, radio, anguloDeInclinacionInicial)
		PoligonoRegular dodecaedrito = new PoligonoRegular(12, new Punto(0.0, 0.0), 5.0, 0.0);
		//PoligonoRegular funciona muy bien.
		System.out.println("Vertices del dodecaedro");
		dodecaedrito.showVertices();
		System.out.println();
		
		
		
		PoligonoIrregular loQueSea = new PoligonoIrregular(4);
		//Prueba de cruce entre líneas, aunque esta clase debería ser PRIVADA.
		//Realiza la prueba con las rectas: P1P2: ((0,3),(3,0)) P3P4: ((0,0),(1,1)), que NO cruzan
		System.out.println("Prueba de cruze de lineas independientes del poligono irregular: ");
		if(loQueSea.segmentsIntersect(new Punto(3.0, 0.0), new Punto(0.0, 3.0), new Punto(0.0, 3.0), new Punto(3.0, 3.0))) {
			System.out.println("Cruzan!!");
		}else {
			System.out.println("No cruzan, funciono!!!!");
		}
		//Prueba para el metodo que no permite que agreges un nodo que cree una linea que cruce
		//Con las anteriores, funciona a partir de que ya tienes una linea, o sea 2 vertices
		loQueSea.addVertice(new Punto(0.0, 0.0));

		loQueSea.addVertice(new Punto(3.0, 3.0));

		loQueSea.addVertice(new Punto(0.0, 3.0));
		//No agrega el nodo pues las lineas que los forman se intersectan.
		//Aun falta decirle a segmentsIntersect que ignore cuando se intersectan en extremos.
		//Pero ya funciona detectando cruces de línea sin problema.
		loQueSea.addVertice(new Punto(0.0, 3.0));
		
		
	}
}
