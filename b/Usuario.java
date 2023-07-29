package VIII.patrones.observer.b;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Observable{
    private String nombre;
    private String apellido;
    private List<Observer> observerList;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        observerList = new ArrayList<>();
    }

    @Override
    public void agregar(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void eliminar(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notificar() {
        for (Observer observer : observerList) {
            observer.actualizar(this);
        }
        System.out.println("-----------------"+ getNombre() + " actualizo su album de fotos -----------------");
    }

    public void subirFoto(){
        System.out.println("Soy "+nombre+" "+apellido+" y estoy subiendo una foto");
        notificar();
    }

    public String getNombre() {
        return nombre;
    }
}
