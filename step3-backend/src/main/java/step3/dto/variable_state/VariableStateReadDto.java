package step3.dto.variable_state;

import step3.entity.VariableState;

public record VariableStateReadDto(
        String variable_name,
        String value_name
) {
    public VariableStateReadDto(VariableState variableState) {
        this(variableState.getVariable().getName(), variableState.getValue().getName());
    }
}
