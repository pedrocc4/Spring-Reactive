## Spring Reactive

En esta aplicación de ejemplo nos conectaremos a una BD PostGreSQL lanzada en un container de docker
y realizaremos ciertas operaciones (GET y POST), todo ello usando Spring Reactive y R2DBC: 
 - Las tablas no se pueden crear automáticamente con la tecnología r2dbc, por
lo tanto tenemos que crearlas manualmente (herramientas como pgAdmin)
 - Los repositorios extenderán de ReactiveCrudRepository<> (prácticamente igual que JpaRepository<>)
 - No será necesario marcar las entidades con @Entity
 - Dependiendo de la BD es recomendable usar una clase de configuración para esta y no definirla a
través del application.properties. Aunque obviamente, los parámetros de entrada sí pueden ser directamente
proporcionados por éste
 - La diferencia principal radica en el uso de Mono y Flex
 - Al no trabajar directamente con Entidades y tener que definirlas manualmente, se pueden omitir éstas y
trabajar directamente con DTOs
