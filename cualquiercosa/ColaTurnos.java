public class ColaTurnos {

    private Nodo frente;
    private Nodo fin;

    // Agregar cliente (enqueue)
    public void agregar(String cliente) {
        Nodo nuevo = new Nodo(cliente);

        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    // Atender cliente (dequeue)
    public void eliminar() {
        if (frente == null) {
            System.out.println("No hay clientes en espera");
            return;
        }

        System.out.println("Atendiendo a: " + frente.cliente);
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }
    }

    // Ver siguiente cliente
    public void buscar() {
        if (frente == null) {
            System.out.println("No hay clientes");
        } else {
            System.out.println("Siguiente: " + frente.cliente);
        }
    }

    // Mostrar lista
    public void mostrar() {
        if (frente == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo actual = frente;

        while (actual != null) {
            System.out.print(actual.cliente + " -> ");
            actual = actual.siguiente;
        }

        System.out.println("null");
    }
}