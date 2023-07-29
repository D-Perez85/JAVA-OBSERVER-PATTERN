### Patrón Observer: Pizarra de cotizacion 

Supongamos que tenemos un sistema que muestra en una pizarra el precio del oro y que al actualizarse se sincroniza con cada instancia
suscrita informando el cambio del precio.

![image](https://github.com/D-Perez85/JAVA-OBSERVER-PATTERN/assets/77124855/fa011322-a08e-421a-8a26-192ff91e2ab8)


Cuando el Observable sufre algún cambio de estado, se ejecuta el método “notificar()”, el cual recorre una lista de todos los objetos que
observan al Observable y llama a su método “actualizar()”. 

De esta manera se mantienen todos los observadores actualizados ante cualquier cambio, sin necesidad de que estén consultando constantemente
si existen actualizaciones de estado.
