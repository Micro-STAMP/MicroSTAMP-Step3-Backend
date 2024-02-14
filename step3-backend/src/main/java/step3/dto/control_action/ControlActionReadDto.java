package step3.dto.control_action;

import step3.entity.ControlAction;

public record ControlActionReadDto(
        Long id,
        String name,
        String controller_name
) {

    // Constructors -----------------------------------

    public ControlActionReadDto(ControlAction controlAction) {
        this(
            controlAction.getId(),
            controlAction.getName(),
            controlAction.getController().getName()
        );
    }

    // ------------------------------------------------
}
