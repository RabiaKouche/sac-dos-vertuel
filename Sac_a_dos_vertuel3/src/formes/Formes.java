package formes;

import java.util.Random;

public class Formes {
	public String nom;
	private int dimension;
	private double base;
	private double volume;

	Random r = new Random();

	public Formes() {
		this.nom = "vide";
	}

	public Formes(String nom, int dimension) {
		this.nom = nom;
		this.dimension = dimension;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimention(int dimension) {
		this.dimension = dimension;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double volume() {
		return 0;
	}

}
