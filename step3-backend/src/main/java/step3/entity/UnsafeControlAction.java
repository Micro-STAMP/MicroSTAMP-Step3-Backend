package step3.entity;

import lombok.*;
import jakarta.persistence.*;

@Table(name = "unsafe_control_action")
@Entity(name = "UnsafeControlAction")
@Getter @Setter @NoArgsConstructor
public class UnsafeControlAction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;  // NAME : <Source> <Type> <Control Action> <Context>

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

    @ManyToOne @JoinColumn(name = "project_id")
    private Project project;

    // Constructors -----------------------------------

    public UnsafeControlAction(String name, ControlAction controlAction, Context context, SafetyConstraint constraint, Hazard hazard, UCAType type, Project project) {
        this.name = name;
        this.controlAction = controlAction;
        this.context = context;
        this.constraint = constraint;
        this.hazard = hazard;
        this.type = type;
        this.project = project;
    }
}
