package episunsa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class MTest {
	private PreguntasExamen pe;
	private String titulo;
	private RespuestaEstudiante re;
	private double media;
	private double mediana;
	private double varianza;
	private Scanner s;
	private int numEst = 0;
	private int numPrg = 0;

	public MTest() {
		System.out.println("-------------MTEST---------------");
		System.out.println("-------------Bienvenido---------------");
		this.mediana = 0.0;
		this.media=0.0;
		this.varianza = 0.0;
		this.titulo = "";
	}

	public MTest(int nestd, int np) {
		this.pe = new PreguntasExamen(np);
		this.re = new RespuestaEstudiante(pe, nestd);
		this.mediana = 0.0;
		this.varianza = 0.0;
		this.media=0.0;
		this.titulo = "";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo() {
		s = new Scanner(System.in);
		String tit;
		while (this.titulo.length() == 0) {
			tit = s.nextLine();
			assert titulo.length() == 0;
			if (tit.length() < 81 && tit.length() <= 0) {
				System.out.println("Error al Establecer titulo ingrese de nuevo!");
			} else {
				this.titulo = tit;
				break;
			}
		}
	}
	public void setTitulo(String tit) {
//		assert titulo.length() != 0;
		if (tit.length() < 81 && tit.length() <= 0) {
			System.err.println("Error al Establecer titulo ingrese de nuevo!");
		} else {
			this.titulo = tit;
		}
	}
	public int getNumEstd() {
		return numEst;
	}

	public void setNumEstd() {
		s = new Scanner(System.in);
		int ne;
		while (numEst == 0) {
			System.out.println("Ingrese numero de estudiantes");
			ne = s.nextInt();
			assert ne >= 0;
			if (ne <= 0 || ne >= 200) {
				System.out.println("Error al Establecer numero de estudiantes ingrese de nuevo!");
			} else {
				this.numEst = ne;
				break;
			}
		}
		s = null;
	}
	public void setNumEstd(int ne) {
		assert ne != 0;
		if (ne <= 0 || ne > 200) {
			System.err.println("Error al Establecer numero de estudiantes!");
		} else {
			this.numEst = ne;
		}
	}
	public void setNumPreguntas() {
		s = new Scanner(System.in);
		try {
			int nup;
			while (this.numPrg == 0) {
				System.out.println("Ingrese numero de preguntas");
				nup = s.nextInt();
				assert nup >= 0;
				if (nup <= 0 || nup >= 1000) {
					System.out.println("Error al Establecer numero de preguntas ingrese de nuevo!");
				} else {
					this.numPrg = nup;
					break;
				}
			}
			s = null;
		}
		catch(Exception e){
			 System.out.print("Type a Number, Not String");
		}
	}
	public int getNumPreguntas() {
		return numPrg;
	}
	public void setNumPreguntas(int nup) {
		assert nup != 0;
		if (nup <= 0 || nup >= 1000) {
			System.err.println("Error al Establecer numero de preguntas!");
		} else {
			this.numPrg = nup;
		}
	}
	public double getMediana() {
		return mediana;
	}

	public void setMediana() {
		assert re.listEstudiantes()!=null;
		if (getNumEstd() % 2 == 0) {
			int sumaMedios = re.listEstudiantes().get(getNumEstd() / 2).getCal()
					+ re.listEstudiantes().get(getNumEstd() / 2 - 1).getCal();
			this.mediana = sumaMedios / 2;
		} else {
			this.mediana = re.listEstudiantes().get(getNumEstd() / 2).getCal();
		}
	}

	public double getVarianza() {
		return varianza;
	}

	public void setVarianza() {
		assert re.listEstudiantes()!=null;
		setMedia();
		double vr = 0.0;
		for (int i = 0; i < numEst; i++) {
			double rango;
			rango = Math.pow(re.listEstudiantes().get(i).getCal() - this.media, 2f);
			vr = vr + rango;
		}
		this.varianza=vr/numEst;
	}

	public void iniciar() {
		this.setNumPreguntas();
		this.setNumEstd();
		this.pe = new PreguntasExamen(this.numPrg);
		this.re = new RespuestaEstudiante(this.pe, this.numEst);
		System.out.println("Ingrese titulo: ");
		this.setTitulo();
		System.out.println("Registros de Resolucion de Preguntas ");
		pe.setPreguntas();
		System.out.println(pe.toString());
		System.out.println("Registros de Respuestas de Estudiantes ");
		re.setEstudiantesRespuestas();
		System.out.println(re.toString());
		this.calificacionEstudiantes(re.listEstudiantes());
	}

	private void calificacionEstudiantes(ArrayList<Estudiante> le) {
		for (int i = 0; i < le.size(); i++) {
			for (int j = i * pe.getNumR(); j < i + (pe.getNumR()); j++) {
				le.get(i).setCal(setCalificacion(this.pe.getPreguntas().get(i % pe.getNumR()), this.re.listR().get(j)));
			}
		}
		this.re.setListEst(le);
	}

	public void reporteCalificacionesEstudiantes() {
		ArrayList<Estudiante> lt = re.listEstudiantes();
		for (Iterator<Estudiante> iterator = lt.iterator(); iterator.hasNext();) {
			Estudiante estudiante = (Estudiante) iterator.next();
			System.out.println("Id: " + estudiante.getId() + " Calificación: " + estudiante.getCal());
		}
	}

	public void reporteCalificacionesOrdenadas() {
		re.listEstudiantes().sort(new Comparator<Estudiante>() {
			@Override
			public int compare(Estudiante o1, Estudiante o2) {
				return Integer.valueOf(o1.getCal()).compareTo(Integer.valueOf(o2.getCal()));
			}
		});
		ArrayList<Estudiante> lt = re.listEstudiantes();
		for (int i = lt.size() - 1; i >= 0; i--) {
			System.out.println("Id: " + lt.get(i).getId() + " Calificación: " + lt.get(i).getCal());
		}

	}

	public void setMedia() {
		assert re.listEstudiantes()!=null;
		int sum = 0;
		ArrayList<Estudiante> lt = re.listEstudiantes();
		for (Iterator<Estudiante> iterator = lt.iterator(); iterator.hasNext();) {
			Estudiante estudiante = (Estudiante) iterator.next();
			sum = sum + estudiante.getCal();
		}
		this.media = sum / pe.getNumP();
	}

	public double getMedia() {
		return this.media;
	}

	public int setCalificacion(String re, String rp) {
		assert this.re.listEstudiantes()!=null;
		int total = 0;
		int cal;
		char[] resp = rp.toCharArray();
		char[] respE = re.toCharArray();
		for (int i = 0; i < resp.length; i++) {
			if (resp[i] == respE[i])
				total++;
		}
		cal=(total*10)/numPrg;
		return cal;
	}
	public ArrayList<Estudiante> getCal(){
		return re.listEstudiantes();
	}
}
