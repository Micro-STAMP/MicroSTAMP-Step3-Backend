package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.variable.VariableCreateDto;
import step3.dto.variable.VariableReadDto;
import step3.entity.Variable;
import step3.repository.ControllerRepository;
import step3.repository.VariableRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VariableService {
    private final VariableRepository variableRepository;
    private final ControllerRepository controllerRepository;

    public void createVariable(VariableCreateDto variableCreateDto) {
        Variable variable = new Variable();
        variable.setName(variableCreateDto.name());
        variable.setController(controllerRepository.getReferenceById(variableCreateDto.controller_id()));
        variableRepository.save(variable);
    }

    public List<VariableReadDto> readAllVariables() {
        return variableRepository.findAll().stream().map(VariableReadDto::new).toList();
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

