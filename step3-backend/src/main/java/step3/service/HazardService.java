package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.hazard.HazardCreateDto;
import step3.entity.Hazard;
import step3.repository.HazardRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HazardService {
    private final HazardRepository hazardRepository;

    public void createHazard(HazardCreateDto hazardCreateDto) {
        Hazard hazard = new Hazard(hazardCreateDto.name());
        hazardRepository.save(hazard);
    }

    public List<Hazard> readAllHazards() {
        return hazardRepository.findAll();
    }

    public void updateHazard(Hazard hazard) {
        Hazard updatedHazard = hazardRepository.getReferenceById(hazard.getId());
        updatedHazard.setName(hazard.getName());
    }


    public void deleteHazard(Long id) {
        hazardRepository.deleteById(id);
    }
}
