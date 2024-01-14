package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.variable.VariableCreateDto;
import step3.dto.variable.VariableReadDto;
import step3.entity.Variable;
import step3.repository.VariableRepository;
import step3.service.VariableService;

import java.util.List;

@RestController
@RequestMapping("/variable")
public class VariableController {
    private final VariableService variableService;

    @Autowired
    public VariableController(VariableService variableService) {
        this.variableService = variableService;
    }

    @PostMapping @Transactional
    public ResponseEntity<VariableCreateDto> createVariable(@RequestBody VariableCreateDto variableCreateDto) {
        variableService.createVariable(variableCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(variableCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<VariableReadDto>> readAllVariables() {
        return ResponseEntity.ok(variableService.readAllVariables());
    }

    @PutMapping @Transactional
    public ResponseEntity<Variable> updateVariable(@RequestBody Variable variable) {
        variableService.updateVariable(variable);
        return ResponseEntity.ok(variable);
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity<Void> deleteVariable(@PathVariable Long id) {
        variableService.deleteVariable(id);
        return ResponseEntity.noContent().build();
    }
}
