package step3.dto.rule;

import java.util.List;

public record RuleCreateDto(
        String name,
        Long context_table_id,
        List<Long> values_ids
){}
