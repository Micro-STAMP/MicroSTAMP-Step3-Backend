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

    @ManyToOne @JoinColumn(name = "context_id") // TODO: Mudar para lista de valores ou manter contexto?
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
        String source = getControlAction().getController().getName();
        String typeAndCA = getTypeAndControlActionString();
        String context = getContext().toString();

        return source + " " + typeAndCA + " when " + context;
    }
    public SafetyConstraint generateConstraint() {
        String source = getControlAction().getController().getName();
        String typeAndCA = getTypeAndControlActionString();
        String context = getContext().toString();

        String scName = source + " must not " + typeAndCA + " when " + context;

        return new SafetyConstraint(scName, this);
    }
    public String getTypeAndControlActionString() {
        return switch (getType()) {
            case PROVIDED -> "provide " + getControlAction().getName();
            case NOT_PROVIDED -> "not provide " + getControlAction().getName();
            case TOO_EARLY -> "provide " + getControlAction().getName() + " too early";
            case TOO_LATE -> "provide " + getControlAction().getName() + " too late";
            case OUT_OF_ORDER -> "provide " + getControlAction().getName() + " out of order";
            case STOPPED_TOO_SOON -> "stop providing " + getControlAction().getName() + " too soon";
            case APPLIED_TOO_LONG -> "provide " + getControlAction().getName() + " too long";
        };
    }

    // ------------------------------------------------
}
