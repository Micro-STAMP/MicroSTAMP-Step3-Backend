package step3.dto.context_table;

import step3.entity.Context;
import step3.entity.ContextTable;
import step3.entity.VariableState;

import java.util.List;

public record ContextTableReadDto(
        Long id,
        List<ContextDto> contexts,
        String project_name
) {
    public ContextTableReadDto(ContextTable contextTable) {
        this(
            contextTable.getId(),
            contextTable.getContexts().stream().map(ContextDto::new).toList(),
            contextTable.getProject().getName()
        );
    }
    public record ContextDto(Long id, List<VariableStateDto> variable_states, Boolean unsafe) {
        public ContextDto(Context context) {
            this(
                context.getId(),
                context.getVariableStates().stream().map(VariableStateDto::new).toList(),
                context.getUnsafe()
            );
        }
        public record VariableStateDto(String variable_name, String value_name) {
            public VariableStateDto(VariableState variableState) {
                this(
                    variableState.getVariable().getName(),
                    variableState.getValue().getName()
                );
            }
        }
    }
}