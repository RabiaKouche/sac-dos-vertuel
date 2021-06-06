package formes;

import java.util.Random;

public class Carres extends Formes implements Surface {
	private double cote;
	private double base;
	private final int dimension = 4;

	Random r = new Random();

	public Carres(String nom, int dim) {
		super(nom, dim);
		this.cote = r.nextDouble() + 1;
		this.base = cote * cote;
		super.setBase(base);
	}

	@Override
	public double surface() {
		double s;
		s = cote * cote;
		return s;

	}

	public double getCote() {
		return cote;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public int getDimension() {
		return dimension;
	}

}
