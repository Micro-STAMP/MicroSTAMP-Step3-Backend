package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.controller.ControllerCreateDto;
import step3.entity.Controller;
import step3.service.ControllerService;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class ControllerController {
    private final ControllerService controllerService;

    @Autowired
    public ControllerController(ControllerService controllerService) {
        this.controllerService = controllerService;
    }

    @PostMapping @Transactional
    public ResponseEntity createController(@RequestBody ControllerCreateDto controllerCreateDto) {
        controllerService.createController(controllerCreateDto);

        return ResponseEntity.created(null).body(controllerCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<Controller>> readAllController() {
        var controllerList = controllerService.readAllControllers();

        return ResponseEntity.ok(controllerList);
    }

    @PutMapping @Transactional
    public ResponseEntity updateController(@RequestBody Controller controller) {
        controllerService.updateController(controller);

        return ResponseEntity.ok(controller);
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity deleteController(@PathVariable Long id) {
        controllerService.deleteController(id);

        return ResponseEntity.noContent().build();
    }
}
