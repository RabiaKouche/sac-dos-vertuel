package formes;

import java.util.Random;

public class Cercles extends Formes implements Surface{
private double rayon;
 final double p =3.14;
 double base;
 private int dimension = 2;
 Random r = new Random();
	public Cercles(String nom, int dim){
		super(nom,dim);
		this.base = 0.0;
		this.rayon = r.nextDouble();
		
		
	}

	@Override
	public double surface() {
		double s;
		s = rayon*rayon*p;
		// TODO Auto-generated method stub
		return s;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	public int getDimension() {
		return dimension;
	}

	
	
	

}
