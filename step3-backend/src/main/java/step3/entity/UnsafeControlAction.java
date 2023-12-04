package step3.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Table(name = "unsafe_control_action")
@Entity(name = "UnsafeControlAction")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class UnsafeControlAction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne @JoinColumn(name = "control_action_id")
    private ControlAction controlAction;

    @ManyToOne @JoinColumn(name = "context_id")
    private Context context;

    @ManyToOne @JoinColumn(name = "constraint_id")
    private SafetyConstraint constraint;

    @ManyToOne @JoinColumn(name = "hazard_id")
    private Hazard hazard;

    @Enumerated(EnumType.STRING)
    private UCAType type;

    public UnsafeControlAction(String name, ControlAction controlAction, Context context, SafetyConstraint constraint, Hazard hazard, UCAType type) {
        this.name = name;
        this.controlAction = controlAction;
        this.context = context;
        this.constraint = constraint;
        this.hazard = hazard;
        this.type = type;
    }

    // NAME : <Source> <Type> <Control Action> <Context>
}
