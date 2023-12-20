package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void createContextTable(@RequestBody ContextTableCreateDto contextTableCreateDto) {
        contextTableService.createContextTable(contextTableCreateDto);
    }

    @GetMapping("/{id}")
    public ContextTableReadDto readContextTableById(@PathVariable Long id) {
        return contextTableService.readContextTableById(id);
    }
    @GetMapping
    public List<ContextTableReadDto> readAllContextTables() {
        return contextTableService.readAllContextTables();
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteContextTable(@PathVariable Long id) {
        contextTableService.deleteContextTable(id);
    }

}
