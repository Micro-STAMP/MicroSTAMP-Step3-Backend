package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.entity.Controller;
import step3.repository.ControllerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ControllerService {
    private final ControllerRepository controllerRepository;

    public List<Controller> findAll() {
        return controllerRepository.findAll();
    }
    public Optional<Controller> find(Long id) {
        return controllerRepository.findById(id);
    }
    public Controller save(Controller controller) {
        return controllerRepository.save(controller);
    }
    public void deleteById(Long id) {
        controllerRepository.deleteById(id);
    }
}

