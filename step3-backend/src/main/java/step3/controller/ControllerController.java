package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.controller.ControllerCreateDto;
import step3.dto.controller.ControllerReadDto;
import step3.entity.Controller;
import step3.service.ControllerService;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class ControllerController {
    private final ControllerService controllerService;

    // Constructors -----------------------------------

    @Autowired
    public ControllerController(ControllerService controllerService) {
        this.controllerService = controllerService;
    }

    // Create -----------------------------------------

    @PostMapping @Transactional
    public ResponseEntity<ControllerCreateDto> createController(@RequestBody ControllerCreateDto controllerCreateDto) {
        controllerService.createController(controllerCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(controllerCreateDto);
    }

    // Read -------------------------------------------

    @GetMapping
    public ResponseEntity<List<ControllerReadDto>> readAllController() {
        return ResponseEntity.ok(controllerService.readAllControllers());
    }

    // Update -----------------------------------------

    @PutMapping @Transactional
    public ResponseEntity<Controller> updateController(@RequestBody Controller controller) {
        controllerService.updateController(controller);
        return ResponseEntity.ok(controller);
    }

    // Delete -----------------------------------------

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity<Void> deleteController(@PathVariable Long id) {
        controllerService.deleteController(id);
        return ResponseEntity.noContent().build();
    }

    // ------------------------------------------------
}
