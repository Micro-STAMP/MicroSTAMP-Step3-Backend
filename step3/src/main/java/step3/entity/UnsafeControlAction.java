package step3.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class UnsafeControlAction extends ControlAction {
    UnsafeControlActionType type;
    List<SafetyConstraint> constraints;
    List<Hazard> hazards;

    public UnsafeControlAction(UnsafeControlActionType type) {
        this.type = type;
        this.constraints = new ArrayList<>();
        this.hazards = new ArrayList<>();
    }
}
