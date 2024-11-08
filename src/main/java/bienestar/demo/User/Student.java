package bienestar.demo.User;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_auth_id")  // Relación con la entidad UserAuth
    private UserAuth userAuth;

    private Integer horasVerificadas;
    private String historialActividades;
    private String progreso;

    public Student () {}  // Constructor sin argumentos (necesario para JPA)

    public Student(UserAuth userAuth, Integer horasVerificadas, String historialActividades, String progreso) {
        this.userAuth = userAuth;
        this.horasVerificadas = horasVerificadas;
        this.historialActividades = historialActividades;
        this.progreso = progreso;
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

    public Integer getHorasVerificadas() {
        return horasVerificadas;
    }

    public void setHorasVerificadas(Integer horasVerificadas) {
        this.horasVerificadas = horasVerificadas;
    }

    public String getHistorialActividades() {
        return historialActividades;
    }

    public void setHistorialActividades(String historialActividades) {
        this.historialActividades = historialActividades;
    }

    public String getProgreso() {
        return progreso;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }
}
