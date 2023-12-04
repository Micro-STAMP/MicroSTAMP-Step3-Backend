package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.unsafe_control_action.UnsafeControlActionCreateDto;
import step3.entity.UnsafeControlAction;
import step3.repository.UnsafeControlActionRepository;
import step3.service.UnsafeControlActionService;

import java.util.List;

@RestController
@RequestMapping("/unsafe-control-action")
public class UnsafeControlActionController {
    private final UnsafeControlActionService unsafeControlActionService;

    @Autowired
    public UnsafeControlActionController(UnsafeControlActionService unsafeControlActionService) {
        this.unsafeControlActionService = unsafeControlActionService;
    }

    @PostMapping @Transactional
    public void createUnsafeControlAction(@RequestBody UnsafeControlActionCreateDto unsafeControlActionCreateDto) {
        unsafeControlActionService.createUnsafeControlAction(unsafeControlActionCreateDto);
    }

    @GetMapping
    public List<UnsafeControlAction> readAllUnsafeControlAction() {
        return unsafeControlActionService.readAllUnsafeControlActions();
    }

    @PutMapping @Transactional
    public void updateUnsafeControlAction(@RequestBody UnsafeControlAction uca) {
        unsafeControlActionService.updateUnsafeControlAction(uca);
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteUnsafeControlAction(@PathVariable Long id) {
        unsafeControlActionService.deleteUnsafeControlAction(id);
    }
}
