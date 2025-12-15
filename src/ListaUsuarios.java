
public class ListaUsuarios {

    private static Usuario primero = null;
    private static int size = 0;

    public ListaUsuarios() {}

    public static void add(Usuario u) {
        if (u == null) return;

        if (buscar(u.getCarnet()) != null) return;

        u.setSiguiente(primero);
        primero = u;
        size++;
    }

    public static Usuario buscar(String carnet) {
        Usuario aux = primero;
        while (aux != null) {
            if (aux.getCarnet().equals(carnet)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public static Usuario getPrimero() {
        return primero;
    }

    public static int getSize() {
        return size;
    }

    public static boolean estaVacia() {
        return primero == null;
    }
}



