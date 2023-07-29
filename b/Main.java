package VIII.patrones.observer.b;
public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Pao","Viloria");

        usuario.agregar(new Seguidor("David", "Gutierrez"));
        usuario.agregar(new Seguidor("Catalina", "Moreno"));
        usuario.agregar(new Seguidor("Luiz", "Peña"));

        usuario.subirFoto();
        usuario.subirFoto();
        usuario.subirFoto();
    }
}