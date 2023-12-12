package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.controller.ControllerCreateDto;
import step3.entity.Controller;
import step3.repository.ControllerRepository;

import javax.naming.ldap.Control;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ControllerService {
    private final ControllerRepository controllerRepository;

    public List<Controller> readAllControllers() {
        return controllerRepository.findAll();
    }

    public void createController(ControllerCreateDto controllerCreateDto) {
        Controller controller = new Controller(controllerCreateDto.name());
        controllerRepository.save(controller);
    }

    public void updateController(Controller controller) {
        Controller updatedController = controllerRepository.getReferenceById(controller.getId());
        updatedController.setName(controller.getName());
        updatedController.setControlActions(controller.getControlActions());
    }

    public void deleteController(Long id) {
        controllerRepository.deleteById(id);
    }
}

