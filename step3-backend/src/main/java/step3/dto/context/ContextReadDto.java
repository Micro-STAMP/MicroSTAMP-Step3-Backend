package step3.dto.context;

import step3.dto.variable_state.VariableStateReadDto;
import step3.entity.Context;

import java.util.List;

public record ContextReadDto(
        Long id,
        List<VariableStateReadDto> variable_states
) {
    public ContextReadDto(Context context) {
        this(context.getId(), context.getVariableStates().stream().map(VariableStateReadDto::new).toList());
    }
}