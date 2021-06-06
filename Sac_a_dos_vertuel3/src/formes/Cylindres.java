package formes;

import java.util.Random;

public class Cylindres extends Formes implements Volume {

	private double hauteur;
	private double rayon;

	double base;

	Random r = new Random();

	public Cylindres(String nom, int dim) {
		super(nom, dim);
		this.rayon = r.nextDouble();
		this.hauteur = r.nextDouble();
		this.base = Math.PI * Math.pow(2, rayon) * hauteur + 1;
		super.setBase(base);

	}

	@Override
	public double volume() {
		double v;
		v = Math.PI * rayon * rayon * hauteur;
		return v;
	}

	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

}
