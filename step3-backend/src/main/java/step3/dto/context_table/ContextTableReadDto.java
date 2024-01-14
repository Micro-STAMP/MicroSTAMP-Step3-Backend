package step3.dto.context_table;

import step3.dto.context.ContextReadDto;
import step3.entity.ContextTable;

import java.util.List;

public record ContextTableReadDto(
        Long id,
        List<ContextReadDto> contexts,
        String project_name
) {
    public ContextTableReadDto(ContextTable contextTable) {
        this(
            contextTable.getId(),
            contextTable.getContexts().stream().map(ContextReadDto::new).toList(),
            contextTable.getProject().getName()
        );
    }
}