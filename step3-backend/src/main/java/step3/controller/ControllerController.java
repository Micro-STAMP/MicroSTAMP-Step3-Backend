package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void createController(@RequestBody ControllerCreateDto controllerCreateDto) {
        controllerService.createController(controllerCreateDto);
    }

    @GetMapping
    public List<Controller> readAllController() {
        return controllerService.readAllControllers();
    }

    @PutMapping @Transactional
    public void updateController(@RequestBody Controller controller) {
        controllerService.updateController(controller);
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteController(@PathVariable Long id) {
        controllerService.deleteController(id);
    }
}
