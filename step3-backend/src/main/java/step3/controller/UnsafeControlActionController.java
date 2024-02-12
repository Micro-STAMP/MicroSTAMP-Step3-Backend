package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.unsafe_control_action.UnsafeControlActionCreateDto;
import step3.dto.unsafe_control_action.UnsafeControlActionReadDto;
import step3.entity.UnsafeControlAction;
import step3.service.UnsafeControlActionService;

import java.util.List;

@RestController
@RequestMapping("/unsafe-control-action")
public class UnsafeControlActionController {
    private final UnsafeControlActionService unsafeControlActionService;

    // Constructors -----------------------------------

    @Autowired
    public UnsafeControlActionController(UnsafeControlActionService unsafeControlActionService) {
        this.unsafeControlActionService = unsafeControlActionService;
    }

    // Create -----------------------------------------

    @PostMapping @Transactional
    public ResponseEntity<UnsafeControlActionReadDto> createUnsafeControlAction(@RequestBody UnsafeControlActionCreateDto unsafeControlActionCreateDto) {
        UnsafeControlActionReadDto createdUCA = unsafeControlActionService.createUnsafeControlAction(unsafeControlActionCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUCA);
    }
    @PostMapping("/rule/{rule_id}") @Transactional
    public ResponseEntity<List<UnsafeControlActionReadDto>> createUCAsByRule(@PathVariable Long rule_id) {
        List<UnsafeControlActionReadDto> createdUCAs = unsafeControlActionService.createUCAsByRule(rule_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUCAs);
    }

    // Read -------------------------------------------

    @GetMapping
    public ResponseEntity<List<UnsafeControlActionReadDto>> readAllUnsafeControlAction() {
        return ResponseEntity.ok(unsafeControlActionService.readAllUnsafeControlActions());
    }

    // Update -----------------------------------------

    @PutMapping @Transactional
    public ResponseEntity<UnsafeControlAction> updateUnsafeControlAction(@RequestBody UnsafeControlAction uca) {
        unsafeControlActionService.updateUnsafeControlAction(uca);
        return ResponseEntity.ok(uca);
    }

    // Delete -----------------------------------------

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity<Void> deleteUnsafeControlAction(@PathVariable Long id) {
        unsafeControlActionService.deleteUnsafeControlAction(id);
        return ResponseEntity.noContent().build();
    }

    // ------------------------------------------------
}
