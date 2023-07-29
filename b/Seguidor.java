package VIII.patrones.observer.b;
public class Seguidor implements Observer{
    private String nombre;
    private String apellido;
    private Integer cantidadDeNotificaciones;

    public Seguidor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        cantidadDeNotificaciones = 0;
    }
    @Override
    public void actualizar(Usuario usuario) {
        cantidadDeNotificaciones++;
        System.out.println(nombre+" fué notificado de la foto que subió "+usuario.getNombre()+ " N° de notificación: "+cantidadDeNotificaciones);
    }
}
