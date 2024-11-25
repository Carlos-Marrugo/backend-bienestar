package bienestar.demo.User;

import bienestar.demo.User.dto.ActivityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final InstructorRepository instructorRepository;

    public Activity createActivity(ActivityRequest request) {
        // Verificar que el instructor existe
        Instructor instructor = instructorRepository.findById(request.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Instructor no encontrado con ID: " + request.getInstructorId()));

        // Validar que la fecha y hora son futuras
        LocalDateTime activityDateTime = LocalDateTime.of(request.getFecha(), request.getHora());
        if (activityDateTime.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("La fecha y hora de la actividad deben ser futuras");
        }

        // Crear y guardar la actividad
        Activity activity = Activity.builder()
                .nombreActividad(request.getNombreActividad())
                .tipoActividad(request.getTipoActividad())
                .lugar(request.getLugar())
                .hora(request.getHora())
                .fecha(request.getFecha())
                .instructor(instructor.getUserAuth().getUsername())
                .duracion(request.getDuracion())
                .capacidad(request.getCapacidad())
                .descripcion(request.getDescripcion())
                .creadoEn(LocalDate.now())
                .build();

        return activityRepository.save(activity);
    }

    public void deleteActivity(Integer id) {
        activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada con ID: " + id));
        activityRepository.deleteById(id);
    }
}