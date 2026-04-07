package co.edu.uniquindio.poo.Escenario4_juegoTurnos;

public class ListaJugadores<T> {
    private Nodo<T> inicial;
    private int tam;

    public ListaJugadores() {
        this.inicial = null;
        this.tam = 0;
    }

    public boolean insertar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (inicial == null) {
            inicial = nuevo;
            nuevo.setProximo(inicial); 
            nuevo.setAnterior(inicial);
            tam++;
            return true;
        }

        Nodo<T> ultimo = inicial.getAnterior(); 

        ultimo.setProximo(nuevo);  
        nuevo.setAnterior(ultimo);   
        nuevo.setProximo(inicial); 
        inicial.setAnterior(nuevo);  
        tam++;
        return true;
    }

    public void insertarInicio(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (inicial == null) {
            inicial = nuevo;
            nuevo.setProximo(inicial);
            nuevo.setAnterior(inicial);
            tam++;
            return;
        }

        Nodo<T> ultimo = inicial.getAnterior(); 

        nuevo.setProximo(inicial); 
        nuevo.setAnterior(ultimo);   
        ultimo.setProximo(nuevo);  
        inicial.setAnterior(nuevo);  
        inicial = nuevo;            
        tam++;
    }

    public void eliminarFinal() {
        if (inicial == null) return;

        if (inicial.getProximo() == inicial) { 
            inicial = null;
            tam--;
            return;
        }

        Nodo<T> ultimo = inicial.getAnterior();   
        Nodo<T> penultimo = ultimo.getAnterior();

        penultimo.setProximo(inicial); 
        inicial.setAnterior(penultimo);  
        tam--;
    }

    public void eliminarInicio() {
        if (inicial == null) return;

        if (inicial.getProximo() == inicial) { 
            inicial = null;
            tam--;
            return;
        }

        Nodo<T> ultimo = inicial.getAnterior(); 
        inicial = inicial.getProximo();     

        ultimo.setProximo(inicial);  
        inicial.setAnterior(ultimo); 
        tam--;
    }

    public void agregarPosicion(int posicion, T valor) {
        if (posicion < 0)
            throw new IllegalArgumentException("Posición negativa.");

        if (posicion == 0) {
            insertarInicio(valor);
            return;
        }

        Nodo<T> actual = inicial;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getProximo();
            if (actual == inicial)
                throw new IndexOutOfBoundsException("Posición fuera de rango: " + posicion);
        }

        Nodo<T> nuevo = new Nodo<>(valor);
        Nodo<T> siguiente = actual.getProximo();

        nuevo.setAnterior(actual);     
        nuevo.setProximo(siguiente);
        siguiente.setAnterior(nuevo); 
        tam++;
    }

    public boolean buscar(T valor) {
        if (inicial == null) return false;

        Nodo<T> actual = inicial;
        do {
            if (actual.getValor().equals(valor)) return true;
            actual = actual.getProximo();
        } while (actual != inicial);

        return false;
    }

    public void mostrarSimulacion(int vueltas) {
    if (inicial == null) {
        System.out.println("La mesa está vacía.");
        return;
    }

    Nodo<T> actual = inicial;
    System.out.println("--- Iniciando secuencia de turnos ---");
    
    for (int i = 1; i <= vueltas; i++) {
        System.out.println("Turno #" + i + ": " + actual.getValor());
        actual = actual.getProximo(); // Pasa al siguiente (del último vuelve al primero)
    }
    System.out.println("-------------------------------------");
}
}