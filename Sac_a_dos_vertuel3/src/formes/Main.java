package formes;

public class Main {

	public static void main(String[] args) throws FormeNonEmpilable {
		SacDot s = new SacDot();
		Formes[][] tab;

		// double v = 0;
		System.out.println("L'ensemble des formes générées aléatoirement :");
		Formes t[] = s.formes_genrer();
		try {
			tab = s.remplir(t);

		} catch (FormeNonEmpilable e) {

		}
		// v = s.VolumeDuSac();
		// System.out.println(v);

	}

}
