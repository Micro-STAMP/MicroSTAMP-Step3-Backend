package step3.dto.rule;

import step3.entity.Rule;
import step3.entity.Value;

import java.util.List;

public record RuleReadDto(
        Long id,
        String name,
        Long context_table_id,
        List<ValueDto> values
) {
    public RuleReadDto(Rule rule) {
        this(
            rule.getId(),
            rule.getName(),
            rule.getContextTable().getId(),
            rule.getValues().stream().map(ValueDto::new).toList()
        );
    }

    public record ValueDto(Long value_id, String variable_name, String value_name) {
        public ValueDto(Value value) {
            this(
                value.getId(),
                value.getVariable().getName(),
                value.getName()
            );
        }
    }
}
