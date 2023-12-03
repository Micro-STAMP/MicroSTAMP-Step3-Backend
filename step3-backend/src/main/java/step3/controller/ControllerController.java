package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.entity.Controller;
import step3.repository.ControllerRepository;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class ControllerController {
    @Autowired
    private ControllerRepository controllerRepository;

    @PostMapping @Transactional
    public void createController(@RequestBody Controller controller) {
        controllerRepository.save(controller);
    }

    @GetMapping
    public List<Controller> readAllController() {
        return controllerRepository.findAll();
    }

    @PutMapping @Transactional
    public void updateController(@RequestBody Controller controller) {
        Controller updatedController = controllerRepository.getReferenceById(controller.getId());
        updatedController.setName(controller.getName());
        updatedController.setControlActions(controller.getControlActions());
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteController(@PathVariable Long id) {
        controllerRepository.deleteById(id);
    }
}
