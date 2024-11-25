package bienestar.demo.User;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_auth_id", referencedColumnName = "id", nullable = false)
    private UserAuth userAuth;

    private String nombre;
    private String correo;
    private String carrera;
    private String cedula;
    private String telefono;
    private LocalDate fechaNacimiento;
    private Integer horasVerificadas;
    private String historialActividades;
    private String progreso;
    private LocalDateTime creadoEn;

    public Student() {}

    public Student(UserAuth userAuth, String nombre, String correo, String carrera, String cedula, String telefono,
                   LocalDate fechaNacimiento, Integer horasVerificadas, String historialActividades, String progreso) {
        this.userAuth = userAuth;
        this.nombre = nombre;
        this.correo = correo;
        this.carrera = carrera;
        this.cedula = cedula;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.horasVerificadas = horasVerificadas;
        this.historialActividades = historialActividades;
        this.progreso = progreso;
        this.creadoEn = LocalDateTime.now();
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}
