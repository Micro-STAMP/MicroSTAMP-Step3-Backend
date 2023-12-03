package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.entity.ControlAction;
import step3.repository.ControlActionRepository;

import java.util.List;

@RestController
@RequestMapping("/control-action")
public class ControlActionController {
    @Autowired
    private ControlActionRepository controlActionRepository;

    @PostMapping @Transactional
    public void createControlAction(@RequestBody ControlAction controlAction) {
        controlActionRepository.save(controlAction);
    }

    @GetMapping
    public List<ControlAction> readAllControlActions() {
       return controlActionRepository.findAll();
    }

    @PutMapping @Transactional
    public void updateControlAction(@RequestBody ControlAction controlAction) {
        ControlAction updatedControlAction = controlActionRepository.getReferenceById(controlAction.getId());
        updatedControlAction.setName(controlAction.getName());
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteControlAction(@PathVariable Long id) {
        controlActionRepository.deleteById(id);
    }
}
