package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.control_action.ControlActionCreateDto;
import step3.entity.ControlAction;
import step3.repository.ControlActionRepository;
import step3.service.ControlActionService;

import java.util.List;

@RestController
@RequestMapping("/control-action")
public class ControlActionController {
    private final ControlActionService controlActionService;

    @Autowired
    public ControlActionController(ControlActionService controlActionService) {
        this.controlActionService = controlActionService;
    }

    @PostMapping @Transactional
    public void createControlAction(@RequestBody ControlActionCreateDto controlActionCreateDto) {
        controlActionService.createControlAction(controlActionCreateDto);
    }

    @GetMapping
    public List<ControlAction> readAllControlActions() {
       return controlActionService.readAllControlActions();
    }

    @PutMapping @Transactional
    public void updateControlAction(@RequestBody ControlAction controlAction) {
        controlActionService.updateControlAction(controlAction);
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteControlAction(@PathVariable Long id) {
        controlActionService.deleteControlAction(id);
    }
}
