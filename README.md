
                                        APPLICACION CRUD

Esta es una aplicación de consola desarrollada en Java que permite gestionar una base de datos de clientes de forma sencilla. El objetivo del proyecto es poner en práctica conocimientos básicos de Java, especialmente relacionados con el manejo de clases, estructuras de control, listas, y persistencia de datos usando JPA con Hibernate.

¿Qué hace esta aplicación?
-Agregar cliente.
(El sistema solicita al usuario ingresar datos como nombre, apellidos, ciudad, teléfono, email, sexo y fecha de nacimiento. Todos los campos son obligatorios y se valida que no queden vacíos.)

-Listar todos los clientes (Muestra en pantalla todos los registros almacenados en la base de datos.)

-Actualizar información de un cliente.

-Se solicita el ID del cliente. Si existe, permite modificar sus datos uno por uno, validando que no estén vacíos.

-Eliminar un cliente.
(Pide el ID del cliente a eliminar. Si existe, lo elimina de la base de datos.)

-Buscar cliente por ciudad.
(El usuario ingresa el nombre de una ciudad y se listan todos los clientes que viven en ella {si hay}).

-Salir (Finaliza la ejecución del programa.)

Conexión con la base de datos
Esta aplicación está conectada a una base de datos MySQL llamada clientes. Todos los datos que se ingresan, modifican o eliminan desde la consola se almacenan directamente en esta base de datos mediante JPA (Jakarta Persistence API) y Hibernate.
Para que la aplicación funcione correctamente, asegúrate de tener:
- Un servidor MySQL en ejecución.
- Una base de datos creada con el nombre clientes.
- La configuración de conexión correctamente definida en el archivo persistence.xml, incluyendo el usuario, la contraseña y la URL de conexión a la base de datos.