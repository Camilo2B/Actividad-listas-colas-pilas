public class Historial {

    private Nodo actual;

    // Visitar nueva página
    public void visitar(String pagina) {
        Nodo nuevo = new Nodo(pagina);

        if (actual != null) {
            actual.siguiente = null; // elimina futuras
            nuevo.anterior = actual;
            actual.siguiente = nuevo;
        }

        actual = nuevo;
    }

    // Ir atrás
    public void atras() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
        } else {
            System.out.println("No hay pagina anterior");
        }
    }

    // Ir adelante
    public void adelante() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
        } else {
            System.out.println("No hay pagina siguiente");
        }
    }

    // Mostrar página actual
    public void mostrar() {
        if (actual == null) {
            System.out.println("No hay paginas");
        } else {
            System.out.println("Pagina actual: " + actual.pagina);
        }
    }
}