package co.edu.uniquindio.poo.Escenario3_musica;

public class MainEscenario3 {
        public static void main(String[] args) {
        ListaCanciones<String> lista = new ListaCanciones<>();

        System.out.println("--- Agregando canciones ---");
        lista.insertarFinal("Café con Ron - Bad Bunny");
        lista.insertarFinal("Where she goes - Bad Bunny");
        lista.insertarInicio("Now - Paramore");
        lista.insertarInicio("Future - Paramore");
        lista.insertarInicio("Toosie Slide - Drake");
        lista.agregarPosicion(2, "Thank u,next - Ariana Grande");

        lista.mostrarLista();

        System.out.println("\n--- Probando Circularidad  ---");
        for (int i = 0; i < 5; i++) {
            System.out.println(lista.siguienteCancion());
        }

        System.out.println("\n--- Eliminando la canción ('Where she goes - Bad Bunny') ---");
        lista.eliminarCancion("Where she goes - Bad Bunny");
        lista.mostrarLista();
        System.out.println(lista.siguienteCancion());

        System.out.println("\n--- Eliminando el 'ultimo' ('Café con Ron - Bad Bunny') ---");
        lista.eliminarFinal();
        lista.mostrarLista();

        System.out.println("\n--- Verificando circularidad con una sola canción ---");
        System.out.println(lista.siguienteCancion());
        System.out.println(lista.siguienteCancion());

    }
   
    
}
