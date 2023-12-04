package step3.entity;

import jakarta.persistence.*;
import lombok.*;
import step3.dto.control_action.ControlActionCreateDto;
import step3.repository.ControllerRepository;

@Table(name = "control_action")
@Entity(name = "ControlAction")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class ControlAction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne @JoinColumn(name = "controller_id")
    private Controller controller;

    public ControlAction(String name, Controller controller) {
        this.name = name;
        this.controller = controller;
    }
}
