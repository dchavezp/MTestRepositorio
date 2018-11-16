package episunsa;

public class Estudiante {
	private String id;
	private int cal;
	public Estudiante() {
		this.id="";
		this.cal=0;
	}
	public Estudiante(String id) {
		this.id=id;
		this.cal=0;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if(id.length()<=9&&id.length()>=0)
			this.id = id;
		System.err.println("Error al ingresar id");
		
	}
	public int getCal() {
		return cal;
	}
	public void setCal(int cal) {
		assert cal>=0 && cal<=10;
		this.cal = cal;
		
	}


}
