package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.entity.ControlAction;
import step3.repository.ControlActionRepository;
import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class ControlActionService {
    private final ControlActionRepository controlActionRepository;

    public List<ControlAction> findAll() {
        return controlActionRepository.findAll();
    }
    public Optional<ControlAction> find(Long id) {
        return controlActionRepository.findById(id);
    }
    public ControlAction save(ControlAction controlAction) {
        return controlActionRepository.save(controlAction);
    }
    public void deleteById(Long id) {
        controlActionRepository.deleteById(id);
    }
}
