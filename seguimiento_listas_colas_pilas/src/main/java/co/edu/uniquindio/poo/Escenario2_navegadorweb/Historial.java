package co.edu.uniquindio.poo.Escenario2_navegadorweb;

public class Historial<T> {

    private Nodo<T> actual;

    public Historial() {
        this.actual = null;
    }

    public void visitar(T item) {
        Nodo<T> nuevo = new Nodo<>(item);

        if (actual != null) {
            actual.setProximo(null); 
            
            nuevo.setAnterior(actual);
            actual.setProximo(nuevo);
        }

        actual = nuevo;
    }

    public void atras() {
        if (actual != null && actual.getAnterior() != null) {
            actual = actual.getAnterior();
            System.out.println("Retrocediendo a: " + actual.getValor());
        } else {
            System.out.println("No hay historial anterior.");
        }
    }

    public void adelante() {
        if (actual != null && actual.getProximo() != null) {
            actual = actual.getProximo();
            System.out.println("Avanzando a: " + actual.getValor());
        } else {
            System.out.println("No hay páginas adelante.");
        }
    }

    public void mostrar() {
        if (actual == null) {
            System.out.println("El historial está vacío.");
        } else {
            System.out.println("Página actual: " + actual.getValor());
        }
    }
}