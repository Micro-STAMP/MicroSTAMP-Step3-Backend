package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.entity.Context;
import step3.repository.ContextRepository;

import java.util.List;
import java.util.Optional;


@Service @AllArgsConstructor
public class ContextService {
    private final ContextRepository contextRepository;

    public List<Context> findAll() {
        return contextRepository.findAll();
    }
    public Optional<Context> find(Long id) {
        return contextRepository.findById(id);
    }
    public Context save(Context context) {
        return contextRepository.save(context);
    }
    public void deleteById(Long id) {
        contextRepository.deleteById(id);
    }
}
