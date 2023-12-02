package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.entity.SafetyConstraint;
import step3.repository.SafetyConstraintRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SafetyConstraintService {
    private final SafetyConstraintRepository safetyConstraintRepository;

    public List<SafetyConstraint> findAll() {
        return safetyConstraintRepository.findAll();
    }
    public Optional<SafetyConstraint> find(Long id) {
        return safetyConstraintRepository.findById(id);
    }
    public SafetyConstraint save(SafetyConstraint safetyConstraint) {
        return safetyConstraintRepository.save(safetyConstraint);
    }
    public void deleteById(Long id) {
        safetyConstraintRepository.deleteById(id);
    }
}
