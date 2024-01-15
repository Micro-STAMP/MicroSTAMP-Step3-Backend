package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.value.ValueCreateDto;
import step3.dto.value.ValueReadDto;
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
    public ResponseEntity<ValueCreateDto> createValue(@RequestBody ValueCreateDto valueCreateDto) {
        valueService.createValue(valueCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(valueCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<ValueReadDto>> readAllValue() {
        return ResponseEntity.ok(valueService.readAllValues());
    }

    @PutMapping @Transactional
    public ResponseEntity<Value> updateValue(@RequestBody Value value) {
        valueService.updateValue(value);
        return ResponseEntity.ok(value);
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity<Void> deleteValue(@PathVariable Long id) {
        valueService.deleteValue(id);
        return ResponseEntity.noContent().build();
    }
}
