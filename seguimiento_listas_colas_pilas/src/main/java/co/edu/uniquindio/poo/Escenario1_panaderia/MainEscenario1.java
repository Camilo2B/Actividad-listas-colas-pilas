package co.edu.uniquindio.poo.Escenario1_panaderia;

public class MainEscenario1 {

    public static void main(String[] args) {

        ColaTurnos<String> filaBanco = new ColaTurnos<>();

        System.out.println("--- 1. Agregando Clientes a la Cola ---");
        filaBanco.agregar("Andrés");
        filaBanco.agregar("Beatriz");
        filaBanco.agregar("Carlos");
        filaBanco.mostrar();

        System.out.println("\n--- 2. Consultando Siguiente Turno ---");
        filaBanco.buscar();

        System.out.println("\n--- 3. Atendiendo Clientes (Eliminar) ---");
        filaBanco.eliminar(); 
        filaBanco.mostrar();   

        System.out.println("\n--- 4. Agregando un nuevo cliente al final ---");
        filaBanco.agregar("Diana");
        filaBanco.mostrar();

        System.out.println("\n--- 5. Vaciando la cola completamente ---");
        filaBanco.eliminar(); 
        filaBanco.eliminar(); 
        filaBanco.eliminar(); 
        filaBanco.eliminar(); 
        
        filaBanco.mostrar();

        System.out.println("\n--- 6. Prueba con Números de Turno (Integer) ---");
        ColaTurnos<Integer> turnosNumericos = new ColaTurnos<>();
        turnosNumericos.agregar(101);
        turnosNumericos.agregar(102);
        turnosNumericos.mostrar();
    }
}