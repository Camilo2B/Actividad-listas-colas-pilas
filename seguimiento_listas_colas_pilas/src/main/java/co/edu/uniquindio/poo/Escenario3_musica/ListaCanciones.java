package co.edu.uniquindio.poo.Escenario3_musica;

public class ListaCanciones<T> {
    private Nodo<T> inicial;
    private Nodo<T> cancionActual;
    private int tam;
    private int posicion;

    public ListaCanciones() {
        this.inicial = null;
        this.cancionActual = null;
        tam = 0;
        posicion = 0;
    }

    public boolean insertarFinal(T valor) {
    Nodo<T> nuevo = new Nodo<>(valor);

        if (inicial == null && tam == 0) {
        inicial = nuevo;
        nuevo.setProximo(inicial); 
        tam++;
        return true;
        }

        Nodo<T> tempo = inicial;
         while (tempo.getProximo() != inicial) { 
        tempo = tempo.getProximo();
        }

        tempo.setProximo(nuevo);   
        nuevo.setProximo(inicial); 
        tam++;
        return true;
    }
    public String siguienteCancion() {
        if (inicial == null) return "Lista vacía"; 

        if (cancionActual == null) {
            cancionActual = inicial;  
        } else {
            cancionActual = cancionActual.getProximo();
        }
        return "Reproduciendo ahora: " + cancionActual.getValor();
    }
   public void insertarInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);

        if (inicial == null && tam == 0) {
            inicial = nuevoNodo;
            nuevoNodo.setProximo(inicial); // apunta a sí mismo
            tam++;
            return;
        }

        Nodo<T> ultimo = inicial;
        while (ultimo.getProximo() != inicial) {
            ultimo = ultimo.getProximo();
        }

        nuevoNodo.setProximo(inicial); 
        ultimo.setProximo(nuevoNodo); 
        inicial = nuevoNodo;          
        tam++;
    }

   public void eliminarFinal() {
        if (inicial == null) { 
            return;
        }

    
        if (inicial.getProximo() == inicial) { 
            inicial = null;
            tam--;
            return;
        }

        Nodo<T> tempo = inicial;
        while (tempo.getProximo().getProximo() != inicial) {
            tempo = tempo.getProximo();
        }

        tempo.setProximo(inicial); 
        tam--;
        }

    public void eliminarInicio() {
        if (inicial == null || tam == 0) return; 

        if (inicial.getProximo() == inicial) { 
            inicial = null;
            tam--;
            return;
        }

    
        Nodo<T> ultimo = inicial;
        while (ultimo.getProximo() != inicial) {
            ultimo = ultimo.getProximo();
        }

        inicial = inicial.getProximo(); 
        ultimo.setProximo(inicial);     
        tam--;
    }

    public void eliminarCancion(String nombre) {
    if (inicial == null) return;  

    Nodo<T> actual = inicial;
    Nodo<T> anterior = null;

    Nodo<T> prevInicial = inicial;
    while (prevInicial.getProximo() != inicial) {
        prevInicial = prevInicial.getProximo();
    }
    anterior = prevInicial;

    boolean encontrado = false;
    do {
        if (((String) actual.getValor()).equalsIgnoreCase(nombre)) {
            encontrado = true;
            break;
        }
        anterior = actual;
        actual = actual.getProximo();
    } while (actual != inicial);

    if (encontrado) {
        if (actual.getProximo() == actual) {
            // Único nodo
            inicial = null;
            cancionActual = null;
        } else {
            anterior.setProximo(actual.getProximo());
            if (actual == inicial) {
                inicial = actual.getProximo();
            }
            if (actual == cancionActual) {
                cancionActual = anterior.getProximo();
            }
        }
        System.out.println("Canción eliminada: " + nombre);
    } else {
        System.out.println("No se encontró la canción: " + nombre);
    }
    }

    public void agregarPosicion(int posicion, T valor) {
        if (posicion < 0)
            throw new IllegalArgumentException("Posición negativa.");

        Nodo<T> nuevoNodo = new Nodo<>(valor);

        if (posicion == 0) {
            if (inicial == null) {              
                inicial = nuevoNodo;
                nuevoNodo.setProximo(inicial);
            } else {
                Nodo<T> ultimo = inicial;
                while (ultimo.getProximo() != inicial) 
                    ultimo = ultimo.getProximo();

                nuevoNodo.setProximo(inicial);      
                ultimo.setProximo(nuevoNodo);       
                inicial = nuevoNodo;
            }
            tam++;  
            return;
        }

        Nodo<T> actual = inicial;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getProximo();
            if (actual == inicial) 
                throw new IndexOutOfBoundsException("Posición fuera de rango: " + posicion);
        }

        nuevoNodo.setProximo(actual.getProximo());
        actual.setProximo(nuevoNodo);
        tam++;
    }

    public boolean buscar(T valor) {
        if (inicial == null) return false;

        Nodo<T> actual = inicial;
        do {                                    
            if (actual.getValor().equals(valor))    
                return true;
            actual = actual.getProximo();
        } while (actual != inicial);              

        return false;
    }

    
    
    public void setInicial(Nodo<T> inicial) {
        this.inicial = inicial;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void mostrarLista() {
    if (inicial == null) {  
        System.out.println("La lista de reproducción está vacía.");
        return;
    }

    System.out.print("Lista de reproducción: [ ");
    Nodo<T> temporal = inicial;
    do {
        if (temporal == cancionActual) {
            System.out.print(">" + temporal.getValor() + "< ");
        } else {
            System.out.print(temporal.getValor() + " ");
        }
        temporal = temporal.getProximo();
    } while (temporal != inicial);
    System.out.println("] (Circular)");
    }

    public Nodo<T> getCancionActual() {
        return cancionActual;
    }

    public void setCancionActual(Nodo<T> cancionActual) {
        this.cancionActual = cancionActual;
    }


}
    

