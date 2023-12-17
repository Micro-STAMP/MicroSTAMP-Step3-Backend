package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.context.ContextCombinationDto;
import step3.dto.context.ContextCreateDto;
import step3.dto.context.ContextReadDto;
import step3.dto.context.ContextUpdateDto;
import step3.entity.Context;
import step3.entity.Variable;
import step3.entity.Value;
import step3.repository.ContextRepository;
import step3.repository.ValueRepository;
import step3.repository.VariableRepository;

import java.util.List;

@Service @AllArgsConstructor
public class ContextService {
    private final ContextRepository contextRepository;
    private final VariableRepository variableRepository;
    private final ValueRepository valueRepository;

    public void createContext(ContextCreateDto contextCreateDto) {
        Context context = new Context();
        for (ContextCombinationDto combinationDto : contextCreateDto.combinations()) {
            Variable variable = variableRepository.getReferenceById(combinationDto.variable_id());
            Value value = valueRepository.getReferenceById(combinationDto.value_id());
            context.addCombination(variable, value);
        }
        contextRepository.save(context);

        // ! Futuramente adicionar uma verificação que o valor tem que ser da variável

    }

    public List<ContextReadDto> readAllContexts() {
        List<Context> contexts = contextRepository.findAll();
        return contexts.stream().map(ContextReadDto::new).toList();
    }

    public void updateContext(ContextUpdateDto contextUpdateDto) {
        Context context = contextRepository.getReferenceById(contextUpdateDto.id());
        context.getCombinations().clear();
        for (ContextCombinationDto combinationDto : contextUpdateDto.combinations()) {
            Variable variable = variableRepository.getReferenceById(combinationDto.variable_id());
            Value value = valueRepository.getReferenceById(combinationDto.value_id());
            context.addCombination(variable, value);
        }
    }

    public void deleteContext(Long id) {
        contextRepository.deleteById(id);
    }
}
