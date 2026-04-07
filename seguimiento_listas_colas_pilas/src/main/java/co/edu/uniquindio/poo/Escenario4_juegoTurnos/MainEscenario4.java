package co.edu.uniquindio.poo.Escenario4_juegoTurnos;

public class MainEscenario4 {
    public static void main(String[] args) {
        ListaJugadores<String> mesa = new ListaJugadores<>();

        System.out.println("--- Configurando Partida ---");
        mesa.insertar("Guerrero");
        mesa.insertar("Mago");
        mesa.insertar("Arquero");
        mesa.insertar("Asesino");


        System.out.println("--- ESTADO INICIAL DE LA MESA ---");
        mesa.mostrarJugadores();
        
        System.out.println("\n--- Probando turnos (Sentido Horario) ---");
        mesa.pasarSiguienteTurno();
        mesa.pasarSiguienteTurno();
        mesa.mostrarJugadores();

        System.out.println("\n--- Probando turnos (Sentido Antihorario) ---");
        mesa.volverTurnoAnterior();
        mesa.volverTurnoAnterior();
        mesa.mostrarJugadores();

        System.out.println("\n--- Eliminamos al jugador que esta en el final ---");
        mesa.eliminarFinal();
        mesa.mostrarJugadores();

        System.out.println("\n--- Eliminamos al Arquero ---");
        mesa.expulsarJugador("Arquero");
        mesa.mostrarJugadores();

        System.out.println("\n¿Sigue el Arquero en la mesa? " + (mesa.buscar("Arquero") ? "Sí" : "No"));

        System.out.println("\n--- Verificando que el círculo sigue intacto ---");
        mesa.pasarSiguienteTurno();
        mesa.pasarSiguienteTurno();
        mesa.volverTurnoAnterior();
        mesa.mostrarJugadores();
    }
}
