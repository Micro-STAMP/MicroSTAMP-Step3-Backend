package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.control_action.ControlActionCreateDto;
import step3.dto.control_action.ControlActionReadDto;
import step3.entity.ControlAction;
import step3.service.ControlActionService;

import java.util.List;

@RestController
@RequestMapping("/control-action")
public class ControlActionController {
    private final ControlActionService controlActionService;

    // Constructors -----------------------------------

    @Autowired
    public ControlActionController(ControlActionService controlActionService) {
        this.controlActionService = controlActionService;
    }

    // Create -----------------------------------------

    @PostMapping @Transactional
    public ResponseEntity<ControlActionCreateDto> createControlAction(@RequestBody ControlActionCreateDto controlActionCreateDto) {
        controlActionService.createControlAction(controlActionCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(controlActionCreateDto);
    }

    // Read -------------------------------------------

    @GetMapping
    public ResponseEntity<List<ControlActionReadDto>> readAllControlActions() {
       return ResponseEntity.ok(controlActionService.readAllControlActions());
    }

    // Update -----------------------------------------

    @PutMapping @Transactional
    public ResponseEntity<ControlAction> updateControlAction(@RequestBody ControlAction controlAction) {
        controlActionService.updateControlAction(controlAction);
        return ResponseEntity.ok(controlAction);
    }

    // Delete -----------------------------------------

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity<Void> deleteControlAction(@PathVariable Long id) {
        controlActionService.deleteControlAction(id);
        return ResponseEntity.noContent().build();
    }

    // ------------------------------------------------
}
