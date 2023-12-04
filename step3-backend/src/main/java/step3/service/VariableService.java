package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.variable.VariableCreateDto;
import step3.entity.Variable;
import step3.repository.VariableRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VariableService {
    private final VariableRepository variableRepository;

    public void createVariable(VariableCreateDto variableCreateDto) {
        Variable variable = new Variable();
        variable.setName(variableCreateDto.name());
        variableRepository.save(variable);
    }

    public List<Variable> readAllVariables() {
        return variableRepository.findAll();
    }

    public void updateVariable(Variable variable) {
        Variable updatedVariable = variableRepository.getReferenceById(variable.getId());
        updatedVariable.setName(variable.getName());
        updatedVariable.setValues(variable.getValues());
    }

    public void deleteVariable(Long id) {
        variableRepository.deleteById(id);
    }
}

