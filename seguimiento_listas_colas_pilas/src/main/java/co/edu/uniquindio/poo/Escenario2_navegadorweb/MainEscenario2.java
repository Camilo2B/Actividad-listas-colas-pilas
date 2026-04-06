package co.edu.uniquindio.poo.Escenario2_navegadorweb;

import Historial;

public class MainEscenario2 {

    public static void main(String[] args) {

        Historial h = new Historial();

        h.visitar("google.com");
        h.visitar("youtube.com");
        h.visitar("facebook.com");

        h.mostrar();

        h.atras();
        h.mostrar();

        h.atras();
        h.mostrar();

        h.adelante();
        h.mostrar();

        h.visitar("twitter.com"); // elimina futuro

        h.mostrar();
    }
}