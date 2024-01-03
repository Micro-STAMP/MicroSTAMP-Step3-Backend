package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.safety_constraint.SafetyConstraintCreateDto;
import step3.entity.SafetyConstraint;
import step3.service.SafetyConstraintService;

import java.util.List;

@RestController
@RequestMapping("/safety-constraint")
public class SafetyConstraintController {
    private final SafetyConstraintService safetyConstraintService;

    @Autowired
    public SafetyConstraintController(SafetyConstraintService safetyConstraintService) {
        this.safetyConstraintService = safetyConstraintService;
    }

    @PostMapping @Transactional
    public ResponseEntity createSafetyConstraint(@RequestBody SafetyConstraintCreateDto safetyConstraintCreateDto) {
        safetyConstraintService.createSafetyConstraint(safetyConstraintCreateDto);

        return ResponseEntity.created(null).body(safetyConstraintCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<SafetyConstraint>> readAllSafetyConstraints() {
        var responseSC = safetyConstraintService.readAllSafetyConstraints();

        return ResponseEntity.ok(responseSC);
    }

    @PutMapping @Transactional
    public ResponseEntity updateSafetyConstraint(@RequestBody SafetyConstraint safetyConstraint) {
        safetyConstraintService.updateSafetyConstraint(safetyConstraint);

        return ResponseEntity.ok(safetyConstraint);
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity deleteSafetyConstraint(@PathVariable Long id) {
        safetyConstraintService.deleteSafetyConstraint(id);

        return ResponseEntity.noContent().build();
    }
}
