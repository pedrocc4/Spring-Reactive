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
 - El anterior punto es algo incorrecto, ya que si no se especifica @Id en la clase, puede llegar a generar problemas.
 - Si finalmente optamos por usar Thymeleaf, es importante agregar la dependencia que soporta reactivo (al igual para postgres).

Finalmente las dependencias más a tener en cuenta por posibles errores, serán estas (sin olvidar project-reactor y webflux):  

![image](https://user-images.githubusercontent.com/101171440/183850913-681c3e1d-d47b-4619-b648-b2c978af2206.png)

### Documentación interesante:
https://www.arquitecturajava.com/spring-5-reactive-y-thymeleaf/   
https://www.youtube.com/watch?v=tSlkTi9_7aE   
https://github.com/mkheck/getting-started-r2dbc/blob/master/src/main/java/com/thehecklers/coffeeservice/CoffeeServiceApplication.java    
https://github.com/tech-recipes/reactive-postgres-demo/tree/master/src/main/java/com/example/reactivepostgresdemo    
https://www.youtube.com/watch?v=P9L3Lq2Ecvw    
https://www.youtube.com/watch?v=qwF6v6FN_Uc   
https://www.baeldung.com/spring-boot-crud-thymeleaf  
https://developer.okta.com/blog/2022/03/24/thymeleaf-security   

### Manual

Una vez clonado en local este repositorio y con docker instalado en nuestro equipo, en la terminal escribimos 'docker-compose up' 
que creará la BD postgres y ejecutará el archivo 'init.sql' inicializando de esta forma nuestra BD.

Lanzaremos desde nuestro IDE la aplicación de Spring Boot y en la ruta localhost:8080 podremos empezar a hacer peticiones.
