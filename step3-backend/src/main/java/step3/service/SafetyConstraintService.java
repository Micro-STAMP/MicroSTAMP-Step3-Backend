package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.safety_constraint.SafetyConstraintCreateDto;
import step3.dto.safety_constraint.SafetyConstraintReadDto;
import step3.entity.SafetyConstraint;
import step3.repository.SafetyConstraintRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SafetyConstraintService {
    private final SafetyConstraintRepository safetyConstraintRepository;

    public void createSafetyConstraint(SafetyConstraintCreateDto safetyConstraintCreateDto) {
        SafetyConstraint safetyConstraint = new SafetyConstraint(safetyConstraintCreateDto.name());
        safetyConstraintRepository.save(safetyConstraint);
    }

    public List<SafetyConstraintReadDto> readAllSafetyConstraints() {
        return safetyConstraintRepository.findAll().stream().map(SafetyConstraintReadDto::new).toList();
    }

    public void updateSafetyConstraint(SafetyConstraint safetyConstraint) {
        SafetyConstraint updatedSafetyConstraint = safetyConstraintRepository.getReferenceById(safetyConstraint.getId());
        updatedSafetyConstraint.setName(safetyConstraint.getName());
    }

    public void deleteSafetyConstraint(Long id) {
        safetyConstraintRepository.deleteById(id);
    }
}
