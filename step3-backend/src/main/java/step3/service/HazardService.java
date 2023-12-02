package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.entity.Hazard;
import step3.repository.HazardRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HazardService {
    private final HazardRepository hazardRepository;

    public List<Hazard> findAll() {
        return hazardRepository.findAll();
    }
    public Optional<Hazard> find(Long id) {
        return hazardRepository.findById(id);
    }
    public Hazard save(Hazard hazard) {
        return hazardRepository.save(hazard);
    }
    public void deleteById(Long id) {
        hazardRepository.deleteById(id);
    }
}
