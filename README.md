# Configuración de la Base de datos
- La base de datos debe ser postgres y estar en el puerto **5432**
- El usuario debe ser **postgres** y el password **postgres**
- Se debe tener una base de datos creada llamada **"db_apificacion_abc"**
- Para cargar el valor del API KEY en la tabla de la base de datos, se puede ejecutar el sql del script **tabla_api_key.sql** sobre la base de datos recién creada.

# Ejecutar el proyecto
- Se debe tener el **jdk** versión **17** instalado. Verificar la variable de entorno JAVA_HOME de ser necesario
- Puede correrlo desde Windows, utilizando PowerShell con el siguiente comando: **.\mvnw.cmd spring-boot:run**
- El valor del API KEY es **'4c2c26bd5557f7df65c9fdacb0697d0812c4a6b2e2069d5a3c2d678765215471'**

# Ver la documentación en swagger
- Ingresar a http://localhost:8080/swagger-ui/index.html