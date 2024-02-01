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

    @ManyToOne @JoinColumn(name = "hazard_id")
    private Hazard hazard;

    @Enumerated(EnumType.STRING)
    private UCAType type;

    @OneToOne(mappedBy = "unsafeControlAction", cascade = CascadeType.ALL, orphanRemoval = true)
    private SafetyConstraint constraint;

    @ManyToOne @JoinColumn(name = "project_id")
    private Project project;

    // Constructors -----------------------------------

    public UnsafeControlAction(ControlAction controlAction, Context context, Hazard hazard, UCAType type, Project project) {
        this.controlAction = controlAction;
        this.context = context;
        this.hazard = hazard;
        this.type = type;
        this.project = project;
        this.name = generateName();
        this.constraint = generateConstraint();
    }

    // Methods ----------------------------------------

    public String generateName() {
        // NAME : <Source> <Type> <Control Action> <Context>
        String source = getControlAction().getController().getName();
        String type = getType().name();
        String ca = getControlAction().getName();
        String context = getContext().toString();

        return source + " " + type + " " + ca + " when " + context;
    }
    public SafetyConstraint generateConstraint() {
        String source = getControlAction().getController().getName();
        String type = getType().name();
        String ca = getControlAction().getName();
        String context = getContext().toString();

        String scName = source + " MUST NOT " + type + " " + ca + " when " + context;

        return new SafetyConstraint(scName, this);
    }

    // ------------------------------------------------
}
