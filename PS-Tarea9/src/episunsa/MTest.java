package episunsa;

import java.util.ArrayList;

public class MTest {
	private PreguntasExamen pe;
	private RespuestaEstudiante re;
	private double mediana;
	private double varianza;
	ArrayList<Integer> calfifaciones;
	
	public MTest() {
		this.pe=new PreguntasExamen();
		this.re=new RespuestaEstudiante();
		this.mediana=0.0;
		this.varianza=0.0;
		this.calfifaciones=new ArrayList<>();
	}
	public MTest(int ne,int np) {
		this.pe=new PreguntasExamen(np);
		this.re=new RespuestaEstudiante(pe,ne);
		this.mediana=0.0;
		this.varianza=0.0;
		this.calfifaciones=new ArrayList<>();
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
	public void inicializar() {
		pe.setPreguntas();
		System.out.println(pe.toString());
		re.setEstudiantesRespuestas();
		System.out.println(re.toString());
	}
	private int calificacion(String rp,String er) {
		return 0;
	}
}
