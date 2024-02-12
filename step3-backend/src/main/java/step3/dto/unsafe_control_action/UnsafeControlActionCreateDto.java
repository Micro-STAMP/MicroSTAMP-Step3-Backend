package step3.dto.unsafe_control_action;

import step3.entity.UCAType;

import java.util.List;

public record UnsafeControlActionCreateDto(
        Long control_action_id,
        List<Long> values_ids,
        Long hazard_id,
        UCAType type,
        Long project_id
) {
}
