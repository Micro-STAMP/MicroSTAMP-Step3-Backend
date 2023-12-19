package step3.dto.rule;

import step3.dto.variable_state.VariableStateCreateDto;

import java.util.List;

public record RuleCreateDto(
        String name,
        Long context_table_id,
        List<VariableStateCreateDto> variable_states
){}
