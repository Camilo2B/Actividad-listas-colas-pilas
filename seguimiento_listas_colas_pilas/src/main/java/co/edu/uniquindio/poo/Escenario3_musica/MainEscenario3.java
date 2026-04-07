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

        System.out.println("Tamaño de la lista: " + lista.getTam());
        System.out.println("¿Existe 'Café con Ron - Bad Bunny'?: " + lista.buscar("Café con Ron - Bad Bunny"));

        System.out.println("--- Eliminando canciones ---");
        lista.eliminarInicio();
        lista.eliminarFinal();

        System.out.println("Tamaño final: " + lista.getTam());
    }
   
    
}
