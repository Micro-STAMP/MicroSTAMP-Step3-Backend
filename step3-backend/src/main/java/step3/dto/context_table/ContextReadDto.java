package step3.dto.context_table;

import step3.entity.Context;

import java.util.List;

public record ContextReadDto(
        List<VariableStateReadDto> variable_states
) {
    public ContextReadDto(Context context) {
        this(context.getVariableStates().stream().map(VariableStateReadDto::new).toList());
    }
}