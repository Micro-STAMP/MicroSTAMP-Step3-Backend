package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.variable.VariableCreateDto;
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
    public ResponseEntity createVariable(@RequestBody VariableCreateDto variableCreateDto) {
        variableService.createVariable(variableCreateDto);

        return ResponseEntity.created(null).body(variableCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<Variable>> readAllVariables() {
        var variableList = variableService.readAllVariables();

        return ResponseEntity.ok(variableList);
    }

    @PutMapping @Transactional
    public ResponseEntity updateVariable(@RequestBody Variable variable) {
        variableService.updateVariable(variable);

        return ResponseEntity.ok(variable);
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity deleteVariable(@PathVariable Long id) {
        variableService.deleteVariable(id);

        return ResponseEntity.noContent().build();
    }
}
