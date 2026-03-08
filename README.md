# 🚀 Foro Hub - API REST

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)

---

# 📚 Sobre el proyecto

**Foro Hub** es una **API REST desarrollada con Spring Boot** que permite gestionar los tópicos de un foro de discusión.

La aplicación implementa un sistema completo para **crear, consultar, actualizar y eliminar tópicos**, aplicando buenas prácticas de desarrollo backend como:

- Arquitectura en capas
- Persistencia con JPA
- Seguridad con JWT
- Migraciones de base de datos
- Validaciones y manejo de errores

Este proyecto fue desarrollado como parte del **Challenge de Alura Latam**, con el objetivo de poner en práctica conceptos clave del desarrollo backend moderno utilizando el ecosistema de **Spring**.

---

# 🛠️ Tecnologías utilizadas

El proyecto está construido utilizando las siguientes tecnologías:

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA** – Manejo de persistencia
- **Spring Security** – Autenticación y autorización
- **JWT (JSON Web Token)** – Seguridad basada en tokens
- **MySQL** – Base de datos relacional
- **Flyway** – Control de migraciones de la base de datos
- **Lombok** – Reducción de código repetitivo

Estas herramientas permiten construir una API robusta, segura y escalable.

---

# ⚙️ Funcionalidades principales

La API permite gestionar tópicos dentro del foro mediante un **CRUD completo** implementado en el `TopicoController`.

## ✨ Crear un tópico

**Endpoint:** `POST /topicos`

Permite registrar un nuevo tópico en el foro.

El sistema valida que **no existan tópicos duplicados** (mismo título y mensaje), ignorando diferencias entre mayúsculas y minúsculas.

Además, se asignan automáticamente:

- 📅 Fecha de creación
- 🟢 Estado activo del tópico

---

## 📋 Listar tópicos

**Endpoint:** `GET /topicos`

Devuelve una lista paginada de los tópicos disponibles.

Características:

- Solo se muestran los tópicos **activos**
- Implementación de **paginación con Pageable**
- Mejora del rendimiento en consultas grandes

---

## 🔍 Ver detalle de un tópico

**Endpoint:** `GET /topicos/{id}`

Permite consultar la información completa de un tópico específico utilizando su **ID**.

---

## 📝 Actualizar un tópico

**Endpoint:** `PUT /topicos/{id}`

Permite modificar los datos de un tópico existente.

Se pueden actualizar:

- Título
- Mensaje
- Curso relacionado

---

## 🗑️ Eliminación lógica

**Endpoint:** `DELETE /topicos/{id}`

En lugar de eliminar el registro físicamente de la base de datos, se realiza un **borrado lógico**.

Esto significa que:

- El campo `activo` se cambia a `false`
- El tópico deja de aparecer en las consultas
- La información **no se pierde**

---

# 🔐 Seguridad

La API implementa **autenticación basada en JWT (JSON Web Token)**.

Para acceder a los endpoints protegidos es necesario:

1️⃣ Autenticarse en el sistema  
2️⃣ Obtener un **Bearer Token**  
3️⃣ Enviar ese token en el header de las peticiones

Ejemplo de header:
Authorization: Bearer TOKEN_AQUI


Esto garantiza que solo usuarios autenticados puedan interactuar con la API.

---

# ⚠️ Manejo de errores

El proyecto implementa una gestión centralizada de excepciones utilizando:

`@RestControllerAdvice`

Esto permite devolver respuestas claras en formato JSON ante diferentes tipos de errores:

- ❌ **400 – Bad Request** → errores de validación
- 🔍 **404 – Not Found** → recurso inexistente
- ⚠️ Otros errores controlados por la API

---

# 🚀 Cómo ejecutar el proyecto

### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/TU_USUARIO/foro-hub.git
```
2️⃣ Configurar variables de entorno

Crear un archivo .env utilizando .env.example como referencia.

3️⃣ Crear la base de datos

Crear una base de datos MySQL llamada:
foro_hub

4️⃣ Ejecutar la aplicación

Desde el IDE o mediante Maven:  
./mvnw spring-boot:run  
Flyway se encargará automáticamente de ejecutar las migraciones de la base de datos.  

📂 Estructura del proyecto
-El proyecto sigue una arquitectura organizada en capas:  
controller  
service  
repository  
domain  
infra  
Esto facilita el mantenimiento, la escalabilidad y la separación de responsabilidades dentro de la aplicación.  

👨‍💻 Autor
Desarrollado con ❤️ por Marcos Santino Mazzanti
