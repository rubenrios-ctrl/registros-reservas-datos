
public class Sala {
	private int ID;
	private String estado;
	private Sala siguiente;
	private Sala anterior;
	public Sala(int ID) {
		this.ID = ID;
		this.estado = "Libre";
		this.siguiente = null;
		this.anterior = null;
	}
	public Sala getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Sala siguiente) {
		this.siguiente = siguiente;
	}
	public Sala getAnterior() {
		return anterior;
	}
	public void setAnterior(Sala anterior) {
		this.anterior = anterior;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
