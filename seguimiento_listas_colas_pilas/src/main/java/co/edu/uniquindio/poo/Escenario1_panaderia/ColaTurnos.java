package co.edu.uniquindio.poo.Escenario1_panaderia;
public class ColaTurnos<T> {

    private Nodo<T> frente;
    private Nodo<T> fin;

    public ColaTurnos() {
        this.frente = null;
        this.fin = null;
    }

    // Agregar elemento (enqueue)
    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            // Usamos el setter para conectar el último con el nuevo
            fin.setProximo(nuevo);
            fin = nuevo;
        }
    }

    // Atender elemento (dequeue)
    public void eliminar() {
        if (frente == null) {
            System.out.println("No hay elementos en la cola.");
            return;
        }

        // Usamos getValor() para obtener el dato antes de mover el puntero
        System.out.println("Atendiendo a: " + frente.getValor());
        
        // Usamos getProximo() para avanzar en la cola
        frente = frente.getProximo();

        if (frente == null) {
            fin = null;
        }
    }

    // Ver el siguiente elemento (peek)
    public void buscar() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("Siguiente en turno: " + frente.getValor());
        }
    }

    // Mostrar lista completa
    public void mostrar() {
        if (frente == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo<T> actual = frente;
        System.out.print("FRENTE: ");
        
        while (actual != null) {
            System.out.print("[" + actual.getValor() + "] -> ");
            actual = actual.getProximo();
        }
        
        System.out.println("null (FIN)");
    }
}