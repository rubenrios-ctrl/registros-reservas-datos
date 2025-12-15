
public class Cola {
    private NodoCola frente;
    private NodoCola fin;

    public Cola() {
        frente = null;
        fin = null;
    }

    public void encolar(String carnet) {
        NodoCola nuevo = new NodoCola(carnet);
        if (fin == null) {
            frente = nuevo;
            fin = nuevo;
        } 
        else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public String desencolar() {
        if (frente == null) {
            return null;
        }
        String valor = frente.getUsuario();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return valor;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}
