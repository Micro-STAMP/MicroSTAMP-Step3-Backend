package step3.dto.context_table;

import java.util.List;

public record ContextTableCreateDto(
        List<Long> variable_ids,
        Long project_id
){}
