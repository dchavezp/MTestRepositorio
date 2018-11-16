package episunsa;

import java.util.*;

public class RespuestaEstudiante {
	private ArrayList<Estudiante> estd;
	private ArrayList<String> idEstudiante;
	private ArrayList<String> respEstudiante;
	private int numP;
	private int numE;
	private static String id = "3";
	private int numreg;
	private Scanner s;

	public RespuestaEstudiante() {
		this.numP = 0;
		this.numE = 0;
		estd = new ArrayList<>();
	}

	public void setNumreg(int nump) {
		assert nump!=0;
		if(nump%50==0)
			this.numreg=nump/50;
		this.numreg = (nump/50)+1;
	}

	public RespuestaEstudiante(PreguntasExamen pe, int numE) {
		assert pe.getNumP() < 999 && pe.getNumP() > 0;
		assert numE < 999 && numE > 0;
		this.estd = new ArrayList<>();
		this.respEstudiante = new ArrayList<>();
		this.idEstudiante = new ArrayList<>();
		this.numP = pe.getNumP();
		this.numE = numE;
		setNumreg(numP);
	}

	public void setEstudiantesRespuestas() {
		String idE;
		String val;
		assert this.numreg != 0;
		int tiPorEstudiante = this.numreg / 2;
		int np = this.numP;
		int te = this.numE;
		s = new Scanner(System.in);
		do {
			System.out.println("Ingrese codigo Estudiante: ");
			idE = s.nextLine();
			if (idE.length() <= 9 && idE.length() >= 0 && !idE.contains(" ") && !idEstudiante.contains(idE)) {
				idEstudiante.add(idE);
				estd.add(new Estudiante(idE));
				do {
					System.out.println("Ingrese Cadena de Respuesta a Preguntas");
					val = s.nextLine();
					if (val.length() <= 50 && val.length() >= 0) {
						this.respEstudiante.add(val);
						tiPorEstudiante--;
						np = np - val.length();
					} else {
						System.out.println("Error al ingresar cadena!");
					}
				} while (tiPorEstudiante > 0 && np > 0);
				te--;
				tiPorEstudiante = this.numreg / 2;
			} else {
				System.out.println("Error al Ingresar codigo!");
			}
		} while (te > 0);
	}

	public void setEstudiantesRespuestas(ArrayList<String> er, ArrayList<Estudiante> es) {
		int numErr = 0;
		if (es.size() > 0 && es.size() < 201) {
			for (int i = 0; i < er.size(); i++) {
				if (er.get(i).length() > 50 || er.get(i).length() == 0) {
					System.err.println("Error en la cadena " + i + " ingresada");
					numErr++;
				}
			}
			if (numErr == 0) {
				this.respEstudiante = er;
				this.estd = es;
			}
		}
		this.respEstudiante = null;
		this.estd = null;

	}

	@Override
	public String toString() {
		int tiPorEstudiante = this.numreg / 2;
		int np = this.numP;
		int te = this.numE;
		String c6079 = "-------------------";
		String resp = "";
		for (int i = 0; i < te; i++) {
			if (np < 51) {
				resp = resp + this.idEstudiante.get(i) + "/" + this.respEstudiante.get(i) + c6079
						+ RespuestaEstudiante.id + "\n";
			} else {
				resp = resp + this.idEstudiante.get(i) + "/" + this.respEstudiante.get(i * tiPorEstudiante) + c6079
						+ RespuestaEstudiante.id + "\n";
				for (int j = 0; j < tiPorEstudiante; j++) {
					if (i == i * tiPorEstudiante)
						continue;
					resp = resp + "---------" + "/" + this.respEstudiante.get(j) + c6079 + RespuestaEstudiante.id
							+ "\n";
				}
			}

		}
		return resp;
	}

	public int getNumR() {
		return this.numreg;
	}

	public ArrayList<Estudiante> listEstudiantes() {
		return estd;
	}
	public void setNumPreguntas(int nup) {
		assert nup != 0;
		if (nup <= 0 || nup >= 1000) {
			System.err.println("Error al Establecer numero de preguntas!");
		} else {
			this.numP = nup;
		}
	}
	
	public ArrayList<String> listR() {
		return this.respEstudiante;
	}

	public void setListEst(ArrayList<Estudiante> le) {
		this.estd = le;
	}
}
