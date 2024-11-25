package bienestar.demo.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idActividad;

    private String nombreActividad;
    private String tipoActividad;
    private String lugar;
    private LocalTime hora;
    private LocalDate fecha;
    private String instructor;
    private Integer duracion; // en minutos
    private Integer capacidad; // Número máximo de participantes
    private String descripcion;

    @Column(updatable = false)
    private LocalDate creadoEn;
}
