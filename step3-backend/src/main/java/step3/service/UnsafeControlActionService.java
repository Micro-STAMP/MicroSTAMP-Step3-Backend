package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.entity.UnsafeControlAction;
import step3.repository.UnsafeControlActionRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UnsafeControlActionService {
    private final UnsafeControlActionRepository unsafeControlActionRepository;

    public List<UnsafeControlAction> findAll() {
        return unsafeControlActionRepository.findAll();
    }
    public Optional<UnsafeControlAction> find(Long id) {
        return unsafeControlActionRepository.findById(id);
    }
    public UnsafeControlAction save(UnsafeControlAction unsafeControlAction) {
        return unsafeControlActionRepository.save(unsafeControlAction);
    }
    public void deleteById(Long id) {
        unsafeControlActionRepository.deleteById(id);
    }
}
