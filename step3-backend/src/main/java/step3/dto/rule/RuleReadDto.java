package step3.dto.rule;

import step3.entity.*;

import java.util.List;
import java.util.Set;

public record RuleReadDto(
        Long id,
        String name,
        ControlActionDto control_action,
        List<ValueDto> values,
        Set<UCAType> types,
        HazardDto hazard
) {
    public RuleReadDto(Rule rule) {
        this(
            rule.getId(),
            rule.getName(),
            new ControlActionDto(rule.getControlAction()),
            rule.getValues().stream().map(ValueDto::new).toList(),
            rule.getTypes(),
            new HazardDto(rule.getHazard())
        );
    }

    public record ControlActionDto(Long id, String name) {
        public ControlActionDto(ControlAction controlAction) {
            this(
                controlAction.getId(),
                controlAction.getName()
            );
        }
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

    public record HazardDto(Long id, String name) {
        public HazardDto(Hazard hazard) {
            this(
                hazard.getId(),
                hazard.getName()
            );
        }
    }
}
