package bienestar.demo.User.dto;

import bienestar.demo.User.Student;

public class StudentDTO {

    private String nombre;
    private String correo;
    private String carrera;
    private String cedula;
    private String telefono;
    private String progreso;

    public StudentDTO(Student student) {
        this.nombre = student.getNombre();
        this.correo = student.getCorreo();
        this.carrera = student.getCarrera();
        this.cedula = student.getCedula();
        this.telefono = student.getTelefono();
        this.progreso = student.getProgreso();
    }


// Getters y Setters
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

    public String getProgreso() {
        return progreso;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }
}
