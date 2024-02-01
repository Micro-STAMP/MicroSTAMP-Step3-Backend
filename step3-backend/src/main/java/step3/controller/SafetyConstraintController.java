package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.safety_constraint.SafetyConstraintCreateDto;
import step3.dto.safety_constraint.SafetyConstraintReadDto;
import step3.entity.SafetyConstraint;
import step3.service.SafetyConstraintService;

import java.util.List;

@RestController
@RequestMapping("/safety-constraint")
public class SafetyConstraintController {
    private final SafetyConstraintService safetyConstraintService;

    // Constructors -----------------------------------

    @Autowired
    public SafetyConstraintController(SafetyConstraintService safetyConstraintService) {
        this.safetyConstraintService = safetyConstraintService;
    }

    // Create -----------------------------------------

    @PostMapping @Transactional
    public ResponseEntity<SafetyConstraintCreateDto> createSafetyConstraint(@RequestBody SafetyConstraintCreateDto safetyConstraintCreateDto) {
        safetyConstraintService.createSafetyConstraint(safetyConstraintCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(safetyConstraintCreateDto);
    }

    // Read -------------------------------------------

    @GetMapping
    public ResponseEntity<List<SafetyConstraintReadDto>> readAllSafetyConstraints() {
        return ResponseEntity.ok(safetyConstraintService.readAllSafetyConstraints());
    }

    // Update -----------------------------------------

    @PutMapping @Transactional
    public ResponseEntity<SafetyConstraint> updateSafetyConstraint(@RequestBody SafetyConstraint safetyConstraint) {
        safetyConstraintService.updateSafetyConstraint(safetyConstraint);
        return ResponseEntity.ok(safetyConstraint);
    }

    // Delete -----------------------------------------

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity<Void> deleteSafetyConstraint(@PathVariable Long id) {
        safetyConstraintService.deleteSafetyConstraint(id);

        return ResponseEntity.noContent().build();
    }

    // ------------------------------------------------
}
