package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.entity.Value;
import step3.repository.ValueRepository;

import java.util.List;

@RestController
@RequestMapping("/value")
public class ValueController {
    @Autowired
    private ValueRepository valueRepository;

    @PostMapping @Transactional
    public void createValue(@RequestBody Value value) {
        valueRepository.save(value);
    }

    @GetMapping
    public List<Value> readAllValue() {
        return valueRepository.findAll();
    }

    @PutMapping @Transactional
    public void updateValue(@RequestBody Value value) {
        Value updatedValue = valueRepository.getReferenceById(value.getId());
        updatedValue.setName(value.getName());
        updatedValue.setVariable(value.getVariable());
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteValue(@PathVariable Long id) {
        valueRepository.deleteById(id);
    }
}
