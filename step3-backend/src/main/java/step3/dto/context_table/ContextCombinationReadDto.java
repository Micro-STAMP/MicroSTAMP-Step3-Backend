package step3.dto.context_table;

import step3.entity.ContextCombination;

public record ContextCombinationReadDto(
        String variable_name,
        String value_name
) {
    public ContextCombinationReadDto(ContextCombination combination) {
        this(combination.getVariable().getName(), combination.getValue().getName());
    }
}
