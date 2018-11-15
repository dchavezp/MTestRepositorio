package episunsa;

import java.util.ArrayList;
import java.util.Scanner;

public class PreguntasExamen {
	private int numP;
	private ArrayList<String> preguntas;
	private static String id = "2";
	private int numreg = 0;
	private Scanner s;

	public PreguntasExamen() {
		this.numP = 0;
		this.preguntas = new ArrayList<>();
		this.numreg = (numP / 50) + 1;
	}

	public PreguntasExamen(int numP) {
		assert numP < 999 && numP > 0;
		this.numP = numP;
		this.numreg = (numP / 50) + 1;
		this.preguntas = new ArrayList<>();

	}

	public int getNumP() {
		return numP;
	}

	public void setNumP(int numP) {
		this.numP = numP;
	}

	public ArrayList<String> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas() {
		int np = this.numP;
		int ti = this.numreg;
		System.out.println("Ingrese Respuestas de Preguntas");
		s = new Scanner(System.in);
		do {
			if (np % 50 == 0 && np!=0) {
				String val = s.nextLine();
				if (val.length() == 50 && !val.contains(" ")) {
					this.preguntas.add(val);
					ti--;
					np = np - 50;
				} else {
					System.out.println("Error al ingresar cadena!");
				}
			} else {
				String val = s.nextLine();
				if ((val.length() == np % 50 || val.length() == 50) && !val.contains(" ")) {
					this.preguntas.add(val);
					ti--;
					np = np - val.length();
				} else {
					System.out.println("Error al ingresar cadena!");
				}
			}
		} while (ti > 0 && np > 0);
	}

	@Override
	public String toString() {
		int np = this.numP;
		int ni = this.numreg;
		String c49 = "-----";
		String c6079 = "-------------------";
		if (np < 51) {
			return this.numP + c49 + this.preguntas.get(0) + c6079 + PreguntasExamen.id;
		} else {
			String reg = this.numP + c49 + this.preguntas.get(0) + c6079 + PreguntasExamen.id + "\n";
			for (int i = 1; i<ni ; i++) {
				reg = reg + "---" + c49 + this.preguntas.get(i) + c6079 + PreguntasExamen.id + "\n";
			}
			return reg;
		}
	}

	public int getNumR() {
		return this.numreg;
	}
	
	public ArrayList<String> listR(){
		return this.preguntas;
	}

}
