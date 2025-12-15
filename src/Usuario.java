
public class Usuario {
    private String carnet;  
    private String nombre;
    private Usuario siguiente;

    public Usuario(String carnet, String nombre) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.siguiente = null;
    }

	public String getCarnet() {
		return carnet;
	}


	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Usuario getSiguiente() {
		return siguiente;
	}


	public void setSiguiente(Usuario siguiente) {
		this.siguiente = siguiente;
	}

	@Override
    public String toString() {
        return "Usuario[carnet=" + carnet + ", nombre=" + nombre + "]";
    }
}
