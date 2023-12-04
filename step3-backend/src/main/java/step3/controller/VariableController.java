package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void createVariable(@RequestBody VariableCreateDto variableCreateDto) {
        variableService.createVariable(variableCreateDto);
    }

    @GetMapping
    public List<Variable> readAllVariables() {
        return variableService.readAllVariables();
    }

    @PutMapping @Transactional
    public void updateVariable(@RequestBody Variable variable) {
        variableService.updateVariable(variable);
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteVariable(@PathVariable Long id) {
        variableService.deleteVariable(id);
    }
}
