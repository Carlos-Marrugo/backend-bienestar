package bienestar.demo.User;

import bienestar.demo.User.dto.InstructorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Instructor> registerInstructor(@RequestBody InstructorRequest request) {
        Instructor instructor = instructorService.registerInstructor(request);
        return ResponseEntity.ok(instructor);
    }
}