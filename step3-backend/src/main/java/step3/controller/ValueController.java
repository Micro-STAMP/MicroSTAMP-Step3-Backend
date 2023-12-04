package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.value.ValueCreateDto;
import step3.entity.Value;
import step3.repository.ValueRepository;
import step3.service.ValueService;

import java.util.List;

@RestController
@RequestMapping("/value")
public class ValueController {
    private final ValueService valueService;

    @Autowired
    public ValueController(ValueService valueService) {
        this.valueService = valueService;
    }

    @PostMapping @Transactional
    public void createValue(@RequestBody ValueCreateDto valueCreateDto) {
        valueService.createValue(valueCreateDto);
    }

    @GetMapping
    public List<Value> readAllValue() {
        return valueService.readAllValues();
    }

    @PutMapping @Transactional
    public void updateValue(@RequestBody Value value) {
        valueService.updateValue(value);
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteValue(@PathVariable Long id) {
        valueService.deleteValue(id);
    }
}
