package bienestar.demo.User;

import jakarta.persistence.*;
import org.aspectj.apache.bcel.generic.InstructionConstants;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_auth_id")  // Relación con la entidad UserAuth
    private UserAuth userAuth;

    private String areaEspecializacion;
    private String horarioAsignado;

    public Instructor() {}
    public Instructor(UserAuth userAuth, String areaEspecializacion, String horarioAsignado) {
        this.userAuth = userAuth;
        this.areaEspecializacion = areaEspecializacion;
        this.horarioAsignado = horarioAsignado;
    }


    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserAuth getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
    }

    public String getAreaEspecializacion() {
        return areaEspecializacion;
    }

    public void setAreaEspecializacion(String areaEspecializacion) {
        this.areaEspecializacion = areaEspecializacion;
    }

    public String getHorarioAsignado() {
        return horarioAsignado;
    }

    public void setHorarioAsignado(String horarioAsignado) {
        this.horarioAsignado = horarioAsignado;
    }
}
