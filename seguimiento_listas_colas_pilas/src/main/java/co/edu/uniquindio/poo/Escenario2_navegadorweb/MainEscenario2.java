package co.edu.uniquindio.poo.Escenario2_navegadorweb;

public class MainEscenario2 {

    public static void main(String[] args) {

        Historial h = new Historial();

        System.out.println("--- Inicio de navegación ---");
        h.visitar("google.com");
        h.visitar("youtube.com");
        h.visitar("facebook.com");
        
        h.mostrar();

        System.out.println("\n--- Probando botones Atrás ---");
        h.atras();
        h.mostrar();
        h.atras();
        h.mostrar();

        System.out.println("\n--- Probando botón Adelante ---");
        h.adelante();
        h.mostrar();

        h.visitar("twitter.com"); 

        h.mostrar();
    }
}