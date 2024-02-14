package step3.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import step3.dto.controller.*;
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
    public ResponseEntity<ControllerReadDto> createController(@RequestBody @Valid ControllerCreateDto controllerCreateDto, UriComponentsBuilder uriBuilder) {
        ControllerReadDto controller = controllerService.createController(controllerCreateDto);
        URI uri = uriBuilder.path("/controller/{id}").buildAndExpand(controller.id()).toUri();
        return ResponseEntity.created(uri).body(controller);
    }

    // Read -------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<ControllerReadDto> readController(@PathVariable Long id) {
        return ResponseEntity.ok(controllerService.readController(id));
    }
    @GetMapping
    public ResponseEntity<List<ControllerReadListDto>> readAllController() {
        return ResponseEntity.ok(controllerService.readAllControllers());
    }

    // Update -----------------------------------------

    @PutMapping @Transactional
    public ResponseEntity<Controller> updateController(@RequestBody Controller controller) {
        controllerService.updateController(controller);
        return ResponseEntity.ok(controller);
    }

    @PutMapping("/{controllerId}/remove-context-table") @Transactional
    public ResponseEntity<ControllerReadDto> deleteContextTable(@PathVariable Long controllerId) {
        ControllerReadDto controller = controllerService.deleteContextTable(controllerId);
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
