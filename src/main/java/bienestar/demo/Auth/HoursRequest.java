package bienestar.demo.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HoursRequest {
    private String username;
    private String password;
    private String cedula; // Identificación del estudiante
}
