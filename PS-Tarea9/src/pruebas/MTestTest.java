package pruebas;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import episunsa.Estudiante;
import episunsa.MTest;
import episunsa.PreguntasExamen;
import episunsa.RespuestaEstudiante;

public class MTestTest {
	MTest test;
	Estudiante estudiante;
	RespuestaEstudiante testRe;
	PreguntasExamen preguntasExa;
	@Before
	public void inicializar() {
		test = new MTest();
	}
	
	@Test
	public void casoPrueba1() {
		test.setTitulo("");
		test.setNumPreguntas(0);
		test.setNumEstd(0);
		fail("Error al Establecer titulo ingrese de nuevo!"); // deberia botar error dado que todo esta vacio
	}
	
	@Test
	public void casoPrueba2() {
		test.setTitulo("");
		String titulo = test.getTitulo();
		fail("Error al Establecer titulo ingrese de nuevo!"); // deberia botar error, dado que el titulo no puede ser vacio
	}
	
	@Test
	public void casoPrueba3() {
		test.setTitulo("a");
		String titulo = test.getTitulo();
		assertEquals(titulo.length(), 1);  // Deberia ser correcto minimo string titulo 1
	}
	
	@Test
	public void casoPrueba4() {
		test.setTitulo("12345678901234567890123456789012345678901234567890123456789012345678901234567890");
		String titulo = test.getTitulo();
		assertEquals(titulo.length(), 80); // Deberia ser correcto maximo numero de caracteres 80
	}
	
	@Test
	public void casoPrueba5() { // Examen 1 pregunta
		test.setTitulo("a");
		test.setNumPreguntas(1);
		int preguntas = test.getNumPreguntas();
		assertEquals(preguntas, 1); 
	}
	
	@Test
	public void casoPrueba6() { // Examen 50 preguntas
		test.setTitulo("a");
		test.setNumPreguntas(50);
		int preguntas = test.getNumPreguntas();
		assertEquals(preguntas, 50); 
	}
	
	@Test
	public void casoPrueba7() { // Examen 51 preguntas
		test.setTitulo("a");
		test.setNumPreguntas(51);
		int preguntas = test.getNumPreguntas();
		assertEquals(preguntas, 51); 
	}
	
	@Test
	public void casoPrueba8() { // Examen 999 preguntas
		test.setTitulo("a");
		test.setNumPreguntas(999);
		int preguntas = test.getNumPreguntas();
		assertEquals(preguntas, 999); 
	}
	
	@Test
	public void casoPrueba9() { // Examen 0 pregunta
		test.setTitulo("a");
		test.setNumPreguntas(0);
		int preguntas = test.getNumPreguntas();
		fail("Error al Establecer numero de preguntas!"); 
	}
	
	@Test
	public void casoPrueba10() { // Numero preguntas no numerico
		test.setTitulo("a");
		test.setNumPreguntas(1);
		fail("Type a Number, Not String"); 	
	}
	
	@Test
	public void casoPrueba11() {
		test.setTitulo("a");
		fail("Error al Establecer numero de preguntas!"); 
	}
	
	@Test
	public void casoPrueba14() { // 0 estudiantes
		test.setNumEstd(0);
		fail("Error al Establecer numero de estudiantes!"); 
	}
	
	@Test
	public void casoPrueba15() { // 1 estudiantes
		test.setNumEstd(1);
		int estu = test.getNumEstd();
		assertEquals(estu, 1); 
	}
	
	@Test
	public void casoPrueba16() { // 200 estudiantes
		test.setNumEstd(200);
		int estu = test.getNumEstd();
		assertEquals(200, estu); 
	}
	
	@Test
	public void casoPrueba17() { // 201 estudiantes
		test.setNumEstd(201);
		fail("Error al Establecer numero de estudiantes!"); 
	}
	
	@Test
	public void casoPrueba18() { // 1 solo registro de respuestas pero 2 respuestas
		
		PreguntasExamen pe=new PreguntasExamen(1);
		ArrayList<String> respEs = new ArrayList<String>();
		ArrayList<Estudiante> estudiante = new ArrayList<Estudiante>();
		estudiante.add(new Estudiante());
		RespuestaEstudiante registro = new RespuestaEstudiante(pe,estudiante.size());
		registro.setEstudiantesRespuestas(respEs, estudiante);
		assertTrue(registro.getNumR() == registro.getNumR() * estudiante.size());
	}
	
	@Test
	void casoprueba26() {
		estudiante = new Estudiante("a");
		assertEquals(0, estudiante.getCal());	
	}
	
	@Test
	void casoprueba27() {
		estudiante = new Estudiante("a");
		int aa=10;
		estudiante.setCal(aa);
		assertEquals(10, estudiante.getCal());
	}
	
	@Test
	void casoprueba28() {
	  test = new MTest();
	  test.setNumEstd(3);
	  testRe =new RespuestaEstudiante();
	 // testRe.setEstudiantesRespuestas(); 
	  //test.reporteCalificacionesEstudiantes();
	}
	
	@Test
	void casoprueba29() {
		estudiante = new Estudiante();
		estudiante.setId("999999999");
		assertEquals("999999999",estudiante.getId());   		
	}
	
	void casoprueba32() {
		preguntasExa = new PreguntasExamen();
		preguntasExa.setNumP(3);		
	}
	
	void prueba36() {
		System.out.println("todos los estudiantes cntestan la pregunta 1 correctmente");	
	}
	
	@After
	public void destruir() {
		this.test = null;
	}
}
