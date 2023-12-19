package step3.dto.rule;

import step3.dto.variable_state.VariableStateReadDto;
import step3.entity.Rule;

import java.util.List;

public record RuleReadDto(
        String name,
        Long context_table_id,
        List<VariableStateReadDto> variable_states
) {
    public RuleReadDto(Rule rule) {
        this(rule.getName(), rule.getContextTable().getId(), rule.getRuleVariableStates().stream().map(VariableStateReadDto::new).toList());
    }
}
