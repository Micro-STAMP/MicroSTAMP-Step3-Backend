package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createControlAction(@RequestBody ControlActionCreateDto controlActionCreateDto) {
        controlActionService.createControlAction(controlActionCreateDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(controlActionCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<ControlAction>> readAllControlActions() {
       var CAList = controlActionService.readAllControlActions();

       return ResponseEntity.ok(CAList);
    }

    @PutMapping @Transactional
    public ResponseEntity updateControlAction(@RequestBody ControlAction controlAction) {
        controlActionService.updateControlAction(controlAction);

        return ResponseEntity.ok(controlAction);
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity deleteControlAction(@PathVariable Long id) {
        controlActionService.deleteControlAction(id);

        return ResponseEntity.noContent().build();
    }
}
