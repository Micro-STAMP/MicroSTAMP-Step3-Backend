package step3.dto.variable;

import step3.entity.Variable;

public record VariableReadDto(
        Long id,
        String name,
        String controller_name
) {
    public VariableReadDto(Variable variable) {
        this(variable.getId(), variable.getName(), variable.getController().getName());
    }
}
