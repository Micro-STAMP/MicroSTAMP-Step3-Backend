package step3.dto.unsafe_control_action;

import step3.entity.UCAType;

public record UnsafeControlActionCreateDto(
        String name,
        Long control_action_id,
        Long context_id,
        Long constraint_id,
        Long hazard_id,
        UCAType type,
        Long project_id
) {
}
