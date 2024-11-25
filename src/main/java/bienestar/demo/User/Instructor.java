package bienestar.demo.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String areaEspecializacion;
    private String horarioAsignado;

    @OneToOne
    @JoinColumn(name = "user_auth_id", referencedColumnName = "id")
    private UserAuth userAuth;
}
