package co.edu.uniquindio.poo.Escenario2_navegadorweb;

public class MainEscenario2 {

    public static void main(String[] args) {
        Historial<String> navegador = new Historial<>();

        navegador.visitar("google.com");

        navegador.visitar("github.com");

        navegador.atras();      

        navegador.adelante();   
    }
}