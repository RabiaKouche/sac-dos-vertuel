package formes;

import java.util.Random;

public class Glomes extends Formes implements Volume {
	private final int dimension = 4;
	private final double base = 0.0;
	private double rayon;

	Random r = new Random();

	public Glomes(String nom, int dim) {
		super(nom, dim);
	}

	public int getDimension() {
		return dimension;
	}

	public double getRayon() {
		rayon = r.nextDouble();
		return rayon;
	}

	@Override
	public double volume() {
		double v = 0.5 * getRayon() * Math.PI * Math.PI;
		return v;
	}

}
