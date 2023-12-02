package step3.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "control_action")
@Entity(name = "ControlAction")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class ControlAction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
