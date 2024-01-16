package step3.dto.rule;

import step3.entity.Rule;
import step3.entity.VariableState;

import java.util.List;

public record RuleReadDto(
        Long id,
        String name,
        Long context_table_id,
        List<VariableStateDto> variable_states
) {
    public RuleReadDto(Rule rule) {
        this(
            rule.getId(),
            rule.getName(),
            rule.getContextTable().getId(),
            rule.getVariableStates().stream().map(VariableStateDto::new).toList()
        );
    }

    public record VariableStateDto(Long variable_state_id, String variable_name, String value_name) {
        public VariableStateDto(VariableState variableState) {
            this(
                variableState.getId(),
                variableState.getVariable().getName(),
                variableState.getValue().getName()
            );
        }
    }
}
