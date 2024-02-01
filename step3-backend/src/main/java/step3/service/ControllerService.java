package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.controller.ControllerCreateDto;
import step3.dto.controller.ControllerReadDto;
import step3.entity.Controller;
import step3.entity.Project;
import step3.repository.ControllerRepository;
import step3.repository.ProjectRepository;

import javax.naming.ldap.Control;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ControllerService {
    private final ControllerRepository controllerRepository;
    private final ProjectRepository projectRepository;

    // Create -----------------------------------------

    public ControllerReadDto createController(ControllerCreateDto controllerCreateDto) {
        Project project = projectRepository.getReferenceById(controllerCreateDto.project_id());
        Controller controller = new Controller(controllerCreateDto.name(), project);

        Controller createdController = controllerRepository.save(controller);

        return new ControllerReadDto(createdController);
    }

    // Read -------------------------------------------

    public List<ControllerReadDto> readAllControllers() {
        return controllerRepository.findAll().stream().map(ControllerReadDto::new).toList();
    }

    // Update -----------------------------------------

    public void updateController(Controller controller) {
        Controller updatedController = controllerRepository.getReferenceById(controller.getId());
        updatedController.setName(controller.getName());
        updatedController.setControlActions(controller.getControlActions());
    }

    // Delete -----------------------------------------

    public void deleteController(Long id) {
        controllerRepository.deleteById(id);
    }

    // Methods ----------------------------------------

    // ------------------------------------------------
}

