
public class ListaSalas {
	private Sala primerNodo;
	private Sala ultimoNodo;
	private int size;
	public ListaSalas() {
		this.primerNodo = null;
		this.ultimoNodo = null;
		size=0;
	}
	public void addLast(Sala x) {
		if(primerNodo==null) {
			primerNodo=x;
			ultimoNodo=x;
		}
		else {
			ultimoNodo.setSiguiente(x);
			ultimoNodo=x;
		}
		size++;
	}
	public void addFirst(Sala x) {
		if(primerNodo==null) {
			primerNodo=x;
			ultimoNodo=x;
		}
		else {
			x.setSiguiente(primerNodo);
			primerNodo=x;
		}
		size++;
	}
	public void deleteFirst() {
		if(primerNodo==null) {
			System.out.println("Nada que eliminar");
		}
		else {
			primerNodo=primerNodo.getSiguiente();
			primerNodo.setAnterior(null);
			size--;
		}
	}
	public void deleteLast() {
		if(ultimoNodo==null) {
			System.out.println("Nada que eliminar");
		}
		else {
			ultimoNodo = ultimoNodo.getAnterior();
			ultimoNodo.setSiguiente(null);
			size--;
		}
		
	}
	public Sala getPrimerNodo() {
		return primerNodo;
	}
	public void setPrimerNodo(Sala primerNodo) {
		this.primerNodo = primerNodo;
	}
	public Sala getUltimoNodo() {
		return ultimoNodo;
	}
	public void setUltimoNodo(Sala ultimoNodo) {
		this.ultimoNodo = ultimoNodo;
	}
	public int size() {
		return size;
	}
}
