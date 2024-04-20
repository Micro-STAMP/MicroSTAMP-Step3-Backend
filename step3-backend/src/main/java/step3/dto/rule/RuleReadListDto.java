package step3.dto.rule;

import step3.entity.Rule;

public record RuleReadListDto(
        Long id,
        String name,
        String control_action_name,
        String tag
) {

    // Constructors -----------------------------------

    public RuleReadListDto(Rule rule) {
        this(
                rule.getId(),
                rule.getName(),
                rule.getControlAction().getName(),
                rule.getTagName()
        );
    }

    // ------------------------------------------------
}
