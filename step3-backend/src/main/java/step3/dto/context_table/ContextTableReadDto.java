package step3.dto.context_table;

import step3.entity.ContextTable;

import java.util.List;

public record ContextTableReadDto(
        Long id,
        List<ContextReadDto> contexts
) {
    public ContextTableReadDto(ContextTable contextTable) {
        this(contextTable.getId(), contextTable.getContexts().stream().map(ContextReadDto::new).toList());
    }
}