package formes;

import java.util.Random;

public class Spheres extends Formes implements Volume {
	private double rayon;
	private double base;

	Random r = new Random();

	public Spheres(String nom, int dim) {
		super(nom, dim);
		this.rayon = r.nextDouble();
		this.base = 0.0;
		super.setBase(base);
	}

	@Override
	public double volume() {
		double v;
		v = 4 / 3 * Math.PI * rayon * rayon * rayon;
		return v;
	}

	public double getRayon() {
		rayon = r.nextDouble();
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

}
