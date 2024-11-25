package bienestar.demo.User;

import bienestar.demo.User.dto.ActivityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    // Endpoint para agregar una nueva actividad
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody ActivityRequest request) {
        return ResponseEntity.ok(activityService.createActivity(request));
    }

    // Endpoint para eliminar una actividad por ID
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable Integer id) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok("Actividad eliminada con éxito");
    }
}
