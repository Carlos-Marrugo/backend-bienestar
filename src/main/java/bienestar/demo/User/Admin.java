package bienestar.demo.User;

import jakarta.persistence.*;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_auth_id")  // Relación con la entidad UserAuth
    private UserAuth userAuth;

    private String departamento;
    private Boolean permisosSuperAdmin;

    public Admin() {}

    public Admin(UserAuth userAuth, String departamento, Boolean permisosSuperAdmin) {
        this.userAuth = userAuth;
        this.departamento = departamento;
        this.permisosSuperAdmin = permisosSuperAdmin;
    }

    public UserAuth getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Boolean getPermisosSuperAdmin() {
        return permisosSuperAdmin;
    }

    public void setPermisosSuperAdmin(Boolean permisosSuperAdmin) {
        this.permisosSuperAdmin = permisosSuperAdmin;
    }
}
