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
		this.id = id;
	}
	public int getCal() {
		return cal;
	}
	public void setCal(int cal) {
		this.cal = cal;
	}


}
