package co.edu.uniquindio.poo.Escenario2_navegadorweb;
    
public class Nodo {
    String pagina;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(String pagina) {
        this.pagina = pagina;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    
}