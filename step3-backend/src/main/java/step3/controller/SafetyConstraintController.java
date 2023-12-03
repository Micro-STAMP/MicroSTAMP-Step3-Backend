package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.entity.SafetyConstraint;
import step3.repository.SafetyConstraintRepository;

import java.util.List;

@RestController
@RequestMapping("/safety-constraint")
public class SafetyConstraintController {
    @Autowired
    private SafetyConstraintRepository safetyConstraintRepository;

    @PostMapping @Transactional
    public void createSafetyConstraint(@RequestBody SafetyConstraint safetyConstraint) {
        safetyConstraintRepository.save(safetyConstraint);
    }

    @GetMapping
    public List<SafetyConstraint> readAllSafetyConstraint() {
        return safetyConstraintRepository.findAll();
    }

    @PutMapping @Transactional
    public void updateSafetyConstraint(@RequestBody SafetyConstraint safetyConstraint) {
        SafetyConstraint updatedSafetyConstraint = safetyConstraintRepository.getReferenceById(safetyConstraint.getId());
        updatedSafetyConstraint.setName(safetyConstraint.getName());
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteSafetyConstraint(@PathVariable Long id) {
        safetyConstraintRepository.deleteById(id);
    }
}
