package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.value.ValueCreateDto;
import step3.dto.value.ValueReadDto;
import step3.entity.Value;
import step3.entity.Variable;
import step3.repository.ValueRepository;
import step3.repository.VariableRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ValueService {
    private final ValueRepository valueRepository;
    private final VariableRepository variableRepository;

    public void createValue(ValueCreateDto valueCreateDto) {
        Long variableId = valueCreateDto.variable_id();
        Variable variable = variableRepository.getReferenceById(variableId);
        Value value = new Value(valueCreateDto.name(), variable);
        valueRepository.save(value);
    }

    public List<ValueReadDto> readAllValues() {
        return valueRepository.findAll().stream().map(ValueReadDto::new).toList();
    }

    public void updateValue(Value value) {
        Value updatedValue = valueRepository.getReferenceById(value.getId());
        updatedValue.setName(value.getName());
        updatedValue.setVariable(value.getVariable());
    }

    public void deleteValue(Long id) {
        valueRepository.deleteById(id);
    }
}
