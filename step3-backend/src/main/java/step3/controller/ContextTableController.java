package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.context_table.ContextTableCreateDto;
import step3.dto.context_table.ContextTableReadDto;
import step3.service.ContextTableService;

import java.util.List;

@RestController
@RequestMapping("/context-table")
public class ContextTableController {
    private final ContextTableService contextTableService;

    @Autowired
    public ContextTableController(ContextTableService contextTableService) {
        this.contextTableService = contextTableService;
    }

    @PostMapping @Transactional
    public ResponseEntity<ContextTableCreateDto> createContextTable(@RequestBody ContextTableCreateDto contextTableCreateDto) {
        contextTableService.createContextTable(contextTableCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(contextTableCreateDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContextTableReadDto> readContextTableById(@PathVariable Long id) {
        return ResponseEntity.ok(contextTableService.readContextTableById(id));
    }
    @GetMapping
    public ResponseEntity<List<ContextTableReadDto>> readAllContextTables() {
        return ResponseEntity.ok(contextTableService.readAllContextTables());
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity<Void> deleteContextTable(@PathVariable Long id) {
        contextTableService.deleteContextTable(id);
        return ResponseEntity.noContent().build();
    }

}
