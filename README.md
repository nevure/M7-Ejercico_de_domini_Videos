# M7-Ejercico_de_domini_Videos

Este proyecto esta dividido en varios paquetes, subpaquetes y clases.

Descripción Paquetes:

- Utilidades: PAquete que tiene una clase para manejar cadenas y colecciones.
- excepcionesPropias: Paquete con dos clases para manejar excepciones personalizadas.
- dominioVideos: Este paquete contiene las clases principales de la APP y varios subpaquetes.
    - ColeccionesWeb : Este paquete nos define articulos de tipo Web.
        - ColeccionesWeb.Basico: Aquí definimos colecciones básicas de tipo web.
    - gestionTiposUsuarios: Este paquete nos define los tipos de usuario y su gestión.
    


El Main de la APP consta de dos iteracciones. Uno para el menú principal y otro para el menú interno de usuario. 
Cada iteracción tiene dentro un switch case para alternar entre las opciones escogidas del menú que se muestra.

Según el case se ejecuta un método de la clase controlador, que es donde se realiza todo el trabajo de la APP con la ayuda del resto de clases. 
LA clase controlador, ControladorVistaMenu, es la clase que realiza todo el trabajo con la ayuda del resto. Esta clase declara objetos del resto de clases para poder trabajar con ellos. El objeto principal es el de la clase ListaUsuarios; clase singleton que almacena un hashmap donde la clave es un string que se corresponde con el mail del usuario (identificador principal) y el valor es un objeto de la clase MiColeccionWeb. 

El controlador instancia un objeto de vista para lanzar los formularios adecuados en función de las opciones elegidas. Tras las rspuestas recibidas por el objeto vista el controlador traaja con el resto de objetos para acabar actualizando o no la lista de usuarios.

Hemos dicho que la lista de usuarios es un hashmap que almacena un string (un mail) y un objeto MiColeccionWeb.  Este objeto de tipo MiColeccionWeb es un objeto con dos elmentos: un objeto User (datos del usuario) y una lista de objetos ColeccionWeb. Éste último no es más que interfaz de la clase de elementos que almacenamos ennuestra app, vídeos.


        
