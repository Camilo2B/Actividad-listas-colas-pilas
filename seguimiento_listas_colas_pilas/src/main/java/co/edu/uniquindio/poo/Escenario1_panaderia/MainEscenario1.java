package co.edu.uniquindio.poo.Escenario1_panaderia;

public class MainEscenario1 {

    public static void main(String[] args) {
        // 1. Creamos una cola para nombres de clientes (String)
        ColaTurnos<String> filaBanco = new ColaTurnos<>();

        System.out.println("--- 1. Agregando Clientes a la Cola ---");
        filaBanco.agregar("Andrés");
        filaBanco.agregar("Beatriz");
        filaBanco.agregar("Carlos");
        filaBanco.mostrar(); // Debería mostrar: FRENTE: [Andrés] -> [Beatriz] -> [Carlos] -> null

        System.out.println("\n--- 2. Consultando Siguiente Turno ---");
        filaBanco.buscar(); // Muestra quién está al frente sin eliminarlo

        System.out.println("\n--- 3. Atendiendo Clientes (Eliminar) ---");
        filaBanco.eliminar(); // Atiende a Andrés
        filaBanco.mostrar();   // Ahora el frente es Beatriz

        System.out.println("\n--- 4. Agregando un nuevo cliente al final ---");
        filaBanco.agregar("Diana");
        filaBanco.mostrar();

        System.out.println("\n--- 5. Vaciando la cola completamente ---");
        filaBanco.eliminar(); // Atiende a Beatriz
        filaBanco.eliminar(); // Atiende a Carlos
        filaBanco.eliminar(); // Atiende a Diana
        filaBanco.eliminar(); // Mensaje: "No hay elementos en la cola"
        
        filaBanco.mostrar();

        // Bonus: Demostración de que es Genérica (usando Números)
        System.out.println("\n--- 6. Prueba con Números de Turno (Integer) ---");
        ColaTurnos<Integer> turnosNumericos = new ColaTurnos<>();
        turnosNumericos.agregar(101);
        turnosNumericos.agregar(102);
        turnosNumericos.mostrar();
    }
}