# Bienestar Demo - Sistema de Gestión de Actividades, Usuarios e Inscripciones

![Logo del Proyecto](https://img.icons8.com/doodle/48/000000/health-and-beauty.png)

Bienvenido al sistema de gestión de actividades para bienestar institucional. Este proyecto, desarrollado en **Spring Boot**, **Spring Security** y **JPA**, permite la administración de actividades, usuarios e inscripciones, integrando un sistema de roles robusto (Administrador, Instructor, Estudiante) y una arquitectura organizada en módulos.

## 🚀 Características Principales

- **Gestión de Usuarios y Roles**:
  - Registro y autenticación segura de usuarios, incluyendo autenticación JWT.
  - Roles definidos para **Administrador**, **Instructor** y **Estudiante**.
  - Distinción entre atributos comunes y específicos para cada rol (patrón de herencia).
  
- **Módulos de Funcionalidad**:
  - **Gestión de Actividades**: Creación, modificación y consulta de actividades, con asignación de instructores.
  - **Gestión de Instructores y Estudiantes**: Registro, edición y gestión de información detallada para instructores y estudiantes.
  - **Inscripción en Actividades**: Inscripción de estudiantes, validación de requisitos, y envío de notificaciones.
  - **Progreso y Validación de Horas**: Administración del progreso de estudiantes y validación de horas completadas.
  - **Notificaciones**: Envío de notificaciones sobre inscripciones, validación de horas y progreso.
  
- **Autenticación y Seguridad**:
  - Autenticación JWT para cada usuario.
  - Seguridad basada en roles, con acceso diferenciado a los endpoints según el rol del usuario.
  - Validación de permisos de administrador para ciertas acciones.

## 📁 Estructura del Proyecto


## ⚙️ Instalación y Ejecución

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/bienestar-demo.git
   cd bienestar-demo
   
2. Configura la base de datos: Actualiza las credenciales en application.properties para la conexión a tu base de datos.

properties
   ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/bienestar_demo
    spring.datasource.username=usuario
    spring.datasource.password=contraseña



