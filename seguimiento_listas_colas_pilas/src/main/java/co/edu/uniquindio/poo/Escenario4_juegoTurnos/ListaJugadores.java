package co.edu.uniquindio.poo.Escenario4_juegoTurnos;

public class ListaJugadores<T> {
    private Nodo<T> inicial;
    private Nodo<T> turnoActual;
    private int tam;

    public ListaJugadores() {
        this.inicial = null;
        this.turnoActual = null;
        this.tam = 0;

    }

    public void pasarSiguienteTurno() {
        if (turnoActual != null) {
            turnoActual = turnoActual.getProximo();
            System.out.println("Es el turno de: " + turnoActual.getProximo());
        }
    }

    public void volverTurnoAnterior() {
        if (turnoActual != null) {
            turnoActual = turnoActual.getAnterior();
            System.out.println("Turno devuelto a: " + turnoActual.getValor());
        }
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

    public void mostrarJugadores() {
        if (inicial == null) {
            System.out.println("No hay jugadores en la partida.");
            return;
        }

        System.out.print("Mesa (Circular Doble): [ ");
        Nodo<T> temp = inicial;
        do {
            if (temp == turnoActual) {
                System.out.print("*" + temp.getValor() + "* "); // Marca el turno actual
            } else {
                System.out.print(temp.getValor() + " ");
            }
            temp = temp.getProximo();
        } while (temp != inicial);
        System.out.println("]");
    }

     public void expulsarJugador(String nombre) {
        if (inicial == null) return;

        Nodo<T> actual = inicial;
        boolean encontrado = false;

        do {
            if (((String) actual.getValor()).equalsIgnoreCase(nombre)) {
                encontrado = true;
                break;
            }
            actual = actual.getProximo();
        } while (actual != inicial);

        if (encontrado) {
            if (actual.getProximo() == actual) {
                inicial = null;
                turnoActual = null;
            } else {
                // Reenlazar a los vecinos
                Nodo<T> anterior = actual.getAnterior();
                Nodo<T> siguiente = actual.getProximo();

                anterior.setProximo(siguiente);
                siguiente.setAnterior(anterior);

                if (actual == inicial) {
                    inicial = siguiente;
                }
                if (actual == turnoActual) {
                    turnoActual = siguiente;
                }
            }
            System.out.println("Jugador '" + nombre + "' ha sido expulsado.");
        } else {
            System.out.println("No se encontró al jugador: " + nombre);
        }
    }
}