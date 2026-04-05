public class MainEscenario1 {

    public static void main(String[] args) {

        ColaTurnos cola = new ColaTurnos();

        cola.agregar("Cliente 1");
        cola.agregar("Cliente 2");
        cola.agregar("Cliente 3");

        cola.mostrar();

        cola.eliminar();

        cola.mostrar();

        cola.buscar();
    }
}