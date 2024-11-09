# Bienestar Demo - Sistema de Gestión de Actividades, Usuarios e Inscripciones

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

- **src**: Contiene el código fuente del proyecto.
  - **controller**: Controladores para manejar las peticiones HTTP.
  - **service**: Servicios que contienen la lógica de negocio.
  - **model**: Entidades JPA.
  - **repository**: Interfaces de repositorios para interactuar con la base de datos.
  - **config**: Archivos de configuración para la seguridad y autenticación.

## ⚙️ Instalación y Ejecución

### 1. Clonar el Repositorio

Primero, clona el repositorio de GitHub:

```bash
git clone https://github.com/tu-usuario/bienestar-demo.git
cd bienestar-demo
```

2. Configurar la Base de Datos
Actualiza las credenciales de tu base de datos en el archivo application.properties:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/bienestar_demo
spring.datasource.username=usuario
spring.datasource.password=contraseña
```

API de Autenticación
Este documento describe cómo usar los endpoints de registro y login para la autenticación de usuarios en la API.

Endpoints
Registro de Usuario
El endpoint de registro permite crear un nuevo usuario en el sistema. Se envía una solicitud POST con el cuerpo en formato JSON.

Método: POST

URL: /api/auth/register

Cuerpo (Ejemplo para un usuario administrador):
```json
{
    "username": "adminUser",
    "password": "securePassword",
    "role": "ADMIN",
    "departamento": "Recursos Humanos",
    "permisosSuperAdmin": true
}
```
Login de Usuario
El endpoint de login permite autenticar un usuario existente en el sistema. Se envía una solicitud POST con el cuerpo en formato JSON.

Método: POST

URL: /api/auth/login
```json
{
    "username": "adminUser",
    "password": "securePassword"
}
```

> [!NOTE]
> Este endpoint valida las credenciales del usuario (username y password) y, si son correctas, devuelve un token de autenticación. Este token es necesario para acceder a otros recursos protegidos en la API.
> Nota: Cambia http://localhost:8000 por la URL correspondiente de la API que estés utilizando en producción o en el entorno adecuado.
