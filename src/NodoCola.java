
public class NodoCola {
        private String usuario;
        private NodoCola siguiente;
        public NodoCola(String usuario) {
            this.usuario = usuario;
            this.siguiente = null;
        }
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public NodoCola getSiguiente() {
			return siguiente;
		}
		public void setSiguiente(NodoCola siguiente) {
			this.siguiente = siguiente;
		}
}
