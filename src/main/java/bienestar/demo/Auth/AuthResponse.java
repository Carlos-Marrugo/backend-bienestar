package bienestar.demo.Auth;

import bienestar.demo.User.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthResponse {
    String token;
    private List<Student> students;
}
