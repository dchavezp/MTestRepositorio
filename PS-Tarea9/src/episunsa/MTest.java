package episunsa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MTest {
	private PreguntasExamen pe;
	private String titulo;
	private RespuestaEstudiante re;
	private double mediana;
	private double varianza;
	private int numEstd;
	private Scanner s;
	private int numEst=0;
	private int numPrg=0;
	public MTest() {
		this.pe=new PreguntasExamen(this.numPrg);
		this.re=new RespuestaEstudiante(this.pe,this.numEst);
		this.mediana=0.0;
		this.varianza=0.0;
		this.titulo="";
	}
	public MTest(int nestd,int np) {
		this.pe=new PreguntasExamen(np);
		this.re=new RespuestaEstudiante(pe,nestd);
		this.mediana=0.0;
		this.varianza=0.0;
		this.titulo="";
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo() {
		s=new Scanner(System.in);
		String tit;
		while(this.titulo.length()==0) {
			tit=s.nextLine();
			assert titulo.length()==0;
			if(tit.length()<81&&tit.length()<=0) {
				System.out.println("Error al Establecer título ingrese de nuevo!");
			}
			else {
				this.titulo=tit;
				break;
			}
		}
	}
	public int getNumEstd() {
		return numEstd;
	}
	public void setNumEstd() {
		while(numEst==0) {
			
		}
		this.numEstd = numEstd;
	}

	public double getMediana() {
		return mediana;
	}
	public void setMediana(double mediana) {
		this.mediana = mediana;
	}
	public double getVarianza() {
		return varianza;
	}
	public void setVarianza(double varianza) {
		this.varianza = varianza;
	}
	public void iniciar() {
		System.out.println("Ingrese titulo: ");
		this.setTitulo();
		System.out.println("Registros de Resolución de Preguntas ");
		pe.setPreguntas();
		System.out.println(pe.toString());
		System.out.println("Registros de Respuestas de Estudiantes ");
		re.setEstudiantesRespuestas();
		System.out.println(re.toString());
		this.calificacionEstudiantes(re.listEstudiantes());
	}
	private void calificacionEstudiantes(ArrayList<Estudiante> le) {
		for (int i = 0; i < le.size(); i++) {
			for (int j = i*pe.getNumR(); j < i+pe.getNumR(); j++) {
				le.get(i).setCal(setCalificacion(this.pe.getPreguntas().get(i%pe.getNumR()), this.re.listR().get(j)));
			}
			
		}
	}
	public void reporteCalificacionesEstudiantes() {
		ArrayList<Estudiante> lt=re.listEstudiantes();
		for (Iterator iterator = lt.iterator(); iterator.hasNext();) {
			Estudiante estudiante = (Estudiante) iterator.next();
			System.out.println("Id: "+estudiante.getId()+" Calificación: "+estudiante.getCal());
		}
	}
	public void reporteCalificacionesOrdenadas() {
		
	}
	public void reportMME() {
		
	}
	public int setCalificacion(String re,String rp) {
		int total=0;
		char[] resp=rp.toCharArray();
		char[] respE=re.toCharArray();
		for (int i = 0; i < resp.length; i++) {
			if(resp[i]==respE[i])
				total++;
		}
		return total;
	}
}
