package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createUnsafeControlAction(@RequestBody UnsafeControlActionCreateDto unsafeControlActionCreateDto) {
        unsafeControlActionService.createUnsafeControlAction(unsafeControlActionCreateDto);

        return ResponseEntity.created(null).body(unsafeControlActionCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<UnsafeControlAction>> readAllUnsafeControlAction() {
        var responseUCA = unsafeControlActionService.readAllUnsafeControlActions();

        return ResponseEntity.ok(responseUCA);
    }

    @PutMapping @Transactional
    public ResponseEntity updateUnsafeControlAction(@RequestBody UnsafeControlAction uca) {
        unsafeControlActionService.updateUnsafeControlAction(uca);

        return ResponseEntity.ok(uca);
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity deleteUnsafeControlAction(@PathVariable Long id) {
        unsafeControlActionService.deleteUnsafeControlAction(id);

        return ResponseEntity.noContent().build();
    }
}
