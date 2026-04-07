package co.edu.uniquindio.poo.Escenario3_musica;

public class ListaCanciones<T> {
    private Nodo<T> inicial;
    private int tam;
    private int posicion;

    public ListaCanciones() {
        this.inicial = null;
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

    



}
    

