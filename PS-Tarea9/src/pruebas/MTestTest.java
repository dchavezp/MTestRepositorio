package pruebas;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import episunsa.Estudiante;
import episunsa.MTest;
import episunsa.RespuestaEstudiante;

public class MTestTest {
	MTest test;
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
	public void casoPrueba11() { // Respuesta correcta no hay 	*****************************
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
		RespuestaEstudiante registro = new RespuestaEstudiante();
		ArrayList<String> preguntas = new ArrayList<String>();
		ArrayList<Estudiante> estudiante = new ArrayList<Estudiante>();
		preguntas.add("a");
		estudiante.add(new Estudiante());
		registro.setEstudiantesRespuestas(preguntas, estudiante);
		System.out.println(registro.getNumR());
		assertTrue(preguntas.size() == registro.getNumR() * estudiante.size());
		
	//********************************************
	}
	
	@After
	public void destruir() {
		this.test = null;
	}
}
