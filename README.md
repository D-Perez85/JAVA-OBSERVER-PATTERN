"# JAVA-OBSERVER-PATTERN" 🚀
--------------------- 


![image](https://github.com/D-Perez85/JAVA-FACTORY-METHOD-PATTERN/assets/77124855/ed22828a-241f-4e7f-8125-bc296d7398dc)


Observer es un patrón de diseño de comportamiento que te permite definir un mecanismo de suscripción para notificar a varios objetos sobre cualquier evento que le suceda al objeto que están observando.


## Problema
Imagina que tienes dos tipos de objetos: un objeto Cliente y un objeto Tienda. 

El cliente está muy interesado en una marca particular de producto (ej un nuevo modelo de iPhone) que estará disponible en la tienda muy pronto.
El cliente puede visitar la tienda cada día para comprobar la disponibilidad del producto, no obstante, mientras el producto está en camino, la mayoría de estos viajes serán en vano.

La tienda podría enviar cientos de correos a todos los clientes cada vez que hay un nuevo producto disponible, (esto ahorraría interminables viajes a la tienda, pero, al mismo tiempo, molestaría a otros clientes que no están interesados en los nuevos productos).

Parece que nos encontramos ante un conflicto: O el cliente pierde tiempo comprobando la disponibilidad del producto, o bien la tienda desperdicia recursos notificando a los clientes equivocados.


## Solución
El objeto que tiene un estado interesante suele denominarse sujeto, (como también va a notificar a otros objetos los cambios en su estado le llamaremos notificador). El resto de los objetos que quieren conocer los cambios en el estado del notificador se denominan suscriptores.


El patrón Observer sugiere que añadas un mecanismo de suscripción a la clase notificadora para que los objetos individuales puedan suscribirse o cancelar su suscripción a un flujo de eventos que proviene de esa notificadora. 

En realidad, este mecanismo consiste en: 
-      1) un campo matriz para almacenar una lista de referencias a objetos suscriptores,
-      2) varios métodos públicos que permiten añadir suscriptores y eliminarlos de esa lista.

