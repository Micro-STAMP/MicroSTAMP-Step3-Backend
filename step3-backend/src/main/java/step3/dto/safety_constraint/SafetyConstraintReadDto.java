package step3.dto.safety_constraint;

import step3.entity.SafetyConstraint;

public record SafetyConstraintReadDto(Long id, String name) {
    public SafetyConstraintReadDto(SafetyConstraint safetyConstraint) {
        this(safetyConstraint.getId(), safetyConstraint.getName());
    }
}
