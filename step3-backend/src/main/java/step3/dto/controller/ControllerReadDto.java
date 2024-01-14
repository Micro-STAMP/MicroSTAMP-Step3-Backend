package step3.dto.controller;

import step3.entity.Controller;

public record ControllerReadDto(
        Long id,
        String name,
        String project_name
) {
    public ControllerReadDto(Controller controller) {
        this(controller.getId(), controller.getName(), controller.getProject().getName());
    }
}
