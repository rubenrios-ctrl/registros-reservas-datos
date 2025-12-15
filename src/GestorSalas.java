
public class GestorSalas {

    private ListaSalas salas;
    private Cola colaEspera;

    public GestorSalas(ListaSalas salas) {
        this.salas = salas;
        this.colaEspera = new Cola();
    }

    public void registrarUsuario(String carnet, String nombre) {
        if (ListaUsuarios.buscar(carnet) != null) {
            System.out.println("El usuario con carnet " + carnet + " ya está registrado.");
        } else {
            Usuario u = new Usuario(carnet, nombre);
            ListaUsuarios.add(u);
            System.out.println("Usuario registrado: " + u);
        }
    }

    public Usuario ocuparSala(String carnet) {
        Usuario u = ListaUsuarios.buscar(carnet);
        if (u == null) {
            System.out.println("Usuario con carnet " + carnet + " no está registrado. Regístralo primero.");
            return null;
        }

        Sala libre = buscarSalaLibre();
        if (libre != null) {
            libre.setEstado("Ocupada");
            System.out.println("Sala " + libre.getID() + " asignada al usuario: " + u.getNombre() + " (" + carnet + ")");
            return u;
        } else {
            colaEspera.encolar(carnet);
            System.out.println("No hay salas libres. Usuario " + u.getNombre() + " (" + carnet + ") en cola de espera.");
            return null;
        }
    }

    public void desocuparSala(int idSala) {
        Sala aux = salas.getPrimerNodo();
        while (aux != null) {
            if (aux.getID() == idSala) {
                aux.setEstado("Libre");
                System.out.println("Sala " + idSala + " desocupada.");

                if (!colaEspera.estaVacia()) {
                    String carnet = colaEspera.desencolar();
                    Usuario u = ListaUsuarios.buscar(carnet);
                    aux.setEstado("Ocupada");
                    System.out.println("Sala " + idSala + " asignada al usuario en espera: " + u.getNombre() + " (" + carnet + ")");
                }
                return;
            }
            aux = aux.getSiguiente();
        }

        System.out.println("Sala no encontrada.");
    }

    private Sala buscarSalaLibre() {
        Sala aux = salas.getPrimerNodo();
        while (aux != null) {
            if (aux.getEstado().equals("Libre")) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public ListaSalas getSalas() {
        return salas;
    }

    public Cola getColaEspera() {
        return colaEspera;
    }

}

