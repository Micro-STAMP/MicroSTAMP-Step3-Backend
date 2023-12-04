package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.control_action.ControlActionCreateDto;
import step3.entity.ControlAction;
import step3.entity.Controller;
import step3.repository.ControlActionRepository;
import step3.repository.ControllerRepository;
import java.util.List;

@Service @AllArgsConstructor
public class ControlActionService {
    private final ControlActionRepository controlActionRepository;
    private final ControllerRepository controllerRepository;

    public void createControlAction(ControlActionCreateDto controlActionCreateDto) {
        Long controllerId = controlActionCreateDto.controller_id();
        Controller controller = controllerRepository.getReferenceById(controllerId);
        ControlAction controlAction = new ControlAction(controlActionCreateDto.name(), controller);
        controlActionRepository.save(controlAction);
    }

    public List<ControlAction> readAllControlActions() {
        return controlActionRepository.findAll();
    }

    public void updateControlAction(ControlAction controlAction) {
        ControlAction updatedControlAction = controlActionRepository.getReferenceById(controlAction.getId());
        updatedControlAction.setName(controlAction.getName());

        // TODO: FALTA ATUALIZAR O CONTROLLER
    }

    public void deleteControlAction(Long id) {
        controlActionRepository.deleteById(id);
    }
}
