package formes;

import java.util.Random;
import java.util.Scanner;

public class SacDot {

	public int tailleSac = 2;
	public int tailleTab = 4;
	Formes[][] tab2d = new Formes[tailleSac][tailleSac];

	Random r = new Random();
	int dim;
	Formes[] tab = new Formes[tailleTab];

	/*
	 * La methode qui va me permettre de généerer des formes aléatoirement
	 */
	public Formes[] formes_genrer() {
		int i = 0;
		int d;
		while (i < tailleTab) {
			d = r.nextInt(6);
			switch (d) {
			case 0:
				tab[i] = new Carres("car", 2);
				break;
			case 1:
				tab[i] = new Cylindres("cyl", 3);
				break;
			case 2:
				tab[i] = new Cubes("cub", 3);
				break;
			case 3:
				tab[i] = new Cercles("cer", 3);
				break;
			case 4:
				tab[i] = new Spheres("sph", 3);
				break;
			case 5:
				tab[i] = new Glomes("Glo", 4);
				break;

			}
			System.out.println(i + " - " + tab[i].nom + " base=" + Math.round(tab[i].getBase() * 10.0) / 10.0);
			i++;
		}

		return tab;
	}

	/* Ici on initialise notre sac a dot a vide */
	public SacDot() {
		for (int i = 0; i < tailleSac; i++) {
			for (int k = 0; k < tailleSac; k++) {
				tab2d[i][k] = new Formes();

			}

		}
	}

	public Formes[][] remplir(Formes[] f) throws FormeNonEmpilable {
		Scanner sc = new Scanner(System.in);

		int i = 0;

		System.out.println();
		System.out.println("Le sac a remplir ...");
		affichage();
		while (!isSacPlein() && i < tailleTab) {
			Formes[] t = new Formes[tailleTab];

			System.out.println("Veuillez choisir le numero de la Formes que vous voulez empiler :");
			int valChoisi = sc.nextInt();
			if (valChoisi > tailleTab - 1 - i || valChoisi < 0) {
				System.out.println("ca n'esiste pas !!");
			} else {
				try {
					if (f[valChoisi].getDimension() != 3) {
						System.out.println("Veuillez choisir une autre forme ...");
						throw new FormeNonEmpilable("La dimension de cette forme n'est pas empilable");
					} else {

						System.out.println("Donnez le numero de la ligne ...");
						int ligne = sc.nextInt();
						System.out.println("Donnez le numero de la colonne ...");
						int colonne = sc.nextInt();
						if (ligne > tailleSac - 1 || colonne > tailleSac - 1) {
							System.out.println("ca n'exite pas cette case dans le sac !!");
						} else {
							if (ligne == tailleSac - 1) {
								if (tab2d[ligne][colonne].getNom() == "vide") {
									tab2d[ligne][colonne] = f[valChoisi];
									i++;
									f[valChoisi] = f[tailleTab - i];

								} else {
									System.out.println("cette case est occupée !!");
								}
							} else {
								if (tab2d[ligne + 1][colonne].getNom() == "vide") {
									throw new FormeNonEmpilable("Ce n'est pas possible la base de dessous est vide !!");
								}

								if (tab2d[ligne + 1][colonne].getBase() >= f[valChoisi].getBase()) {
									tab2d[ligne][colonne] = f[valChoisi];
									i++;
									f[valChoisi] = f[tailleTab - i];

								} else {
									try {
										String message = "Cette forme n'est pas empilable !!, sa base est plus grande par rapport a celle de dessous !!";
										throw new FormeNonEmpilable(message);

									} catch (FormeNonEmpilable f3) {

									}
								}
							}
						}

						System.out.println("Il vous reste " + (tailleTab - i) + " formes !!");
						test(f, tailleTab - i);

						for (int j = 0; j < tailleTab - i; j++) {
							System.out.println(
									j + " - " + f[j].nom + " base=" + Math.round(f[j].getBase() * 10.0) / 10.0);
							t[j] = f[j];

						}
						System.out.println();
						affichage();
					}
				} catch (FormeNonEmpilable f1) {
					System.out.println("Attention !!");

				}

			}
			/*
			 * if(!verifie(f)) {
			 * System.out.println("Il vous reste que les formes non emilable "); double v =
			 * VolumeDuSac(); System.out.println("Le volumes de sac a doc est : "+v);
			 * System.exit(0); }
			 */
		}
		VolumeDuSac();

		return tab2d;

	}

	/*
	 * public boolean verifie(Formes[] f) { boolean b = false; int i = 0; while (i <
	 * tailleTab && !b) { if (f[i].getDimension() == 3) { b = true; } i++; } return
	 * b; }
	 */

	/*
	 * Cette methode verifie si le sac est plein et il reste toujours des formes qui
	 * sont empilable
	 */
	public void test(Formes[] f, int t) {
		// todo
		boolean b = false;
		int i = 0;
		if (isSacPlein()) {
			while (!b && i < t) {
				if (f[i].getDimension() == 3) {
					b = true;
				}
				i++;
			}
			if (b) {
				System.out.println("trop de Formes.");
				System.out.println("Le volume du sac a dos est :" + VolumeDuSac());
				System.exit(0);
			}else {
				System.out.println("sac-à-dos suffisament grand.");
				System.out.println("Le volume du sac a dos est :" + VolumeDuSac());
				System.exit(0);
			}

		} else {
			while (!b && i < t) {
				if (f[i].getDimension() == 3) {
					b = true;
				}
				i++;
			}
			if (!b) {
				System.out.println("sac-à-dos trés grand.");
				System.out.println("Le volume du sac a dos est :" + VolumeDuSac());
				System.exit(0);
			}
		}

	}

	/*
	 * Cette methode vérifie si le sac est plein ou il reste encore des case vide
	 */
	public boolean isSacPlein() {

		boolean b = true;
		int i = 0;
		while (i < tailleSac && b) {
			if (tab2d[0][i].getNom() == "vide") {
				b = false;
			}
			i++;
		}
		return b;

	}

	public double VolumeDuSac() {

		double volum = 0;

		for (int i = 0; i < tailleSac; i++) {
			for (int k = 0; k < tailleSac; k++) {
				volum += tab2d[i][k].volume();

			}

		}
		return volum;

	}

	public void affichage() {
		String s = "";
		for (int i = 0; i < tailleSac; i++) {
			for (int j = 0; j < tailleSac; j++) {
				System.out.print(i + "[ " + tab2d[i][j].getNom() + ",base="
						+ Math.round(tab2d[i][j].getBase() * 10.0) / 10.0 + " ] ");
			}
			System.out.println();
			// System.out.println();
		}

	}

}
