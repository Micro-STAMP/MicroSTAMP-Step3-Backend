package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.context.ContextCreateDto;
import step3.entity.Context;
import step3.repository.ContextRepository;

import java.util.List;
import java.util.Optional;


@Service @AllArgsConstructor
public class ContextService {
    private final ContextRepository contextRepository;

    public void createContext(ContextCreateDto contextCreateDto) {
        Context context = new Context();
        contextRepository.save(context);
    }

    public List<Context> readAllContexts() {
        return contextRepository.findAll();
    }

    public void updateContext(Context context) {
        Context updatedContext = contextRepository.getReferenceById(context.getId());
        updatedContext.setValues(context.getValues());
        updatedContext.setVariables(context.getVariables());
    }

    public void deleteContext(Long id) {
        contextRepository.deleteById(id);
    }
}
