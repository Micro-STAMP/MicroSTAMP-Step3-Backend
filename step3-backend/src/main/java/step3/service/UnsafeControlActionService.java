package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.unsafe_control_action.UnsafeControlActionCreateDto;
import step3.entity.*;
import step3.repository.*;

import java.util.List;

@Service
@AllArgsConstructor
public class UnsafeControlActionService {
    private final UnsafeControlActionRepository unsafeControlActionRepository;
    private final ControlActionRepository controlActionRepository;
    private final ContextRepository contextRepository;
    private final SafetyConstraintRepository safetyConstraintRepository;
    private final HazardRepository hazardRepository;

    public void createUnsafeControlAction(UnsafeControlActionCreateDto unsafeControlActionCreateDto) {
        Long controlActionId = unsafeControlActionCreateDto.control_action_id();
        ControlAction controlAction = controlActionRepository.getReferenceById(controlActionId);

        Long contextId = unsafeControlActionCreateDto.context_id();
        Context context = contextRepository.getReferenceById(contextId);

        Long constraintId = unsafeControlActionCreateDto.constraint_id();
        SafetyConstraint safetyConstraint = safetyConstraintRepository.getReferenceById(constraintId);

        Long hazardId = unsafeControlActionCreateDto.hazard_id();
        Hazard hazard = hazardRepository.getReferenceById(hazardId);

        UnsafeControlAction uca = new UnsafeControlAction(
                unsafeControlActionCreateDto.name(),
                controlAction,
                context,
                safetyConstraint,
                hazard,
                unsafeControlActionCreateDto.type()
        );

        unsafeControlActionRepository.save(uca);
    }

    public List<UnsafeControlAction> readAllUnsafeControlActions() {
        return unsafeControlActionRepository.findAll();
    }

    public void updateUnsafeControlAction(UnsafeControlAction uca) {
        UnsafeControlAction updatedUca = unsafeControlActionRepository.getReferenceById(uca.getId());
        updatedUca.setName(uca.getName());
        updatedUca.setConstraint(uca.getConstraint());
        updatedUca.setContext(uca.getContext());
        updatedUca.setHazard(uca.getHazard());
    }

    public void deleteUnsafeControlAction(Long id) {
        unsafeControlActionRepository.deleteById(id);
    }
}
