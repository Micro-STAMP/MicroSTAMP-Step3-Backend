package step3.dto.rule;

import step3.entity.UCAType;

import java.util.List;
import java.util.Set;

public record RuleCreateDto(
        String name,
        Long control_action_id,
        List<Long> values_ids,
        Set<UCAType> types,
        Long hazard_id

){}
