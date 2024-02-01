package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.hazard.HazardCreateDto;
import step3.dto.hazard.HazardReadDto;
import step3.entity.Hazard;
import step3.entity.Project;
import step3.repository.HazardRepository;
import step3.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HazardService {
    private final HazardRepository hazardRepository;
    private final ProjectRepository projectRepository;

    // Create -----------------------------------------

    public void createHazard(HazardCreateDto hazardCreateDto) {
        Project project = projectRepository.getReferenceById(hazardCreateDto.project_id());
        Hazard hazard = new Hazard(hazardCreateDto.name(), project);
        hazardRepository.save(hazard);
    }

    // Read -------------------------------------------

    public List<HazardReadDto> readAllHazards() {
        return hazardRepository.findAll().stream().map(HazardReadDto::new).toList();
    }

    // Update -----------------------------------------

    public void updateHazard(Hazard hazard) {
        Hazard updatedHazard = hazardRepository.getReferenceById(hazard.getId());
        updatedHazard.setName(hazard.getName());
    }

    // Delete -----------------------------------------

    public void deleteHazard(Long id) {
        hazardRepository.deleteById(id);
    }

    // Methods ----------------------------------------

    // ------------------------------------------------
}
