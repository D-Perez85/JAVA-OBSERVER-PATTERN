package VIII.patrones.observer.a;

public class Main {
    public static void main(String[] args) {
        Pizarra pizarra = new Pizarra();

        Observador obs1 = new Oro();
        Observador obs2 = new Oro();

        pizarra.agregar(obs1);
        pizarra.agregar(obs2);

        pizarra.cambiarPrecio(42.5f);
        pizarra.cambiarPrecio(44.3f);
        pizarra.cambiarPrecio(40.3f);

        System.out.println("Fin del programa!");
    }
}
