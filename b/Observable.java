package VIII.patrones.observer.b;
public interface Observable {
    public void agregar(Observer observer);
    public void eliminar(Observer observer);
    public void notificar();
}
