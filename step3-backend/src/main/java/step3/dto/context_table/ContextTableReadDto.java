package step3.dto.context_table;

import step3.entity.Context;
import step3.entity.ContextTable;
import step3.entity.Value;

import java.util.List;

public record ContextTableReadDto(
        Long id,
        List<ContextDto> contexts,
        String controller_name
) {
    public ContextTableReadDto(ContextTable contextTable) {
        this(
            contextTable.getId(),
            contextTable.getContexts().stream().map(ContextDto::new).toList(),
            contextTable.getController().getName()
        );
    }
    public record ContextDto(Long id, List<ValueDto> values, Boolean unsafe) {
        public ContextDto(Context context) {
            this(
                context.getId(),
                context.getValues().stream().map(ValueDto::new).toList(),
                context.getUnsafe()
            );
        }
        public record ValueDto(String variable_name, String value_name) {
            public ValueDto(Value value) {
                this(
                    value.getVariable().getName(),
                    value.getName()
                );
            }
        }
    }
}