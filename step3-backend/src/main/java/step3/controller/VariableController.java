package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.entity.Variable;
import step3.repository.VariableRepository;

import java.util.List;

@RestController
@RequestMapping("/variable")
public class VariableController {
    @Autowired
    private VariableRepository variableRepository;

    @PostMapping @Transactional
    public void createVariable(@RequestBody Variable variable) {
        variableRepository.save(variable);
    }

    @GetMapping
    public List<Variable> readAllVariable() {
        return variableRepository.findAll();
    }

    @PutMapping @Transactional
    public void updateVariable(@RequestBody Variable variable) {
        Variable updatedVariabe = variableRepository.getReferenceById(variable.getId());
        updatedVariabe.setName(variable.getName());
        updatedVariabe.setValues(variable.getValues());
    }

    @DeleteMapping @Transactional
    public void deleteVariable(@PathVariable Long id) {
        variableRepository.deleteById(id);
    }
}
