package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.entity.Variable;
import step3.repository.VariableRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VariableService {
    private final VariableRepository variableRepository;

    public List<Variable> findAll() {
        return variableRepository.findAll();
    }
    public Optional<Variable> find(Long id) {
        return variableRepository.findById(id);
    }
    public Variable save(Variable variable) {
        return variableRepository.save(variable);
    }
    public void deleteById(Long id) {
        variableRepository.deleteById(id);
    }
}

