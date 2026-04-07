package co.edu.uniquindio.poo.Escenario1_panaderia;
public class ColaTurnos<T> {

    public Nodo<T> frente;
    public Nodo<T> fin;

    public ColaTurnos() {
        this.frente = null;
        this.fin = null;
    }

    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setProximo(nuevo);
            fin = nuevo;
        }
    }

    public void eliminar() {
        if (frente == null) {
            System.out.println("No hay elementos en la cola.");
            return;
        }

        System.out.println("Atendiendo a: " + frente.getValor());
        
        frente = frente.getProximo();

        if (frente == null) {
            fin = null;
        }
    }

    public void buscar() {
        if (frente == null) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("Siguiente en turno: " + frente.getValor());
        }
    }

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