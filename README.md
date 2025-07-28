# Foro Web API - Proyecto Java con Spring Boot y MySQL

Este proyecto es una API RESTful desarrollada en **Java con Spring Boot**, que permite manejar un **foro** donde los usuarios pueden registrar publicaciones, consultarlas, actualizarlas y manejar su estatus. Además, la API incluye seguridad basada en **tokens JWT**, lo que garantiza una autenticación robusta para cada usuario.

## Funcionalidades principales

- 🔐 **Seguridad basada en JWT**: Cada usuario recibe un token al autenticarse, el cual se debe incluir en las solicitudes protegidas.
- 📝 **Crear nuevas publicaciones**: Permite registrar nuevas entradas al foro.
- 📋 **Consultar publicaciones**:
  - Ver todas las publicaciones existentes.
  - Consultar una publicación específica por su ID.
- ♻️ **Actualizar publicaciones**:
  - Modificar el contenido (título, mensaje, etc.) de una publicación.
  - Cambiar el estatus de una publicación (`activo`, `cerrado`, `pendiente`,).
- 💾 **Persistencia en MySQL**: Todos los datos se almacenan de forma segura en una base de datos MySQL.

## Tecnologías utilizadas

- ☕ **Java 17+**
- 🌱 **Spring Boot**
  - Spring Web
  - Spring Data JPA
  - Spring Security
- 🐬 **MySQL**
- 🔐 **JWT (JSON Web Token)**
- 🛠️ **Maven**

## Requisitos

- Java 17 o superior
- MySQL 8 o superior
- Maven
  
| Método | Ruta                       | Descripción                             | Seguridad |
| ------ | -------------------------- | --------------------------------------- | --------- |
| POST   | /login                     | Login y obtención de token              | ❌         |
| POST   | /tema                      | Crear nueva publicación                 | ✅         |
| GET    | /tema                      | Consultar todas las publicaciones       | ✅         |
| GET    | /tema/{id}                 | Consultar una publicación por ID        | ✅         |
| PUT    | /tema/{id}                 | Actualizar contenido de una publicación | ✅         |
| PATCH  | /tema/{id}/                | Cambiar estatus de la publicación       | ✅         |


