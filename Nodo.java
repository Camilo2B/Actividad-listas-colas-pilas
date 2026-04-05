class Nodo {
    String pagina;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(String pagina) {
        this.pagina = pagina;
        this.siguiente = null;
        this.anterior = null;
    }
}