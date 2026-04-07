package co.edu.uniquindio.poo.Escenario4_juegoTurnos;

public class MainEscenario4 {
    public static void main(String[] args) {
        ListaJugadores<String> mesa = new ListaJugadores<>();

        mesa.insertar("Guerrero");
        mesa.insertar("Mago");
        mesa.insertar("Arquero");
        mesa.insertar("Asesino");

        System.out.println("--- ESTADO INICIAL DE LA MESA ---");
        mesa.mostrarSimulacion(6); 

        System.out.println("\n--- El Guerrero sale de la partida ---");
        mesa.eliminarInicio();
    
        mesa.mostrarSimulacion(5);

        // 5. Probamos buscar a alguien
        System.out.println("\n¿Sigue el Arquero en la mesa? " + (mesa.buscar("Arquero") ? "Sí" : "No"));
    }
}