![image](https://github.com/D-Perez85/JAVA-OBSERVER-PATTERN/assets/77124855/5a840125-8c5a-4252-85d0-a3ebf92914f5)


Ahora, cuando le sucede un evento importante al notificador, recorre sus suscriptores y llama al método de notificación específico de sus objetos.
Las aplicaciones reales pueden tener decenas de clases suscriptoras diferentes interesadas en seguir los eventos de la misma clase notificadora. 

Es fundamental que todos los suscriptores implementen la misma interfaz y que el notificador únicamente se comunique con ellos a través de esa interfaz. 

Esta interfaz debe declarar el método de notificación junto con un grupo de parámetros que el notificador puede utilizar para pasar cierta información contextual con la notificación.


## Analogía en el mundo real
Si te suscribes a un periódico o una revista, ya no necesitarás ir a la tienda a comprobar si el siguiente número está disponible. 

En lugar de eso, el notificador envía nuevos números directamente a tu buzón justo después de la publicación, o incluso antes.


![image](https://github.com/D-Perez85/JAVA-OBSERVER-PATTERN/assets/77124855/ac41fc80-ee7c-463a-bfdf-0dc531bb1d09)

El notificador mantiene una lista de suscriptores y sabe qué revistas les interesan, los suscriptores pueden abandonar la lista en cualquier momento si quieren que el notificador deje de enviarles nuevos números.


## Estructura
![image](https://github.com/D-Perez85/JAVA-OBSERVER-PATTERN/assets/77124855/8dd25376-3c6f-429e-88ae-d72a410602e1)



 ## Aplicabilidad
 :pushpin: cuando los cambios en el estado de un objeto puedan necesitar cambiar otros objetos y el grupo de objetos sea desconocido de antemano o cambie 
 dinámicamente: Por ejemplo, si creaste clases personalizadas de botón y quieres permitir al cliente colgar código cliente de tus botones para que se active cuando un usuario pulse un botón.

El patrón Observer permite que cualquier objeto que implemente la interfaz suscriptora pueda suscribirse a notificaciones de eventos en objetos notificadores, (puedes añadir el mecanismo de suscripción a tus botones, permitiendo a los clientes acoplar su código personalizado a través de clases suscriptoras personalizadas).

 :pushpin: cuando algunos objetos de tu aplicación deban observar a otros, pero sólo durante un tiempo limitado o en casos específicos.
 La lista de suscripción es dinámica, por lo que los suscriptores pueden unirse o abandonar la lista cuando lo deseen.


## Cómo implementarlo

-    Repasa tu lógica de negocio e intenta dividirla en dos partes: la funcionalidad central, independiente del resto de código, actuará como notificador; el resto se convertirá en un grupo de clases suscriptoras.
-    Declara la interfaz suscriptora. Como mínimo, deberá declarar un único método actualizar.
-    Declara la interfaz notificadora y describe un par de métodos para añadir y eliminar de la lista un objeto suscriptor. Recuerda que los notificadores deben trabajar con suscriptores únicamente a través de la interfaz suscriptora.
-    Decide dónde colocar la lista de suscripción y la implementación de métodos de suscripción. Normalmente, este código tiene el mismo aspecto para todos los tipos de notificadores, por lo que el lugar obvio para colocarlo es en una clase abstracta derivada directamente de la interfaz notificadora. Los notificadores concretos extienden esa clase, heredando el comportamiento de suscripción.
Sin embargo, si estás aplicando el patrón a una jerarquía de clases existentes, considera una solución basada en la composición: coloca la lógica de la suscripción en un objeto separado y haz que todos los notificadores reales la utilicen.
-    Crea clases notificadoras concretas. Cada vez que suceda algo importante dentro de una notificadora, deberá notificar a todos sus suscriptores.
-    Implementa los métodos de notificación de actualizaciones en clases suscriptoras concretas. La mayoría de las suscriptoras necesitarán cierta información de contexto sobre el evento, que puede pasarse como argumento del método de notificación.
Pero hay otra opción. Al recibir una notificación, el suscriptor puede extraer la información directamente de ella. En este caso, el notificador debe pasarse a sí mismo a través del método de actualización. La opción menos flexible es vincular un notificador con el suscriptor de forma permanente a través del constructor.
-    El cliente debe crear todos los suscriptores necesarios y registrarlos con los notificadores adecuados.




## Pros y contras

•	     Principio de abierto/cerrado. Puedes introducir nuevas clases suscriptoras sin tener que cambiar el código de la notificadora
•	     Puedes establecer relaciones entre objetos durante el tiempo de ejecución.
•	     Los suscriptores son notificados en un orden aleatorio.



## Relaciones con otros patrones
:heavy_check_mark:	Chain of Responsibility, Command, Mediator y Observer abordan distintas formas de conectar emisores y receptores de solicitudes:

     •	 Chain of Responsibility pasa una solicitud secuencialmente a lo largo de una cadena dinámica de receptores potenciales hasta que uno de ellos la gestiona.
     •	 Command establece conexiones unidireccionales entre emisores y receptores.
     •	 Mediator elimina las conexiones directas entre emisores y receptores, forzándolos a comunicarse indirectamente a través de un objeto mediador.
     •	 Observer permite a los receptores suscribirse o darse de baja dinámicamente a la recepción de solicitudes.


:heavy_check_mark:	La diferencia entre Mediator y Observer a menudo resulta difusa. En la mayoría de los casos, puedes implementar uno de estos dos patrones; pero en ocasiones puedes aplicarlos ambos a la vez. 

La meta principal del patrón Mediator consiste en eliminar las dependencias mutuas entre un grupo de componentes del sistema. En su lugar, estos componentes se vuelven dependientes de un único objeto mediador. 

La meta del patrón Observer es establecer conexiones dinámicas de un único sentido entre objetos, donde algunos objetos actúan como subordinados de otros.

Hay una implementación popular del patrón Mediator que se basa en el Observer:  el objeto mediador juega el papel de notificador, y los componentes actúan como suscriptores que se suscriben o se dan de baja de los eventos del mediador. Cuando se implementa el Mediator de esta forma, puede asemejarse mucho al Observer.


## Comenzando 🚀

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.


### Instalación 🔧

### `Clonar` 
Clonar el proyecto utilizando git clone  dentro de tu entorno local para poder obtener el codigo fuente. 
``` 
git clone https://github.com/D-Perez85/JAVA-OBSERVER-PATTERN.git
```
### `Instalar Intellij IDE`
Necesitas este framework para poder compilar los archivos de prueba
```
https://www.jetbrains.com/es-es/idea/download/?section=windows
```
### `Run`
Una vez instalado el frame podras correr la App para ver este patron en funcionamiento.  

![image](https://github.com/D-Perez85/JAVA-OBSERVER-PATTERN/assets/77124855/9b0c43ea-cd91-4d6e-b605-58dc615255c9)


Made with ❤️ by [Damian Perez](https://github.com/D-Perez85) 😊


