package step3.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Table(name = "unsafe_control_action")
@Entity(name = "UnsafeControlAction")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class UnsafeControlAction extends ControlAction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne @JoinColumn(name = "context_id")
    private Context context;

    @ManyToOne @JoinColumn(name = "contraint_id")
    private SafetyConstraint constraint;

    @ManyToOne @JoinColumn(name = "hazard_id")
    private Hazard hazard;

    @Enumerated(EnumType.STRING)
    private UCAType type;

    // NAME : <Source> <Type> <Control Action> <Context>
}
