package step3.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class UnsafeControlAction extends ControlAction {
    private Long id;
    private String name;
    private UnsafeControlActionType type;
    private List<SafetyConstraint> constraints;
    private List<Hazard> hazards;
}
