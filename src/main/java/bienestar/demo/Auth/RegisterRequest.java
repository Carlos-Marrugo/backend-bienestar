package bienestar.demo.Auth;

import bienestar.demo.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String username;
    private String password;
    private Role role;

    private String departamento; // Admin
    private Boolean permisosSuperAdmin; // Admin
    private String especialidad; // Instructor
    private String major; // Student
    private Integer year; // Student
}
