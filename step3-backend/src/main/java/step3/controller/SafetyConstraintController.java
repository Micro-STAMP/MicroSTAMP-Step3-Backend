package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void createSafetyConstraint(@RequestBody SafetyConstraintCreateDto safetyConstraintCreateDto) {
        safetyConstraintService.createSafetyConstraint(safetyConstraintCreateDto);
    }

    @GetMapping
    public List<SafetyConstraint> readAllSafetyConstraints() {
        return safetyConstraintService.readAllSafetyConstraints();
    }

    @PutMapping @Transactional
    public void updateSafetyConstraint(@RequestBody SafetyConstraint safetyConstraint) {
        safetyConstraintService.updateSafetyConstraint(safetyConstraint);
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteSafetyConstraint(@PathVariable Long id) {
        safetyConstraintService.deleteSafetyConstraint(id);
    }
}
