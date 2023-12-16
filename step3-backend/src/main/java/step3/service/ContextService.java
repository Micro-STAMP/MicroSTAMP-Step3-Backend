package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.context.ContextCombinationCreateDto;
import step3.dto.context.ContextCreateDto;
import step3.entity.Context;
import step3.entity.Variable;
import step3.entity.Value;
import step3.repository.ContextRepository;
import step3.repository.ValueRepository;
import step3.repository.VariableRepository;

import java.util.List;
import java.util.Optional;


@Service @AllArgsConstructor
public class ContextService {
    private final ContextRepository contextRepository;
    private final VariableRepository variableRepository;
    private final ValueRepository valueRepository;

    public void createContext(ContextCreateDto contextCreateDto) {
        Context context = new Context();
        for (ContextCombinationCreateDto combinationDto : contextCreateDto.contextCombinations()) {
            Variable variable = variableRepository.getReferenceById(combinationDto.variable_id());
            Value value = valueRepository.getReferenceById(combinationDto.value_id());
            context.addCombination(variable, value);
        }
        contextRepository.save(context);
    }

    public List<Context> readAllContexts() {
        return contextRepository.findAll();
    }

    public void updateContext(Context context) {
        Context updatedContext = contextRepository.getReferenceById(context.getId());
        updatedContext.setContextCombinations(context.getContextCombinations());
    }

    public void deleteContext(Long id) {
        contextRepository.deleteById(id);
    }
}
