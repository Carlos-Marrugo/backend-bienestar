package bienestar.demo.User.dto;

import lombok.Data;

@Data
public class InstructorRequest {
    // Datos de usuario
    private String username;
    private String password;

    // Datos del instructor
    private String areaEspecializacion;
    private String horarioAsignado;
}
