# API-REST-Spring-Boot-3
## Listado de  dependencias maeven
- MYSQL JDBC
- Lombok
- Flayway

## Correcciones en migraciones
En caso de que al crear alguna de las migraciones te de algun error por ejemplo lo mas comun es esto:
```bash
Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'flywayInitializer' defined in class path resource [org/springframework/boot/autoconfigure/flyway/FlywayAutoConfiguration$FlywayConfiguration.class]: Validate failed: Migrations have failed validation
```
Puedes observar que el mensaje de error indica que alguna de las migraciones fallo, lo que impide que el proyecto se inicie correctamente, Este error tambien puede ocurrir si el codigo de migración no es válido y contiene algún fragmento de SQL escrito incorrectamente.
Para lo solución de este error será necesario acceder a la base de datos de la aplicación y ejecutar el siguiente comando sql:
```sql
DELETE FROM flyway_schema_history WHERE success = 0;
```
El comando anterior se usa para eliminar de la tabla Flyway todas las migraciones cuya ejecución falló. Después de eso, simplemente corrija el código de migración y ejecute el proyecto nuevamente.

## Manejo de versiones para migraciones de Flyway
Para poder agregar migraciones Flyway tiene un manejo por defecto una nomenclatura de nombre de archivos por ejemplo:
- _V1__create_table_libros.sql_
- _V2__create_table_autores.sql_
- _V3__alter_table_add_fecha_libros.sql_

Podemos ver que para cada sentencia se necesita colocar una version diferente, si no se hace esto, nos dara un error de que encontro 2 numeros de versiones iguales y el programa lo tomara como error.

## @Autowired ¿Qué es?
Traducido del inglés, la palabra Autowired sería ''un cable automático''. En el contexto del framework Spring, que utiliza como una de sus bases el patrón de diseño “Inyección de Dependencias”, la idea sirve para definir una inyección automática en un determinado componente del proyecto Spring, ese componente puede ser atributos, métodos e incluso constructores.

Esta anotación se permite con la ayuda de la anotación @SpringBootApplication, en el archivo de configuración de Spring, disponible cada vez que se crea un proyecto Spring.

Al marcar un componente con la anotación @Autowired le estamos diciendo a Spring que el componente es un punto donde se debe inyectar una dependencia, en otras palabras, el componente se inyecta en la clase que lo posee, estableciendo una colaboración entre componentes.

Para más información sobre la anotación, echa un vistazo a la [documentación oficial](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html)
