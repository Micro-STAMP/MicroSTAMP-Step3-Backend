package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.context_table.ContextTableCreateDto;
import step3.dto.context_table.ContextTableReadDto;
import step3.dto.context_table.ContextTableUpdateDto;
import step3.service.ContextTableService;

import java.util.List;

@RestController
@RequestMapping("/context-table")
public class ContextTableController {
    private final ContextTableService contextTableService;

    // Constructors -----------------------------------

    @Autowired
    public ContextTableController(ContextTableService contextTableService) {
        this.contextTableService = contextTableService;
    }

    // Create -----------------------------------------

    @PostMapping @Transactional
    public ResponseEntity<ContextTableReadDto> createContextTable(@RequestBody ContextTableCreateDto contextTableCreateDto) {
        ContextTableReadDto createdContexTable = contextTableService.createContextTable(contextTableCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContexTable);
    }

    // Read -------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<ContextTableReadDto> readContextTableById(@PathVariable Long id) {
        return ResponseEntity.ok(contextTableService.readContextTableById(id));
    }
    @GetMapping
    public ResponseEntity<List<ContextTableReadDto>> readAllContextTables() {
        return ResponseEntity.ok(contextTableService.readAllContextTables());
    }
    @GetMapping("/controller/{controller_id}")
    public ResponseEntity<ContextTableReadDto> readContextTableByController(@PathVariable Long controller_id) {
        return ResponseEntity.ok(contextTableService.readContextTableByController(controller_id));
    }

    // Update -----------------------------------------

    @PutMapping @Transactional
    public ResponseEntity<ContextTableReadDto> updateContextFromTable(@RequestBody ContextTableUpdateDto contextTableUpdateDto) {
        return ResponseEntity.ok(contextTableService.updateContextFromTable(contextTableUpdateDto));
    }
     @PutMapping("/apply-rule/{rule_id}") @Transactional
     public ResponseEntity<ContextTableReadDto> updateContextTableApplyRule(@PathVariable Long rule_id) {
         return ResponseEntity.ok(contextTableService.updateContextTableApplyRule(rule_id));
     }

    // Delete ----------------------------------------- todo: tem problema aqui, não apaga

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity<Void> deleteContextTable(@PathVariable Long id) {
        contextTableService.deleteContextTable(id);
        return ResponseEntity.noContent().build();
    }

    // ------------------------------------------------
}
