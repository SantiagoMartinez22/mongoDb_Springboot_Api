# Proyecto Examen 4 - Tópicos Avanzados de Bases de Datos

Este proyecto es una API REST desarrollada con Spring Boot y MongoDB para gestionar información sobre medicamentos y sus compuestos.

## Prerrequisitos

- Java Development Kit (JDK) 17 o superior
- MongoDB Server
- Git
- Gradle

## Configuración

### 1. Clonar el Repositorio

```bash
git clone https://github.com/SantiagoMartinez22/tadb_examen_04.git
cd tadb_examen_04
```

### 2. Configuración de la Base de Datos MongoDB (Manual)

Estos pasos asumen que tienes MongoDB instalado y ejecutándose.

**a. Conectar a MongoDB:**
Abre una terminal o consola y conéctate a tu instancia de MongoDB usando `mongosh`:

```bash
mongosh
```

**b. Crear Usuario, Base de Datos, Colecciones y Validaciones **

- Una vez dentro de `mongosh`, puedes extraer del script `mongo-init.js` proporcionado lo necesario para la creación del modelo de datos. Este script se encargará de:

- Crear la base de datos `medicamentos_db`.

- Crear el usuario `medicamentos_usr` con los permisos correspondientes sobre `medicamentos_db`.

- Crear las colecciones `medicamentos`, `compuestos` y `compuestos_medicamento`.

- Aplicar las validaciones de esquema a cada colección.

**c. Importar Datos:**
Ahora, importa los datos desde los archivos JSON proporcionados en el directorio `Datos/`

### 3. Configuración de la Aplicación Spring Boot

La configuración de la conexión a la base de datos se encuentra en `src/main/resources/application.properties`. Verifica que los valores coincidan con tu configuración de MongoDB (URI, nombre de usuario, contraseña, base de datos):

```properties
spring.data.mongodb.uri=mongodb://medicamentos_usr:medicamentos123@localhost:27017/medicamentos_db?authSource=admin
# O si usas la configuración por propiedades individuales:
# spring.data.mongodb.host=localhost
# spring.data.mongodb.port=27017
# spring.data.mongodb.database=medicamentos_db
# spring.data.mongodb.username=medicamentos_usr
# spring.data.mongodb.password=medicamentos123
# spring.data.mongodb.authentication-database=admin
```

## Compilación y Ejecución

Navega hasta el directorio raíz del proyecto en tu terminal.

### 1. Compilar el Proyecto (Opcional)

Gradle manejará la compilación automáticamente al ejecutar, pero si deseas compilar explícitamente:

```bash
# En Windows
.\gradlew.bat build

# En Linux/macOS
./gradlew build
```

### 2. Ejecutar la Aplicación

```bash
# En Windows
.\gradlew.bat bootRun

# En Linux/macOS
./gradlew bootRun
```

El servidor se iniciará, generalmente en el puerto 8080.

## Acceso a la API

Una vez que la aplicación esté en ejecución, puedes acceder a la documentación interactiva de la API (Swagger UI) en tu navegador:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Desde Swagger UI, puedes explorar los diferentes endpoints, ver los modelos de datos y probar la API directamente.

## Autores

- **Alejandro Gómez Quiñones** - 000150096
- **Santiago Martinez Yara** - 000497795
