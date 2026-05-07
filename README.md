# CRUD con Spring Boot + JPA: Gestión de Productos

Este proyecto es una implementación de una API RESTful para la gestión de productos, desarrollada como parte de la formación en el bootcamp de Generation México. El objetivo principal es demostrar la integración de Spring Boot con Spring Data JPA para realizar operaciones CRUD completas en una base de datos MySQL.

## Tecnologías Utilizadas

* **Java 17 SE**
* **Spring Boot 3.5.14**
* **Spring Data JPA**
* **MySQL Connector**
* **Gradle 8.14.4**
* **Postman** (para pruebas de endpoints)

## Arquitectura del Proyecto

El proyecto sigue una arquitectura de capas estándar para asegurar la separación de responsabilidades y la escalabilidad:

* **Controller:** Define los endpoints de la API y maneja las solicitudes HTTP.
* **Service:** Contiene la lógica de negocio y coordina las llamadas al repositorio.
* **Repository:** Interfaz que extiende de `JpaRepository` para la interacción directa con la base de datos MySQL.
* **Model:** Define el modelo de datos `Product` que se mapea a la tabla de la base de datos.

## ⚙️ Configuración del Entorno

> **Nota:** Por razones de seguridad, la carpeta `org/generation/products` que contiene el archivo `application.properties` no se encuentra en el repositorio (incluida en `.gitignore`).

Para ejecutar este proyecto localmente, debes crear el archivo `application.properties` con la siguiente configuración:

```properties
spring.application.name=products

# Configuración de Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/product_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Puerto del Servidor
server.port=8080
