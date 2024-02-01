package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.unsafe_control_action.UnsafeControlActionCreateDto;
import step3.dto.unsafe_control_action.UnsafeControlActionReadDto;
import step3.entity.*;
import step3.repository.*;

import java.util.List;

@Service
@AllArgsConstructor
public class UnsafeControlActionService {
    private final UnsafeControlActionRepository unsafeControlActionRepository;
    private final ControlActionRepository controlActionRepository;
    private final ContextRepository contextRepository;
    private final HazardRepository hazardRepository;
    private final ProjectRepository projectRepository;

    // Create -----------------------------------------

    public UnsafeControlActionReadDto createUnsafeControlAction(UnsafeControlActionCreateDto unsafeControlActionCreateDto) {
        Long controlActionId = unsafeControlActionCreateDto.control_action_id();
        ControlAction controlAction = controlActionRepository.getReferenceById(controlActionId);

        Long contextId = unsafeControlActionCreateDto.context_id();
        Context context = contextRepository.getReferenceById(contextId);

        Long hazardId = unsafeControlActionCreateDto.hazard_id();
        Hazard hazard = hazardRepository.getReferenceById(hazardId);

        Long projectId = unsafeControlActionCreateDto.project_id();
        Project project = projectRepository.getReferenceById(projectId);

        UnsafeControlAction uca = new UnsafeControlAction(
                controlAction,
                context,
                hazard,
                unsafeControlActionCreateDto.type(),
                project
        );

        UnsafeControlAction createdUCA = unsafeControlActionRepository.save(uca);

        return new UnsafeControlActionReadDto(createdUCA);
    }

    // Read -------------------------------------------

    public List<UnsafeControlActionReadDto> readAllUnsafeControlActions() {
        return unsafeControlActionRepository.findAll().stream().map(UnsafeControlActionReadDto::new).toList();
    }

    // Update -----------------------------------------

    public void updateUnsafeControlAction(UnsafeControlAction uca) {
        UnsafeControlAction updatedUca = unsafeControlActionRepository.getReferenceById(uca.getId());
        updatedUca.setName(uca.getName());
        updatedUca.setConstraint(uca.getConstraint());
        updatedUca.setContext(uca.getContext());
        updatedUca.setHazard(uca.getHazard());
    }

    // Delete -----------------------------------------

    public void deleteUnsafeControlAction(Long id) {
        unsafeControlActionRepository.deleteById(id);
    }

    // Methods ----------------------------------------

    // ------------------------------------------------
}
