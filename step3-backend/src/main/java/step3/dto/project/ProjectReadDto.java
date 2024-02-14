package step3.dto.project;

import step3.entity.Controller;
import step3.entity.Hazard;
import step3.entity.Project;
import step3.entity.UnsafeControlAction;
import java.util.List;

public record ProjectReadDto(
        Long id,
        String name,
        String description,
        List<HazardDto> hazards,
        List<ControllerDto> controllers,
        List<UnsafeControlActionDto> unsafe_control_actions
) {

    // Constructors -----------------------------------

    public ProjectReadDto(Project project) {
        this(
            project.getId(),
            project.getName(),
            project.getDescription(),
            project.getHazards().stream().map(HazardDto::new).toList(),
            project.getControllers().stream().map(ControllerDto::new).toList(),
            project.getUnsafeControlActions().stream().map(UnsafeControlActionDto::new).toList()
        );
    }

    // DTOs -------------------------------------------

    private record HazardDto(String name) {
        public HazardDto(Hazard hazard) {
            this(hazard.getName());
        }
    }
    private record ControllerDto(String name) {
        public ControllerDto (Controller controller){
            this(controller.getName());
        }
    }
    private record UnsafeControlActionDto(String name) {
        public UnsafeControlActionDto(UnsafeControlAction uca) {
            this(uca.getName());
        }
    }

    // ------------------------------------------------
}
