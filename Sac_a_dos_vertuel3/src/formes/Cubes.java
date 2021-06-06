package formes;

import java.util.Random;

public class Cubes extends Formes implements Volume {
	private float cote;
	double base;
	private int dimension = 3;

	Random r = new Random();

	public Cubes(String nom, int dim) {
		super(nom, dim);
		this.cote = (float) (r.nextDouble() + 1);
		this.base = cote * cote;
		super.setBase(base);
	}

	@Override
	public double volume() {
		double s;
		s = cote * getBase();
		return s;
	}

	public int getDimension() {
		return dimension;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

}
