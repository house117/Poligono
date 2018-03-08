package Poligono;
public class PoligonoIrregular extends Poligono{
	int verticeActual;
	public PoligonoIrregular (Integer numeroDeLados) {
		super(numeroDeLados);
		verticeActual = 0;
		//ladoArreglo = new Linea[numeroDeLados];
	}
	//Agrega un nuevo vertice si la nueva linea no se intersecta con las anteriores.
	public void addVertice(Punto vertice) {
		Boolean intersectan = false;
		if(verticeActual > 2) {
			for(int i=1; i<verticeActual; i++) {
				if(this.segmentsIntersect(vertice, verticeArreglo[verticeActual-1], verticeArreglo[i], verticeArreglo[i-1])) {
					intersectan = true;
				}
			}
				//Integer voyParaAtras = verticeActual;

		}

		if(!intersectan) {
			if(verticeActual>=0 && verticeActual<=super.getNumeroDeLados()-1) {
				System.out.println("No intersectan, vertice agregado");
				verticeArreglo[verticeActual] = new Punto();
				verticeArreglo[verticeActual].setX(vertice.getX());
				verticeArreglo[verticeActual].setY(vertice.getY());
				verticeActual++;
				/*for(int i=0;i<this.verticeActual;i++) {
					System.out.printf("Vertice %d en coordenadas (%.2f , %.2f)\n",i, verticeArreglo[i].getX(), verticeArreglo[i].getY());
				}*/
			}
		}
	}
	public Boolean segmentsIntersect(Punto p1, Punto p2, Punto p3, Punto p4) {
		double d1 = direction(p3, p4, p1);
		double d2 = direction(p3, p4, p2);
		double d3 = direction(p1, p2, p3);
		double d4 = direction(p1, p2, p4);
		if(((d1 > 0 && d2 < 0) || (d1 < 0 && d2 >0)) && ((d3 > 0 && d4 < 0 ) || (d3 < 0 && d4 >0)))
		return true;
		else if( (d1 == 0) && onSegment(p3, p4, p1) )
			return true;
		else if( (d2 == 0) && onSegment(p3, p4, p2) )
			return true;
		else if( (d3 == 0) && onSegment(p1, p2, p3) )
			return true;
		else if( (d4 == 0) && onSegment(p1, p2, p4) )
			return true;
		else return false;
	}
	
	//(p1-p0)x(p2-p0) = (X1-x0)(y2-y0)-(x2-x0)(y1-y0)
	//(pk-pi)x(pj-pi) = (xk-xi)(yj-yi)-(xj-xi)(yk-yi)
	public double direction(Punto pi, Punto pj, Punto pk) {
		//(pk-pi)x(pj-pi) = (xk-xi)(yj-yi)                -        (xj-xi)(yk-yi)
		return (pk.getX()-pi.getX())*(pj.getY()-pi.getY())-(pj.getX()-pi.getX())*(pk.getY()-pi.getY());

	}
	public boolean onSegment(Punto i, Punto j, Punto k) {
		Boolean A = Math.min(i.getX(),j.getX()) <= k.getX();
		Boolean B = k.getX() <= Math.max(i.getX(), j.getX());
		Boolean C = Math.min(i.getY(), j.getY()) <= k.getY();
		Boolean D = k.getY() <= Math.max(i.getY(), j.getY());
		if(A && B && C && D) {
			return true;
			
		}else {
			return false;
		}		
	}
	
}
