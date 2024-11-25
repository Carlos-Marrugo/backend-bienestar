package bienestar.demo.User.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ActivityRequest {
    private String nombreActividad;
    private String tipoActividad;
    private String lugar;
    private LocalTime hora;
    private LocalDate fecha;
    private Integer instructorId; // ID del instructor ya registrado
    private Integer duracion; // En minutos
    private Integer capacidad; // Número máximo de participantes
    private String descripcion;
}
