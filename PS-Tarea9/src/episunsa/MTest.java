package episunsa;
public class MTest {
	public static void main(String [] args) {
		PreguntasExamen pe=new PreguntasExamen(50);
		RespuestaEstudiante re=new RespuestaEstudiante(pe,2);
		pe.setPreguntas();
		System.out.println(pe.toString());
		re.setEstudiantesRespuestas();
		System.out.println(re.toString());
		
	}
}
