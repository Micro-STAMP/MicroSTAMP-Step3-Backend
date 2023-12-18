package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.context.ContextReadDto;
import step3.entity.Context;
import step3.repository.ContextRepository;

import java.util.List;

@Service @AllArgsConstructor
public class ContextService {
    private final ContextRepository contextRepository;

    public List<ContextReadDto> readAllContexts() {
        List<Context> contexts = contextRepository.findAll();
        return contexts.stream().map(ContextReadDto::new).toList();
    }

}
